package platform.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import platform.bean.BeanFactory;
import platform.shop.dao.ShoplicenseDao;
import platform.shop.vo.Shoplicense;

import commonTool.base.BaseDao;

public class ShoplicenseDaoImpl extends BaseDao implements ShoplicenseDao {

	static Logger log = Logger.getLogger(ShoplicenseDaoImpl.class.getName());
	
    /**
     *
     */
    public ShoplicenseDaoImpl() {
        super();
    }
    
    /**
     * select some record by PK
     */
    public Shoplicense selectByPK(Long shopid, String syscode, String resourcecode){
    	if(shopid==null || syscode==null || resourcecode==null)
    		return null;
    	Shoplicense vo = new Shoplicense();
    	vo.setShopid(shopid);
    	vo.setSyscode(syscode);
    	vo.setResourcecode(resourcecode);
		Shoplicense record = (Shoplicense) this.queryForObject("Shoplicense.selectByPK", vo);
		return record;
    }
           
    /**
     * select records by shop
     */
    public List selectByShop(Long shopid, String syscode){
		if(shopid==null || syscode==null)
			return new ArrayList();
		Shoplicense vo = new Shoplicense();
		vo.setShopid(shopid);
    	vo.setSyscode(syscode);
		List list = this.queryForList("Shoplicense.selectByShop", vo);
		return list;
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Shoplicense record){
    	if(record==null)
    		return null;
		return (Long)super.insert("Shoplicense.insert", record);
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Shoplicense vo){
    	if(vo==null||vo.getShopid()==null||vo.getResourcecode()==null||vo.getSyscode()==null)
    		return 0;
    	if(vo.getAllocatenum()==null&&vo.getUsenum()==null)
    		return 0;
		int rows = super.update("Shoplicense.updateByPK", vo);
		return rows;
    }
    
    /**
     * 修改shop的license使用数据，累计的增加或减少
     * @param shopid
     * @param syscode
     * @param resourcecode
     * @param size
     * @return
     */
    public boolean updateLicenseUsageSum(Long shopid, String syscode, String resourcecode, Long size){
    	if(shopid==null||syscode==null||resourcecode==null||size==null){
    		return false;
    	}
    	Shoplicense vo = new Shoplicense();
    	vo.setShopid(shopid);
    	vo.setSyscode(syscode);
    	vo.setResourcecode(resourcecode);
    	vo.setUsenum(size);
    	super.update("Shoplicense.updateLicenseUsageSum", vo);
		return true;
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Shoplicense save(Shoplicense vo){
    	if(vo==null||vo.getShopid()==null||vo.getResourcecode()==null||vo.getSyscode()==null)
    		return null;
    	Shoplicense dbvo = selectByPK(vo.getShopid(), vo.getSyscode(), vo.getResourcecode());
		if(dbvo==null){
			this.insert(vo);
		}else{
			this.updateByPK(vo);
		}
		return vo;
    }

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long shopid, String syscode, String resourcecode){
    	if(shopid==null || syscode==null || resourcecode==null)
    		return 0;
    	Shoplicense vo = new Shoplicense();
    	vo.setShopid(shopid);
    	vo.setSyscode(syscode);
    	vo.setResourcecode(resourcecode);
		int rows = super.delete("Shoplicense.deleteByPK", vo);
		return rows;
    }
    
    /**
     * 根据商店和系统code删除，shopid为必须的
     */
    public int deleteByShop(Long shopid, String syscode){
    	if(shopid==null)
    		return 0;
    	Shoplicense vo = new Shoplicense();
    	vo.setShopid(shopid);
    	vo.setSyscode(syscode);
		int rows = super.delete("Shoplicense.deleteByShop", vo);
		return rows;
    }
    
    
    /**
     * static spring getMethod
     */
     public static ShoplicenseDao getInstance(){
       	 ShoplicenseDao dao = (ShoplicenseDao)BeanFactory.getBeanFactory().getBean("shoplicenseDao");
         return dao;
     }
    
}
