package netTest.paper.dao;

import java.util.List;
import commonTool.base.Page;
import netTest.paper.vo.Paperprop;
import netTest.paper.dto.PaperpropQuery;

public interface PaperpropDao {
   
    /**
     * select some record by PK
     */
    public Paperprop selectByPK(Long pk);
            
    /**
     * select records by queryVO
     */
    public List selectByVO(PaperpropQuery queryVO);
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(PaperpropQuery queryVO,int pageIndex,int pageSize,Integer total);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Paperprop record);

    /**
     * update a record By PK
     */
    public int updateByPK(Paperprop record);

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Paperprop save(Paperprop record);

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
