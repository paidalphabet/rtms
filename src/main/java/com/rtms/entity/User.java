package com.rtms.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.rtms.model.system.BaseBusinessObject;

/**
 * @author mahavir
 *
 */
public class User extends BaseBusinessObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1132305600346711591L;
	
	private String id;
	private String prefix;
	private String firstName;
	private String displayName;
	private String middleName;
	private String lastName;
	private String gender;
	private Date dob;
	private String photo;
	private String status;
	private String loginID;
	private String emailID;
	private String password;
	private String securityQuestion;
	private String securityQuestionAnswer;
	private Date lastLoginDate;

	public final static String ENTITY_TYPE_USER = "USER";

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(final String prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		this.displayName = firstName;
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		if(!StringUtils.isEmpty(prefix)){
			this.displayName = prefix + this.displayName;
		}
		if(firstName!=null){
			this.displayName = firstName + " " + lastName; 
		}else{
			this.displayName = lastName;
		}
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(final String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(final Date dob) {
		this.dob = dob;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(final String photo) {
		this.photo = photo;
	}

	/**
	 * @return display name 
	 */
	public String getDisplayName() {
		if(!StringUtils.isEmpty(this.getFirstName())){
			displayName = this.getFirstName();
		}
		if(!StringUtils.isEmpty(this.getLastName()) && StringUtils.isEmpty(displayName)){
			displayName = this.getLastName();
		}
		if(StringUtils.isEmpty(displayName)){
			displayName = null;
		}
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the loginID
	 */
	public String getLoginID() {
		return loginID;
	}

	/**
	 * @param loginID the loginID to set
	 */
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * @param emailID the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the securityQuestion
	 */
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	/**
	 * @param securityQuestion the securityQuestion to set
	 */
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	/**
	 * @return the securityQuestionAnswer
	 */
	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

	/**
	 * @param securityQuestionAnswer the securityQuestionAnswer to set
	 */
	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}

	/**
	 * @return the lastLoginDate
	 */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * @param lastLoginDate the lastLoginDate to set
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", prefix=").append(prefix).append(", firstName=");
		builder.append(firstName).append(", displayName=").append(displayName).append(", middleName=").append(middleName);
		return builder.toString();
	}

}