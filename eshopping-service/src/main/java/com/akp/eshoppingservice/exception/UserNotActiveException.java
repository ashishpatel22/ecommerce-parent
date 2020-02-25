package com.akp.eshoppingservice.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotActiveException extends AuthenticationException {
    /**
	 *
	 */
	private static final long serialVersionUID = -761503632186596342L;

	public UserNotActiveException(String e) {
        super(e);
    }
}
