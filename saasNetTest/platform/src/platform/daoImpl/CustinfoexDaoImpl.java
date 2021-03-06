package platform.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import platform.bean.BeanFactory;
import platform.dao.CustinfoexDao;
import platform.dto.CustinfoexQuery;
import platform.vo.Custinfoex;
import commonTool.base.BaseDao;
import commonTool.base.Page;
import commonTool.constant.CommonConstant;

public class CustinfoexDaoImpl extends BaseDao implements CustinfoexDao {

	static Logger log = Logger.getLogger(CustinfoexDaoImpl.class.getName());
	
    /**
     *
     */
    public CustinfoexDaoImpl() {
        super();
    }
    
    /**
     * select some record by PK
     */
    public Custinfoex selectByPK(Long pk) {
    	if(pk==null)
    		return null;
		Custinfoex record = (Custinfoex) this.queryForObject("Custinfoex.selectByPK", pk);
		return record;
    }
            
    /**
     * select records by queryVO
     */
    public List selectByVO(CustinfoexQuery queryVO)  {
		if(queryVO==null)
			return new ArrayList();
		List list = this.queryForList("Custinfoex.selectByVO", queryVO);
		return list;
    }
    
    /**
     * select page by queryVO 
     */
    public Page selectByVOPage(CustinfoexQuery queryVO,int pageIndex,int pageSize,Integer total) {
    	if(queryVO==null)
    		return Page.EMPTY_PAGE;
    	if(pageIndex<=0)
        	pageIndex = 1;
        if(pageSize<=0)
        	pageSize = CommonConstant.PAGESIZE;
        return queryForPage("Custinfoex.selectByVO", queryVO, pageIndex, pageSize, total);
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Custinfoex record)  {
    	if(record==null)
    		return null;
		return (Long)super.insert("Custinfoex.insert", record);
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Custinfoex record)  {
    	if(record==null||record.getUserid()==null)
    		return 0;
    	Long pk = record.getUserid();
    	record.setUserid(null);
    	if(record.isEmpty())
    		return 0;
    	record.setUserid(pk);
		int rows = super.update("Custinfoex.updateByPK", record);
		return rows;
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @
     */
    public Custinfoex save(Custinfoex record)  {
    	if(record==null||record.getUserid()==null)
    		return null;
		Long userid = record.getUserid();
		Custinfoex votemp = this.selectByPK(userid);
		if(votemp==null)
			this.insert(record);
		else
			this.updateByPK(record);
		return record;
    }

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk) {
    	if(pk==null)
    		return 0;
		int rows = super.delete("Custinfoex.deleteByPK", pk);
		return rows;
    }
    
    /**
     * delete records by queryVO
     */
    public int deleteByVO(CustinfoexQuery queryVO)  {
    	if(queryVO==null)
    		return 0;
		int rows = super.delete("Custinfoex.deleteByVO",queryVO);
		return rows;
    }
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list)  {
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
       	rows = super.insertBatch("Custinfoex.insert", list);
       	return rows;
    }
    
    /**
     * updateBatch records of List
     */
    public int updateBatch(List list)  {
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
       	rows = super.updateBatch("Custinfoex.updateByPK", list);
       	return rows;
    }
    
    /**
     * deleteBatch records by the Long Array of PK
     */
    public int deleteBatchByPK(Long[] pkArray)  {
    	if(pkArray==null||pkArray.length<=0)
    		return 0;
    	int rows = super.deleteBatch("Custinfoex.deleteByPK", pkArray);
       	return rows;
    }
    
    /**
     * deleteBatch records by the String Array of PK
     */
    public int deleteBatchByPK(String[] pkArray)  {
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
     public static CustinfoexDao getInstance() {
       	 CustinfoexDao dao = (CustinfoexDao)BeanFactory.getBeanFactory().getBean("custinfoexDao");
         return dao;
     }
    
}
