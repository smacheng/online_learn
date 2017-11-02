package netTest.wareques.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import commonTool.base.BaseDao;
import commonTool.base.Page;
import netTest.wareques.dao.QuesdifficultDao;
import commonTool.constant.CommonConstant;
import netTest.wareques.vo.Quesdifficult;
import netTest.wareques.dto.QuesdifficultQuery;
import netTest.bean.BeanFactory;

public class QuesdifficultDaoImpl extends BaseDao implements QuesdifficultDao {

	static Logger log = Logger.getLogger(QuesdifficultDaoImpl.class.getName());
	
    /**
     *
     */
    public QuesdifficultDaoImpl() {
        super();
    }
    
    /**
     * select some record by PK
     */
    public Quesdifficult selectByPK(Long pk){
    	if(pk==null)
    		return null;
		Quesdifficult record = (Quesdifficult) this.queryForObject("Quesdifficult.selectByPK", pk);
		return record;
    }
           
    /**
     * select records by queryVO
     */
    public List selectByVO(QuesdifficultQuery queryVO){
		if(queryVO==null)
			return new ArrayList();
		List list = this.queryForList("Quesdifficult.selectByVO", queryVO);
		return list;
    }
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(QuesdifficultQuery queryVO,int pageIndex,int pageSize,Integer total){
        if(pageIndex<=0)
        	pageIndex = 1;
        if(pageSize<=0)
        	pageSize = CommonConstant.PAGESIZE;
        Page page = null;
        String sqlStr = "";
        if(queryVO==null){
        	page = Page.EMPTY_PAGE;
        } else {
        	sqlStr = "Quesdifficult.selectByVO";
        	page = queryForPage(sqlStr, queryVO, pageIndex, pageSize, total);
        }
        return page;
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Quesdifficult record){
    	if(record==null)
    		return null;
		return (Long)super.insert("Quesdifficult.insert", record);
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Quesdifficult record){
    	if(record==null||record.getDifficultid()==null)
    		return 0;
		int rows = super.update("Quesdifficult.updateByPK", record);
		return rows;
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Quesdifficult save(Quesdifficult record){
    	if(record==null)
    		return null;
		if(record.getDifficultid()==null||record.getDifficultid().intValue()==0){
			Long pkValue = this.insert(record);
			record.setDifficultid(pkValue);
    		return record;
		}else{
			this.updateByPK(record);
			return record;
		}
    }

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk){
    	if(pk==null)
    		return 0;
		int rows = super.delete("Quesdifficult.deleteByPK", pk);
		return rows;
    }
    
    /**
     * delete records by queryVO
     */
    public int deleteByVO(QuesdifficultQuery queryVO){
    	if(queryVO==null)
    		return 0;
		int rows = super.delete("Quesdifficult.deleteByVO",queryVO);
		return rows;
    }
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list){
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
       	rows = super.insertBatch("Quesdifficult.insert", list);
       	return rows;
    }
    
    /**
     * updateBatch records of List
     */
    public int updateBatch(List list){
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
       	rows = super.updateBatch("Quesdifficult.updateByPK", list);
       	return rows;
    }
    
    /**
     * deleteBatch records by the String Array of PK
     */
    public int deleteBatchByPK(String[] pkArray){
    	if(pkArray==null||pkArray.length<=0)
    		return 0;
    	int rows = 0;
    	Long[] arrs = new Long[pkArray.length];
		for(int i=0;i<pkArray.length;i++){
			if(pkArray[i]!=null)
				arrs[i] = new Long(Long.parseLong(pkArray[i]));
		}
		rows = super.deleteBatch("Quesdifficult.deleteByPK", arrs);
		return rows;
    }
    
    /**
     * static spring getMethod
     */
     public static QuesdifficultDao getInstance(){
       	 QuesdifficultDao dao = (QuesdifficultDao)BeanFactory.getBeanFactory().getBean("quesdifficultDao");
         return dao;
     }
    
}