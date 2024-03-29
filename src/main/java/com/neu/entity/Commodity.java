package com.neu.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table commodity
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class   Commodity{
    /**
     * Database Column Remarks:
     *   ID主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   商品名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.ComName
     *
     * @mbg.generated
     */
    private String comname;

    /**
     * Database Column Remarks:
     *   商品单价
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.Price
     *
     * @mbg.generated
     */
    private Double price;

    /**
     * Database Column Remarks:
     *   商品描述
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.Bescribe
     *
     * @mbg.generated
     */
    private String bescribe;

    /**
     * Database Column Remarks:
     *   商品剩余数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.Surplus
     *
     * @mbg.generated
     */
    private Integer surplus;

    /**
     * Database Column Remarks:
     *   商品大类别编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.Lclassify_No
     *
     * @mbg.generated
     */
    private LargerCategory largercategory;

    /**
     * Database Column Remarks:
     *   商品小分类编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.Sclassify_No
     *
     * @mbg.generated
     */
    private SmallCategory smallcategory;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.ID
     *
     * @return the value of commodity.ID
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.ID
     *
     * @param id the value for commodity.ID
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.ComName
     *
     * @return the value of commodity.ComName
     *
     * @mbg.generated
     */
    public String getComname() {
        return comname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.ComName
     *
     * @param comname the value for commodity.ComName
     *
     * @mbg.generated
     */
    public void setComname(String comname) {
        this.comname = comname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.Price
     *
     * @return the value of commodity.Price
     *
     * @mbg.generated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.Price
     *
     * @param price the value for commodity.Price
     *
     * @mbg.generated
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.Bescribe
     *
     * @return the value of commodity.Bescribe
     *
     * @mbg.generated
     */
    public String getBescribe() {
        return bescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.Bescribe
     *
     * @param bescribe the value for commodity.Bescribe
     *
     * @mbg.generated
     */
    public void setBescribe(String bescribe) {
        this.bescribe = bescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.Surplus
     *
     * @return the value of commodity.Surplus
     *
     * @mbg.generated
     */
    public Integer getSurplus() {
        return surplus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.Surplus
     *
     * @param surplus the value for commodity.Surplus
     *
     * @mbg.generated
     */
    public void setSurplus(Integer surplus) {
        this.surplus = surplus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.Lclassify_No
     *
     * @return the value of commodity.Lclassify_No
     *
     * @mbg.generated
     */
    public LargerCategory getLargercategory() {
        return largercategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.Lclassify_No
     *
     * @param largercategory the value for commodity.Lclassify_No
     *
     * @mbg.generated
     */
    public void setLargercategory(LargerCategory largercategory) {
        this.largercategory = largercategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.Sclassify_No
     *
     * @return the value of commodity.Sclassify_No
     *
     * @mbg.generated
     */
    public SmallCategory getSmallcategory() {
        return smallcategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.Sclassify_No
     *
     * @param smallcategory the value for commodity.Sclassify_No
     *
     * @mbg.generated
     */
    public void setSmallcategory(SmallCategory smallcategory) {
        this.smallcategory = smallcategory;
    }
}