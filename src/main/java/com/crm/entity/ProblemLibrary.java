package com.crm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ProblemLibrary {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column problem_library.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column problem_library.category
     *
     * @mbggenerated
     */
    private String category;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column problem_library.question
     *
     * @mbggenerated
     */
    private String question;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column problem_library.answer
     *
     * @mbggenerated
     */
    private String answer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column problem_library.create_date
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column problem_library.update_date
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table problem_library
     *
     * @mbggenerated
     */
    public ProblemLibrary(Long id, String category, String question, String answer, Date createDate, Date updateDate) {
        this.id = id;
        this.category = category;
        this.question = question;
        this.answer = answer;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table problem_library
     *
     * @mbggenerated
     */
    public ProblemLibrary() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column problem_library.id
     *
     * @return the value of problem_library.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column problem_library.id
     *
     * @param id the value for problem_library.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column problem_library.category
     *
     * @return the value of problem_library.category
     *
     * @mbggenerated
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column problem_library.category
     *
     * @param category the value for problem_library.category
     *
     * @mbggenerated
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column problem_library.question
     *
     * @return the value of problem_library.question
     *
     * @mbggenerated
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column problem_library.question
     *
     * @param question the value for problem_library.question
     *
     * @mbggenerated
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column problem_library.answer
     *
     * @return the value of problem_library.answer
     *
     * @mbggenerated
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column problem_library.answer
     *
     * @param answer the value for problem_library.answer
     *
     * @mbggenerated
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column problem_library.create_date
     *
     * @return the value of problem_library.create_date
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column problem_library.create_date
     *
     * @param createDate the value for problem_library.create_date
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column problem_library.update_date
     *
     * @return the value of problem_library.update_date
     *
     * @mbggenerated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column problem_library.update_date
     *
     * @param updateDate the value for problem_library.update_date
     *
     * @mbggenerated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}