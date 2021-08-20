package edu.eci.co.integrationproject.data;

import java.util.Date;

import edu.eci.co.integrationproject.share.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	private String id;

	private String name;

	private String description;

	private Status status;

	private String assignedTo;

	private Date dueDate;

	private Date createdAt;

}
