package cn.wzb.ssm.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class KnowledgeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowledgeExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentIsNull() {
            addCriterion("knowledgecontent is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentIsNotNull() {
            addCriterion("knowledgecontent is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentEqualTo(String value) {
            addCriterion("knowledgecontent =", value, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentNotEqualTo(String value) {
            addCriterion("knowledgecontent <>", value, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentGreaterThan(String value) {
            addCriterion("knowledgecontent >", value, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentGreaterThanOrEqualTo(String value) {
            addCriterion("knowledgecontent >=", value, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentLessThan(String value) {
            addCriterion("knowledgecontent <", value, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentLessThanOrEqualTo(String value) {
            addCriterion("knowledgecontent <=", value, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentLike(String value) {
            addCriterion("knowledgecontent like", value, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentNotLike(String value) {
            addCriterion("knowledgecontent not like", value, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentIn(List<String> values) {
            addCriterion("knowledgecontent in", values, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentNotIn(List<String> values) {
            addCriterion("knowledgecontent not in", values, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentBetween(String value1, String value2) {
            addCriterion("knowledgecontent between", value1, value2, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andKnowledgecontentNotBetween(String value1, String value2) {
            addCriterion("knowledgecontent not between", value1, value2, "knowledgecontent");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterionForJDBCTime("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterionForJDBCTime("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterionForJDBCTime("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andTagidIsNull() {
            addCriterion("tagid is null");
            return (Criteria) this;
        }

        public Criteria andTagidIsNotNull() {
            addCriterion("tagid is not null");
            return (Criteria) this;
        }

        public Criteria andTagidEqualTo(Integer value) {
            addCriterion("tagid =", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidNotEqualTo(Integer value) {
            addCriterion("tagid <>", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidGreaterThan(Integer value) {
            addCriterion("tagid >", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tagid >=", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidLessThan(Integer value) {
            addCriterion("tagid <", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidLessThanOrEqualTo(Integer value) {
            addCriterion("tagid <=", value, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidIn(List<Integer> values) {
            addCriterion("tagid in", values, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidNotIn(List<Integer> values) {
            addCriterion("tagid not in", values, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidBetween(Integer value1, Integer value2) {
            addCriterion("tagid between", value1, value2, "tagid");
            return (Criteria) this;
        }

        public Criteria andTagidNotBetween(Integer value1, Integer value2) {
            addCriterion("tagid not between", value1, value2, "tagid");
            return (Criteria) this;
        }

        public Criteria andCateidIsNull() {
            addCriterion("cateid is null");
            return (Criteria) this;
        }

        public Criteria andCateidIsNotNull() {
            addCriterion("cateid is not null");
            return (Criteria) this;
        }

        public Criteria andCateidEqualTo(Integer value) {
            addCriterion("cateid =", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotEqualTo(Integer value) {
            addCriterion("cateid <>", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidGreaterThan(Integer value) {
            addCriterion("cateid >", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cateid >=", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidLessThan(Integer value) {
            addCriterion("cateid <", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidLessThanOrEqualTo(Integer value) {
            addCriterion("cateid <=", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidIn(List<Integer> values) {
            addCriterion("cateid in", values, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotIn(List<Integer> values) {
            addCriterion("cateid not in", values, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidBetween(Integer value1, Integer value2) {
            addCriterion("cateid between", value1, value2, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotBetween(Integer value1, Integer value2) {
            addCriterion("cateid not between", value1, value2, "cateid");
            return (Criteria) this;
        }

        public Criteria andSfshareIsNull() {
            addCriterion("sfshare is null");
            return (Criteria) this;
        }

        public Criteria andSfshareIsNotNull() {
            addCriterion("sfshare is not null");
            return (Criteria) this;
        }

        public Criteria andSfshareEqualTo(Integer value) {
            addCriterion("sfshare =", value, "sfshare");
            return (Criteria) this;
        }

        public Criteria andSfshareNotEqualTo(Integer value) {
            addCriterion("sfshare <>", value, "sfshare");
            return (Criteria) this;
        }

        public Criteria andSfshareGreaterThan(Integer value) {
            addCriterion("sfshare >", value, "sfshare");
            return (Criteria) this;
        }

        public Criteria andSfshareGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfshare >=", value, "sfshare");
            return (Criteria) this;
        }

        public Criteria andSfshareLessThan(Integer value) {
            addCriterion("sfshare <", value, "sfshare");
            return (Criteria) this;
        }

        public Criteria andSfshareLessThanOrEqualTo(Integer value) {
            addCriterion("sfshare <=", value, "sfshare");
            return (Criteria) this;
        }

        public Criteria andSfshareIn(List<Integer> values) {
            addCriterion("sfshare in", values, "sfshare");
            return (Criteria) this;
        }

        public Criteria andSfshareNotIn(List<Integer> values) {
            addCriterion("sfshare not in", values, "sfshare");
            return (Criteria) this;
        }

        public Criteria andSfshareBetween(Integer value1, Integer value2) {
            addCriterion("sfshare between", value1, value2, "sfshare");
            return (Criteria) this;
        }

        public Criteria andSfshareNotBetween(Integer value1, Integer value2) {
            addCriterion("sfshare not between", value1, value2, "sfshare");
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