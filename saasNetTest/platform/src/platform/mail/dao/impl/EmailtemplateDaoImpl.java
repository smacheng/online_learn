package platform.mail.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import platform.bean.BeanFactory;
import platform.mail.dao.EmailtemplateDao;
import platform.mail.vo.Emailtemplate;

import commonTool.base.BaseDao;

public class EmailtemplateDaoImpl extends BaseDao implements EmailtemplateDao {

	static Logger log = Logger.getLogger(EmailtemplateDaoImpl.class.getName());
	
    /**
     *
     */
    public EmailtemplateDaoImpl() {
        super();
    }
    
    public static String getLogicCacheKey(String templatename, String locale){
    	return templatename+"~"+locale;
    }
    
    /**
     * select some record by PK
     */
    @Cacheable(value="platform.emailCache", key="'EmailtemplateDao.selectByPK~'+#pk", unless="#result==null")
    public Emailtemplate selectByPK(Long pk){
    	if(pk==null)
    		return null;
		Emailtemplate record = (Emailtemplate) this.queryForObject("Emailtemplate.selectByPK", pk);
		return record;
    }
    
    @Cacheable(value="platform.emailCache", key="'EmailtemplateDao.selectByLogicPK~'+#templatename+'~'+#locale+'~'+#syscode", unless="#result==null")
	public Emailtemplate selectByLogicPK(String templatename, String locale, String syscode) {
		Emailtemplate vo = new Emailtemplate();
		vo.setTemplatename(templatename);
		vo.setLocale(locale);
		vo.setSyscode(syscode);
		vo = (Emailtemplate) this.queryForObject("Emailtemplate.selectByLogicPK", vo);
		return vo;
	}
    
    /**
     * select by syscode, and return map, which has logicPK as map key
     * the value is emailTemplate object
     */
    @Cacheable(value="platform.emailCache", key="'EmailtemplateDao.selectEmailtemplateMap~'+#syscode")
    public Map<String, Emailtemplate> selectEmailtemplateMap(String syscode){
		if(syscode==null||syscode.trim().length()<1)
			return null;
		Map<String, Emailtemplate> map = new HashMap<String, Emailtemplate>();
		List list = this.queryForList("Emailtemplate.selectBySyscode", syscode);
		if(list!=null&&list.size()>0){
			Emailtemplate vo = null;
			for(int i=0;i<list.size();i++){
				vo = (Emailtemplate)list.get(i);
				map.put(getLogicCacheKey(vo.getTemplatename(), vo.getLocale()), vo);
			}
		}
		return map;
    }
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
//    public Page selectByVOPage(Emailtemplate queryVO,int pageIndex,int pageSize,Integer total){
//        if(pageIndex<=0)
//        	pageIndex = 1;
//        if(pageSize<=0)
//        	pageSize = CommonConstant.PAGESIZE;
//        Page page = null;
//        String sqlStr = "";
//        if(queryVO==null){
//        	page = Page.EMPTY_PAGE;
//        } else {
//        	sqlStr = "Emailtemplate.selectByVO";
//        	page = queryForPage(sqlStr, queryVO, pageIndex, pageSize, total);
//        }
//        return page;
//    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    @Caching(evict={@CacheEvict(value="platform.emailCache", allEntries=true)})
    public Long insert(Emailtemplate record){
    	if(record==null)
    		return null;
		Long pk = (Long)super.insert("Emailtemplate.insert", record);
		return pk;
    }

    /**
     * update a record By PK
     */
    @Caching(evict={@CacheEvict(value="platform.emailCache", allEntries=true)})
    public int updateByPK(Emailtemplate record){
    	if(record==null||record.getId()==null)
    		return 0;
		int rows = super.update("Emailtemplate.updateByPK", record);
		return rows;
    }
    
	/**
     * insertBatch records of List
     */
    @Caching(evict={@CacheEvict(value="platform.emailCache", allEntries=true)})
    public int insertBatch(List list){
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
       	rows = super.insertBatch("Emailtemplate.insert", list);
       	return rows;
    }
    
    /**
     * static spring getMethod
     */
     public static EmailtemplateDao getInstance(){
       	 EmailtemplateDao dao = (EmailtemplateDao)BeanFactory.getBeanFactory().getBean("emailtemplateDao");
         return dao;
     }
    
}
