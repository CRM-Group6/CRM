package com.crm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class WorkPlan {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_plan.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_plan.opportunity_id
     *
     * @mbggenerated
     */
    private Long opportunityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_plan.executor_id
     *
     * @mbggenerated
     */
    private Long executorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_plan.start_time
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_plan.end_time
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_plan.outline
     *
     * @mbggenerated
     */
    private String outline;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_plan.detailed_info
     *
     * @mbggenerated
     */
    private String detailedInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_plan.status
     *
     * @mbggenerated
     */
    private Boolean status;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_plan
     *
     * @mbggenerated
     */
    public WorkPlan(Long id, Long opportunityId, Long executorId, Date startTime, Date endTime, String outline, String detailedInfo, Boolean status) {
        this.id = id;
        this.opportunityId = opportunityId;
        this.executorId = executorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.outline = outline;
        this.detailedInfo = detailedInfo;
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_plan
     *
     * @mbggenerated
     */
    public WorkPlan() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_plan.id
     *
     * @return the value of work_plan.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_plan.id
     *
     * @param id the value for work_plan.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_plan.opportunity_id
     *
     * @return the value of work_plan.opportunity_id
     *
     * @mbggenerated
     */
    public Long getOpportunityId() {
        return opportunityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_plan.opportunity_id
     *
     * @param opportunityId the value for work_plan.opportunity_id
     *
     * @mbggenerated
     */
    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_plan.executor_id
     *
     * @return the value of work_plan.executor_id
     *
     * @mbggenerated
     */
    public Long getExecutorId() {
        return executorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_plan.executor_id
     *
     * @param executorId the value for work_plan.executor_id
     *
     * @mbggenerated
     */
    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_plan.start_time
     *
     * @return the value of work_plan.start_time
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_plan.start_time
     *
     * @param startTime the value for work_plan.start_time
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_plan.end_time
     *
     * @return the value of work_plan.end_time
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_plan.end_time
     *
     * @param endTime the value for work_plan.end_time
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_plan.outline
     *
     * @return the value of work_plan.outline
     *
     * @mbggenerated
     */
    public String getOutline() {
        return outline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_plan.outline
     *
     * @param outline the value for work_plan.outline
     *
     * @mbggenerated
     */
    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_plan.detailed_info
     *
     * @return the value of work_plan.detailed_info
     *
     * @mbggenerated
     */
    public String getDetailedInfo() {
        return detailedInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_plan.detailed_info
     *
     * @param detailedInfo the value for work_plan.detailed_info
     *
     * @mbggenerated
     */
    public void setDetailedInfo(String detailedInfo) {
        this.detailedInfo = detailedInfo == null ? null : detailedInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_plan.status
     *
     * @return the value of work_plan.status
     *
     * @mbggenerated
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_plan.status
     *
     * @param status the value for work_plan.status
     *
     * @mbggenerated
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WorkPlan{" +
                "id=" + id +
                ", opportunityId=" + opportunityId +
                ", executorId=" + executorId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", outline='" + outline + '\'' +
                ", detailedInfo='" + detailedInfo + '\'' +
                ", status=" + status +
                '}';
    }
}