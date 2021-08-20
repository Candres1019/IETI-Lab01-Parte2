package edu.eci.co.integrationproject.share;

import lombok.Getter;

/**
 * Integration Project Enum Status
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public enum Status {

	TODO("TODO"),

	DOING("DOING"),

	REVIEW("REVIEW"),

	DONE("DONE");

	private final String statusMessage;

	/**
	 * Constructor.
	 *
	 * @param statusMessage Status message
	 */
	Status(final String statusMessage) {

		this.statusMessage = statusMessage;
	}
}
