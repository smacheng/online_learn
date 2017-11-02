package netTest.paper.dao.impl;

import java.util.ArrayList;
import java.util.List;

import netTest.bean.BeanFactory;
import netTest.paper.dao.PaperquestypeDao;
import netTest.paper.dto.PaperquestypeQuery;
import netTest.paper.vo.Paper;
import netTest.paper.vo.Paperquestype;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;

import commonTool.base.BaseDao;
import commonTool.cache.CacheSynchronizer;
import commonTool.util.AssertUtil;

public class PaperquestypeDaoImpl extends BaseDao implements PaperquestypeDao {

	static Logger log = Logger.getLogger(PaperquestypeDaoImpl.class.getName());
	
    /**
     *
     */
    public PaperquestypeDaoImpl() {
        super();
    }
    
    /**
     * select some record by PK
     */
    public Paperquestype selectByPK(Long pk){
    	if(pk==null)
    		return null;
    	Paperquestype record = (Paperquestype) this.queryForObject("Paperquestype.selectByPK", pk);
		return record;
    }
    
    /**
     * select some record by Logic PK
     */
    public Paperquestype selectByLogicPK(Long shopid,Long paperid,Long questypeid){
    	if(shopid==null||paperid==null||questypeid==null)
    		return null;
    	PaperquestypeQuery queryVO = new PaperquestypeQuery();
    	queryVO.setShopid(shopid);
    	queryVO.setPaperid(paperid);
    	queryVO.setQuestypeid(questypeid);
		Paperquestype record = (Paperquestype) this.queryForObject("Paperquestype.selectByLogicPK", queryVO);
		return record;
    }
    
    /**
     * 查找一份试卷上最大的questypeid
     * @param shopid
     * @param paperid
     * @return
     */
    public Long getMaxQuestypeid(Long shopid,Long paperid){
    	PaperquestypeQuery queryVO = new PaperquestypeQuery();
    	queryVO.setShopid(shopid);
    	queryVO.setPaperid(paperid);
    	Long questypeid = (Long) this.queryForObject("Paperquestype.getMaxQuestypeid", queryVO);
    	return questypeid;
    }
           
    /**
     * select records by queryVO
     */
//    public List selectByVO(PaperquestypeQuery queryVO){
//		if(queryVO==null)
//			return new ArrayList();
//		List list = this.queryForList("Paperquestype.selectByVO", queryVO);
//		return list;
//    }
    
    /**
     * select records by paperid
     */
    @Cacheable(value="netTest.paperCache", key="'PaperquestypeDao.qryByPaperid~paper:'+#paperid", unless="#result==null")
    public List<Paperquestype> qryByPaperid(Long paperid){
		if(paperid==null)
			return new ArrayList<Paperquestype>();
		List<Paperquestype> list = (List<Paperquestype>)this.queryForList("Paperquestype.qryByPaperid", paperid);
		if(list!=null && list.size()>0){
    	   CacheSynchronizer.getInstance().buildAssoc("netTest.paperCache", 
    			 "PaperquestypeDao.qryByPaperid~"+Paper.ObjectType+":"+paperid);
    	}
		return list;
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Paperquestype record){
    	AssertUtil.assertNotNull(record, null);
    	AssertUtil.assertNotNull(record.getPaperid(), null);
		Long pk= (Long)super.insert("Paperquestype.insert", record);
		// flush query cache
		CacheSynchronizer.getInstance().pubFlush("netTest.paperCache", Paper.ObjectType, record.getPaperid().toString());
		return pk;
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Paperquestype record){
    	AssertUtil.assertNotNull(record, null);
    	AssertUtil.assertNotNull(record.getPaperid(), null);
		int rows = super.update("Paperquestype.updateByPK", record);
		// flush query cache
		CacheSynchronizer.getInstance().pubFlush("netTest.paperCache", Paper.ObjectType, record.getPaperid().toString());
		return rows;
    }
    
    /**
     * update the scores of papertype
     * @param updateType: 更新类型，1为分数更新为参数。2为分数做增量加减，即在原有的分数上做加法
     */
    public int updatePatternscore(Long paperid,Long questypeid,Float paperquesscore,int updateType,Long shopid){
    	if(paperid==null||questypeid==null||shopid==null||paperquesscore==null)
    		return 0;
    	Paperquestype vo = new Paperquestype();
    	vo.setPaperid(paperid);
    	vo.setQuestypeid(questypeid);
    	vo.setShopid(shopid);
    	vo.setPatternscore(paperquesscore);
    	String sqlStr = "Paperquestype.updatePatternscore1";
    	if(updateType==2)
    		sqlStr = "Paperquestype.updatePatternscore2";
		int rows = super.update(sqlStr, vo);
		return rows;
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Paperquestype save(Paperquestype record){
    	if(record==null)
    		return null;
		if(record.getPatternid()==null||record.getPatternid().intValue()==0){
			Long pkValue = this.insert(record);
			record.setPaperid(pkValue);
    		return record;
		}else{
			this.updateByPK(record);
			return record;
		}
    }

    /**
     * delete a record by logic PK
     */
    public int deleteByPK(Long patternid){
    	if(patternid==null)
    		return 0;
    	Paperquestype vo = selectByPK(patternid);
    	AssertUtil.assertNotNull(vo, null);
		int rows = super.delete("Paperquestype.deleteByPK", patternid);
		// flush query cache
		CacheSynchronizer.getInstance().pubFlush("netTest.paperCache", Paper.ObjectType, vo.getPaperid().toString());
		return rows;
    }
    
    /**
     * delete a record by Paperid
     */
    public int delByPaperid(Long paperid){
    	if(paperid==null)
    		return 0;
		int rows = super.delete("Paperquestype.deleteByPaper", paperid);
		return rows;
    }
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list){
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
       	rows = super.insertBatch("Paperquestype.insert", list);
       	Paperquestype tempvo = (Paperquestype)list.get(0);
        // flush query cache
     	CacheSynchronizer.getInstance().pubFlush("netTest.paperCache", Paper.ObjectType, tempvo.getPaperid().toString());
     	return rows;
    }
    
//    /**
//     * deleteBatch records by the String Array of PK
//     */
//    public int deleteBatchByPK(String[] pkArray){
//    	if(pkArray==null||pkArray.length<=0)
//    		return 0;
//    	int rows = 0;
//    	Long[] arrs = new Long[pkArray.length];
//		for(int i=0;i<pkArray.length;i++){
//			if(pkArray[i]!=null)
//				arrs[i] = new Long(Long.parseLong(pkArray[i]));
//		}
//		rows = super.deleteBatch("Paperquestype.deleteByPK", arrs);
//		return rows;
//    }
    
    /**
     * static spring getMethod
     */
     public static PaperquestypeDao getInstance(){
       	 PaperquestypeDao dao = (PaperquestypeDao)BeanFactory.getBeanFactory().getBean("paperquestypeDao");
         return dao;
     }
    
}
