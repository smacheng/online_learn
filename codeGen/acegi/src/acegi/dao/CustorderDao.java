package acegi.dao;

import java.util.List;
import commonTool.base.Page;
import acegi.vo.Custorder;
import acegi.dto.CustorderQuery;

public interface CustorderDao {
   
    /**
     * select some record by PK
     */
    public Custorder selectByPK(Long pk);
    
    /**
     * select all records
     * @return
     */
    public List selectAll();
        
    /**
     * select records by queryVO
     */
    public List selectByVO(CustorderQuery queryVO);
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(CustorderQuery queryVO,int pageIndex,int pageSize);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Custorder record);

    /**
     * update a record By PK
     */
    public int updateByPK(Custorder record);

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Custorder save(Custorder record);

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk) throws Exception ;
    
    /**
     * delete records by queryVO
     */
    public int deleteByVO(CustorderQuery queryVO);

	/**
     * insertBatch records of List
     */
    public int insertBatch(List list);
    
    /**
     * updateBatch records of List
     */
    public int updateBatch(List list);
    
    /**
     * deleteBatch records by the Long Array of PK
     */
    public int deleteBatchByPK(Long[] pkArray);
    
    /**
     * deleteBatch records by the String Array of PK
     */
    public int deleteBatchByPK(String[] pkArray);
	
}
