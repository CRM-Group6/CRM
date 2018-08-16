package com.crm.entity;

public class Customer {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.custom_service_id
     *
     * @mbggenerated
     */
    private Long customServiceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.account
     *
     * @mbggenerated
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.telephone
     *
     * @mbggenerated
     */
    private String telephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.personal_interest
     *
     * @mbggenerated
     */
    private String personalInterest;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.province
     *
     * @mbggenerated
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.city
     *
     * @mbggenerated
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.area
     *
     * @mbggenerated
     */
    private String area;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.source
     *
     * @mbggenerated
     */
    private String source;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.vocation
     *
     * @mbggenerated
     */
    private String vocation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.category
     *
     * @mbggenerated
     */
    private String category;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.job
     *
     * @mbggenerated
     */
    private String job;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    public Customer(Long id, Long customServiceId, String account, String password, String name, String telephone, String personalInterest, String province, String city, String area, String source, String vocation, String category, String job) {
        this.id = id;
        this.customServiceId = customServiceId;
        this.account = account;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.personalInterest = personalInterest;
        this.province = province;
        this.city = city;
        this.area = area;
        this.source = source;
        this.vocation = vocation;
        this.category = category;
        this.job = job;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    public Customer() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.id
     *
     * @return the value of customer.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.id
     *
     * @param id the value for customer.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.custom_service_id
     *
     * @return the value of customer.custom_service_id
     *
     * @mbggenerated
     */
    public Long getCustomServiceId() {
        return customServiceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.custom_service_id
     *
     * @param customServiceId the value for customer.custom_service_id
     *
     * @mbggenerated
     */
    public void setCustomServiceId(Long customServiceId) {
        this.customServiceId = customServiceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.account
     *
     * @return the value of customer.account
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.account
     *
     * @param account the value for customer.account
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.password
     *
     * @return the value of customer.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.password
     *
     * @param password the value for customer.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.name
     *
     * @return the value of customer.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.name
     *
     * @param name the value for customer.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.telephone
     *
     * @return the value of customer.telephone
     *
     * @mbggenerated
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.telephone
     *
     * @param telephone the value for customer.telephone
     *
     * @mbggenerated
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.personal_interest
     *
     * @return the value of customer.personal_interest
     *
     * @mbggenerated
     */
    public String getPersonalInterest() {
        return personalInterest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.personal_interest
     *
     * @param personalInterest the value for customer.personal_interest
     *
     * @mbggenerated
     */
    public void setPersonalInterest(String personalInterest) {
        this.personalInterest = personalInterest == null ? null : personalInterest.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.province
     *
     * @return the value of customer.province
     *
     * @mbggenerated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.province
     *
     * @param province the value for customer.province
     *
     * @mbggenerated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.city
     *
     * @return the value of customer.city
     *
     * @mbggenerated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.city
     *
     * @param city the value for customer.city
     *
     * @mbggenerated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.area
     *
     * @return the value of customer.area
     *
     * @mbggenerated
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.area
     *
     * @param area the value for customer.area
     *
     * @mbggenerated
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.source
     *
     * @return the value of customer.source
     *
     * @mbggenerated
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.source
     *
     * @param source the value for customer.source
     *
     * @mbggenerated
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.vocation
     *
     * @return the value of customer.vocation
     *
     * @mbggenerated
     */
    public String getVocation() {
        return vocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.vocation
     *
     * @param vocation the value for customer.vocation
     *
     * @mbggenerated
     */
    public void setVocation(String vocation) {
        this.vocation = vocation == null ? null : vocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.category
     *
     * @return the value of customer.category
     *
     * @mbggenerated
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.category
     *
     * @param category the value for customer.category
     *
     * @mbggenerated
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.job
     *
     * @return the value of customer.job
     *
     * @mbggenerated
     */
    public String getJob() {
        return job;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.job
     *
     * @param job the value for customer.job
     *
     * @mbggenerated
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customServiceId=" + customServiceId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", personalInterest='" + personalInterest + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", source='" + source + '\'' +
                ", vocation='" + vocation + '\'' +
                ", category='" + category + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}