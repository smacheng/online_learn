package netTest.product.dao.impl;

import java.util.List;

import netTest.bean.BeanFactory;
import netTest.product.dao.UserprodstatuslogDao;
import netTest.product.dto.UserprodstatuslogQuery;
import netTest.product.vo.Userprodstatuslog;

import org.apache.log4j.Logger;

import commonTool.base.BaseDao;
import commonTool.base.Page;
import commonTool.constant.CommonConstant;

public class UserprodstatuslogDaoImpl extends BaseDao implements UserprodstatuslogDao {

	static Logger log = Logger.getLogger(UserprodstatuslogDaoImpl.class.getName());
	
    /**
     *
     */
    public UserprodstatuslogDaoImpl() {
        super();
    }
    
    
    /**
     * select some record by PK
     */
    public Userprodstatuslog selectByPK(Long pk) {
    	if(pk==null)
    		return null;
    	Userprodstatuslog record = (Userprodstatuslog) this.queryForObject("Userprodstatuslog.selectByPK", pk);
		return record;
    }
        
    /**
     * select records by queryVO
     */
    public List selectByVO(UserprodstatuslogQuery queryVO){
		if(queryVO==null)
			return null;
		List list = this.queryForList("Userprodstatuslog.selectByVO", queryVO);
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
    public Page selectByVOPage(UserprodstatuslogQuery queryVO,int pageIndex,int pageSize,Integer total) {
        if(pageIndex<=0)
        	pageIndex = 1;
        if(pageSize<=0)
        	pageSize = CommonConstant.PAGESIZE;
        String sqlStr = "Userprodstatuslog.selectByVO";
        return queryForPage(sqlStr, queryVO, pageIndex, pageSize, total);
    }
    
        
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Userprodstatuslog record) {
    	if(record==null)
    		return null;
		return (Long)super.insert("Userprodstatuslog.insert", record);
    }

    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list) {
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
       	rows = super.insertBatch("Userprodstatuslog.insert", list);
       	return rows;
    }
    
    
    
    /**
     * static spring getMethod
     */
     public static UserprodstatuslogDao getInstance() {
       	 UserprodstatuslogDao dao = (UserprodstatuslogDao)BeanFactory.getBeanFactory().getBean("userprodstatuslogDao");
         return dao;
     }
    
}
