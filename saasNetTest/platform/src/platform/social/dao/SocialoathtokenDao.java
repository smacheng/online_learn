package platform.social.dao;

import platform.social.vo.Socialoathtoken;


public interface SocialoathtokenDao {
	
    /**
     * select all social account binded by an identity
     */
    public Socialoathtoken selectByUser(Long identityid, Short identitytype);
   
    /**
     * select some record by PK
     */
    public Socialoathtoken selectBySocialAccount(Short identitytype, Short servicetype, String socialuserid);
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public void insert(Socialoathtoken record);

    /**
     * update a record By PK
     */
    public int updateByPK(Socialoathtoken record);
    
    /**
     * delete a record by PK
     */
    public int deleteByPK(Long identityid, Short identitytype, Short servicetype, String socialuserid);
    	
}
