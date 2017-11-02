package platform.social.dao;

import java.util.Map;

import platform.social.vo.Usecomment;
import commonTool.base.Page;


public interface UsecommentDao {
   
	public static final String AvgGradeValue = "AVGGRADEVALUE";
	
	public static final String CommentNumber = "COMMENTNUMBER";
	
	public Usecomment selectByPK(Long pk);
	
    public Usecomment selectByUser(Long userid, Long objectid, String objecttype);
    
    public Map<String, String> selectAvgComment(Long objectid, String objecttype);
                
    /**
     * select page by queryVO 
     * @param queryVO:the query vo,if queryVO is null,then search all
     * @param pageIndex:the current page num,start from 1;
     * @param pageSize:the page size,if less equal than 0,the default PlatfromConstant.PAGESIZE will be used;
     * @return Page
     * @throws Exception
     */
    public Page selectComments(Long objectid, String objecttype, int pageIndex, int pageSize, Integer total);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Usecomment record);

    /**
     * update a record By PK
     */
    public int updateByPK(Usecomment record);
    
    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Usecomment save(Usecomment record);

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk);
    
    public int deleteByObject(Long objectid, String objecttype);
    
    
}
