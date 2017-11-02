package platform.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import platform.bean.BeanFactory;
import platform.dao.CuststatusDao;
import platform.dto.CuststatusQuery;
import platform.vo.Custstatus;

import commonTool.base.BaseDao;

public class CuststatusDaoImpl extends BaseDao implements CuststatusDao {

	static Logger log = Logger.getLogger(CuststatusDaoImpl.class.getName());
	
    /**
     *
     */
    public CuststatusDaoImpl() {
        super();
    }
    
    /**
     * select records by userid
     */
    public List selectByUserid(Long userid) {
		if(userid==null)
			return new ArrayList();
		List list = this.queryForList("Custstatus.selectByUserid", userid);
		return list;
    }
    
    /**
     * 根据userid 查询最近的一条记录
     * @param userid
     * @return
     */
    public Custstatus selectUserLastChange(Long userid){
    	Custstatus vo = (Custstatus)this.queryForObject("Custstatus.selectUserLastChange", userid);
    	return vo;
    }
        
    /**
     * select records by queryVO
     */
    public List selectByVO(CuststatusQuery queryVO) {
		if(queryVO==null)
			return new ArrayList();
		List list = this.queryForList("Custstatus.selectByVO", queryVO);
		return list;
    }
           
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Custstatus record){
    	if(record==null)
    		return null;
		return (Long)super.insert("Custstatus.insert", record);
    }
    
    /**
     * delete a record by userID
     */
    public int deleteByUserID(Long userID) {
    	if(userID==null)
    		return 0;
		int rows = super.delete("Custstatus.deleteByUserID", userID);
		return rows;
    }
    
    /**
     * static spring getMethod
     */
     public static CuststatusDao getInstance() {
       	 CuststatusDao dao = (CuststatusDao)BeanFactory.getBeanFactory().getBean("custstatusDao");
         return dao;
     }
     
     public static void main(String[] args) throws Exception{
    	 CuststatusDao dao = CuststatusDaoImpl.getInstance();
    	 if(dao==null)
    		 System.out.println("null");
    	 else
    		 System.out.println("not null");
     }
    
}
