package com.rtms.framework.exception;

import com.rtms.bo.BaseService;

public interface TrackedExceptionLogger {

	public void log(RTMSException exception);

	public void log(RTMSException exception, String objectID);
	
	public void log(RTMSException exception, String objectID,String message);

	public TrackedException getTrackedException();

	public void setTrackedException(TrackedException trackedException);

	public BaseService getBaseBO();

	void setBaseBO(BaseService basebo);
	
}
