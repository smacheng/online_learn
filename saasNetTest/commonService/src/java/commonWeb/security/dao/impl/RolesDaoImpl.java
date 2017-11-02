package commonWeb.security.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import commonTool.base.BaseDao;
import commonTool.util.StringUtil;
import commonWeb.security.bean.BeanFactory;
import commonWeb.security.dao.RolesDao;
import commonWeb.security.dto.RolesQuery;
import commonWeb.security.vo.Roles;
import commonWeb.security.vo.Rolesvalue;

public class RolesDaoImpl extends BaseDao implements RolesDao {

	static Logger log = Logger.getLogger(RolesDaoImpl.class.getName());
	
    /**
     *
     */
    public RolesDaoImpl() {
        super();
    }
    
    @Cacheable(value="commonService.SecurityCache", key="'Roles~'+#pk")
    public Roles selectByPK(Long pk){
    	if(pk==null)
    		return null;
    	Roles record = (Roles)this.queryForObject("Roles.selectByPK", pk);
    	return record;
    }
    
    /**
     * select some record by PK and localeid
     */
    public Roles selectValueByPK(Long pk,Long localeid){
    	if(pk==null)
    		return null;
    	Roles record = null;
    	if(localeid==null)
    		record = (Roles)this.queryForObject("Roles.selectByPK", pk);
    	else{
    		Roles vo = new Roles();
    		vo.setId(pk);
    		vo.setLocaleid(localeid);
    		record = (Roles) this.queryForObject("Roles.selectByPK_locale", vo);
    	}
		return record;
    }
    
    @Cacheable(value="commonService.SecurityCache", key="'Roles.selRoleByCode~'+#rolecodeArr.toString()+'~'+#syscode")
    private List<Roles> selRoleByCode(String[] rolecodeArr, String syscode){
    	List<Roles> list = null;
    	if(rolecodeArr!=null && rolecodeArr.length>0 && syscode!=null){
    		RolesQuery queryVO = new RolesQuery();
    		StringBuffer buffer = new StringBuffer();
    		for(String code : rolecodeArr){
    			buffer.append("'").append(code).append("',");
    		}
    		String rolecodeStr = buffer.toString();
    		rolecodeStr = StringUtil.trimComma(rolecodeStr);
    		queryVO.setRolecodeStr(rolecodeStr);
    		queryVO.setSyscode(syscode);
    		list = (List<Roles>)this.queryForList("Roles.selectByVO", queryVO);
    		
    	}
    	return list;
    }
    
    /**
     * 根据角色code查询角色id字符串，方便其他查询
     * @param rolecodeArr
     * @param syscode
     * @return
     */
    @Cacheable(value="commonService.SecurityCache", key="'Roles.selRoleidStrByCode~'+#rolecodeArr.toString()+'~'+#syscode")
    public String selRoleidStrByCode(String[] rolecodeArr, String syscode){
    	List<Roles> list = this.selRoleByCode(rolecodeArr, syscode);
    	StringBuffer buffer = new StringBuffer();
    	String roleidStr = null;
    	if(list!=null){
	    	for(Roles vo : list){
	    		buffer.append(vo.getId().toString()).append(",");
	    	}
	    	roleidStr = buffer.toString();
	    	roleidStr = StringUtil.trimComma(roleidStr);
    	}
    	return roleidStr;
    }
    
    /**
     * select all records
     * @return
     */
    public List selectAll(){
		List list = this.queryForList("Roles.selectAll", null);
		return list;
    }
        
