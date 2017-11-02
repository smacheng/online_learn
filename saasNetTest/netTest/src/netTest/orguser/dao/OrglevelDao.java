package netTest.orguser.dao;

import java.util.List;
import commonTool.base.Page;
import netTest.orguser.dto.OrglevelQuery;
import netTest.orguser.vo.Orglevel;

public interface OrglevelDao {
   
    /**
     * select some record by PK
     */
    public Orglevel selectByPK(Long pk) throws Exception ;
    
    /**
     * select all records
     * @return
     */
    public List selectAll() throws Exception ;
        
    /**
     * select records by queryVO
     */
    public List selectByVO(OrglevelQuery queryVO) throws Exception ;
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(OrglevelQuery queryVO,int pageIndex,int pageSize,Integer total) throws Exception ;
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Orglevel record) throws Exception ;

    /**
     * update a record By PK
     */
    public int updateByPK(Orglevel record) throws Exception ;

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Orglevel save(Orglevel record) throws Exception ;

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk) throws Exception ;
    
    /**
     * delete records by queryVO
     */
    public int deleteByVO(OrglevelQuery queryVO) throws Exception ;

	/**
     * insertBatch records of List
     */
    public int insertBatch(List list) throws Exception ;
    
    /**
     * updateBatch records of List
     */
    public int updateBatch(List list) throws Exception ;
    
    /**
     * deleteBatch records by the Long Array of PK
     */
    public int deleteBatchByPK(Long[] pkArray) throws Exception ;
    
    /**
     * deleteBatch records by the String Array of PK
     */
    public int deleteBatchByPK(String[] pkArray) throws Exception ;
	
}
