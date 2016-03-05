package com.rtms.framework.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import com.rtms.bo.BaseBO;

public class TrackedExceptionLoggerImpl extends Thread implements TrackedExceptionLogger {

	private TrackedException trackedException;

	private BaseBO baseBO;
	
	public TrackedExceptionLoggerImpl(final TrackedException trackedException) {
		this.setTrackedException(trackedException);
	}
	
	public TrackedExceptionLoggerImpl() {
	
	}
	

	@Override
	public TrackedException getTrackedException() {
		return trackedException;
	}

	@Override
	public void setTrackedException(TrackedException trackedException) {
		this.trackedException = trackedException;
	}

	/**
	 * @return the baseBO
	 */
	public BaseBO getBaseBO() {
		return baseBO;
	}

	/**
	 * @param baseBO the baseBO to set
	 */
	public void setBaseBO(BaseBO baseBO) {
		this.baseBO = baseBO;
	}

	@Override
	public void run() {
		getBaseBO().saveTrackedException(getTrackedException());
	}

	@Override
	public void log(final RTMSException exception) {
		final StringWriter errors = new StringWriter();
		exception.printStackTrace(new PrintWriter(errors));

		final TrackedException trackedException = new TrackedException();
		trackedException.setStackTrace(errors.toString());
		trackedException.setMessage(exception.getMessage());
		trackedException.setCreationDate(new Date());
		trackedException.setModificationDate(new Date());
		
		final Thread logger = new TrackedExceptionLoggerImpl(trackedException);
		logger.start();
	}

	@Override
	public void log(final RTMSException exception, final String objectID) {
		StringWriter errors = new StringWriter();
		exception.printStackTrace(new PrintWriter(errors));

		TrackedException trackedException = new TrackedException();
		trackedException.setStackTrace(errors.toString());
		trackedException.setMessage(exception.getMessage());
		trackedException.setObjectID(objectID);
		trackedException.setCreationDate(new Date());
		trackedException.setModificationDate(new Date());
		final Thread logger = new TrackedExceptionLoggerImpl(trackedException);
		logger.start();
	}

	@Override
	public void log(final RTMSException exception, final String objectID, final String message) {
		StringWriter errors = new StringWriter();
		exception.printStackTrace(new PrintWriter(errors));

		TrackedException trackedException = new TrackedException();
		trackedException.setStackTrace(errors.toString());
		trackedException.setMessage(message);
		trackedException.setObjectID(objectID);
		trackedException.setCreationDate(new Date());
		trackedException.setModificationDate(new Date());

		final Thread logger = new TrackedExceptionLoggerImpl(trackedException);
		logger.start();

	}

}
