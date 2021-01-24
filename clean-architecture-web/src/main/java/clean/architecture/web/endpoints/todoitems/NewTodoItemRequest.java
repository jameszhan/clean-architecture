package clean.architecture.web.endpoints.todoitems;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NewTodoItemRequest {

    @NotNull
    private String title;
    private String description;

}
