package com.crm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AfterServiceSheet {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column after_service_sheet.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column after_service_sheet.creator_id
     *
     * @mbggenerated
     */
    private Long creatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column after_service_sheet.executor_id
     *
     * @mbggenerated
     */
    private Long executorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column after_service_sheet.executed
     *
     * @mbggenerated
     */
    private Boolean executed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column after_service_sheet.summary
     *
     * @mbggenerated
     */
    private String summary;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column after_service_sheet.create_date
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column after_service_sheet.execute_date
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date executeDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column after_service_sheet.custom_id
     *
     * @mbggenerated
     */
    private Long customId;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_service_sheet
     *
     * @mbggenerated
     */
    public AfterServiceSheet(Long id, Long creatorId, Long executorId, Boolean executed, String summary, Date createDate, Date executeDate, Long customId) {
        this.id = id;
        this.creatorId = creatorId;
        this.executorId = executorId;
        this.executed = executed;
        this.summary = summary;
        this.createDate = createDate;
        this.executeDate = executeDate;
        this.customId = customId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_service_sheet
     *
     * @mbggenerated
     */
    public AfterServiceSheet() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column after_service_sheet.id
     *
     * @return the value of after_service_sheet.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column after_service_sheet.id
     *
     * @param id the value for after_service_sheet.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column after_service_sheet.creator_id
     *
     * @return the value of after_service_sheet.creator_id
     *
     * @mbggenerated
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column after_service_sheet.creator_id
     *
     * @param creatorId the value for after_service_sheet.creator_id
     *
     * @mbggenerated
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column after_service_sheet.executor_id
     *
     * @return the value of after_service_sheet.executor_id
     *
     * @mbggenerated
     */
    public Long getExecutorId() {
        return executorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column after_service_sheet.executor_id
     *
     * @param executorId the value for after_service_sheet.executor_id
     *
     * @mbggenerated
     */
    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column after_service_sheet.executed
     *
     * @return the value of after_service_sheet.executed
     *
     * @mbggenerated
     */
    public Boolean getExecuted() {
        return executed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column after_service_sheet.executed
     *
     * @param executed the value for after_service_sheet.executed
     *
     * @mbggenerated
     */
    public void setExecuted(Boolean executed) {
        this.executed = executed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column after_service_sheet.summary
     *
     * @return the value of after_service_sheet.summary
     *
     * @mbggenerated
     */
    public String getSummary() {
        return summary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column after_service_sheet.summary
     *
     * @param summary the value for after_service_sheet.summary
     *
     * @mbggenerated
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column after_service_sheet.create_date
     *
     * @return the value of after_service_sheet.create_date
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column after_service_sheet.create_date
     *
     * @param createDate the value for after_service_sheet.create_date
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column after_service_sheet.execute_date
     *
     * @return the value of after_service_sheet.execute_date
     *
     * @mbggenerated
     */
    public Date getExecuteDate() {
        return executeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column after_service_sheet.execute_date
     *
     * @param executeDate the value for after_service_sheet.execute_date
     *
     * @mbggenerated
     */
    public void setExecuteDate(Date executeDate) {
        this.executeDate = executeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column after_service_sheet.custom_id
     *
     * @return the value of after_service_sheet.custom_id
     *
     * @mbggenerated
     */
    public Long getCustomId() {
        return customId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column after_service_sheet.custom_id
     *
     * @param customId the value for after_service_sheet.custom_id
     *
     * @mbggenerated
     */
    public void setCustomId(Long customId) {
        this.customId = customId;
    }
}