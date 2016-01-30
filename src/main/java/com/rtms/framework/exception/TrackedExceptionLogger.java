package com.rtms.framework.exception;

import com.rtms.bo.BaseBO;

public interface TrackedExceptionLogger {

	public void log(RTMSException exception);

	public void log(RTMSException exception, String objectID);
	
	public void log(RTMSException exception, String objectID,String message);

	public TrackedException getTrackedException();

	public void setTrackedException(TrackedException trackedException);

	public BaseBO getBaseBO();

	void setBaseBO(BaseBO basebo);
	
}
