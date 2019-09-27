package com.neu.mapper;

import com.neu.entity.MailingList;
import com.neu.entity.MailingListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailingListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    long countByExample(MailingListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    int deleteByExample(MailingListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    int insert(MailingList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    int insertSelective(MailingList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    List<MailingList> selectByExample(MailingListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    MailingList selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MailingList record, @Param("example") MailingListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MailingList record, @Param("example") MailingListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MailingList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mailing_list
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MailingList record);
}