package netTest.product.dao;

import java.util.Date;

import netTest.product.vo.Openactivity;
import commonTool.base.Page;

public interface OpenactivityDao {
   
    /**
     * select some record by PK
     */
    public Openactivity selectByPK(Long pk);
    
    /**
     * select plain record by PK
     */
    public Openactivity selectByPKSimple(Long pk);
            
    public Page query(Long categoryid, String name, Long localeid, 
			   String regioncode, Short status, Long shopid, Long productid, 
			   Date starttime1, Date starttime2, Date endtime1, Date endtime2, 
			   Integer pageIndex, Integer pageSize,Integer total);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Openactivity record);

    /**
     * update a record By PK
     */
    public int updateByPK(Openactivity record);
    
    public int updateUserNum(Long activityid, Integer increaseNum);

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Openactivity save(Openactivity record);

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk);
	
}
