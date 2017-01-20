package com.ourdesignz.hrm.model;

/**
 * Created by ourdesignz on 22/9/16.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "status",
        "message",
        "user"
})
public class LogInPOJO {

    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("user")
    private User user;
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
     * @return The message
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The user
     */
    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
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
            "team_lead_id",
            "role_id",
            "employee_id",
            "username",
            "name",
            "email",
            "dob",
            "locker",
            "website",
            "activation_key",
            "image",
            "title",
            "slug",
            "path",
            "mime_type",
            "designation_id",
            "department_id",
            "correspondence_address",
            "correspondence_city",
            "correspondence_state",
            "correspondence_country",
            "correspondence_postcode",
            "permanent_address",
            "permanent_city",
            "permanent_state",
            "permanent_country",
            "permanent_postcode",
            "experience",
            "hiring_date",
            "confirm_date",
            "resign_date",
            "year",
            "gender",
            "personal_email",
            "cemail",
            "cpassword",
            "skype_id",
            "skype_password",
            "odesk_username",
            "odesk_password",
            "additional_email",
            "additional_password",
            "github_heroku_portfolio",
            "bank_name",
            "account_number",
            "account_holder_name",
            "ifsc_code",
            "emergency_contact_person_name",
            "emergency_contact_number",
            "contact_number",
            "vehicle_no",
            "contact_relation",
            "bio",
            "timezone",
            "client_attention",
            "client_attention_month",
            "status",
            "old",
            "client_rating",
            "show_sale_tab",
            "updated",
            "created"
    })
    public class User implements Serializable{

        @JsonProperty("id")
        private String id;
        @JsonProperty("team_lead_id")
        private String teamLeadId;
        @JsonProperty("role_id")
        private String roleId;
        @JsonProperty("employee_id")
        private String employeeId;
        @JsonProperty("username")
        private String username;
        @JsonProperty("name")
        private String name;
        @JsonProperty("email")
        private String email;
        @JsonProperty("dob")
        private String dob;
        @JsonProperty("locker")
        private String locker;
        @JsonProperty("website")
        private Object website;
        @JsonProperty("activation_key")
        private String activationKey;
        @JsonProperty("image")
        private String image;
        @JsonProperty("title")
        private String title;
        @JsonProperty("slug")
        private String slug;
        @JsonProperty("path")
        private String path;
        @JsonProperty("mime_type")
        private String mimeType;
        @JsonProperty("designation_id")
        private String designationId;
        @JsonProperty("department_id")
        private String departmentId;
        @JsonProperty("correspondence_address")
        private String correspondenceAddress;
        @JsonProperty("correspondence_city")
        private String correspondenceCity;
        @JsonProperty("correspondence_state")
        private String correspondenceState;
        @JsonProperty("correspondence_country")
        private String correspondenceCountry;
        @JsonProperty("correspondence_postcode")
        private String correspondencePostcode;
        @JsonProperty("permanent_address")
        private String permanentAddress;
        @JsonProperty("permanent_city")
        private String permanentCity;
        @JsonProperty("permanent_state")
        private String permanentState;
        @JsonProperty("permanent_country")
        private String permanentCountry;
        @JsonProperty("permanent_postcode")
        private String permanentPostcode;
        @JsonProperty("experience")
        private String experience;
        @JsonProperty("hiring_date")
        private String hiringDate;
        @JsonProperty("confirm_date")
        private String confirmDate;
        @JsonProperty("resign_date")
        private Object resignDate;
        @JsonProperty("year")
        private String year;
        @JsonProperty("gender")
        private String gender;
        @JsonProperty("personal_email")
        private String personalEmail;
        @JsonProperty("cemail")
        private String cemail;
        @JsonProperty("cpassword")
        private String cpassword;
        @JsonProperty("skype_id")
        private String skypeId;
        @JsonProperty("skype_password")
        private String skypePassword;
        @JsonProperty("odesk_username")
        private String odeskUsername;
        @JsonProperty("odesk_password")
        private String odeskPassword;
        @JsonProperty("additional_email")
        private String additionalEmail;
        @JsonProperty("additional_password")
        private String additionalPassword;
        @JsonProperty("github_heroku_portfolio")
        private String githubHerokuPortfolio;
        @JsonProperty("bank_name")
        private String bankName;
        @JsonProperty("account_number")
        private String accountNumber;
        @JsonProperty("account_holder_name")
        private String accountHolderName;
        @JsonProperty("ifsc_code")
        private String ifscCode;
        @JsonProperty("emergency_contact_person_name")
        private String emergencyContactPersonName;
        @JsonProperty("emergency_contact_number")
        private String emergencyContactNumber;
        @JsonProperty("contact_number")
        private String contactNumber;
        @JsonProperty("vehicle_no")
        private String vehicleNo;
        @JsonProperty("contact_relation")
        private String contactRelation;
        @JsonProperty("bio")
        private Object bio;
        @JsonProperty("timezone")
        private String timezone;
        @JsonProperty("client_attention")
        private String clientAttention;
        @JsonProperty("client_attention_month")
        private String clientAttentionMonth;
        @JsonProperty("status")
        private String status;
        @JsonProperty("old")
        private String old;
        @JsonProperty("client_rating")
        private String clientRating;
        @JsonProperty("show_sale_tab")
        private String showSaleTab;
        @JsonProperty("updated")
        private String updated;
        @JsonProperty("created")
        private String created;
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
         * @return The teamLeadId
         */
        @JsonProperty("team_lead_id")
        public String getTeamLeadId() {
            return teamLeadId;
        }

        /**
         * @param teamLeadId The team_lead_id
         */
        @JsonProperty("team_lead_id")
        public void setTeamLeadId(String teamLeadId) {
            this.teamLeadId = teamLeadId;
        }

        /**
         * @return The roleId
         */
        @JsonProperty("role_id")
        public String getRoleId() {
            return roleId;
        }

        /**
         * @param roleId The role_id
         */
        @JsonProperty("role_id")
        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        /**
         * @return The employeeId
         */
        @JsonProperty("employee_id")
        public String getEmployeeId() {
            return employeeId;
        }

        /**
         * @param employeeId The employee_id
         */
        @JsonProperty("employee_id")
        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        /**
         * @return The username
         */
        @JsonProperty("username")
        public String getUsername() {
            return username;
        }

        /**
         * @param username The username
         */
        @JsonProperty("username")
        public void setUsername(String username) {
            this.username = username;
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
         * @return The email
         */
        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        /**
         * @param email The email
         */
        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * @return The dob
         */
        @JsonProperty("dob")
        public String getDob() {
            return dob;
        }

        /**
         * @param dob The dob
         */
        @JsonProperty("dob")
        public void setDob(String dob) {
            this.dob = dob;
        }

        /**
         * @return The locker
         */
        @JsonProperty("locker")
        public String getLocker() {
            return locker;
        }

        /**
         * @param locker The locker
         */
        @JsonProperty("locker")
        public void setLocker(String locker) {
            this.locker = locker;
        }

        /**
         * @return The website
         */
        @JsonProperty("website")
        public Object getWebsite() {
            return website;
        }

        /**
         * @param website The website
         */
        @JsonProperty("website")
        public void setWebsite(Object website) {
            this.website = website;
        }

        /**
         * @return The activationKey
         */
        @JsonProperty("activation_key")
        public String getActivationKey() {
            return activationKey;
        }

        /**
         * @param activationKey The activation_key
         */
        @JsonProperty("activation_key")
        public void setActivationKey(String activationKey) {
            this.activationKey = activationKey;
        }

        /**
         * @return The image
         */
        @JsonProperty("image")
        public String getImage() {
            return image;
        }

        /**
         * @param image The image
         */
        @JsonProperty("image")
        public void setImage(String image) {
            this.image = image;
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

        /**
         * @return The path
         */
        @JsonProperty("path")
        public String getPath() {
            return path;
        }

        /**
         * @param path The path
         */
        @JsonProperty("path")
        public void setPath(String path) {
            this.path = path;
        }

        /**
         * @return The mimeType
         */
        @JsonProperty("mime_type")
        public String getMimeType() {
            return mimeType;
        }

        /**
         * @param mimeType The mime_type
         */
        @JsonProperty("mime_type")
        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        /**
         * @return The designationId
         */
        @JsonProperty("designation_id")
        public String getDesignationId() {
            return designationId;
        }

        /**
         * @param designationId The designation_id
         */
        @JsonProperty("designation_id")
        public void setDesignationId(String designationId) {
            this.designationId = designationId;
        }

        /**
         * @return The departmentId
         */
        @JsonProperty("department_id")
        public String getDepartmentId() {
            return departmentId;
        }

        /**
         * @param departmentId The department_id
         */
        @JsonProperty("department_id")
        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        /**
         * @return The correspondenceAddress
         */
        @JsonProperty("correspondence_address")
        public String getCorrespondenceAddress() {
            return correspondenceAddress;
        }

        /**
         * @param correspondenceAddress The correspondence_address
         */
        @JsonProperty("correspondence_address")
        public void setCorrespondenceAddress(String correspondenceAddress) {
            this.correspondenceAddress = correspondenceAddress;
        }

        /**
         * @return The correspondenceCity
         */
        @JsonProperty("correspondence_city")
        public String getCorrespondenceCity() {
            return correspondenceCity;
        }

        /**
         * @param correspondenceCity The correspondence_city
         */
        @JsonProperty("correspondence_city")
        public void setCorrespondenceCity(String correspondenceCity) {
            this.correspondenceCity = correspondenceCity;
        }

        /**
         * @return The correspondenceState
         */
        @JsonProperty("correspondence_state")
        public String getCorrespondenceState() {
            return correspondenceState;
        }

        /**
         * @param correspondenceState The correspondence_state
         */
        @JsonProperty("correspondence_state")
        public void setCorrespondenceState(String correspondenceState) {
            this.correspondenceState = correspondenceState;
        }

        /**
         * @return The correspondenceCountry
         */
        @JsonProperty("correspondence_country")
        public String getCorrespondenceCountry() {
            return correspondenceCountry;
        }

        /**
         * @param correspondenceCountry The correspondence_country
         */
        @JsonProperty("correspondence_country")
        public void setCorrespondenceCountry(String correspondenceCountry) {
            this.correspondenceCountry = correspondenceCountry;
        }

        /**
         * @return The correspondencePostcode
         */
        @JsonProperty("correspondence_postcode")
        public String getCorrespondencePostcode() {
            return correspondencePostcode;
        }

        /**
         * @param correspondencePostcode The correspondence_postcode
         */
        @JsonProperty("correspondence_postcode")
        public void setCorrespondencePostcode(String correspondencePostcode) {
            this.correspondencePostcode = correspondencePostcode;
        }

        /**
         * @return The permanentAddress
         */
        @JsonProperty("permanent_address")
        public String getPermanentAddress() {
            return permanentAddress;
        }

        /**
         * @param permanentAddress The permanent_address
         */
        @JsonProperty("permanent_address")
        public void setPermanentAddress(String permanentAddress) {
            this.permanentAddress = permanentAddress;
        }

        /**
         * @return The permanentCity
         */
        @JsonProperty("permanent_city")
        public String getPermanentCity() {
            return permanentCity;
        }

        /**
         * @param permanentCity The permanent_city
         */
        @JsonProperty("permanent_city")
        public void setPermanentCity(String permanentCity) {
            this.permanentCity = permanentCity;
        }

        /**
         * @return The permanentState
         */
        @JsonProperty("permanent_state")
        public String getPermanentState() {
            return permanentState;
        }

        /**
         * @param permanentState The permanent_state
         */
        @JsonProperty("permanent_state")
        public void setPermanentState(String permanentState) {
            this.permanentState = permanentState;
        }

        /**
         * @return The permanentCountry
         */
        @JsonProperty("permanent_country")
        public String getPermanentCountry() {
            return permanentCountry;
        }

        /**
         * @param permanentCountry The permanent_country
         */
        @JsonProperty("permanent_country")
        public void setPermanentCountry(String permanentCountry) {
            this.permanentCountry = permanentCountry;
        }

        /**
         * @return The permanentPostcode
         */
        @JsonProperty("permanent_postcode")
        public String getPermanentPostcode() {
            return permanentPostcode;
        }

        /**
         * @param permanentPostcode The permanent_postcode
         */
        @JsonProperty("permanent_postcode")
        public void setPermanentPostcode(String permanentPostcode) {
            this.permanentPostcode = permanentPostcode;
        }

        /**
         * @return The experience
         */
        @JsonProperty("experience")
        public String getExperience() {
            return experience;
        }

        /**
         * @param experience The experience
         */
        @JsonProperty("experience")
        public void setExperience(String experience) {
            this.experience = experience;
        }

        /**
         * @return The hiringDate
         */
        @JsonProperty("hiring_date")
        public String getHiringDate() {
            return hiringDate;
        }

        /**
         * @param hiringDate The hiring_date
         */
        @JsonProperty("hiring_date")
        public void setHiringDate(String hiringDate) {
            this.hiringDate = hiringDate;
        }

        /**
         * @return The confirmDate
         */
        @JsonProperty("confirm_date")
        public String getConfirmDate() {
            return confirmDate;
        }

        /**
         * @param confirmDate The confirm_date
         */
        @JsonProperty("confirm_date")
        public void setConfirmDate(String confirmDate) {
            this.confirmDate = confirmDate;
        }

        /**
         * @return The resignDate
         */
        @JsonProperty("resign_date")
        public Object getResignDate() {
            return resignDate;
        }

        /**
         * @param resignDate The resign_date
         */
        @JsonProperty("resign_date")
        public void setResignDate(Object resignDate) {
            this.resignDate = resignDate;
        }

        /**
         * @return The year
         */
        @JsonProperty("year")
        public String getYear() {
            return year;
        }

        /**
         * @param year The year
         */
        @JsonProperty("year")
        public void setYear(String year) {
            this.year = year;
        }

        /**
         * @return The gender
         */
        @JsonProperty("gender")
        public String getGender() {
            return gender;
        }

        /**
         * @param gender The gender
         */
        @JsonProperty("gender")
        public void setGender(String gender) {
            this.gender = gender;
        }

        /**
         * @return The personalEmail
         */
        @JsonProperty("personal_email")
        public String getPersonalEmail() {
            return personalEmail;
        }

        /**
         * @param personalEmail The personal_email
         */
        @JsonProperty("personal_email")
        public void setPersonalEmail(String personalEmail) {
            this.personalEmail = personalEmail;
        }

        /**
         * @return The cemail
         */
        @JsonProperty("cemail")
        public String getCemail() {
            return cemail;
        }

        /**
         * @param cemail The cemail
         */
        @JsonProperty("cemail")
        public void setCemail(String cemail) {
            this.cemail = cemail;
        }

        /**
         * @return The cpassword
         */
        @JsonProperty("cpassword")
        public String getCpassword() {
            return cpassword;
        }

        /**
         * @param cpassword The cpassword
         */
        @JsonProperty("cpassword")
        public void setCpassword(String cpassword) {
            this.cpassword = cpassword;
        }

        /**
         * @return The skypeId
         */
        @JsonProperty("skype_id")
        public String getSkypeId() {
            return skypeId;
        }

        /**
         * @param skypeId The skype_id
         */
        @JsonProperty("skype_id")
        public void setSkypeId(String skypeId) {
            this.skypeId = skypeId;
        }

        /**
         * @return The skypePassword
         */
        @JsonProperty("skype_password")
        public String getSkypePassword() {
            return skypePassword;
        }

        /**
         * @param skypePassword The skype_password
         */
        @JsonProperty("skype_password")
        public void setSkypePassword(String skypePassword) {
            this.skypePassword = skypePassword;
        }

        /**
         * @return The odeskUsername
         */
        @JsonProperty("odesk_username")
        public String getOdeskUsername() {
            return odeskUsername;
        }

        /**
         * @param odeskUsername The odesk_username
         */
        @JsonProperty("odesk_username")
        public void setOdeskUsername(String odeskUsername) {
            this.odeskUsername = odeskUsername;
        }

        /**
         * @return The odeskPassword
         */
        @JsonProperty("odesk_password")
        public String getOdeskPassword() {
            return odeskPassword;
        }

        /**
         * @param odeskPassword The odesk_password
         */
        @JsonProperty("odesk_password")
        public void setOdeskPassword(String odeskPassword) {
            this.odeskPassword = odeskPassword;
        }

        /**
         * @return The additionalEmail
         */
        @JsonProperty("additional_email")
        public String getAdditionalEmail() {
            return additionalEmail;
        }

        /**
         * @param additionalEmail The additional_email
         */
        @JsonProperty("additional_email")
        public void setAdditionalEmail(String additionalEmail) {
            this.additionalEmail = additionalEmail;
        }

        /**
         * @return The additionalPassword
         */
        @JsonProperty("additional_password")
        public String getAdditionalPassword() {
            return additionalPassword;
        }

        /**
         * @param additionalPassword The additional_password
         */
        @JsonProperty("additional_password")
        public void setAdditionalPassword(String additionalPassword) {
            this.additionalPassword = additionalPassword;
        }

        /**
         * @return The githubHerokuPortfolio
         */
        @JsonProperty("github_heroku_portfolio")
        public String getGithubHerokuPortfolio() {
            return githubHerokuPortfolio;
        }

        /**
         * @param githubHerokuPortfolio The github_heroku_portfolio
         */
        @JsonProperty("github_heroku_portfolio")
        public void setGithubHerokuPortfolio(String githubHerokuPortfolio) {
            this.githubHerokuPortfolio = githubHerokuPortfolio;
        }

        /**
         * @return The bankName
         */
        @JsonProperty("bank_name")
        public String getBankName() {
            return bankName;
        }

        /**
         * @param bankName The bank_name
         */
        @JsonProperty("bank_name")
        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        /**
         * @return The accountNumber
         */
        @JsonProperty("account_number")
        public String getAccountNumber() {
            return accountNumber;
        }

        /**
         * @param accountNumber The account_number
         */
        @JsonProperty("account_number")
        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        /**
         * @return The accountHolderName
         */
        @JsonProperty("account_holder_name")
        public String getAccountHolderName() {
            return accountHolderName;
        }

        /**
         * @param accountHolderName The account_holder_name
         */
        @JsonProperty("account_holder_name")
        public void setAccountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
        }

        /**
         * @return The ifscCode
         */
        @JsonProperty("ifsc_code")
        public String getIfscCode() {
            return ifscCode;
        }

        /**
         * @param ifscCode The ifsc_code
         */
        @JsonProperty("ifsc_code")
        public void setIfscCode(String ifscCode) {
            this.ifscCode = ifscCode;
        }

        /**
         * @return The emergencyContactPersonName
         */
        @JsonProperty("emergency_contact_person_name")
        public String getEmergencyContactPersonName() {
            return emergencyContactPersonName;
        }

        /**
         * @param emergencyContactPersonName The emergency_contact_person_name
         */
        @JsonProperty("emergency_contact_person_name")
        public void setEmergencyContactPersonName(String emergencyContactPersonName) {
            this.emergencyContactPersonName = emergencyContactPersonName;
        }

        /**
         * @return The emergencyContactNumber
         */
        @JsonProperty("emergency_contact_number")
        public String getEmergencyContactNumber() {
            return emergencyContactNumber;
        }

        /**
         * @param emergencyContactNumber The emergency_contact_number
         */
        @JsonProperty("emergency_contact_number")
        public void setEmergencyContactNumber(String emergencyContactNumber) {
            this.emergencyContactNumber = emergencyContactNumber;
        }

        /**
         * @return The contactNumber
         */
        @JsonProperty("contact_number")
        public String getContactNumber() {
            return contactNumber;
        }

        /**
         * @param contactNumber The contact_number
         */
        @JsonProperty("contact_number")
        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        /**
         * @return The vehicleNo
         */
        @JsonProperty("vehicle_no")
        public String getVehicleNo() {
            return vehicleNo;
        }

        /**
         * @param vehicleNo The vehicle_no
         */
        @JsonProperty("vehicle_no")
        public void setVehicleNo(String vehicleNo) {
            this.vehicleNo = vehicleNo;
        }

        /**
         * @return The contactRelation
         */
        @JsonProperty("contact_relation")
        public String getContactRelation() {
            return contactRelation;
        }

        /**
         * @param contactRelation The contact_relation
         */
        @JsonProperty("contact_relation")
        public void setContactRelation(String contactRelation) {
            this.contactRelation = contactRelation;
        }

        /**
         * @return The bio
         */
        @JsonProperty("bio")
        public Object getBio() {
            return bio;
        }

        /**
         * @param bio The bio
         */
        @JsonProperty("bio")
        public void setBio(Object bio) {
            this.bio = bio;
        }

        /**
         * @return The timezone
         */
        @JsonProperty("timezone")
        public String getTimezone() {
            return timezone;
        }

        /**
         * @param timezone The timezone
         */
        @JsonProperty("timezone")
        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        /**
         * @return The clientAttention
         */
        @JsonProperty("client_attention")
        public String getClientAttention() {
            return clientAttention;
        }

        /**
         * @param clientAttention The client_attention
         */
        @JsonProperty("client_attention")
        public void setClientAttention(String clientAttention) {
            this.clientAttention = clientAttention;
        }

        /**
         * @return The clientAttentionMonth
         */
        @JsonProperty("client_attention_month")
        public String getClientAttentionMonth() {
            return clientAttentionMonth;
        }

        /**
         * @param clientAttentionMonth The client_attention_month
         */
        @JsonProperty("client_attention_month")
        public void setClientAttentionMonth(String clientAttentionMonth) {
            this.clientAttentionMonth = clientAttentionMonth;
        }

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
         * @return The old
         */
        @JsonProperty("old")
        public String getOld() {
            return old;
        }

        /**
         * @param old The old
         */
        @JsonProperty("old")
        public void setOld(String old) {
            this.old = old;
        }

        /**
         * @return The clientRating
         */
        @JsonProperty("client_rating")
        public String getClientRating() {
            return clientRating;
        }

        /**
         * @param clientRating The client_rating
         */
        @JsonProperty("client_rating")
        public void setClientRating(String clientRating) {
            this.clientRating = clientRating;
        }

        /**
         * @return The showSaleTab
         */
        @JsonProperty("show_sale_tab")
        public String getShowSaleTab() {
            return showSaleTab;
        }

        /**
         * @param showSaleTab The show_sale_tab
         */
        @JsonProperty("show_sale_tab")
        public void setShowSaleTab(String showSaleTab) {
            this.showSaleTab = showSaleTab;
        }

        /**
         * @return The updated
         */
        @JsonProperty("updated")
        public String getUpdated() {
            return updated;
        }

        /**
         * @param updated The updated
         */
        @JsonProperty("updated")
        public void setUpdated(String updated) {
            this.updated = updated;
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


