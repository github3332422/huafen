package edu.javaee.ssmcrud.bean;

import java.util.ArrayList;
import java.util.List;

public class EmployerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployerExample() {
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

        public Criteria andEmp_idIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmp_idIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmp_idEqualTo(Integer value) {
            addCriterion("emp_id =", value, "emp_id");
            return (Criteria) this;
        }

        public Criteria andEmp_idNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "emp_id");
            return (Criteria) this;
        }

        public Criteria andEmp_idGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "emp_id");
            return (Criteria) this;
        }

        public Criteria andEmp_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "emp_id");
            return (Criteria) this;
        }

        public Criteria andEmp_idLessThan(Integer value) {
            addCriterion("emp_id <", value, "emp_id");
            return (Criteria) this;
        }

        public Criteria andEmp_idLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "emp_id");
            return (Criteria) this;
        }

        public Criteria andEmp_idIn(List<Integer> values) {
            addCriterion("emp_id in", values, "emp_id");
            return (Criteria) this;
        }

        public Criteria andEmp_idNotIn(List<Integer> values) {
            addCriterion("emp_id not in", values, "emp_id");
            return (Criteria) this;
        }

        public Criteria andEmp_idBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between", value1, value2, "emp_id");
            return (Criteria) this;
        }

        public Criteria andEmp_idNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between", value1, value2, "emp_id");
            return (Criteria) this;
        }

        public Criteria andEmp_nameIsNull() {
            addCriterion("emp_name is null");
            return (Criteria) this;
        }

        public Criteria andEmp_nameIsNotNull() {
            addCriterion("emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmp_nameEqualTo(String value) {
            addCriterion("emp_name =", value, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameNotEqualTo(String value) {
            addCriterion("emp_name <>", value, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameGreaterThan(String value) {
            addCriterion("emp_name >", value, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name >=", value, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameLessThan(String value) {
            addCriterion("emp_name <", value, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameLessThanOrEqualTo(String value) {
            addCriterion("emp_name <=", value, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameLike(String value) {
            addCriterion("emp_name like", value, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameNotLike(String value) {
            addCriterion("emp_name not like", value, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameIn(List<String> values) {
            addCriterion("emp_name in", values, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameNotIn(List<String> values) {
            addCriterion("emp_name not in", values, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameBetween(String value1, String value2) {
            addCriterion("emp_name between", value1, value2, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_nameNotBetween(String value1, String value2) {
            addCriterion("emp_name not between", value1, value2, "emp_name");
            return (Criteria) this;
        }

        public Criteria andEmp_genderIsNull() {
            addCriterion("emp_gender is null");
            return (Criteria) this;
        }

        public Criteria andEmp_genderIsNotNull() {
            addCriterion("emp_gender is not null");
            return (Criteria) this;
        }

        public Criteria andEmp_genderEqualTo(String value) {
            addCriterion("emp_gender =", value, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderNotEqualTo(String value) {
            addCriterion("emp_gender <>", value, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderGreaterThan(String value) {
            addCriterion("emp_gender >", value, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderGreaterThanOrEqualTo(String value) {
            addCriterion("emp_gender >=", value, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderLessThan(String value) {
            addCriterion("emp_gender <", value, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderLessThanOrEqualTo(String value) {
            addCriterion("emp_gender <=", value, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderLike(String value) {
            addCriterion("emp_gender like", value, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderNotLike(String value) {
            addCriterion("emp_gender not like", value, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderIn(List<String> values) {
            addCriterion("emp_gender in", values, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderNotIn(List<String> values) {
            addCriterion("emp_gender not in", values, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderBetween(String value1, String value2) {
            addCriterion("emp_gender between", value1, value2, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmp_genderNotBetween(String value1, String value2) {
            addCriterion("emp_gender not between", value1, value2, "emp_gender");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andDept_idIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDept_idIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDept_idEqualTo(Integer value) {
            addCriterion("dept_id =", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idNotEqualTo(Integer value) {
            addCriterion("dept_id <>", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idGreaterThan(Integer value) {
            addCriterion("dept_id >", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_id >=", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idLessThan(Integer value) {
            addCriterion("dept_id <", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idLessThanOrEqualTo(Integer value) {
            addCriterion("dept_id <=", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idIn(List<Integer> values) {
            addCriterion("dept_id in", values, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idNotIn(List<Integer> values) {
            addCriterion("dept_id not in", values, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idBetween(Integer value1, Integer value2) {
            addCriterion("dept_id between", value1, value2, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_id not between", value1, value2, "dept_id");
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