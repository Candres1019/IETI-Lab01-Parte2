package edu.eci.co.integrationproject.dto;

import java.util.Date;

import edu.eci.co.integrationproject.share.Status;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TaskDto {

	private final String name;

	private final String description;

	private final Status status;

	private final String assignedTo;

	private final Date dueDate;

	private final Date createdAt;

}
