package com.neu.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table mailing_list
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class MailingList {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mailing_list.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   收件人姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mailing_list.recipients_name
     *
     * @mbg.generated
     */
    private String recipientsName;

    /**
     * Database Column Remarks:
     *   邮编
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mailing_list.postcode
     *
     * @mbg.generated
     */
    private Integer postcode;

    /**
     * Database Column Remarks:
     *   寄存地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mailing_list.Check_address
     *
     * @mbg.generated
     */
    private String checkAddress;

    /**
     * Database Column Remarks:
     *   联系电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mailing_list.phone
     *
     * @mbg.generated
     */
    private Integer phone;

    /**
     * Database Column Remarks:
     *   邮寄方式（平邮、快邮）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mailing_list.mailing_method
     *
     * @mbg.generated
     */
    private String mailingMethod;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mailing_list.id
     *
     * @return the value of mailing_list.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mailing_list.id
     *
     * @param id the value for mailing_list.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mailing_list.recipients_name
     *
     * @return the value of mailing_list.recipients_name
     *
     * @mbg.generated
     */
    public String getRecipientsName() {
        return recipientsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mailing_list.recipients_name
     *
     * @param recipientsName the value for mailing_list.recipients_name
     *
     * @mbg.generated
     */
    public void setRecipientsName(String recipientsName) {
        this.recipientsName = recipientsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mailing_list.postcode
     *
     * @return the value of mailing_list.postcode
     *
     * @mbg.generated
     */
    public Integer getPostcode() {
        return postcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mailing_list.postcode
     *
     * @param postcode the value for mailing_list.postcode
     *
     * @mbg.generated
     */
    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mailing_list.Check_address
     *
     * @return the value of mailing_list.Check_address
     *
     * @mbg.generated
     */
    public String getCheckAddress() {
        return checkAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mailing_list.Check_address
     *
     * @param checkAddress the value for mailing_list.Check_address
     *
     * @mbg.generated
     */
    public void setCheckAddress(String checkAddress) {
        this.checkAddress = checkAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mailing_list.phone
     *
     * @return the value of mailing_list.phone
     *
     * @mbg.generated
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mailing_list.phone
     *
     * @param phone the value for mailing_list.phone
     *
     * @mbg.generated
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mailing_list.mailing_method
     *
     * @return the value of mailing_list.mailing_method
     *
     * @mbg.generated
     */
    public String getMailingMethod() {
        return mailingMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mailing_list.mailing_method
     *
     * @param mailingMethod the value for mailing_list.mailing_method
     *
     * @mbg.generated
     */
    public void setMailingMethod(String mailingMethod) {
        this.mailingMethod = mailingMethod;
    }
}