    /**
     * select records by queryVO
     */
    public List selectByVO(RolesQuery queryVO){
		if(queryVO==null)
			return selectAll();
		List list = null;
		if(queryVO.getLocaleid()==null)
		   list = this.queryForList("Roles.selectByVO", queryVO);
		else
		   list = this.queryForList("Roles.selectByVO_locale", queryVO);
		return list;
    }
    
        
    /**
     * 选择某用户没有的Roles，以供选择，其中不包括用户已经具有的角色
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public List selectRolesForUserAdd(RolesQuery queryVO){
        if(queryVO==null)
        	return null;
        String sqlStr = "Roles.selectRolesForUserAdd";
        return queryForList(sqlStr, queryVO);
    }
    
    /**
     * 查询该用户所具有的角色 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
//    public List selectByUserId(RolesQuery queryVO){
//        if(queryVO==null||queryVO.getUserId()==null)
//        	return null;
//        if(queryVO.getShopid()==null){
//        	queryVO.setRolelevel(RolesConstant.RoleLevel_System);
//        }
//        String sqlStr = "Roles.selectByUserId";
//        return queryForList(sqlStr, queryVO);
//    }

       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Roles record){
    	if(record==null)
    		return null;
		Long pk = (Long)super.insert("Roles.insert", record);
		Rolesvalue valueVO = new Rolesvalue();
		valueVO.setId(pk);
		valueVO.setLocaleid(record.getLocaleid());
		valueVO.setName(record.getName());
		valueVO.setShopid(record.getShopid());
		super.insert("Rolesvalue.insert", valueVO);
		return pk;
    }

    /**
     * update a record By PK
     */
    @Caching(evict={@CacheEvict(value="commonService.SecurityCache", key="'Roles~'+#record.id")})
    public int updateByPK(Roles record){
    	if(record==null||record.getId()==null)
    		return 0;
		int rows = super.update("Roles.updateByPK", record);
		return rows;
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    @Caching(evict={@CacheEvict(value="commonService.SecurityCache", key="'Roles~'+#record.id")})
    public Roles save(Roles record){
    	if(record==null)
    		return null;
		if(record.getId()==null||record.getId().intValue()==0){
			Long pkValue = this.insert(record);
			record.setId(pkValue);
    		return record;
		}else{
			this.updateByPK(record);
			return record;
		}
    }

    /**
     * delete a record by PK
     */
    @Caching(evict={@CacheEvict(value="commonService.SecurityCache", key="'Roles~'+#pk")})
    public int deleteByPK(Long pk){
    	if(pk==null)
    		return 0;
    	super.delete("Rolesvalue.deleteByFK", pk);
		int rows = super.delete("Roles.deleteByPK", pk);
		return rows;
    }
    
//    /**
//     * delete records by queryVO
//     */
//    public int deleteByVO(RolesQuery queryVO){
//    	if(queryVO==null)
//    		return 0;
//		int rows = super.delete("Roles.deleteByVO",queryVO);
//		return rows;
//    }
    
//	/**
//     * insertBatch records of List
//     */
//    public int insertBatch(List list){
//    	if(list==null||list.size()<=0)
//    		return 0;
//    	int rows = 0;
//       	rows = super.insertBatch("Roles.insert", list);
//       	return rows;
//    }
    
//    /**
//     * updateBatch records of List
//     */
//    public int updateBatch(List list){
//    	if(list==null||list.size()<=0)
//    		return 0;
//    	int rows = 0;
//       	rows = super.updateBatch("Roles.updateByPK", list);
//       	return rows;
//    }
    
    /**
     * deleteBatch records by the String Array of PK
     */
//    public int deleteBatchByPK(String[] pkArray){
//    	if(pkArray==null||pkArray.length<=0)
//    		return 0;
//    	int rows = 0;
//    	StringBuffer buffer = new StringBuffer();
//    	Long[] arrs = new Long[pkArray.length];
//		for(int i=0;i<pkArray.length;i++){
//			if(pkArray[i]!=null&&pkArray[i].trim().length()>0){
//				arrs[i] = new Long(Long.parseLong(pkArray[i]));
//				buffer.append(pkArray[i]).append(",");
//			}
//		}
//		// 删除Role下的资源引用
//		String roleStr = buffer.toString();
//		if(roleStr.endsWith(",")){
//			roleStr = roleStr.substring(0, roleStr.length()-1);
//		}
//		super.delete("RoleResc.delByRoleStr", roleStr); 
//		// 删除Role
//		super.deleteBatch("Rolesvalue.deleteByFK", arrs);
//		rows = super.deleteBatch("Roles.deleteByPK", arrs);
//		return rows;
//    }
    
    /**
     * static spring getMethod
     */
     public static RolesDao getInstance(){
       	 RolesDao dao = (RolesDao)BeanFactory.getBeanFactory().getBean("rolesDao");
         return dao;
     }
    
}