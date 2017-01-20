package com.ourdesignz.hrm.model;

/**
 * Created by ourdesignz on 30/9/16.
 */

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "status",
        "userApplyLeaves",
        "leaveType",
        "userId",
        "leaveStatus"
})
public class LeaveListPOJO {

    @JsonProperty("status")
    private String status;
    @JsonProperty("userApplyLeaves")
    private List<UserApplyleaf> userApplyLeaves = new ArrayList<UserApplyleaf>();
    @JsonProperty("leaveType")
    private LeaveType leaveType;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("leaveStatus")
    private LeaveStatus leaveStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The userApplyLeaves
     */
    @JsonProperty("userApplyLeaves")
    public List<UserApplyleaf> getUserApplyLeaves() {
        return userApplyLeaves;
    }

    /**
     * @param userApplyLeaves The userApplyLeaves
     */
    @JsonProperty("userApplyLeaves")
    public void setUserApplyLeaves(List<UserApplyleaf> userApplyLeaves) {
        this.userApplyLeaves = userApplyLeaves;
    }

    /**
     * @return The leaveType
     */
    @JsonProperty("leaveType")
    public LeaveType getLeaveType() {
        return leaveType;
    }

    /**
     * @param leaveType The leaveType
     */
    @JsonProperty("leaveType")
    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    /**
     * @return The userId
     */
    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId The userId
     */
    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return The leaveStatus
     */
    @JsonProperty("leaveStatus")
    public LeaveStatus getLeaveStatus() {
        return leaveStatus;
    }

