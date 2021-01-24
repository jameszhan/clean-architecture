package clean.architecture.data;

import lombok.Data;

@Data
public class TodoItemDO {
    private Long id;
    private String title;
    private String description;
    private boolean isDone;
}
