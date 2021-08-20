package edu.eci.co.integrationproject.share;

import lombok.Getter;

@Getter
public enum Status {

	TODO("TODO"),

	DOING("DOING"),

	REVIEW("REVIEW"),

	DONE("DONE");

	private final String statusMessage;

	Status(final String statusMessage) {

		this.statusMessage = statusMessage;
	}
}
