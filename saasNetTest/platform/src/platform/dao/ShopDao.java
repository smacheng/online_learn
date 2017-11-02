package platform.dao;

import java.util.List;
import commonTool.base.Page;
import platform.vo.Shop;
import platform.dto.ShopQuery;

public interface ShopDao {
   
//	public Shop selectByPK(Long pk);
	
    /**
     * select some record by PK
     */
    public Shop selectByPK(Long shopid,Long localeid) ;
    
    /**
     * 根据shopcode查询商店
     */
    public Shop selectByCode(String shopcode);
   
    /**
     * select records WithoutBLOBs by queryVO
     */
    //public List selectByVOWithoutBLOBs(ShopQuery queryVO)  ;
    
    /**
     * select page by queryVO WithoutBLOBs
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @
     */
    //public Page selectByVOWithoutBLOBsPage(ShopQuery queryVO,int pageIndex,int pageSize,Integer total)  ;
        
    /**
     * select records including all fields by queryVO
     */
    public List selectByVO(ShopQuery queryVO);
    
    /**
     * 查询user创建了多少个商店
     * @param userid
     * @return
     */
    public int selectCountByOwner(Long userid);
    
    
    public Page selectByVOPage(Long categoryid, String regioncode, Short ownertype, Short opentype,
			String searchText, Long localeID, Short shopStatus,	
			int pageIndex,int pageSize,Integer total);
        
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Shop record) ;

    /**
     * update a record By PK
     */
    public int updateByPK(Shop record) ;
    
    /**
     * 根据主键更新商店的状态
     * @param vo
     * @return
     */
    public boolean updateStatus(Shop vo);

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @
     */
    public Shop save(Shop record) ;

    /**
     * 删除了商店的多国语言值Shopvalue、商店功能Shopfunc、商店选择的课程目录和商店本身shop
     */
    public int deleteByPK(Long pk);
        
    /**
     * 查询该用户已经设置过商店的Locale集合，用于根据Locales选择商店
     * 用户已经设置了商店的I18n的List集合
     * @param userid
     * @return I18n的List集合
     */
    public List selectUserSetLocales(Long userid) ;
    
    /**
     * 查询该商店已经设置过的Locale集合，用于根据Locales查看商店信息
     * 商店已经设置的I18n的List集合
     * @param userid
     * @return I18n的List集合
     */
    public List selectShopSetLocales(Long userid) ;
    
    /**
     * 检查是否有重code的商店
     * @return true:有重名商店, false:没有重名商店
     */
    public boolean existcheckByCode(String shopcode) ;
	
}