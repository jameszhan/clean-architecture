package clean.architecture.core.entities;

import clean.architecture.sharedkernel.BaseEntity;
import clean.architecture.sharedkernel.interfaces.IAggregateRoot;
import lombok.Data;

@Data
public class TodoItem extends BaseEntity implements IAggregateRoot {

    private String title;
    private String description;
    private boolean isDone;

}
