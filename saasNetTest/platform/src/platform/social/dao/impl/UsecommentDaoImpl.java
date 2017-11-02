package platform.social.dao.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;

import platform.bean.BeanFactory;
import platform.social.dao.UsecommentDao;
import platform.social.vo.Usecomment;

import commonTool.base.BaseDao;
import commonTool.base.Page;
import commonTool.cache.CacheSynchronizer;

public class UsecommentDaoImpl extends BaseDao implements UsecommentDao {

	static Logger log = Logger.getLogger(UsecommentDaoImpl.class.getName());
	
    /**
     *
     */
    public UsecommentDaoImpl() {
        super();
    }
    
    /**
     * select some record by creator
     */
    @Cacheable(value="platform.socialContentCache", key="'UsecommentDao.selectByUser~'+#userid+'~usecomment-'+#objecttype+':'+#objectid", unless="#result==null")
    public Usecomment selectByUser(Long userid, Long objectid, String objecttype){
    	if(userid==null||objectid==null||objecttype==null||objecttype.trim().length()<1)
    		return null;
    	Usecomment vo = new Usecomment();
    	vo.setUserid(userid);
    	vo.setObjectid(objectid);
    	vo.setObjecttype(objecttype);
    	vo = (Usecomment) this.queryForObject("Usecomment.selectByUser", vo);
    	//
    	if(vo!=null){
    	   CacheSynchronizer.getInstance().buildAssoc("platform.socialContentCache", 
    			 "UsecommentDao.selectByUser~"+userid+"~"+Usecomment.ObjectType+"-"+vo.getObjecttype()+":"+vo.getObjectid());
    	}
		return vo;
    }
    
    @Cacheable(value="platform.socialContentCache", key="'UsecommentDao.selectByPK~'+#pk", unless="#result==null")
    public Usecomment selectByPK(Long pk){
    	if(pk==null)
    		return null;
    	Usecomment record = (Usecomment) this.queryForObject("Usecomment.selectByPK", pk);
    	//
    	if(record!=null){
    	   CacheSynchronizer.getInstance().buildAssoc("platform.socialContentCache", 
    			 "UsecommentDao.selectByPK~"+pk, new String[]{Usecomment.ObjectType+"-"+record.getObjecttype()+":"+record.getObjectid()});
    	}
		return record;
    }
    
    @Cacheable(value="platform.socialContentCache", key="'UsecommentDao.selectAvgComment~usecomment-'+#objecttype+':'+#objectid")
    public Map<String, String> selectAvgComment(Long objectid, String objecttype){
    	if(objectid==null || objecttype==null || objecttype.trim().length()<1)
    		return null;
    	Usecomment vo = new Usecomment();
    	vo.setObjectid(objectid);
    	vo.setObjecttype(objecttype);
    	Map<String,String> map = (Map<String,String>)queryForObject("Usecomment.selectAvgComment", vo);
    	String gradevalue = map.get(UsecommentDao.AvgGradeValue);
    	// 只保留小数点后一位
    	if(gradevalue!=null	&& gradevalue.indexOf(".")!=-1){
    		int pos = gradevalue.indexOf(".")+2;
    		if(gradevalue.endsWith(".")){
    			pos = pos-2;
    		}
    		gradevalue = gradevalue.substring(0, pos);
    		map.put(UsecommentDao.AvgGradeValue, gradevalue);
    	}
    	//
    	CacheSynchronizer.getInstance().buildAssoc("platform.socialContentCache", 
    			 "UsecommentDao.selectAvgComment~"+Usecomment.ObjectType+"-"+objecttype+":"+objectid);
    	
		return map;
    }
    
    
    @Cacheable(value="platform.socialContentCache", key="'UsecommentDao.selectComments~usecomment-'+#objecttype+':'+#objectid+'~'+#pageIndex+'~'+#pageSize")
    public Page selectComments(Long objectid, String objecttype,int pageIndex,int pageSize,Integer total){
    	if(objectid==null || objecttype==null || objecttype.trim().length()<1)
    		return Page.EMPTY_PAGE;
        if(pageIndex<=0)
        	pageIndex = 1;
        if(pageSize<=0)
        	pageSize = 15;
        Usecomment vo = new Usecomment();
        vo.setObjectid(objectid);
        vo.setObjecttype(objecttype);
        String sqlStr = "Usecomment.selectComments";
        Page page = queryForPage(sqlStr, vo, pageIndex, pageSize, total);
        //
    	CacheSynchronizer.getInstance().buildAssoc("platform.socialContentCache", 
    			 "UsecommentDao.selectComments~"+Usecomment.ObjectType+"-"+objecttype+":"+objectid+"~"+pageIndex+"~"+pageSize);
    	
        return page;
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Usecomment record){
    	if(record==null)
    		return null;
		Long pk = (Long)super.insert("Usecomment.insert", record);	
		// 
		CacheSynchronizer.getInstance().pubFlush("platform.socialContentCache", 
				Usecomment.ObjectType+"-"+record.getObjecttype(), record.getObjectid().toString());
		return pk;
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Usecomment record){
    	if(record==null||record.getCommentid()==null)
    		return 0;
		int rows = super.update("Usecomment.updateByPK", record);
		// 
		record = selectByPK(record.getCommentid());
		CacheSynchronizer.getInstance().pubFlush("platform.socialContentCache", 
				Usecomment.ObjectType+"-"+record.getObjecttype(), record.getObjectid().toString());
		return rows;
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Usecomment save(Usecomment record){
    	if(record==null)
    		return null;
		if(record.getCommentid()==null||record.getCommentid().intValue()==0){
			Long pkValue = this.insert(record);
			record.setCommentid(pkValue);
    		return record;
		}else{
			this.updateByPK(record);
			return record;
		}
    }

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk){
    	if(pk==null)
    		return 0;
    	Usecomment vo = selectByPK(pk);
    	if(vo==null){
    		return 0;
    	}
		int rows = super.delete("Usecomment.deleteByPK", pk);
		// 
		CacheSynchronizer.getInstance().pubFlush("platform.socialContentCache", 
				Usecomment.ObjectType+"-"+vo.getObjecttype(), vo.getObjectid().toString());
		
		return rows;
    }
    
    /**
     * 
     */
    public int deleteByObject(Long objectid, String objecttype){
    	if(objectid==null || objecttype==null || objecttype.trim().length()<1)
    		return 0;
    	Usecomment vo = new Usecomment();
    	vo.setObjectid(objectid);
    	vo.setObjecttype(objecttype);
		int rows = super.delete("Usecomment.deleteByObject", vo);
		// 
		CacheSynchronizer.getInstance().pubFlush("platform.socialContentCache", 
				Usecomment.ObjectType+"-"+objecttype, objectid.toString());
		
		return rows;
    }
    

    /**
     * static spring getMethod
     */
     public static UsecommentDao getInstance(){
    	 UsecommentDao dao = (UsecommentDao)BeanFactory.getBeanFactory().getBean("usecommentDao");
         return dao;
     }
    
}
