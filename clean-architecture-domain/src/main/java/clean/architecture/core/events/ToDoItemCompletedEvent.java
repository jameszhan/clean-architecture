package clean.architecture.core.events;

import clean.architecture.core.entities.TodoItem;
import clean.architecture.sharedkernel.BaseDomainEvent;
import lombok.Getter;

public class ToDoItemCompletedEvent extends BaseDomainEvent {

    @Getter
    private final TodoItem completedItem;

    public ToDoItemCompletedEvent(TodoItem completedItem) {
        this.completedItem = completedItem;
    }

}
