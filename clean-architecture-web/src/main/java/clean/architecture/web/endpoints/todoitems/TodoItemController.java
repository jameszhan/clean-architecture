package clean.architecture.web.endpoints.todoitems;

import clean.architecture.common.Result;
import clean.architecture.core.entities.TodoItem;
import clean.architecture.core.interfaces.ITodoItemSearchService;
import clean.architecture.sharedkernel.interfaces.IRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "任务相关接口", value = "提供任务相关的Rest API")
public class TodoItemController {

    @Autowired
    private IRepository<TodoItem> repository;

    @Autowired
    private ITodoItemSearchService todoItemSearchService;

    @PostMapping("/todos")
    @ApiOperation(value	= "新增任务接口",	notes = "新增任务")
    public Result<TodoItemResponse> create(NewTodoItemRequest request) {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle(request.getTitle());
        todoItem.setDescription(request.getDescription());
        return Result.success(TodoItemResponse.from(repository.add(todoItem)));
    }

    @RequestMapping(value = "/todos/{id}", method = { RequestMethod.DELETE })
    @ApiOperation(value	= "删除任务接口",	notes = "删除任务")
    public Result<TodoItemResponse> delete(@PathVariable("id") Long id) {
        TodoItem todoItem = repository.getById(id);
        if (todoItem == null) {
            return Result.notFound();
        }
        repository.delete(todoItem);
        return Result.success(TodoItemResponse.from(todoItem));
    }

    @GetMapping(value = "/todos/{id}")
    @ApiOperation(value	= "查找任务接口",	notes = "根据任务id查找任务信息")
    public Result<TodoItemResponse> getById(@PathVariable("id") Long id) {
        TodoItem todoItem = repository.getById(id);
        if (todoItem == null) {
            return Result.notFound();
        }
        return Result.success(TodoItemResponse.from(todoItem));
    }

    @GetMapping(value = "/todos")
    @ApiOperation(value	= "列出所有任务接口",	notes = "列出所有任务信息")
    public Result<List<TodoItemResponse>> list() {
        List<TodoItem> todoItems = repository.list();
        if (todoItems.isEmpty()) {
            return Result.notFound();
        }
        return Result.success(todoItems.stream().map(TodoItemResponse::from).collect(Collectors.toList()));
    }

    @GetMapping(value = "/todos/next")
    @ApiOperation(value	= "列出下个未完成任务",	notes = "列出下个未完成任务")
    public Result<TodoItem> next() {
        return todoItemSearchService.getNextIncompleteItem();
    }

}
