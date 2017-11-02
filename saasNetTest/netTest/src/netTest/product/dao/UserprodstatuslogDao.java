package netTest.product.dao;

import java.util.List;

import netTest.product.dto.UserprodstatuslogQuery;
import netTest.product.vo.Userprodstatuslog;
import commonTool.base.Page;

public interface UserprodstatuslogDao {
             
    /**
     * select some record by PK
     */
    public Userprodstatuslog selectByPK(Long pk) ;
	
    /**
     * select records by queryVO
     */
    public List selectByVO(UserprodstatuslogQuery queryVO);
 
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(UserprodstatuslogQuery queryVO,int pageIndex,int pageSize,Integer total) ;
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Userprodstatuslog record);

 	/**
     * insertBatch records of List
     */
    public int insertBatch(List list);
    
	
}
