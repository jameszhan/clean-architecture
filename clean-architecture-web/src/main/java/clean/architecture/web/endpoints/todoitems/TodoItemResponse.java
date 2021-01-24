package clean.architecture.web.endpoints.todoitems;

import clean.architecture.core.entities.TodoItem;
import lombok.Data;

@Data
public class TodoItemResponse {

    private Long id;
    private String title;
    private String description;
    private boolean isDone;

    public static TodoItemResponse from(TodoItem todoItem) {
        TodoItemResponse response = new TodoItemResponse();
        response.setId(todoItem.getId());
        response.setTitle(todoItem.getTitle());
        response.setDescription(todoItem.getDescription());
        response.setDone(todoItem.isDone());
        return response;
    }

}
