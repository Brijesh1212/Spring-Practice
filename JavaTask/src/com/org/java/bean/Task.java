package com.org.java.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Date taskDate;
	
	@Column
    private Date startTime;
	
	@Column
	private Date endTime;
	
	@Column
	private String objectiveOfTheTask;
	
	private String status;
	
	public Task() {
		super();
	}

	public Task(Date taskDate, Date startTime, Date endTime, String objectiveOfTheTask,String status) {
		super();
		this.taskDate = taskDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.objectiveOfTheTask = objectiveOfTheTask;
		this.status=status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getObjectiveOfTheTask() {
		return objectiveOfTheTask;
	}

	public void setObjectiveOfTheTask(String objectiveOfTheTask) {
		this.objectiveOfTheTask = objectiveOfTheTask;
	}

}
