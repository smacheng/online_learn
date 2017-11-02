package platform.shop.dao;

import java.util.Date;
import java.util.List;

import platform.shop.vo.Shoppost;

import commonTool.base.Page;

public interface ShoppostDao {
   
    /**
     * select some record by PK
     */
    public Shoppost selectByPK(Long pk);
            
    /**
     * select records by queryVO
     */
//    public List selectByVO(ShoppostQuery queryVO);
    
    /**
     * select page by queryVO 
     */
    public Page selectByVOPage(Long shopid, String caption, Short status, String syscode, 
    						   int pageIndex, int pageSize, Integer total);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Shoppost record);

    /**
     * update a record By PK
     */
    public int updateByPK(Shoppost record);

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Shoppost save(Shoppost record);

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk);
        
    /**
     * 查询超过给定时间的数据，主要是为清理脏数据使用
     * 仅仅返回前600条数据，需要反复调用处理
     */
    public List<Shoppost> selectLongTimeData(Date date, Short status);
    
    /**
     * 删除超过给定时间的数据，主要是为清理脏数据使用
     * 目前全部查询出来，假设开始数据应该是每天小于1万条
     */
    public int deleteLongTimeData(Date date, Short status);
	
}
