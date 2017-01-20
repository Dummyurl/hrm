package com.ourdesignz.hrm.model;

/**
 * Created by ourdesignz on 12/10/16.
 */

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "status",
        "paid_leaves",
        "unpaid_leaves",
        "total_paid_leaves_balance",
        "class_name",
        "message",
        "applied_leave_limit",
        "leave",
        "leave_type_id"
})
public class AvailableLeavesRequestPOJO {

    @JsonProperty("status")
    private String status;
    @JsonProperty("paid_leaves")
    private String paid_leaves;
    @JsonProperty("unpaid_leaves")
    private String unpaid_leaves;
    @JsonProperty("total_paid_leaves_balance")
    private String total_paid_leaves_balance;
    @JsonProperty("class_name")
    private String class_name;
    @JsonProperty("message")
    private String message;
    @JsonProperty("applied_leave_limit")
    private String applied_leave_limit;
    @JsonProperty("leave")
    private String leave;
    @JsonProperty("leave_type_id")
    private String leave_type_id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The paidLeaves
     */
    @JsonProperty("paid_leaves")
    public String getPaidLeaves() {
        return paid_leaves;
    }

    /**
     *
     * @param paidLeaves
     * The paid_leaves
     */
    @JsonProperty("paid_leaves")
    public void setPaidLeaves(String paid_leaves) {
        this.paid_leaves = paid_leaves;
    }

    /**
     *
     * @return
     * The unpaidLeaves
     */
    @JsonProperty("unpaid_leaves")
    public String getUnpaidLeaves() {
        return unpaid_leaves;
    }

    /**
     *
     * @param unpaidLeaves
     * The unpaid_leaves
     */
    @JsonProperty("unpaid_leaves")
    public void setUnpaidLeaves(String unpaid_leaves) {
        this.unpaid_leaves = unpaid_leaves;
    }

    /**
     *
     * @return
     * The totalPaidLeavesBalance
     */
    @JsonProperty("total_paid_leaves_balance")
    public String getTotalPaidLeavesBalance() {
        return total_paid_leaves_balance;
    }

    /**
     *
     * @param totalPaidLeavesBalance
     * The total_paid_leaves_balance
     */
    @JsonProperty("total_paid_leaves_balance")
    public void setTotalPaidLeavesBalance(String total_paid_leaves_balance) {
        this.total_paid_leaves_balance = total_paid_leaves_balance;
    }

    /**
     *
     * @return
     * The className
     */
    @JsonProperty("class_name")
    public String getClassName() {
        return class_name;
    }

    /**
     *
     * @param className
     * The class_name
     */
    @JsonProperty("class_name")
    public void setClassName(String class_name) {
        this.class_name = class_name;
    }

    /**
     *
     * @return
     * The message
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The appliedLeaveLimit
     */
    @JsonProperty("applied_leave_limit")
    public String getAppliedLeaveLimit() {
        return applied_leave_limit;
    }

    /**
     *
     * @param appliedLeaveLimit
     * The applied_leave_limit
     */
    @JsonProperty("applied_leave_limit")
    public void setAppliedLeaveLimit(String applied_leave_limit) {
        this.applied_leave_limit = applied_leave_limit;
    }

    /**
     *
     * @return
     * The leave
     */
    @JsonProperty("leave")
    public String getLeave() {
        return leave;
    }

    /**
     *
     * @param leave
     * The leave
     */
    @JsonProperty("leave")
    public void setLeave(String leave) {
        this.leave = leave;
    }

    /**
     *
     * @return
     * The leaveTypeId
     */
    @JsonProperty("leave_type_id")
    public String getLeaveTypeId() {
        return leave_type_id;
    }

    /**
     *
     * @param leaveTypeId
     * The leave_type_id
     */
    @JsonProperty("leave_type_id")
    public void setLeaveTypeId(String leave_type_id) {
        this.leave_type_id = leave_type_id;
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