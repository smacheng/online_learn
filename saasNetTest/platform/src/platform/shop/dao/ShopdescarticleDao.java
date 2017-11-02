package platform.shop.dao;

import java.util.List;

import platform.shop.dto.ShopdescarticleQuery;
import platform.shop.vo.Shopdescarticle;

public interface ShopdescarticleDao {
   
    /**
     * select some record by PK
     */
    public Shopdescarticle selectByPK(Long pk);
    
    /**
     * select some record by logic PK
     */
    public Shopdescarticle selectByLogicPK(Long shopid, Short articletype);
    
    /**
     * select records by queryVO
     */
    public List selectByVO(ShopdescarticleQuery queryVO);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Shopdescarticle record);

    /**
     * update a record By PK
     */
    public int updateByPK(Shopdescarticle record);

	/**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Shopdescarticle save(Shopdescarticle record);

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk);
	
}