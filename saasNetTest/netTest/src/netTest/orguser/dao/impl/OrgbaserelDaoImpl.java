package netTest.orguser.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import commonTool.base.BaseDao;
import commonTool.base.Page;
import commonTool.constant.CommonConstant;
import netTest.orguser.dao.OrgbaserelDao;
import netTest.orguser.dto.OrgbaserelQuery;
import netTest.orguser.vo.Orgbaserel;
import netTest.bean.BeanFactory;

public class OrgbaserelDaoImpl extends BaseDao implements OrgbaserelDao {

	static Logger log = Logger.getLogger(OrgbaserelDaoImpl.class.getName());
	
    /**
     *
     */
    public OrgbaserelDaoImpl() {
        super();
    }
    
    /**
     * select some record by PK
     */
    public Orgbaserel selectByPK(Long pk) throws Exception {
    	if(pk==null)
    		return null;
        try {
			Orgbaserel record = (Orgbaserel) this.queryForObject("Orgbaserel.selectByPK", pk);
			return record;
		} catch (Exception e) {
			log.error("OrgbaserelDaoImpl主键查询selectByPK时出错误!", e);
			throw e ;
		}
    }
    
    /**
     * select all records
     * @return
     */
    public List selectAll() throws Exception {
    	try {
			List list = this.queryForList("Orgbaserel.selectAll", null);
			return list;
		} catch (Exception e) {
			log.error("OrgbaserelDaoImpl的selectAll时出错误!", e);
			throw e ;
		}
    }
        
    /**
     * select records by queryVO
     */
    public List selectByVO(OrgbaserelQuery queryVO) throws Exception {
        try {
			if(queryVO==null)
				return selectAll();
			List list = this.queryForList("Orgbaserel.selectByVO", queryVO);
			return list;
        } catch (Exception e) {
			log.error("OrgbaserelDaoImpl的selectByVO时出错误!", e);
			throw e ;
		}
    }
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(OrgbaserelQuery queryVO,int pageIndex,int pageSize,Integer total) throws Exception {
        if(pageIndex<=0)
        	pageIndex = 1;
        if(pageSize<=0)
        	pageSize = CommonConstant.PAGESIZE;
        String sqlStr = "";
        if(queryVO==null)
        	sqlStr = "Orgbaserel.selectAll";
        else 
        	sqlStr = "Orgbaserel.selectByVO";
        try{
	        return queryForPage(sqlStr, queryVO, pageIndex, pageSize, total);
        }catch(Exception e) {
            log.error("OrgbaserelDaoImpl分页查询selectByVOPage时出错误!", e);
			throw e ;
        }
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Orgbaserel record) throws Exception {
    	if(record==null)
    		return null;
        try {
			return (Long)super.insert("Orgbaserel.insert", record);
        }catch(Exception e) {
            log.error("OrgbaserelDaoImpl插入insert时出错误!", e);
			throw e ;
        }
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Orgbaserel record) throws Exception {
    	if(record==null||record.getOrgbaserelid()==null)
    		return 0;
        try {
			int rows = super.update("Orgbaserel.updateByPK", record);
			return rows;
        }catch(Exception e) {
            log.error("OrgbaserelDaoImpl更新updateByPK时出错误!", e);
			throw e ;
        }
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Orgbaserel save(Orgbaserel record) throws Exception {
    	if(record==null)
    		return null;
    	try {
			if(record.getOrgbaserelid()==null||record.getOrgbaserelid().intValue()==0){
				Long pkValue = this.insert(record);
				record.setOrgbaserelid(pkValue);
				return record;
			}else{
				this.updateByPK(record);
				return record;
			}
		} catch (RuntimeException e) {
			log.error("OrgbaserelDaoImpl保存save时出错误!", e);
			throw e ;
		}
    }

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk) throws Exception {
    	if(pk==null)
    		return 0;
        try {
			int rows = super.delete("Orgbaserel.deleteByPK", pk);
			return rows;
        }catch(Exception e) {
            log.error("OrgbaserelDaoImpl删除deleteByPK时出错误!", e);
			throw e ;
        }
    }
    
    /**
     * delete records by queryVO
     */
    public int deleteByVO(OrgbaserelQuery queryVO) throws Exception {
    	if(queryVO==null)
    		return 0;
        try {
			int rows = super.delete("Orgbaserel.deleteByVO",queryVO);
			return rows;
        }catch(Exception e) {
            log.error("OrgbaserelDaoImpl删除deleteByVO时出错误!", e);
			throw e ;
        }
    }
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list) throws Exception {
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
        try {
        	rows = super.insertBatch("Orgbaserel.insert", list);
        	return rows;
        }catch(Exception e) {
            log.error("OrgbaserelDaoImpl批量新增insertBatch(List list)时出错误!", e);
			throw e ;
        }
    }
    
    /**
     * updateBatch records of List
     */
    public int updateBatch(List list) throws Exception {
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
        try {
        	rows = super.updateBatch("Orgbaserel.updateByPK", list);
        	return rows;
        }catch(Exception e) {
            log.error("OrgbaserelDaoImpl批量修改updateBatch(List list)时出错误!", e);
			throw e ;
        }
    }
    
    /**
     * deleteBatch records by the Long Array of PK
     */
    public int deleteBatchByPK(Long[] pkArray) throws Exception {
    	if(pkArray==null||pkArray.length<=0)
    		return 0;
    	int rows = 0;
        try {
        	rows = super.deleteBatch("Orgbaserel.deleteByPK", pkArray);
        	return rows;
        }catch(Exception e) {
            log.error("OrgbaserelDaoImpl删除deleteBatchByPK(Long[] pkArray)时出错误!", e);
			throw e ;
        }
    }
    
    /**
     * deleteBatch records by the String Array of PK
     */
    public int deleteBatchByPK(String[] pkArray) throws Exception {
    	if(pkArray==null||pkArray.length<=0)
    		return 0;
    	int rows = 0;
    	Long[] arrs = new Long[pkArray.length];
    	try {
			for(int i=0;i<pkArray.length;i++){
				if(pkArray[i]!=null)
					arrs[i] = new Long(Long.parseLong(pkArray[i]));
			}
			rows = this.deleteBatchByPK(arrs);
			return rows;
		} catch (NumberFormatException e) {
			log.error("OrgbaserelDaoImpl删除deleteBatchByPK(String[] pkArray)时出现转换错�?!", e);
			throw new Exception("NumberFormatException：from String to Long!") ;
		}catch(Exception e) {
            log.error("OrgbaserelDaoImpl删除deleteBatchByPK(String[] pkArray)时出错误!", e);
			throw e ;
        }
    	
    }
    
    /**
     * static spring getMethod
     */
     public static OrgbaserelDao getInstance() {
       	 OrgbaserelDao dao = (OrgbaserelDao)BeanFactory.getBeanFactory().getBean("orgbaserelDaoProxy");
         return dao;
     }
    
}
