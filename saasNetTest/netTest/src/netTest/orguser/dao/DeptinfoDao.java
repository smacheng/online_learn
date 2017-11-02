package netTest.orguser.dao;

import java.util.List;
import commonTool.base.Page;
import netTest.orguser.dto.DeptinfoQuery;
import netTest.orguser.vo.Deptinfo;

public interface DeptinfoDao {
   
    /**
     * select some record by PK
     */
    public Deptinfo selectByPK(Long pk) ;
        
    /**
     * select records by queryVO
     */
    public List selectByVO(DeptinfoQuery queryVO) ;
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(DeptinfoQuery queryVO,int pageIndex,int pageSize,Integer total) throws Exception;
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Deptinfo record);

    /**
     * update a record By PK
     */
    public int updateByPK(Deptinfo record) throws Exception;
    
    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Deptinfo save(Deptinfo record) throws Exception ;

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk) throws Exception ;
    
    /**
     * delete records by queryVO
     */
    public int deleteByVO(DeptinfoQuery queryVO) throws Exception ;

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
