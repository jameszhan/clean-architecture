package clean.architecture.data;

import clean.architecture.common.Specification;
import clean.architecture.core.entities.TodoItem;
import clean.architecture.core.specifications.IncompleteItemsSpecification;
import clean.architecture.sharedkernel.interfaces.IRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EfRepository implements IRepository<TodoItem> {

    @Autowired
    private TodoItemMapper todoItemMapper;

    @Override
    public TodoItem getById(long id) {
        TodoItemDO todoItemDO = todoItemMapper.getById(id);
        if (todoItemDO != null) {
            TodoItem toDoItem = new TodoItem();
            BeanUtils.copyProperties(todoItemDO, toDoItem);
            return toDoItem;
        } else {
            return null;
        }
    }

    @Override
    public List<TodoItem> list() {
        return todoItemMapper.list().stream().map(this::to).collect(Collectors.toList());
    }

    @Override
    public List<TodoItem> list(Specification spec) {
        if (spec instanceof IncompleteItemsSpecification) {
            return todoItemMapper.listUncompleted().stream().map(this::to).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public TodoItem add(TodoItem entity) {
        TodoItemDO todoItemDO = from(entity);
        int changed = todoItemMapper.add(todoItemDO);
        entity.setId(todoItemDO.getId());
        return entity;
    }

    @Override
    public int update(TodoItem entity) {
        return todoItemMapper.update(from(entity));
    }

    @Override
    public int delete(TodoItem entity) {
        return todoItemMapper.delete(entity.getId());
    }

    private TodoItem to(TodoItemDO todoItemDO) {
        TodoItem toDoItem = new TodoItem();
        BeanUtils.copyProperties(todoItemDO, toDoItem);
        return toDoItem;
    }

    private TodoItemDO from(TodoItem todoItem) {
        TodoItemDO todoItemDO = new TodoItemDO();
        BeanUtils.copyProperties(todoItem, todoItemDO);
        return todoItemDO;
    }

}
