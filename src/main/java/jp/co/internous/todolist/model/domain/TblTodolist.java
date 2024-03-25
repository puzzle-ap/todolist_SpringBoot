package jp.co.internous.todolist.model.domain;

import java.sql.Timestamp;

public class TblTodolist {

	private int id;
	
	private int userId;
	
	private String todo;
	
	private Timestamp deadline;
	
	private byte completed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public byte getCompleted() {
		return completed;
	}

	public void setCompleted(byte completed) {
		this.completed = completed;
	}
	
}
