package acegi.daoImpl;

import java.util.List;
import org.apache.log4j.Logger;
import commonTool.base.BaseDao;
import commonTool.base.Page;
import acegi.dao.RolesvalueDao;
import commonTool.constant.CommonConstant;
import acegi.vo.Rolesvalue;
import acegi.dto.RolesvalueQuery;
import acegi.bean.BeanFactory;

public class RolesvalueDaoImpl extends BaseDao implements RolesvalueDao {

	static Logger log = Logger.getLogger(RolesvalueDaoImpl.class.getName());
	
    /**
     *
     */
    public RolesvalueDaoImpl() {
        super();
    }
    
    /**
     * select some record by PK
     */
    public Rolesvalue selectByPK(Long pk){
    	if(pk==null)
    		return null;
		Rolesvalue record = (Rolesvalue) this.queryForObject("Rolesvalue.selectByPK", pk);
		return record;
    }
    
    /**
     * select all records
     * @return
     */
    public List selectAll(){
		List list = this.queryForList("Rolesvalue.selectAll", null);
		return list;
    }
        
    /**
     * select records by queryVO
     */
    public List selectByVO(RolesvalueQuery queryVO){
		if(queryVO==null)
			return selectAll();
		List list = this.queryForList("Rolesvalue.selectByVO", queryVO);
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
    public Page selectByVOPage(RolesvalueQuery queryVO,int pageIndex,int pageSize){
        if(pageIndex<=0)
        	pageIndex = 1;
        if(pageSize<=0)
        	pageSize = CommonConstant.PAGESIZE;
        String sqlStr = "";
        if(queryVO==null)
        	sqlStr = "Rolesvalue.selectAll";
        else 
        	sqlStr = "Rolesvalue.selectByVO";
        return queryForPage(sqlStr, queryVO, pageIndex, pageSize);
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Rolesvalue record){
    	if(record==null)
    		return null;
		return (Long)super.insert("Rolesvalue.insert", record);
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Rolesvalue record){
    	if(record==null||record.getValueid()==null)
    		return 0;
		int rows = super.update("Rolesvalue.updateByPK", record);
		return rows;
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Rolesvalue save(Rolesvalue record){
    	if(record==null)
    		return null;
		if(record.getValueid()==null||record.getValueid().intValue()==0){
			Long pkValue = this.insert(record);
			record.setValueid(pkValue);
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
		int rows = super.delete("Rolesvalue.deleteByPK", pk);
		return rows;
    }
    
    /**
     * delete records by queryVO
     */
    public int deleteByVO(RolesvalueQuery queryVO){
    	if(queryVO==null)
    		return 0;
		int rows = super.delete("Rolesvalue.deleteByVO",queryVO);
		return rows;
    }
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list){
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
       	rows = super.insertBatch("Rolesvalue.insert", list);
       	return rows;
    }
    
    /**
     * updateBatch records of List
     */
    public int updateBatch(List list){
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
       	rows = super.updateBatch("Rolesvalue.updateByPK", list);
       	return rows;
    }
    
    /**
     * deleteBatch records by the Long Array of PK
     */
    public int deleteBatchByPK(Long[] pkArray){
    	if(pkArray==null||pkArray.length<=0)
    		return 0;
    	int rows = 0;
       	rows = super.deleteBatch("Rolesvalue.deleteByPK", pkArray);
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
		rows = this.deleteBatchByPK(arrs);
		return rows;
    }
    
    /**
     * static spring getMethod
     */
     public static RolesvalueDao getInstance(){
       	 RolesvalueDao dao = (RolesvalueDao)BeanFactory.getBeanFactory().getBean("rolesvalueDao");
         return dao;
     }
    
}
