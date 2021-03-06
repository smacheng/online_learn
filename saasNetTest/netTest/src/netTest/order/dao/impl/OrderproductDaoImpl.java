package netTest.order.dao.impl;

import java.util.ArrayList;
import java.util.List;
import netTest.order.dao.OrderproductDao;
import netTest.order.dto.OrderproductQuery;
import netTest.order.vo.Orderproduct;
import org.apache.log4j.Logger;
import netTest.bean.BeanFactory;
import commonTool.base.BaseDao;
import commonTool.base.Page;
import commonTool.constant.CommonConstant;
import commonTool.exception.NeedParamsException;

public class OrderproductDaoImpl extends BaseDao implements OrderproductDao {

	static Logger log = Logger.getLogger(OrderproductDaoImpl.class.getName());
	
    /**
     *
     */
    public OrderproductDaoImpl() {
        super();
    }
    
    /**
     * select some record by PK
     */
    public Orderproduct selectByPK(Long orderid, Long productbaseid){
    	if(orderid==null||productbaseid==null)
    		return null;
    	Orderproduct vo = new Orderproduct();
    	vo.setOrderid(orderid);
    	vo.setProductbaseid(productbaseid);
		Orderproduct record = (Orderproduct) this.queryForObject("Orderproduct.selectByPK", vo);
		return record;
    }
           
    /**
     * select records by queryVO
     */
    public List<Orderproduct> selectByVO(OrderproductQuery queryVO){
		if(queryVO==null)
			return new ArrayList<Orderproduct>();
		List<Orderproduct> list = (List<Orderproduct>)this.queryForList("Orderproduct.selectByVO", queryVO);
		return list;
    }
    
    /**
     * 根据订单id查询该订单的所有订单产品
     * @param orderid
     * @return
     * @
     */
    public List<Orderproduct> selectByOrderid(Long orderid) {
    	OrderproductQuery query = new OrderproductQuery();
    	query.setOrderid(orderid);
    	return this.selectByVO(query);
    }
    
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectByVOPage(OrderproductQuery queryVO,int pageIndex,int pageSize,Integer total){
        if(pageIndex<=0)
        	pageIndex = 1;
        if(pageSize<=0)
        	pageSize = CommonConstant.PAGESIZE;
        Page page = null;
        String sqlStr = "";
        if(queryVO==null){
        	page = Page.EMPTY_PAGE;
        } else {
        	sqlStr = "Orderproduct.selectByVO";
        	page = queryForPage(sqlStr, queryVO, pageIndex, pageSize, total);
        }
        return page;
    }
       
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Orderproduct record){
    	if(record==null)
    		return null;
		return (Long)super.insert("Orderproduct.insert", record);
    }

    /**
     * update a record By PK
     */
    public int updateByPK(Orderproduct record){
    	if(record==null||record.getOrderid()==null)
    		return 0;
		int rows = super.update("Orderproduct.updateByPK", record);
		return rows;
    }

    /**
     * 查询是否有用户订购的在某个状态的产品
     * @param userid
     * @param prodid
     * @param status
     * @return
     */
    public boolean existUnhandleOrderProd(Long userid, Long prodid, Short status){
    	if(prodid==null||status==null)
    		throw new NeedParamsException();
    	Orderproduct vo = new Orderproduct();
    	vo.setUserid(userid);
    	vo.setProductbaseid(prodid);
    	vo.setStatus(status);
    	int count = (Integer)super.queryForObject("Orderproduct.existUnhandleOrderProd", vo);
    	if(count>0)
    		return true;
    	else
    		return false;
    }
    
    /**
     * 更新未经处理的订单产品的状态
     */
    public int updateUnhandleStatusByOrder(Long orderid, Short orderstatus){
    	if(orderid==null||orderstatus==null)
    		return 0;
    	Orderproduct vo = new Orderproduct();
    	vo.setOrderid(orderid);
    	vo.setStatus(orderstatus);
		int rows = super.update("Orderproduct.updateUnhandleStatusByOrder", vo);
		return rows;
    }
    
    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Orderproduct save(Orderproduct record){
    	if(record==null)
    		return null;
		if(record.getOrderid()==null||record.getOrderid().intValue()==0){
			Long pkValue = this.insert(record);
			record.setOrderid(pkValue);
    		return record;
		}else{
			this.updateByPK(record);
			return record;
		}
    }

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long orderid, Long productbaseid){
    	if(orderid==null||productbaseid==null)
    		return 0;
    	Orderproduct vo = new Orderproduct();
    	vo.setOrderid(orderid);
    	vo.setProductbaseid(productbaseid);
		int rows = super.delete("Orderproduct.deleteByPK", vo);
		return rows;
    }
    
    /**
     * 根据订单id删除订单条目
     * @param orderid
     * @return
     * @
     */
    public int deleteByOrderid(Long orderid){
    	if(orderid==null)
    		return 0;
		int rows = super.delete("Orderproduct.deleteByOrderid", orderid);
		return rows;
    }
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list){
    	if(list==null||list.size()<=0)
    		return 0;
    	int rows = 0;
       	rows = super.insertBatch("Orderproduct.insert", list);
       	return rows;
    }
    
    /**
     * deleteBatch records by the String Array of PK
     */
    public int deleteBatchByPK(String[] pkArray){
    	if(pkArray==null||pkArray.length<=0)
    		return 0;
    	int rows = 0;
    	Long[] arrs = new Long[pkArray.length];
		for(int i=0;i<pkArray.length;i++){
			if(pkArray[i]!=null)
				arrs[i] = new Long(Long.parseLong(pkArray[i]));
		}
		rows = super.deleteBatch("Orderproduct.deleteByPK", arrs);
		return rows;
    }
    
    /**
     * static spring getMethod
     */
     public static OrderproductDao getInstance(){
       	 OrderproductDao dao = (OrderproductDao)BeanFactory.getBeanFactory().getBean("orderproductDao");
         return dao;
     }
    
}
