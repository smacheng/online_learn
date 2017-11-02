package commonWeb.security.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import commonTool.base.BaseDao;
import commonTool.base.Page;
import commonTool.cache.CacheSynchronizer;
import commonTool.constant.CommonConstant;
import commonWeb.security.bean.BeanFactory;
import commonWeb.security.dao.MenusDao;
import commonWeb.security.dao.ResourcesDao;
import commonWeb.security.dto.MenusQuery;
import commonWeb.security.vo.Menus;
import commonWeb.security.vo.Menusvalue;
import commonWeb.security.vo.Resources;


public class MenusDaoImpl extends BaseDao implements MenusDao {

	static Logger log = Logger.getLogger(MenusDaoImpl.class.getName());
	
    /**
     *
     */
    public MenusDaoImpl() {
        super();
    }
    
    /**
     * select some record by PK
     */
    public Menus selectByPK(Long pk,Long localeid){
    	if(pk==null)
    		return null;
    	Menus vo = new Menus();
    	vo.setId(pk);
    	vo.setLocaleid(localeid);
		Menus record = (Menus) this.queryForObject("Menus.selectByPK", vo);
		return record;
    }
    
    /**
     * select all records
     * @return
     */
    public List selectAll(){
		List list = this.queryForList("Menus.selectAll", null);
		return list;
    }
        
    /**
     * select records by queryVO
     */
    public List selectByVO(MenusQuery queryVO){
		if(queryVO==null)
			return selectAll();
		List list = this.queryForList("Menus.selectByVO", queryVO);
		return list;
    }
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(MenusQuery queryVO,int pageIndex,int pageSize,Integer total){
        if(pageIndex<=0)
        	pageIndex = 1;
        if(pageSize<=0)
        	pageSize = CommonConstant.PAGESIZE;
        String sqlStr = "";
        if(queryVO==null)
        	sqlStr = "Menus.selectAll";
        else 
        	sqlStr = "Menus.selectByVO";
        return queryForPage(sqlStr, queryVO, pageIndex, pageSize, total);
    }
    
    /**
     * 查询用户可以查看到的菜单集合。
     * TODO 现在的实现是时时查询数据库，以后要改变这一实现
     * @param syscode
     * @param upId
     * @param userId
     * @param localeId
     * @param menutype
     * @return
     */
    public List selectForDisplay(String syscode,Long upId,Long userId,Long localeid,Long shopid){
    	if(syscode==null||syscode.trim().length()<1)
    	   return new ArrayList();
    	MenusQuery queryVO = new MenusQuery();
    	queryVO.setSyscode(syscode);
    	queryVO.setPid(upId);
    	queryVO.setUserId(userId);
    	queryVO.setLocaleid(localeid);
    	String sqlStr = "Menus.selectForDisplay";
    	List list = this.queryForList(sqlStr, queryVO);
		return list;
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Menus record){
    	if(record==null)
    		return null;
    	ResourcesDao dao = ResourcesDaoImpl.getInstance();
    	Long pk = dao.insert(record);
		if(record.getResType()!=null&&record.getResType().equals(Resources.ResType_MENU)){
    	   super.insert("Menus.insert", record);
    	   Menusvalue meuValue = new Menusvalue();
    	   meuValue.setId(pk);
    	   meuValue.setLocaleid(record.getLocaleid());
    	   meuValue.setTitle(record.getTitle());
    	   meuValue.setTooltip(record.getTooltip());
    	   super.insert("Menusvalue.insert", meuValue);
		}
    	return pk;
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Menus record){
    	if(record==null||record.getId()==null)
    		return 0;
    	int rows = 0;
    	if(record.getPid()==null)
     	   record.setPid(CommonConstant.TreeTopnodePid);
    	int row1 = super.update("Resources.updateByPK", record);
    	rows = row1;
    	if(!record.isMenuEmpty())
		   rows = super.update("Menus.updateByPK", record);
		return rows;
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Menus save(Menus record){
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
    public int deleteByPK(Long pk){
    	if(pk==null)
    		return 0;
		super.delete("Menusvalue.deleteByFK", pk);
    	super.delete("Menus.deleteByPK", pk);
    	super.delete("Resourcesvalue.deleteByFK", pk);
		int rows = super.delete("Resources.deleteByPK", pk);
		return rows;
    }
    
    /**
     * delete records by queryVO
     */
    public int deleteByVO(MenusQuery queryVO){
    	if(queryVO==null)
    		return 0;
		int rows = super.delete("Menus.deleteByVO",queryVO);
		return rows;
    }
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list){
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
    	String[][] sqlArr = new String[][]{{"Resources.insert", null}, {"Menus.insert",null}};
    	rows = super.insertBatchMutiTable(sqlArr, list, "id");
       	return rows;
    }
    
    /**
     * updateBatch records of List
     */
    public int updateBatch(List list){
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
    	String[] sqlArr = new String[]{"Resources.updateByPK","Menus.updateByPK"};
    	rows = super.updateBatchMutiTable(sqlArr, list);
       	return rows;
    }
    
    /**
     * deleteBatch records by the Long Array of PK
     */
    public Map deleteBatchByPK(Long[] pkArray,Long localeid){
    	if(pkArray==null||pkArray.length<=0){
    	   Map map = new HashMap();
    	   map.put("result", "0");
    	   map.put("info", "缺少参数");
    	}
    	int rows = 0;
    	ResourcesDao rescDao = ResourcesDaoImpl.getInstance();
    	Map map = rescDao.checkRescRef(pkArray, localeid);
    	if(map==null||map.get("result")==null||!"1".equals((String)map.get("result")))
    	   return map;
    	String[] sqlArr = new String[]{"Menusvalue.deleteByFK","Menus.deleteByPK","Resourcesvalue.deleteByFK","Resources.deleteByPK"};
    	rows = super.deleteBatchMutiTable(sqlArr, pkArray);
    	rows = pkArray.length;
    	map.put("info", String.valueOf(rows));
    	
    	// 刷新缓存
    	StringBuffer buffer = new StringBuffer();
    	for(Long pk : pkArray){
    		buffer.append(String.valueOf(pk.longValue())).append(",");
    	}
    	String idStr = buffer.toString();
    	idStr = idStr.substring(0, idStr.length()-1);
    	List<String> urls = ResourcesDaoImpl.getInstance().getRestringByIdStr(idStr);
    	CacheSynchronizer.getInstance().batchFlush(null, urls);
    	
       	return map;
    }
    
    /**
     * deleteBatch records by the String Array of PK
     */
    public Map deleteBatchByPK(String[] pkArray,Long localeid){
    	if(pkArray==null||pkArray.length<=0){
     	   Map map = new HashMap();
     	   map.put("result", "0");
     	   map.put("info", "缺少参数");
     	}
    	Long[] arrs = new Long[pkArray.length];
		for(int i=0;i<pkArray.length;i++){
			if(pkArray[i]!=null)
				arrs[i] = new Long(Long.parseLong(pkArray[i]));
		}
		Map map = this.deleteBatchByPK(arrs,localeid);
		return map;
    }
    
    /**
     * static spring getMethod
     */
     public static MenusDao getInstance(){
       	 MenusDao dao = (MenusDao)BeanFactory.getBeanFactory().getBean("menusDao");
         return dao;
     }
    
}
