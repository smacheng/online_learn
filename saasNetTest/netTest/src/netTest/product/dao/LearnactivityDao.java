package netTest.product.dao;

import java.util.List;
import java.util.Map;

import netTest.product.dto.LearnactivityQuery;
import netTest.product.vo.Learnactivity;

public interface LearnactivityDao {
   
    /**
     * select some record by PK
     */
	public Learnactivity selectByPK(Long userid, Long objectid, 
            String objecttype, Short actiontype);
	
	public Learnactivity selectLearnLastest(Long userid, Long productid);
            
    /**
     * select records by queryVO
     */
    public List selectByVO(LearnactivityQuery queryVO);
    
    /**
     * 查询用户学习记录
     */
    public Map<String, Learnactivity> selectUserLearnActivity(Long userid, Long productid, String objecttype);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Learnactivity record);

    /**
     * update a record By PK
     */
    public int updateByPK(Learnactivity record);
    
    public int save(Learnactivity vo);


    /**
     * delete a record by PK
     */
    public int deleteByPK(Long userid, Long objectid, String objecttype, Short actiontype);
    
    /**
     * delete a record by product
     */
    public int deleteByProduct(Long userid, Long productid);
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list);
    	
}
