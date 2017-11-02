package netTest.paper.dao;

import java.util.List;

import netTest.paper.vo.Paperquestype;

public interface PaperquestypeDao {
   
    /**
     * select some record by PK
     */
    public Paperquestype selectByPK(Long pk);
	
    /**
     * select some record by Logic PK
     */
    public Paperquestype selectByLogicPK(Long shopid,Long paperid,Long questypeid);
    
    /**
     * 查找一份试卷上最大的questypeid
     * @param shopid
     * @param paperid
     * @return
     */
    public Long getMaxQuestypeid(Long shopid,Long paperid);
    
    /**
     * select records by paperid
     */
    public List<Paperquestype> qryByPaperid(Long paperid);
    
    /**
     * insert a record
     * @return Object with the PK(generated by DB)
     */
    public Long insert(Paperquestype record);

    /**
     * update a record By PK
     */
    public int updateByPK(Paperquestype record);
    
    /**
     * update the scores of papertype
     * @param updateType: 更新类型，1为分数更新为参数。2为分数做增量加减，即在原有的分数上做加法
     */
    public int updatePatternscore(Long paperid,Long questypeid,Float paperquesscore,int updateType,Long shopid);

    /**
     * update the record if exists pk,else insert the record
     * @param record
     * @return
     * @throws Exception
     */
    public Paperquestype save(Paperquestype record);

    /**
     * delete a record by PK
     */
    public int deleteByPK(Long patternid);
    
    /**
     * delete a record by Paperid
     */
    public int delByPaperid(Long paperid);
    
	/**
     * insertBatch records of List
     */
    public int insertBatch(List list);
	
}
