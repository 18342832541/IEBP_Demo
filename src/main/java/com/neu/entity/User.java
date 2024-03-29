package com.neu.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table user
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class User {
    /**
	 * Database Column Remarks: 自增序号 This field was generated by MyBatis Generator. This field corresponds to the database column user.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * Database Column Remarks: 用户名 This field was generated by MyBatis Generator. This field corresponds to the database column user.username
	 * @mbg.generated
	 */
	private String username;
	/**
	 * Database Column Remarks: 用户密码 This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbg.generated
	 */
	private String password;
	/**
	 * Database Column Remarks: 用户身份 This field was generated by MyBatis Generator. This field corresponds to the database column user.role_id
	 * @mbg.generated
	 */
	private Role role;
	/**
	 * Database Column Remarks: 删除标记 This field was generated by MyBatis Generator. This field corresponds to the database column user.delMark
	 * @mbg.generated
	 */
	private Integer delmark;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.id
	 * @return  the value of user.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.id
	 * @param id  the value for user.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.username
	 * @return  the value of user.username
	 * @mbg.generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.username
	 * @param username  the value for user.username
	 * @mbg.generated
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.password
	 * @return  the value of user.password
	 * @mbg.generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.password
	 * @param password  the value for user.password
	 * @mbg.generated
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.role_id
	 * @return  the value of user.role_id
	 * @mbg.generated
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.role_id
	 * @param role  the value for user.role_id
	 * @mbg.generated
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.delMark
	 * @return  the value of user.delMark
	 * @mbg.generated
	 */
	public Integer getDelmark() {
		return delmark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.delMark
	 * @param delmark  the value for user.delMark
	 * @mbg.generated
	 */
	public void setDelmark(Integer delmark) {
		this.delmark = delmark;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
    
}