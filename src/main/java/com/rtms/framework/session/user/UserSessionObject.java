package com.rtms.framework.session.user;

public class UserSessionObject {
	
	private String userID;
	private String displayName;
	private String profilePic;
	private String emailID;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserSessionObject [userID=");
		builder.append(userID);
		builder.append(", displayName=");
		builder.append(displayName);
		builder.append(", profilePic=");
		builder.append(profilePic);
		builder.append(", emailID=");
		builder.append(emailID);
		builder.append("]");
		return builder.toString();
	}

}
