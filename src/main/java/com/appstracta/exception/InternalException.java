package com.appstracta.exception;

public class InternalException extends Exception {

	private static final long serialVersionUID = -1074110678318635096L;

	protected InternalException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace, final Object... params) {
		super(String.format(message, params), cause, enableSuppression, writableStackTrace);
	}

	public InternalException(final String message, final Throwable cause, final Object... params) {
		super(String.format(message, params), cause, false, true);
	}

	public InternalException(final String message, final Object... params) {
		this(message, (Throwable) null, params);
	}

}