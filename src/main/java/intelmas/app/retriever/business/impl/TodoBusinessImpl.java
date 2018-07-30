package intelmas.app.retriever.business.impl;

import java.util.ArrayList;
import java.util.List;

import intelmas.app.retriever.service.TodoService;

public class TodoBusinessImpl {
	
	private TodoService todoService;

	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		allTodos.stream().forEach(todo->{
			if(todo ==null)
				return;
			if(todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		});
		
		
//		for (String todo : allTodos) {
//			if (todo.contains("Spring")) {
//				filteredTodos.add(todo);
//			}
//		}
		return filteredTodos;
	}
	
	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}

}
