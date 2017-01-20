package com.ourdesignz.hrm.model;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePOJO {

    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("result")
    private List<Result> result = new ArrayList<Result>();
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
     * @return The result
     */
    @JsonProperty("result")
    public List<Result> getResult() {
        return result;
    }

    /**
     * @param result The result
     */
    @JsonProperty("result")
    public void setResult(List<Result> result) {
        this.result = result;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public class Result {

        @JsonProperty("Announcement")
        private Announcement Announcement;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The announcement
         */
        @JsonProperty("Announcement")
        public Announcement getAnnouncement() {
            return Announcement;
        }

        /**
         * @param announcement The Announcement
         */
        @JsonProperty("Announcement")
        public void setAnnouncement(Announcement announcement) {
            this.Announcement = announcement;
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

    public class Announcement {

        @JsonProperty("id")
        private String id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("desc")
        private String desc;
        @JsonProperty("status")
        private String status;
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
         * @return The desc
         */
        @JsonProperty("desc")
        public String getDesc() {
            return desc;
        }

        /**
         * @param desc The desc
         */
        @JsonProperty("desc")
        public void setDesc(String desc) {
            this.desc = desc;
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
}





