package com.rtms.framework.exception;

import com.rtms.framework.bo.factory.BOFactory;

public class RTMSException extends Exception {

	private static final long serialVersionUID = -6801213111853741751L;

	public RTMSException() {
		super();
		final TrackedExceptionLogger trackedExceptionLogger = BOFactory.getTrackedExceptionLogger();
		//trackedExceptionLogger.setBaseBO(BOFactory.getBaseBO());
		trackedExceptionLogger.log(this, null, null);

	}

	public RTMSException(final String message) {
		super(message);
		final TrackedExceptionLogger trackedExceptionLogger = BOFactory.getTrackedExceptionLogger();
		//trackedExceptionLogger.setBaseBO(BOFactory.getBaseBO());
		trackedExceptionLogger.log(this, null, message);

	}

	public RTMSException(final Throwable cause) {
		super(cause);
		final TrackedExceptionLogger trackedExceptionLogger = BOFactory.getTrackedExceptionLogger();
		//trackedExceptionLogger.setBaseBO(BOFactory.getBaseBO());
		trackedExceptionLogger.log(this);
	}

	public RTMSException(final String message,final Throwable cause) {
		super(message, cause);
		final TrackedExceptionLogger trackedExceptionLogger = BOFactory.getTrackedExceptionLogger();
		//trackedExceptionLogger.setBaseBO(BOFactory.getBaseBO());
		trackedExceptionLogger.log(this, message);
	}

	public RTMSException(final String message, final Throwable cause, final String objectID) {
		final TrackedExceptionLogger trackedExceptionLogger = BOFactory.getTrackedExceptionLogger();
		//trackedExceptionLogger.setBaseBO(BOFactory.getBaseBO());
		trackedExceptionLogger.log(this, objectID, message);
	}

}