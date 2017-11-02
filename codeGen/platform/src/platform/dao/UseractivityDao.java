package platform.user.dao;

import java.util.List;
import commonTool.base.Page;
import platform.user.vo.Useractivity;
import platform.user.dto.UseractivityQuery;

public interface UseractivityDao {
   
    /**
     * select some record by PK
     */
    public Useractivity selectByPK(Long pk);
            
    /**
     * select records by queryVO
     */
    public List selectByVO(UseractivityQuery queryVO);
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(UseractivityQuery queryVO,int pageIndex,int pageSize);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Useractivity record);

    /**
     * update a record By PK
     */
    public int updateByPK(Useractivity record);

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Useractivity save(Useractivity record);

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk);
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list);
    
    /**
     * deleteBatch records by the String Array of PK
     */
    public int deleteBatchByPK(String[] pkArray);
	
}
