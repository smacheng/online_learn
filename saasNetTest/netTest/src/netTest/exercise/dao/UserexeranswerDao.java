package netTest.exercise.dao;

import java.util.List;

import netTest.exercise.dto.UserexeranswerQuery;
import netTest.exercise.vo.Userexeranswer;

public interface UserexeranswerDao {
   
    /**
     * select some record by PK
     */
    public Userexeranswer selectByPK(Long pk);
    
    /**
     * select records by queryVO
     */
    public List selectByVO(UserexeranswerQuery queryVO);
    
    /**
     * 查询用户某次考试的某份试卷的所有答案
     * @param shopid
     * @param testid
     * @param userid
     * @param paperid
     * @param needRandom:是否按乱序的查询。如果是1则直接查询出答案，如果是0则按照题目中的quesOrder排序
     * @return
     */
    public List<Userexeranswer> qryUseranswerList(Long shopid, Long userid, Long exerid);

    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Userexeranswer record);

    /**
     * update a record By PK
     */
    public int updateByPK(Userexeranswer record);
    
    /**
     * 更新用户练习的答案
     */
    public int updUseranswerPK(Userexeranswer record);
    
    /**
     * 批量更新用户练习的答案
     */
    public int batchUpdUseranswerPK(List<Userexeranswer> list);

	/**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Userexeranswer save(Userexeranswer record);

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long pk);
    
    /**
     * 删除该次练习的所有用户答案
     */
    public int deleteByExer(Long exerid);
    
    /**
     * 删除某个用户的某次练习的所有答案
     */
    public int deleteByExerUser(Long exerid, Long userid);

	/**
     * insertBatch records of List
     */
    public int insertBatch(List list);
    
    /**
     * deleteBatch records by the String Array of PK
     */
    public int deleteBatchByPK(String[] pkArray);
	
}
