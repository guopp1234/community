package cn.community.pojo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class CarPortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarPortExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPortIdIsNull() {
            addCriterion("port_id is null");
            return (Criteria) this;
        }

        public Criteria andPortIdIsNotNull() {
            addCriterion("port_id is not null");
            return (Criteria) this;
        }

        public Criteria andPortIdEqualTo(String value) {
            addCriterion("port_id =", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdNotEqualTo(String value) {
            addCriterion("port_id <>", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdGreaterThan(String value) {
            addCriterion("port_id >", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdGreaterThanOrEqualTo(String value) {
            addCriterion("port_id >=", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdLessThan(String value) {
            addCriterion("port_id <", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdLessThanOrEqualTo(String value) {
            addCriterion("port_id <=", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdLike(String value) {
            addCriterion("port_id like", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdNotLike(String value) {
            addCriterion("port_id not like", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdIn(List<String> values) {
            addCriterion("port_id in", values, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdNotIn(List<String> values) {
            addCriterion("port_id not in", values, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdBetween(String value1, String value2) {
            addCriterion("port_id between", value1, value2, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdNotBetween(String value1, String value2) {
            addCriterion("port_id not between", value1, value2, "portId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_Id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_Id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(Integer value) {
            addCriterion("owner_Id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(Integer value) {
            addCriterion("owner_Id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(Integer value) {
            addCriterion("owner_Id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_Id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(Integer value) {
            addCriterion("owner_Id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("owner_Id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<Integer> values) {
            addCriterion("owner_Id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<Integer> values) {
            addCriterion("owner_Id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(Integer value1, Integer value2) {
            addCriterion("owner_Id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_Id not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andPortStatIsNull() {
            addCriterion("port_stat is null");
            return (Criteria) this;
        }

        public Criteria andPortStatIsNotNull() {
            addCriterion("port_stat is not null");
            return (Criteria) this;
        }

        public Criteria andPortStatEqualTo(String value) {
            addCriterion("port_stat =", value, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatNotEqualTo(String value) {
            addCriterion("port_stat <>", value, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatGreaterThan(String value) {
            addCriterion("port_stat >", value, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatGreaterThanOrEqualTo(String value) {
            addCriterion("port_stat >=", value, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatLessThan(String value) {
            addCriterion("port_stat <", value, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatLessThanOrEqualTo(String value) {
            addCriterion("port_stat <=", value, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatLike(String value) {
            addCriterion("port_stat like", value, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatNotLike(String value) {
            addCriterion("port_stat not like", value, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatIn(List<String> values) {
            addCriterion("port_stat in", values, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatNotIn(List<String> values) {
            addCriterion("port_stat not in", values, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatBetween(String value1, String value2) {
            addCriterion("port_stat between", value1, value2, "portStat");
            return (Criteria) this;
        }

        public Criteria andPortStatNotBetween(String value1, String value2) {
            addCriterion("port_stat not between", value1, value2, "portStat");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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