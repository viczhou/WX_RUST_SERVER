package cn.zhouweiyao.rest.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShopInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopInfoExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopImgIsNull() {
            addCriterion("shop_img is null");
            return (Criteria) this;
        }

        public Criteria andShopImgIsNotNull() {
            addCriterion("shop_img is not null");
            return (Criteria) this;
        }

        public Criteria andShopImgEqualTo(String value) {
            addCriterion("shop_img =", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotEqualTo(String value) {
            addCriterion("shop_img <>", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgGreaterThan(String value) {
            addCriterion("shop_img >", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgGreaterThanOrEqualTo(String value) {
            addCriterion("shop_img >=", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgLessThan(String value) {
            addCriterion("shop_img <", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgLessThanOrEqualTo(String value) {
            addCriterion("shop_img <=", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgLike(String value) {
            addCriterion("shop_img like", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotLike(String value) {
            addCriterion("shop_img not like", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgIn(List<String> values) {
            addCriterion("shop_img in", values, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotIn(List<String> values) {
            addCriterion("shop_img not in", values, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgBetween(String value1, String value2) {
            addCriterion("shop_img between", value1, value2, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotBetween(String value1, String value2) {
            addCriterion("shop_img not between", value1, value2, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNull() {
            addCriterion("shop_address is null");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNotNull() {
            addCriterion("shop_address is not null");
            return (Criteria) this;
        }

        public Criteria andShopAddressEqualTo(String value) {
            addCriterion("shop_address =", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotEqualTo(String value) {
            addCriterion("shop_address <>", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThan(String value) {
            addCriterion("shop_address >", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThanOrEqualTo(String value) {
            addCriterion("shop_address >=", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThan(String value) {
            addCriterion("shop_address <", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThanOrEqualTo(String value) {
            addCriterion("shop_address <=", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLike(String value) {
            addCriterion("shop_address like", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotLike(String value) {
            addCriterion("shop_address not like", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressIn(List<String> values) {
            addCriterion("shop_address in", values, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotIn(List<String> values) {
            addCriterion("shop_address not in", values, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressBetween(String value1, String value2) {
            addCriterion("shop_address between", value1, value2, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotBetween(String value1, String value2) {
            addCriterion("shop_address not between", value1, value2, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopPhoneIsNull() {
            addCriterion("shop_phone is null");
            return (Criteria) this;
        }

        public Criteria andShopPhoneIsNotNull() {
            addCriterion("shop_phone is not null");
            return (Criteria) this;
        }

        public Criteria andShopPhoneEqualTo(String value) {
            addCriterion("shop_phone =", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotEqualTo(String value) {
            addCriterion("shop_phone <>", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneGreaterThan(String value) {
            addCriterion("shop_phone >", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("shop_phone >=", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneLessThan(String value) {
            addCriterion("shop_phone <", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneLessThanOrEqualTo(String value) {
            addCriterion("shop_phone <=", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneLike(String value) {
            addCriterion("shop_phone like", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotLike(String value) {
            addCriterion("shop_phone not like", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneIn(List<String> values) {
            addCriterion("shop_phone in", values, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotIn(List<String> values) {
            addCriterion("shop_phone not in", values, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneBetween(String value1, String value2) {
            addCriterion("shop_phone between", value1, value2, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotBetween(String value1, String value2) {
            addCriterion("shop_phone not between", value1, value2, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeIsNull() {
            addCriterion("shop_latitude is null");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeIsNotNull() {
            addCriterion("shop_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeEqualTo(String value) {
            addCriterion("shop_latitude =", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeNotEqualTo(String value) {
            addCriterion("shop_latitude <>", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeGreaterThan(String value) {
            addCriterion("shop_latitude >", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_latitude >=", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeLessThan(String value) {
            addCriterion("shop_latitude <", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeLessThanOrEqualTo(String value) {
            addCriterion("shop_latitude <=", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeLike(String value) {
            addCriterion("shop_latitude like", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeNotLike(String value) {
            addCriterion("shop_latitude not like", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeIn(List<String> values) {
            addCriterion("shop_latitude in", values, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeNotIn(List<String> values) {
            addCriterion("shop_latitude not in", values, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeBetween(String value1, String value2) {
            addCriterion("shop_latitude between", value1, value2, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeNotBetween(String value1, String value2) {
            addCriterion("shop_latitude not between", value1, value2, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeIsNull() {
            addCriterion("shop_longitude is null");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeIsNotNull() {
            addCriterion("shop_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeEqualTo(String value) {
            addCriterion("shop_longitude =", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeNotEqualTo(String value) {
            addCriterion("shop_longitude <>", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeGreaterThan(String value) {
            addCriterion("shop_longitude >", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_longitude >=", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeLessThan(String value) {
            addCriterion("shop_longitude <", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeLessThanOrEqualTo(String value) {
            addCriterion("shop_longitude <=", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeLike(String value) {
            addCriterion("shop_longitude like", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeNotLike(String value) {
            addCriterion("shop_longitude not like", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeIn(List<String> values) {
            addCriterion("shop_longitude in", values, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeNotIn(List<String> values) {
            addCriterion("shop_longitude not in", values, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeBetween(String value1, String value2) {
            addCriterion("shop_longitude between", value1, value2, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeNotBetween(String value1, String value2) {
            addCriterion("shop_longitude not between", value1, value2, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLicenceIsNull() {
            addCriterion("shop_licence is null");
            return (Criteria) this;
        }

        public Criteria andShopLicenceIsNotNull() {
            addCriterion("shop_licence is not null");
            return (Criteria) this;
        }

        public Criteria andShopLicenceEqualTo(String value) {
            addCriterion("shop_licence =", value, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceNotEqualTo(String value) {
            addCriterion("shop_licence <>", value, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceGreaterThan(String value) {
            addCriterion("shop_licence >", value, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceGreaterThanOrEqualTo(String value) {
            addCriterion("shop_licence >=", value, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceLessThan(String value) {
            addCriterion("shop_licence <", value, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceLessThanOrEqualTo(String value) {
            addCriterion("shop_licence <=", value, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceLike(String value) {
            addCriterion("shop_licence like", value, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceNotLike(String value) {
            addCriterion("shop_licence not like", value, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceIn(List<String> values) {
            addCriterion("shop_licence in", values, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceNotIn(List<String> values) {
            addCriterion("shop_licence not in", values, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceBetween(String value1, String value2) {
            addCriterion("shop_licence between", value1, value2, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andShopLicenceNotBetween(String value1, String value2) {
            addCriterion("shop_licence not between", value1, value2, "shopLicence");
            return (Criteria) this;
        }

        public Criteria andRespNameIsNull() {
            addCriterion("resp_name is null");
            return (Criteria) this;
        }

        public Criteria andRespNameIsNotNull() {
            addCriterion("resp_name is not null");
            return (Criteria) this;
        }

        public Criteria andRespNameEqualTo(String value) {
            addCriterion("resp_name =", value, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameNotEqualTo(String value) {
            addCriterion("resp_name <>", value, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameGreaterThan(String value) {
            addCriterion("resp_name >", value, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameGreaterThanOrEqualTo(String value) {
            addCriterion("resp_name >=", value, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameLessThan(String value) {
            addCriterion("resp_name <", value, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameLessThanOrEqualTo(String value) {
            addCriterion("resp_name <=", value, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameLike(String value) {
            addCriterion("resp_name like", value, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameNotLike(String value) {
            addCriterion("resp_name not like", value, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameIn(List<String> values) {
            addCriterion("resp_name in", values, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameNotIn(List<String> values) {
            addCriterion("resp_name not in", values, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameBetween(String value1, String value2) {
            addCriterion("resp_name between", value1, value2, "respName");
            return (Criteria) this;
        }

        public Criteria andRespNameNotBetween(String value1, String value2) {
            addCriterion("resp_name not between", value1, value2, "respName");
            return (Criteria) this;
        }

        public Criteria andRespPhoneIsNull() {
            addCriterion("resp_phone is null");
            return (Criteria) this;
        }

        public Criteria andRespPhoneIsNotNull() {
            addCriterion("resp_phone is not null");
            return (Criteria) this;
        }

        public Criteria andRespPhoneEqualTo(String value) {
            addCriterion("resp_phone =", value, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneNotEqualTo(String value) {
            addCriterion("resp_phone <>", value, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneGreaterThan(String value) {
            addCriterion("resp_phone >", value, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("resp_phone >=", value, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneLessThan(String value) {
            addCriterion("resp_phone <", value, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneLessThanOrEqualTo(String value) {
            addCriterion("resp_phone <=", value, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneLike(String value) {
            addCriterion("resp_phone like", value, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneNotLike(String value) {
            addCriterion("resp_phone not like", value, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneIn(List<String> values) {
            addCriterion("resp_phone in", values, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneNotIn(List<String> values) {
            addCriterion("resp_phone not in", values, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneBetween(String value1, String value2) {
            addCriterion("resp_phone between", value1, value2, "respPhone");
            return (Criteria) this;
        }

        public Criteria andRespPhoneNotBetween(String value1, String value2) {
            addCriterion("resp_phone not between", value1, value2, "respPhone");
            return (Criteria) this;
        }

        public Criteria andShopStatusIsNull() {
            addCriterion("shop_status is null");
            return (Criteria) this;
        }

        public Criteria andShopStatusIsNotNull() {
            addCriterion("shop_status is not null");
            return (Criteria) this;
        }

        public Criteria andShopStatusEqualTo(Byte value) {
            addCriterion("shop_status =", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotEqualTo(Byte value) {
            addCriterion("shop_status <>", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusGreaterThan(Byte value) {
            addCriterion("shop_status >", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("shop_status >=", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusLessThan(Byte value) {
            addCriterion("shop_status <", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusLessThanOrEqualTo(Byte value) {
            addCriterion("shop_status <=", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusIn(List<Byte> values) {
            addCriterion("shop_status in", values, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotIn(List<Byte> values) {
            addCriterion("shop_status not in", values, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusBetween(Byte value1, Byte value2) {
            addCriterion("shop_status between", value1, value2, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("shop_status not between", value1, value2, "shopStatus");
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