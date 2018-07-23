package intelmas.app.retriever.business.impl;

import java.util.List;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import intelmas.app.retriever.service.TodoService;
import intelmas.app.retriever.service.TodoServiceStub;

public class TodoBusinessImplStubTest {
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, todos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingStub2() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy1");
		assertEquals(2, todos.size());
	}
}
