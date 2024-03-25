package jp.co.internous.todolist.model.form;

import java.io.Serializable;

public class AddTodoListForm implements Serializable {

	private String todo;
	
	private String deadline;
	
	private int userId;

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
