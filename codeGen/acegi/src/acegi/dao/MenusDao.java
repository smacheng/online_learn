package acegi.dao;

import java.util.List;
import commonTool.base.Page;
import acegi.vo.Menus;
import acegi.dto.MenusQuery;

public interface MenusDao {
   
    /**
     * select some record by PK
     */
    public Menus selectByPK(Long pk);
    
    /**
     * select all records
     * @return
     */
    public List selectAll();
        
    /**
     * select records by queryVO
     */
    public List selectByVO(MenusQuery queryVO);
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(MenusQuery queryVO,int pageIndex,int pageSize);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Menus record);

    /**
     * update a record By PK
     */
    public int updateByPK(Menus record);

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Menus save(Menus record);

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk) throws Exception ;
    
    /**
     * delete records by queryVO
     */
    public int deleteByVO(MenusQuery queryVO);

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
