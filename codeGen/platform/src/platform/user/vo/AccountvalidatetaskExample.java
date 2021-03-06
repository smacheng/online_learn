package platform.user.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountvalidatetaskExample {
    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
     */
    protected List oredCriteria;

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
     */
    public AccountvalidatetaskExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
     */
    protected AccountvalidatetaskExample(AccountvalidatetaskExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
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
     * This method corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table accountvalidatetask
     *
     * @abatorgenerated Sat Apr 13 23:06:40 CST 2013
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return this;
        }

        public Criteria andIdIn(List values) {
            addCriterion("id in", values, "id");
            return this;
        }

        public Criteria andIdNotIn(List values) {
            addCriterion("id not in", values, "id");
            return this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return this;
        }

        public Criteria andEmailIn(List values) {
            addCriterion("email in", values, "email");
            return this;
        }

        public Criteria andEmailNotIn(List values) {
            addCriterion("email not in", values, "email");
            return this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return this;
        }

        public Criteria andValidatetypeIsNull() {
            addCriterion("validateType is null");
            return this;
        }

        public Criteria andValidatetypeIsNotNull() {
            addCriterion("validateType is not null");
            return this;
        }

        public Criteria andValidatetypeEqualTo(String value) {
            addCriterion("validateType =", value, "validatetype");
            return this;
        }

        public Criteria andValidatetypeNotEqualTo(String value) {
            addCriterion("validateType <>", value, "validatetype");
            return this;
        }

        public Criteria andValidatetypeGreaterThan(String value) {
            addCriterion("validateType >", value, "validatetype");
            return this;
        }

        public Criteria andValidatetypeGreaterThanOrEqualTo(String value) {
            addCriterion("validateType >=", value, "validatetype");
            return this;
        }

        public Criteria andValidatetypeLessThan(String value) {
            addCriterion("validateType <", value, "validatetype");
            return this;
        }

        public Criteria andValidatetypeLessThanOrEqualTo(String value) {
            addCriterion("validateType <=", value, "validatetype");
            return this;
        }

        public Criteria andValidatetypeLike(String value) {
            addCriterion("validateType like", value, "validatetype");
            return this;
        }

        public Criteria andValidatetypeNotLike(String value) {
            addCriterion("validateType not like", value, "validatetype");
            return this;
        }

        public Criteria andValidatetypeIn(List values) {
            addCriterion("validateType in", values, "validatetype");
            return this;
        }

        public Criteria andValidatetypeNotIn(List values) {
            addCriterion("validateType not in", values, "validatetype");
            return this;
        }

        public Criteria andValidatetypeBetween(String value1, String value2) {
            addCriterion("validateType between", value1, value2, "validatetype");
            return this;
        }

        public Criteria andValidatetypeNotBetween(String value1, String value2) {
            addCriterion("validateType not between", value1, value2, "validatetype");
            return this;
        }

        public Criteria andValidatecodeIsNull() {
            addCriterion("validateCode is null");
            return this;
        }

        public Criteria andValidatecodeIsNotNull() {
            addCriterion("validateCode is not null");
            return this;
        }

        public Criteria andValidatecodeEqualTo(String value) {
            addCriterion("validateCode =", value, "validatecode");
            return this;
        }

        public Criteria andValidatecodeNotEqualTo(String value) {
            addCriterion("validateCode <>", value, "validatecode");
            return this;
        }

        public Criteria andValidatecodeGreaterThan(String value) {
            addCriterion("validateCode >", value, "validatecode");
            return this;
        }

        public Criteria andValidatecodeGreaterThanOrEqualTo(String value) {
            addCriterion("validateCode >=", value, "validatecode");
            return this;
        }

        public Criteria andValidatecodeLessThan(String value) {
            addCriterion("validateCode <", value, "validatecode");
            return this;
        }

        public Criteria andValidatecodeLessThanOrEqualTo(String value) {
            addCriterion("validateCode <=", value, "validatecode");
            return this;
        }

        public Criteria andValidatecodeLike(String value) {
            addCriterion("validateCode like", value, "validatecode");
            return this;
        }

        public Criteria andValidatecodeNotLike(String value) {
            addCriterion("validateCode not like", value, "validatecode");
            return this;
        }

        public Criteria andValidatecodeIn(List values) {
            addCriterion("validateCode in", values, "validatecode");
            return this;
        }

        public Criteria andValidatecodeNotIn(List values) {
            addCriterion("validateCode not in", values, "validatecode");
            return this;
        }

        public Criteria andValidatecodeBetween(String value1, String value2) {
            addCriterion("validateCode between", value1, value2, "validatecode");
            return this;
        }

        public Criteria andValidatecodeNotBetween(String value1, String value2) {
            addCriterion("validateCode not between", value1, value2, "validatecode");
            return this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return this;
        }

        public Criteria andStatusIn(List values) {
            addCriterion("status in", values, "status");
            return this;
        }

        public Criteria andStatusNotIn(List values) {
            addCriterion("status not in", values, "status");
            return this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return this;
        }

        public Criteria andCreatedateIn(List values) {
            addCriterion("createDate in", values, "createdate");
            return this;
        }

        public Criteria andCreatedateNotIn(List values) {
            addCriterion("createDate not in", values, "createdate");
            return this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return this;
        }

        public Criteria andAliveenddateIsNull() {
            addCriterion("aliveEndDate is null");
            return this;
        }

        public Criteria andAliveenddateIsNotNull() {
            addCriterion("aliveEndDate is not null");
            return this;
        }

        public Criteria andAliveenddateEqualTo(Date value) {
            addCriterion("aliveEndDate =", value, "aliveenddate");
            return this;
        }

        public Criteria andAliveenddateNotEqualTo(Date value) {
            addCriterion("aliveEndDate <>", value, "aliveenddate");
            return this;
        }

        public Criteria andAliveenddateGreaterThan(Date value) {
            addCriterion("aliveEndDate >", value, "aliveenddate");
            return this;
        }

        public Criteria andAliveenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("aliveEndDate >=", value, "aliveenddate");
            return this;
        }

        public Criteria andAliveenddateLessThan(Date value) {
            addCriterion("aliveEndDate <", value, "aliveenddate");
            return this;
        }

        public Criteria andAliveenddateLessThanOrEqualTo(Date value) {
            addCriterion("aliveEndDate <=", value, "aliveenddate");
            return this;
        }

        public Criteria andAliveenddateIn(List values) {
            addCriterion("aliveEndDate in", values, "aliveenddate");
            return this;
        }

        public Criteria andAliveenddateNotIn(List values) {
            addCriterion("aliveEndDate not in", values, "aliveenddate");
            return this;
        }

        public Criteria andAliveenddateBetween(Date value1, Date value2) {
            addCriterion("aliveEndDate between", value1, value2, "aliveenddate");
            return this;
        }

        public Criteria andAliveenddateNotBetween(Date value1, Date value2) {
            addCriterion("aliveEndDate not between", value1, value2, "aliveenddate");
            return this;
        }

        public Criteria andActivedateIsNull() {
            addCriterion("activeDate is null");
            return this;
        }

        public Criteria andActivedateIsNotNull() {
            addCriterion("activeDate is not null");
            return this;
        }

        public Criteria andActivedateEqualTo(Date value) {
            addCriterion("activeDate =", value, "activedate");
            return this;
        }

        public Criteria andActivedateNotEqualTo(Date value) {
            addCriterion("activeDate <>", value, "activedate");
            return this;
        }

        public Criteria andActivedateGreaterThan(Date value) {
            addCriterion("activeDate >", value, "activedate");
            return this;
        }

        public Criteria andActivedateGreaterThanOrEqualTo(Date value) {
            addCriterion("activeDate >=", value, "activedate");
            return this;
        }

        public Criteria andActivedateLessThan(Date value) {
            addCriterion("activeDate <", value, "activedate");
            return this;
        }

        public Criteria andActivedateLessThanOrEqualTo(Date value) {
            addCriterion("activeDate <=", value, "activedate");
            return this;
        }

        public Criteria andActivedateIn(List values) {
            addCriterion("activeDate in", values, "activedate");
            return this;
        }

        public Criteria andActivedateNotIn(List values) {
            addCriterion("activeDate not in", values, "activedate");
            return this;
        }

        public Criteria andActivedateBetween(Date value1, Date value2) {
            addCriterion("activeDate between", value1, value2, "activedate");
            return this;
        }

        public Criteria andActivedateNotBetween(Date value1, Date value2) {
            addCriterion("activeDate not between", value1, value2, "activedate");
            return this;
        }
    }
}