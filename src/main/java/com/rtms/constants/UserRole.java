package com.rtms.constants;

public enum UserRole {

	ROLE_ADMIN("ROLE_ADMIN"),	
	ROLE_OPERATOR("ROLE_OPERATOR");

	private String userRole;

	UserRole(final String theUserRole) {
		this.userRole = theUserRole;
	}

	public String getUserRole() {
		return this.userRole;
	}

}
