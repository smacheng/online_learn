package platform.mail.dao;

import java.util.List;
import java.util.Map;

import commonTool.base.Page;
import platform.mail.vo.Emailtemplate;

public interface EmailtemplateDao {
   
    /**
     * select some record by PK
     */
    public Emailtemplate selectByPK(Long pk);
    
    /**
     * select some record by PK
     */
    public Emailtemplate selectByLogicPK(String templatename, String locale, String syscode);
    
    /**
     * select by syscode, and return map, which has logicPK as map key
     * the value is emailTemplate object
     */
    public Map<String, Emailtemplate> selectEmailtemplateMap(String syscode);
        
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    //public Page selectByVOPage(Emailtemplate queryVO,int pageIndex,int pageSize,Integer total);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Emailtemplate record);

    /**
     * update a record By PK
     */
    public int updateByPK(Emailtemplate record);

	/**
     * insertBatch records of List
     */
    public int insertBatch(List list);
    
}