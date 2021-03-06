package platform.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import platform.bean.BeanFactory;
import platform.dao.UsercontactinfoDao;
import platform.dto.UsercontactinfoQuery;
import platform.vo.Usercontactinfo;

import commonTool.base.BaseDao;

public class UsercontactinfoDaoImpl extends BaseDao implements UsercontactinfoDao {

	static Logger log = Logger.getLogger(UsercontactinfoDaoImpl.class.getName());
	
    /**
     *
     */
    public UsercontactinfoDaoImpl() {
        super();
    }
    
    /**
     * select some record by PK
     */
    public Usercontactinfo selectByPK(Long pk)  {
    	if(pk==null)
    		return null;
		Usercontactinfo record = (Usercontactinfo) this.queryForObject("Usercontactinfo.selectByPK", pk);
		return record;
    }
        
    /**
     * select records by queryVO
     */
    public List selectByVO(UsercontactinfoQuery queryVO)  {
		if(queryVO==null)
			return new ArrayList();
		List list = this.queryForList("Usercontactinfo.selectByVO", queryVO);
		return list;
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Usercontactinfo record) {
    	if(record==null)
    		return null;
		return (Long)super.insert("Usercontactinfo.insert", record);
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Usercontactinfo record)  {
    	if(record==null||record.getUserid()==null||record.isEmpty())
    		return 0;
		int rows = super.update("Usercontactinfo.updateByPK", record);
		return rows;
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @
     */
    public void save(Usercontactinfo vo)  {
    	if(vo==null||vo.getUserid()==null)
    		return;
    	Usercontactinfo tempvo = selectByPK(vo.getUserid());
		if(tempvo==null){
			this.insert(vo);
		}else{
			this.updateByPK(vo);
		}
    }

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk)  {
    	if(pk==null)
    		return 0;
		int rows = super.delete("Usercontactinfo.deleteByPK", pk);
		return rows;
    }
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list)  {
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = super.insertBatch("Usercontactinfo.insert", list);
        return rows;
    }
    
    
    /**
     * static spring getMethod
     */
     public static UsercontactinfoDao getInstance() {
       	 UsercontactinfoDao dao = (UsercontactinfoDao)BeanFactory.getBeanFactory().getBean("usercontactinfoDao");
         return dao;
     }
    
}
