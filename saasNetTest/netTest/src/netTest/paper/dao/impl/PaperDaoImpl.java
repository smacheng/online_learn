package netTest.paper.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import netTest.bean.BeanFactory;
import netTest.exception.ExceptionConstant;
import netTest.paper.constant.PaperConstant;
import netTest.paper.dao.PaperDao;
import netTest.paper.dto.PaperQuery;
import netTest.paper.vo.Paper;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;

import commonTool.base.BaseDao;
import commonTool.base.Page;
import commonTool.cache.CacheSynchronizer;
import commonTool.constant.CommonConstant;
import commonTool.exception.LogicException;
import commonTool.util.DateUtil;

public class PaperDaoImpl extends BaseDao implements PaperDao {

	static Logger log = Logger.getLogger(PaperDaoImpl.class.getName());
	
    /**
     *
     */
    public PaperDaoImpl() {
        super();
    }
    
    /**
     * 仅仅查询试卷的基本信息，表paper
     */
    @Cacheable(value="netTest.paperCache", key="'PaperDao.selectByPK_Plain~paper:'+#pk", unless="#result==null")
    public Paper selectByPK_plain(Long pk){
    	if(pk==null)
    		return null;
		Paper record = (Paper) this.queryForObject("Paper.selectByPK_plain", pk);
		if(record!=null){
    	   CacheSynchronizer.getInstance().buildAssoc("netTest.paperCache", 
    			 "PaperDao.selectByPK_Plain~"+Paper.ObjectType+":"+pk);
    	}
		return record;
    }
    
    /**
     * select some record by PK(包括试卷属性表)
     */
    @Cacheable(value="netTest.paperCache", key="'PaperDao.selectByPK~paper:'+#pk", unless="#result==null")
    public Paper selectByPK(Long pk){
    	if(pk==null)
    		return null;
		Paper record = (Paper) this.queryForObject("Paper.selectByPK", pk);
		if(record!=null){
    	   CacheSynchronizer.getInstance().buildAssoc("netTest.paperCache", 
    			 "PaperDao.selectByPK~"+Paper.ObjectType+":"+pk);
    	}
		return record;
    }
    
    /**
     * select records by queryVO
     */
    public List selectByVO(PaperQuery queryVO){
		if(queryVO==null)
			return new ArrayList();
		List list = this.queryForList("Paper.selectByVO", queryVO);
		return list;
    }
    
    /**
     * select records by product, it only include the basic information
     */
    public List selectByProd(Long productid, Long shopid){
    	PaperQuery queryVO = new PaperQuery();
    	queryVO.setProductbaseid(productid);
    	queryVO.setShopid(shopid);
		if(queryVO==null)
			return new ArrayList();
		List list = this.queryForList("Paper.selectByProd", queryVO);
		return list;
    }
    
    /**
     * 根据试卷id查询考试数量
     * @param productid
     * @param shopid
     * @return
     */
    public int countTestinfoNumber(Long paperid, Long shopid){
    	if(paperid==null)
			throw new LogicException(ExceptionConstant.Error_Need_Paramter);
    	PaperQuery queryVO = new PaperQuery();
    	queryVO.setPaperid(paperid);
    	queryVO.setShopid(shopid);
		Integer count = (Integer)this.queryForObject("Paper.countTestinfoNumber", queryVO);
		return count;
    }
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(PaperQuery queryVO,int pageIndex,int pageSize,Integer total){
        if(pageIndex<=0)
        	pageIndex = 1;
        if(pageSize<=0)
        	pageSize = CommonConstant.PAGESIZE;
        Page page = null;
        String sqlStr = "";
        if(queryVO==null){
        	page = Page.EMPTY_PAGE;
        } else {
        	sqlStr = "Paper.selectByVO";
        	page = queryForPage(sqlStr, queryVO, pageIndex, pageSize, total);
        }
        return page;
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Paper record){
    	if(record==null||record.isEmptyVO())
    		return null;
    	if(record.getVersion()==null)
    		record.setVersion(1);
    	if(record.getCreatetime()==null)
    		record.setCreatetime(DateUtil.getInstance().getNowtime_GLNZ());
    	if(record.getModitime()==null)
    		record.setModitime(DateUtil.getInstance().getNowtime_GLNZ());
		return (Long)super.insert("Paper.insert", record);
    }

    /**
     * update a record By PK
     */
	public int updateByPK(Paper record){
    	if(record==null||record.getPaperid()==null||record.isEmptyVO())
    		return 0;
    	record.setModitime(DateUtil.getInstance().getNowtime_GLNZ());
		int rows = super.update("Paper.updateByPK", record);
		
		// flush query cache
		CacheSynchronizer.getInstance().pubFlush("netTest.paperCache", Paper.ObjectType, record.getPaperid().toString());
		return rows;
    }
    
