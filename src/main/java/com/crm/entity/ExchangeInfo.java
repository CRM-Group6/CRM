package com.crm.entity;

import java.util.Date;

public class ExchangeInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exchange_info.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exchange_info.executor_id
     *
     * @mbggenerated
     */
    private Long executorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exchange_info.contact_id
     *
     * @mbggenerated
     */
    private Long contactId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exchange_info.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exchange_info.place
     *
     * @mbggenerated
     */
    private String place;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exchange_info.contact_way
     *
     * @mbggenerated
     */
    private Integer contactWay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exchange_info.outline
     *
     * @mbggenerated
     */
    private String outline;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchange_info
     *
     * @mbggenerated
     */
    public ExchangeInfo(Long id, Long executorId, Long contactId, Date time, String place, Integer contactWay, String outline) {
        this.id = id;
        this.executorId = executorId;
        this.contactId = contactId;
        this.time = time;
        this.place = place;
        this.contactWay = contactWay;
        this.outline = outline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchange_info
     *
     * @mbggenerated
     */
    public ExchangeInfo() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchange_info.id
     *
     * @return the value of exchange_info.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchange_info.id
     *
     * @param id the value for exchange_info.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchange_info.executor_id
     *
     * @return the value of exchange_info.executor_id
     *
     * @mbggenerated
     */
    public Long getExecutorId() {
        return executorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchange_info.executor_id
     *
     * @param executorId the value for exchange_info.executor_id
     *
     * @mbggenerated
     */
    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchange_info.contact_id
     *
     * @return the value of exchange_info.contact_id
     *
     * @mbggenerated
     */
    public Long getContactId() {
        return contactId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchange_info.contact_id
     *
     * @param contactId the value for exchange_info.contact_id
     *
     * @mbggenerated
     */
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchange_info.time
     *
     * @return the value of exchange_info.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchange_info.time
     *
     * @param time the value for exchange_info.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchange_info.place
     *
     * @return the value of exchange_info.place
     *
     * @mbggenerated
     */
    public String getPlace() {
        return place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchange_info.place
     *
     * @param place the value for exchange_info.place
     *
     * @mbggenerated
     */
    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchange_info.contact_way
     *
     * @return the value of exchange_info.contact_way
     *
     * @mbggenerated
     */
    public Integer getContactWay() {
        return contactWay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchange_info.contact_way
     *
     * @param contactWay the value for exchange_info.contact_way
     *
     * @mbggenerated
     */
    public void setContactWay(Integer contactWay) {
        this.contactWay = contactWay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchange_info.outline
     *
     * @return the value of exchange_info.outline
     *
     * @mbggenerated
     */
    public String getOutline() {
        return outline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchange_info.outline
     *
     * @param outline the value for exchange_info.outline
     *
     * @mbggenerated
     */
    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }
}