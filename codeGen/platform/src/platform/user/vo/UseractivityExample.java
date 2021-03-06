package platform.user.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseractivityExample {
    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    protected List oredCriteria;

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    public UseractivityExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    protected UseractivityExample(UseractivityExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table useractivity
     *
     * @abatorgenerated Wed Apr 17 23:46:05 CST 2013
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andActivityidIsNull() {
            addCriterion("activityID is null");
            return this;
        }

        public Criteria andActivityidIsNotNull() {
            addCriterion("activityID is not null");
            return this;
        }

        public Criteria andActivityidEqualTo(Long value) {
            addCriterion("activityID =", value, "activityid");
            return this;
        }

        public Criteria andActivityidNotEqualTo(Long value) {
            addCriterion("activityID <>", value, "activityid");
            return this;
        }

        public Criteria andActivityidGreaterThan(Long value) {
            addCriterion("activityID >", value, "activityid");
            return this;
        }

        public Criteria andActivityidGreaterThanOrEqualTo(Long value) {
            addCriterion("activityID >=", value, "activityid");
            return this;
        }

        public Criteria andActivityidLessThan(Long value) {
            addCriterion("activityID <", value, "activityid");
            return this;
        }

        public Criteria andActivityidLessThanOrEqualTo(Long value) {
            addCriterion("activityID <=", value, "activityid");
            return this;
        }

        public Criteria andActivityidIn(List values) {
            addCriterion("activityID in", values, "activityid");
            return this;
        }

        public Criteria andActivityidNotIn(List values) {
            addCriterion("activityID not in", values, "activityid");
            return this;
        }

        public Criteria andActivityidBetween(Long value1, Long value2) {
            addCriterion("activityID between", value1, value2, "activityid");
            return this;
        }

        public Criteria andActivityidNotBetween(Long value1, Long value2) {
            addCriterion("activityID not between", value1, value2, "activityid");
            return this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userID =", value, "userid");
            return this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userID <>", value, "userid");
            return this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userID >", value, "userid");
            return this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userID >=", value, "userid");
            return this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userID <", value, "userid");
            return this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userID <=", value, "userid");
            return this;
        }

        public Criteria andUseridIn(List values) {
            addCriterion("userID in", values, "userid");
            return this;
        }

        public Criteria andUseridNotIn(List values) {
            addCriterion("userID not in", values, "userid");
            return this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userID between", value1, value2, "userid");
            return this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return this;
        }

        public Criteria andActiontypeIsNull() {
            addCriterion("actionType is null");
            return this;
        }

        public Criteria andActiontypeIsNotNull() {
            addCriterion("actionType is not null");
            return this;
        }

        public Criteria andActiontypeEqualTo(String value) {
            addCriterion("actionType =", value, "actiontype");
            return this;
        }

        public Criteria andActiontypeNotEqualTo(String value) {
            addCriterion("actionType <>", value, "actiontype");
            return this;
        }

        public Criteria andActiontypeGreaterThan(String value) {
            addCriterion("actionType >", value, "actiontype");
            return this;
        }

        public Criteria andActiontypeGreaterThanOrEqualTo(String value) {
            addCriterion("actionType >=", value, "actiontype");
            return this;
        }

        public Criteria andActiontypeLessThan(String value) {
            addCriterion("actionType <", value, "actiontype");
            return this;
        }

        public Criteria andActiontypeLessThanOrEqualTo(String value) {
            addCriterion("actionType <=", value, "actiontype");
            return this;
        }

        public Criteria andActiontypeLike(String value) {
            addCriterion("actionType like", value, "actiontype");
            return this;
        }

        public Criteria andActiontypeNotLike(String value) {
            addCriterion("actionType not like", value, "actiontype");
            return this;
        }

        public Criteria andActiontypeIn(List values) {
            addCriterion("actionType in", values, "actiontype");
            return this;
        }

        public Criteria andActiontypeNotIn(List values) {
            addCriterion("actionType not in", values, "actiontype");
            return this;
        }

        public Criteria andActiontypeBetween(String value1, String value2) {
            addCriterion("actionType between", value1, value2, "actiontype");
            return this;
        }

        public Criteria andActiontypeNotBetween(String value1, String value2) {
            addCriterion("actionType not between", value1, value2, "actiontype");
            return this;
        }

        public Criteria andTargetobjectIsNull() {
            addCriterion("targetObject is null");
            return this;
        }

        public Criteria andTargetobjectIsNotNull() {
            addCriterion("targetObject is not null");
            return this;
        }

        public Criteria andTargetobjectEqualTo(String value) {
            addCriterion("targetObject =", value, "targetobject");
            return this;
        }

        public Criteria andTargetobjectNotEqualTo(String value) {
            addCriterion("targetObject <>", value, "targetobject");
            return this;
        }

        public Criteria andTargetobjectGreaterThan(String value) {
            addCriterion("targetObject >", value, "targetobject");
            return this;
        }

        public Criteria andTargetobjectGreaterThanOrEqualTo(String value) {
            addCriterion("targetObject >=", value, "targetobject");
            return this;
        }

        public Criteria andTargetobjectLessThan(String value) {
            addCriterion("targetObject <", value, "targetobject");
            return this;
        }

        public Criteria andTargetobjectLessThanOrEqualTo(String value) {
            addCriterion("targetObject <=", value, "targetobject");
            return this;
        }

        public Criteria andTargetobjectLike(String value) {
            addCriterion("targetObject like", value, "targetobject");
            return this;
        }

        public Criteria andTargetobjectNotLike(String value) {
            addCriterion("targetObject not like", value, "targetobject");
            return this;
        }

        public Criteria andTargetobjectIn(List values) {
            addCriterion("targetObject in", values, "targetobject");
            return this;
        }

        public Criteria andTargetobjectNotIn(List values) {
            addCriterion("targetObject not in", values, "targetobject");
            return this;
        }

        public Criteria andTargetobjectBetween(String value1, String value2) {
            addCriterion("targetObject between", value1, value2, "targetobject");
            return this;
        }

        public Criteria andTargetobjectNotBetween(String value1, String value2) {
            addCriterion("targetObject not between", value1, value2, "targetobject");
            return this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return this;
        }

        public Criteria andResultIn(List values) {
            addCriterion("result in", values, "result");
            return this;
        }

        public Criteria andResultNotIn(List values) {
            addCriterion("result not in", values, "result");
            return this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return this;
        }

        public Criteria andNoteIn(List values) {
            addCriterion("note in", values, "note");
            return this;
        }

        public Criteria andNoteNotIn(List values) {
            addCriterion("note not in", values, "note");
            return this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeIn(List values) {
            addCriterion("createTime in", values, "createtime");
            return this;
        }

        public Criteria andCreatetimeNotIn(List values) {
            addCriterion("createTime not in", values, "createtime");
            return this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return this;
        }
    }
}