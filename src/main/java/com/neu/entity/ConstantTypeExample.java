package com.neu.entity;

import java.util.ArrayList;
import java.util.List;

public class ConstantTypeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public ConstantTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMailingMethodIsNull() {
            addCriterion("mailing_method is null");
            return (Criteria) this;
        }

        public Criteria andMailingMethodIsNotNull() {
            addCriterion("mailing_method is not null");
            return (Criteria) this;
        }

        public Criteria andMailingMethodEqualTo(String value) {
            addCriterion("mailing_method =", value, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodNotEqualTo(String value) {
            addCriterion("mailing_method <>", value, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodGreaterThan(String value) {
            addCriterion("mailing_method >", value, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodGreaterThanOrEqualTo(String value) {
            addCriterion("mailing_method >=", value, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodLessThan(String value) {
            addCriterion("mailing_method <", value, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodLessThanOrEqualTo(String value) {
            addCriterion("mailing_method <=", value, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodLike(String value) {
            addCriterion("mailing_method like", value, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodNotLike(String value) {
            addCriterion("mailing_method not like", value, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodIn(List<String> values) {
            addCriterion("mailing_method in", values, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodNotIn(List<String> values) {
            addCriterion("mailing_method not in", values, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodBetween(String value1, String value2) {
            addCriterion("mailing_method between", value1, value2, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andMailingMethodNotBetween(String value1, String value2) {
            addCriterion("mailing_method not between", value1, value2, "mailingMethod");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentIsNull() {
            addCriterion("pattern_payment is null");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentIsNotNull() {
            addCriterion("pattern_payment is not null");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentEqualTo(String value) {
            addCriterion("pattern_payment =", value, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentNotEqualTo(String value) {
            addCriterion("pattern_payment <>", value, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentGreaterThan(String value) {
            addCriterion("pattern_payment >", value, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("pattern_payment >=", value, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentLessThan(String value) {
            addCriterion("pattern_payment <", value, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentLessThanOrEqualTo(String value) {
            addCriterion("pattern_payment <=", value, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentLike(String value) {
            addCriterion("pattern_payment like", value, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentNotLike(String value) {
            addCriterion("pattern_payment not like", value, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentIn(List<String> values) {
            addCriterion("pattern_payment in", values, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentNotIn(List<String> values) {
            addCriterion("pattern_payment not in", values, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentBetween(String value1, String value2) {
            addCriterion("pattern_payment between", value1, value2, "patternPayment");
            return (Criteria) this;
        }

        public Criteria andPatternPaymentNotBetween(String value1, String value2) {
            addCriterion("pattern_payment not between", value1, value2, "patternPayment");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table constant_type
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table constant_type
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}