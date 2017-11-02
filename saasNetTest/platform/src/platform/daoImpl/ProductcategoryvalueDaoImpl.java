package platform.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import platform.bean.BeanFactory;
import platform.dao.ProductcategoryvalueDao;
import platform.dto.ProductcategoryvalueQuery;
import platform.vo.Productcategory;
import platform.vo.Productcategoryvalue;

import commonTool.base.BaseDao;
import commonTool.base.Page;
import commonTool.cache.CacheSynchronizer;
import commonTool.constant.CommonConstant;

public class ProductcategoryvalueDaoImpl extends BaseDao implements ProductcategoryvalueDao {

	static Logger log = Logger.getLogger(ProductcategoryvalueDaoImpl.class.getName());
	
    /**
     *
     */
    public ProductcategoryvalueDaoImpl() {
        super();
    }
    
    /**
     * select some record by PK
     */
    public Productcategoryvalue selectByPK(Long pk) {
    	if(pk==null)
    		return null;
		Productcategoryvalue record = (Productcategoryvalue) this.queryForObject("Productcategoryvalue.selectByPK", pk);
		return record;
    }
        
    /**
     * select records by queryVO
     */
    public List selectByVO(ProductcategoryvalueQuery queryVO) {
    	if(queryVO==null)
			return new ArrayList();

		List list = this.queryForList("Productcategoryvalue.selectByVO", queryVO);
		return list;
    }
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @
     */
    public Page selectByVOPage(ProductcategoryvalueQuery queryVO,int pageIndex,int pageSize,Integer total)  {
    	if(queryVO==null)
        	return Page.EMPTY_PAGE;
    	if(pageIndex<=0)
        	pageIndex = 1;
        if(pageSize<=0)
        	pageSize = CommonConstant.PAGESIZE;
        
        return queryForPage("Productcategoryvalue.selectByVO", queryVO, pageIndex, pageSize, total);
    }
    
    /**
     * 根据目录id查询该目录已经设置的国家语言集合字符串，其中用","隔开各个localeid
     * @param categoryid
     * @return
     * @
     */
    public String qrySelectedLocaleStr(Long categoryid){
    	if(categoryid==null)
    		return "";
    	ProductcategoryvalueQuery queryVO = new ProductcategoryvalueQuery();
    	queryVO.setCategoryid(categoryid);
    	StringBuffer buffer = new StringBuffer();
    	List list = this.selectByVO(queryVO);
        if(list!=null&&list.size()>0){
        	Productcategoryvalue valueVO = null;
        	for(int i=0;i<list.size();i++){
        		valueVO = (Productcategoryvalue)list.get(i);
        		if(valueVO!=null&&valueVO.getLocaleid()!=null){
        			buffer.append(String.valueOf(valueVO.getLocaleid())).append(",");
        		}
        	}
        }
        return buffer.toString();
    }

    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Productcategoryvalue record)  {
    	if(record==null)
    		return null;
		Long pk = (Long)super.insert("Productcategoryvalue.insert", record);
		
		// flush cache
		CacheSynchronizer.getInstance().pubFlush("platform.categoryCache", Productcategory.ObjectType, record.getCategoryid().toString());
	
		return pk;
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Productcategoryvalue record)  {
    	if(record==null||record.getCategoryvalueid()==null)
    		return 0;
		int rows = super.update("Productcategoryvalue.updateByPK", record);
		
		// flush cache
		if(record.getCategoryid()==null) {
		   record = selectByPK(record.getCategoryvalueid());
		}
		CacheSynchronizer.getInstance().pubFlush("platform.categoryCache", Productcategory.ObjectType, record.getCategoryid().toString());
		return rows;
    }

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @
     */
    public Productcategoryvalue save(Productcategoryvalue record)  {
    	if(record==null)
    		return null;
		if(record.getCategoryvalueid()==null||record.getCategoryvalueid().intValue()==0){
			Long pkValue = this.insert(record);
			record.setCategoryvalueid(pkValue);
			return record;
		}else{
			this.updateByPK(record);
			return record;
		}
    }

    /**
     * delete a record by PK
     */
    // delete locale value don't need flush cache
    public int deleteByPK(Long pk)  {
    	if(pk==null)
    		return 0;
		int rows = super.delete("Productcategoryvalue.deleteByPK", pk);
		return rows;
    }
    
    /**
     * delete a record by categoryid，同时删除该categoryid对应的所有下级记录
     * 在sql语句中实现
     */
//  delete locale value don't need flush cache
    public int deleteByCategoryidChild(Long categoryid)  {
    	if(categoryid==null)
    		return 0;
		int rows = super.delete("Productcategoryvalue.deleteByCategoryidChild", categoryid);
		return rows;
    }
    
	/**
     * insertBatch records of List
     */
//    public int insertBatch(List list)  {
//    	if(list==null||list.size()<=0)
//    		return 0;
//    	int rows = super.insertBatch("Productcategoryvalue.insert", list);
//       	return rows;
//    }
        
    /**
     * deleteBatch records by the String Array of PK
     */
    public int deleteBatchByPK(String[] pkArray)  {
    	if(pkArray==null||pkArray.length<=0)
    		return 0;
    	int rows = 0;
    	Long[] arrs = new Long[pkArray.length];
		for(int i=0;i<pkArray.length;i++){
			if(pkArray[i]!=null)
				arrs[i] = new Long(Long.parseLong(pkArray[i]));
		}
		rows = super.deleteBatch("Productcategoryvalue.deleteByPK", arrs);
		return rows;
   	
    }
    
    /**
     * static spring getMethod
     */
     public static ProductcategoryvalueDao getInstance() {
         ProductcategoryvalueDao dao = (ProductcategoryvalueDao)BeanFactory.getBeanFactory().getBean("productcategoryvalueDaoProxy");
         return dao;
     }
    
}