    /**
     * update the paper modifyTime and version
     */
    public int updateModInfo(Long paperid,Long shopid,Date date){
    	if(paperid==null||shopid==null)
    		return 0;
    	Paper vo = new Paper();
    	vo.setPaperid(paperid);
    	vo.setShopid(shopid);
    	//TODO 如果时间为空，则设置为当前时间的格林尼治时间
    	if(date==null)
    	{
    		date = DateUtil.getInstance().getNowtime_GLNZ();
    	}
    	vo.setModitime(date);
		int rows = super.update("Paper.updateModInfo", vo);
		// flush query cache
		CacheSynchronizer.getInstance().pubFlush("netTest.paperCache", Paper.ObjectType, paperid.toString());
		return rows;
    }
    
    /**
     * 更新试卷分数，同时也更新试卷的最后修改时间和试卷的版本号
     * @param paperid
     * @param papertotalscore
     * @param updateType: 更新类型，1为分数更新为参数。2为分数做增量加减，即在原有的分数上做加法
     * @param shopid
     */
    public int updateScore(Long paperid,Float papertotalscore,int updateType,Long shopid){
    	if(paperid==null||papertotalscore==null||shopid==null)
    		return 0;
    	Date date = DateUtil.getInstance().getNowtime_GLNZ();
    	Paper vo = new Paper();
    	vo.setPaperid(paperid);
    	vo.setShopid(shopid);
    	vo.setPapertotalscore(papertotalscore);
    	// 更新试卷的版本和修改时间
    	vo.setModitime(date);
    	
    	String sqlStr = "Paper.updateTotalscore1";
    	if(updateType==2){
    	   sqlStr = "Paper.updateTotalscore2";
    	}
		int rows = super.update(sqlStr, vo);
		// flush query cache
		CacheSynchronizer.getInstance().pubFlush("netTest.paperCache", Paper.ObjectType, paperid.toString());
		return rows;
    }
    
    /**
     * 根据paper自动更新该份试卷的总分数
     * @param paperid
     * @param shopid
     */
    public void autoUpdateScore(Long paperid, Long shopid){
    	if(paperid==null || shopid==null)
    		return;
    	Paper vo = new Paper();
    	vo.setPaperid(paperid);
    	vo.setShopid(shopid);
    	super.update("Paper.autoUpdateScoreByPK", vo);
    	// flush query cache
    	CacheSynchronizer.getInstance().pubFlush("netTest.paperCache", Paper.ObjectType, paperid.toString());
    }

    /**
     * 删除试卷包括试卷属性，试卷属性，试卷子题目，试卷试题答案表，试卷题型表，试卷题型比例表，引用试卷题目
     * @param pk:试卷id
     * @param genetype:是否是动态试卷。1正常试卷，2动态试卷。其他值，则全部都删除
     */
    public int deleteByPK(Long pk, Short genetype){
    	if(pk==null)
    		return 0;
    	super.delete("Paperprop.deleteByPK", pk);
    	super.delete("Paperquestype.deleteByPaper", pk);
    	super.delete("Paperpatternratio.deleteByPaper", pk);
    	if(!PaperConstant.GeneType_dynamic.equals(genetype)){
    	   super.delete("Paperques.delByPaperid", pk);
    	}else {
    		//TODO 删除引用试卷题目RefPaperQues
    		//TODO 删除DynamicPaper??
    	}
		int rows = super.delete("Paper.deleteByPK", pk);
		
		// flush query cache
		CacheSynchronizer.getInstance().pubFlush("netTest.paperCache", Paper.ObjectType, pk.toString());
		return rows;
    }
    
	/**
     * insertBatch records of List
     */
//    public int insertBatch(List list){
//    	if(list==null||list.size()<=0)
//    		return 0;
//    	int rows = 0;
//       	rows = super.insertBatch("Paper.insert", list);
//       	return rows;
//    }
    
    /**
     * deleteBatch records by the String Array of PK
     */
//    public int deleteBatchByPK(String[] pkArray){
//    	if(pkArray==null||pkArray.length<=0)
//    		return 0;
//    	int rows = 0;
//    	Long[] arrs = new Long[pkArray.length];
//		for(int i=0;i<pkArray.length;i++){
//			if(pkArray[i]!=null)
//				arrs[i] = new Long(Long.parseLong(pkArray[i]));
//		}
//		rows = super.deleteBatch("Paper.deleteByPK", arrs);
//		return rows;
//    }
    
    /**
     * 调用存储过程，根据试卷的配置，生成试卷题目
     * @param paperid
     * @return
     */
    public Long genePaperQues(Long paperid){
    	if(paperid==null)
    		return null;
    	Map map = new HashMap();
    	map.put("paperid", paperid);
    	super.update("Paper.P_InsertPaperQues", map);
    	return paperid;
    }
    
    /**
     * static spring getMethod
     */
     public static PaperDao getInstance(){
       	 PaperDao dao = (PaperDao)BeanFactory.getBeanFactory().getBean("paperDao");
         return dao;
     }

     /**
      * 查询试卷属于哪个org
      */
	public Long getInContainer(Long pk) {
		if(pk==null)
			return null;
		Object obj = this.queryForObject("Paper.selectInContainer", pk);
		if(obj!=null)
			return (Long)obj;
		else
		    return null;
	}
    
}
