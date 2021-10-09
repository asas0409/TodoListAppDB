package com.todo.dao;

import java.sql.Connection;
import java.util.*;

import com.todo.service.TodoSortByDate;
import com.todo.service.TodoSortByDateReverse;
import com.todo.service.TodoSortByName;

public class TodoList {
	Connection conn;
	
		
	public TodoList() {
		this.conn = DbConnect.getConnection();
	}

	public void addItem(TodoItem t) {
		list.add(t);
	}

	public void deleteItem(TodoItem t) {
		list.remove(t);
	}

	void editItem(TodoItem t, TodoItem updated) {
		int index = list.indexOf(t);
		list.remove(index);
		list.add(updated);
	}

	public ArrayList<TodoItem> getList() {
		return new ArrayList<TodoItem>(list);
	}

	public void sortByName() {
		Collections.sort(list, new TodoSortByName());

	}

	public void listAll() {
		int count = 1;
		System.out.println("[��ü ���, �� " + list.size() + "��]");
		for (TodoItem myitem : list) {
			System.out.println(count + ". " + myitem.toString());
			count++;
		}
	}
	
	public void reverseList() {
		Collections.reverse(list);
	}

	public void sortByDate() {
		Collections.sort(list, new TodoSortByDate());
	}
	
	public void sortByDateReverse(){
		Collections.sort(list, new TodoSortByDateReverse());
	}

	public int indexOf(TodoItem t) {
		return list.indexOf(t);
	}

	public Boolean isDuplicate(String title) {
		for (TodoItem item : list) {
			if (title.equals(item.getTitle())) return true;
		}
		return false;
	}
}