    /**
     * @param leaveStatus The leaveStatus
     */
    @JsonProperty("leaveStatus")
    public void setLeaveStatus(LeaveStatus leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "id",
            "user_id",
            "leave_status_id",
            "leave_type_id",
            "date_from",
            "date_to",
            "number_of_days",
            "holidays",
            "working_days",
            "paid",
            "unpaid",
            "duration_type",
            "half_day",
            "reason",
            "created",
            "modified"
    })
    public class UserApplyLeave {

        @JsonProperty("id")
        private String id;
        @JsonProperty("user_id")
        private String user_id;
        @JsonProperty("leave_status_id")
        private String leave_status_id;
        @JsonProperty("leave_type_id")
        private String leave_type_id;
        @JsonProperty("date_from")
        private String date_from;
        @JsonProperty("date_to")
        private String date_to;
        @JsonProperty("number_of_days")
        private String number_of_days;
        @JsonProperty("holidays")
        private String holidays;
        @JsonProperty("working_days")
        private String working_days;
        @JsonProperty("paid")
        private String paid;
        @JsonProperty("unpaid")
        private String unpaid;
        @JsonProperty("duration_type")
        private String duration_type;
        @JsonProperty("half_day")
        private Object half_day;
        @JsonProperty("reason")
        private String reason;
        @JsonProperty("created")
        private String created;
        @JsonProperty("modified")
        private String modified;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The id
         */
        @JsonProperty("id")
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The userId
         */
        @JsonProperty("user_id")
        public String getUserId() {
            return userId;
        }

        /**
         * @param userId The user_id
         */
        @JsonProperty("user_id")
        public void setUserId(String userId) {
            this.user_id = user_id;
        }

        /**
         * @return The leaveStatusId
         */
        @JsonProperty("leave_status_id")
        public String getLeaveStatusId() {
            return leave_status_id;
        }

        /**
         * @param leaveStatusId The leave_status_id
         */
        @JsonProperty("leave_status_id")
        public void setLeaveStatusId(String leaveStatusId) {
            this.leave_status_id = leave_status_id;
        }

        /**
         * @return The leaveTypeId
         */
        @JsonProperty("leave_type_id")
        public String getLeaveTypeId() {
            return leave_type_id;
        }

        /**
         * @param leaveTypeId The leave_type_id
         */
        @JsonProperty("leave_type_id")
        public void setLeaveTypeId(String leaveTypeId) {
            this.leave_type_id = leave_type_id;
        }

        /**
         * @return The dateFrom
         */
        @JsonProperty("date_from")
        public String getDateFrom() {
            return date_from;
        }

        /**
         * @param dateFrom The date_from
         */
        @JsonProperty("date_from")
        public void setDateFrom(String dateFrom) {
            this.date_from = date_from;
        }

        /**
         * @return The dateTo
         */
        @JsonProperty("date_to")
        public String getDateTo() {
            return date_to;
        }

        /**
         * @param dateTo The date_to
         */
        @JsonProperty("date_to")
        public void setDateTo(String dateTo) {
            this.date_to = date_to;
        }

        /**
         * @return The numberOfDays
         */
        @JsonProperty("number_of_days")
        public String getNumberOfDays() {
            return number_of_days;
        }

        /**
         * @param numberOfDays The number_of_days
         */
        @JsonProperty("number_of_days")
        public void setNumberOfDays(String numberOfDays) {
            this.number_of_days = number_of_days;
        }

        /**
         * @return The holidays
         */
        @JsonProperty("holidays")
        public String getHolidays() {
            return holidays;
        }

        /**
         * @param holidays The holidays
         */
        @JsonProperty("holidays")
        public void setHolidays(String holidays) {
            this.holidays = holidays;
        }

        /**
         * @return The workingDays
         */
        @JsonProperty("working_days")
        public String getWorkingDays() {
            return working_days;
        }

        /**
         * @param workingDays The working_days
         */
        @JsonProperty("working_days")
        public void setWorkingDays(String workingDays) {
            this.working_days = working_days;
        }

        /**
         * @return The paid
         */
        @JsonProperty("paid")
        public String getPaid() {
            return paid;
        }

        /**
         * @param paid The paid
         */
        @JsonProperty("paid")
        public void setPaid(String paid) {
            this.paid = paid;
        }

        /**
         * @return The unpaid
         */
        @JsonProperty("unpaid")
        public String getUnpaid() {
            return unpaid;
        }

        /**
         * @param unpaid The unpaid
         */
        @JsonProperty("unpaid")
        public void setUnpaid(String unpaid) {
            this.unpaid = unpaid;
        }

        /**
         * @return The durationType
         */
        @JsonProperty("duration_type")
        public String getDurationType() {
            return duration_type;
        }

        /**
         * @param durationType The duration_type
         */
        @JsonProperty("duration_type")
        public void setDurationType(String durationType) {
            this.duration_type = duration_type;
        }

        /**
         * @return The halfDay
         */
        @JsonProperty("half_day")
        public Object getHalfDay() {
            return half_day;
        }

        /**
         * @param halfDay The half_day
         */
        @JsonProperty("half_day")
        public void setHalfDay(Object halfDay) {
            this.half_day = half_day;
        }

        /**
         * @return The reason
         */
        @JsonProperty("reason")
        public String getReason() {
            return reason;
        }

        /**
         * @param reason The reason
         */
        @JsonProperty("reason")
        public void setReason(String reason) {
            this.reason = reason;
        }

        /**
         * @return The created
         */
        @JsonProperty("created")
        public String getCreated() {
            return created;
        }

        /**
         * @param created The created
         */
        @JsonProperty("created")
        public void setCreated(String created) {
            this.created = created;
        }

        /**
         * @return The modified
         */
        @JsonProperty("modified")
        public String getModified() {
            return modified;
        }

        /**
         * @param modified The modified
         */
        @JsonProperty("modified")
        public void setModified(String modified) {
            this.modified = modified;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "UserApplyLeave",
            "LeaveStatus",
            "LeaveType",
            "User"
    })
    public class UserApplyleaf {

        @JsonProperty("UserApplyLeave")
        private UserApplyLeave UserApplyLeave;
        @JsonProperty("LeaveStatus")
        private LeaveStatus LeaveStatus;
        @JsonProperty("LeaveType")
        private LeaveType LeaveType;
        @JsonProperty("User")
        private User User;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The userApplyLeave
         */
        @JsonProperty("UserApplyLeave")
        public UserApplyLeave getUserApplyLeave() {
            return UserApplyLeave;
        }

        /**
         * @param userApplyLeave The UserApplyLeave
         */
        @JsonProperty("UserApplyLeave")
        public void setUserApplyLeave(UserApplyLeave UserApplyLeave) {
            this.UserApplyLeave = UserApplyLeave;
        }

        /**
         * @return The leaveStatus
         */
        @JsonProperty("LeaveStatus")
        public LeaveStatus getLeaveStatus() {
            return LeaveStatus;
        }

        /**
         * @param leaveStatus The LeaveStatus
         */
        @JsonProperty("LeaveStatus")
        public void setLeaveStatus(LeaveStatus leaveStatus) {
            this.LeaveStatus = LeaveStatus;
        }

        /**
         * @return The leaveType
         */
        @JsonProperty("LeaveType")
        public LeaveType getLeaveType() {
            return LeaveType;
        }

        /**
         * @param leaveType The LeaveType
         */
        @JsonProperty("LeaveType")
        public void setLeaveType(LeaveType LeaveType) {
            this.LeaveType = LeaveType;
        }

        /**
         * @return The user
         */
        @JsonProperty("User")
        public User getUser() {
            return User;
        }

        /**
         * @param user The User
         */
        @JsonProperty("User")
        public void setUser(User User) {
            this.User = User;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "id",
            "title",
            "slug"
    })
    public class LeaveStatus {

        @JsonProperty("id")
        private String id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("slug")
        private String slug;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The id
         */
        @JsonProperty("id")
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The title
         */
        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The slug
         */
        @JsonProperty("slug")
        public String getSlug() {
            return slug;
        }

        /**
         * @param slug The slug
         */
        @JsonProperty("slug")
        public void setSlug(String slug) {
            this.slug = slug;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "1",
            "4",
            "2",
            "3"
    })
    public class LeaveStatus_ {

        @JsonProperty("1")
        private String _1;
        @JsonProperty("4")
        private String _4;
        @JsonProperty("2")
        private String _2;
        @JsonProperty("3")
        private String _3;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The _1
         */
        @JsonProperty("1")
        public String get1() {
            return _1;
        }

        /**
         * @param _1 The 1
         */
        @JsonProperty("1")
        public void set1(String _1) {
            this._1 = _1;
        }

        /**
         * @return The _4
         */
        @JsonProperty("4")
        public String get4() {
            return _4;
        }

        /**
         * @param _4 The 4
         */
        @JsonProperty("4")
        public void set4(String _4) {
            this._4 = _4;
        }

        /**
         * @return The _2
         */
        @JsonProperty("2")
        public String get2() {
            return _2;
        }

        /**
         * @param _2 The 2
         */
        @JsonProperty("2")
        public void set2(String _2) {
            this._2 = _2;
        }

        /**
         * @return The _3
         */
        @JsonProperty("3")
        public String get3() {
            return _3;
        }

        /**
         * @param _3 The 3
         */
        @JsonProperty("3")
        public void set3(String _3) {
            this._3 = _3;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "id",
            "name",
            "slug"
    })
    public class LeaveType {

        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("slug")
        private String slug;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The id
         */
        @JsonProperty("id")
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The name
         */
        @JsonProperty("name")
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return The slug
         */
        @JsonProperty("slug")
        public String getSlug() {
            return slug;
        }

        /**
         * @param slug The slug
         */
        @JsonProperty("slug")
        public void setSlug(String slug) {
            this.slug = slug;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "1",
            "3",
            "2"
    })
    public class LeaveType_ {

        @JsonProperty("1")
        private String _1;
        @JsonProperty("3")
        private String _3;
        @JsonProperty("2")
        private String _2;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The _1
         */
        @JsonProperty("1")
        public String get1() {
            return _1;
        }

        /**
         * @param _1 The 1
         */
        @JsonProperty("1")
        public void set1(String _1) {
            this._1 = _1;
        }

        /**
         * @return The _3
         */
        @JsonProperty("3")
        public String get3() {
            return _3;
        }

        /**
         * @param _3 The 3
         */
        @JsonProperty("3")
        public void set3(String _3) {
            this._3 = _3;
        }

        /**
         * @return The _2
         */
        @JsonProperty("2")
        public String get2() {
            return _2;
        }

        /**
         * @param _2 The 2
         */
        @JsonProperty("2")
        public void set2(String _2) {
            this._2 = _2;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "id",
            "name"
    })
    public class User {

        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The id
         */
        @JsonProperty("id")
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The name
         */
        @JsonProperty("name")
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

}
















