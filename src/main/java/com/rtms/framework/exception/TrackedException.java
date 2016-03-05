package com.rtms.framework.exception;

import com.rtms.model.system.BaseBusinessObject;

public class TrackedException extends BaseBusinessObject{
	
	private long exceptionLogID;
	private String message;
	private String stackTrace;
	private String objectID;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	public String getObjectID() {
		return objectID;
	}
	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}
	@Override
	public String toString() {
		return "TrackedException [exceptionLogID=" + exceptionLogID + ", message=" + message + ", stackTrace="
				+ stackTrace + ", objectID=" + objectID + "]";
	}
	public long getExceptionLogID() {
		return exceptionLogID;
	}
	public void setExceptionLogID(long exceptionLogID) {
		this.exceptionLogID = exceptionLogID;
	}
	

}
