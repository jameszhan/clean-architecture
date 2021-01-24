package clean.architecture.core.services;

import clean.architecture.common.Result;
import clean.architecture.common.Specification;
import clean.architecture.common.ValidationError;
import clean.architecture.common.ValidationSeverity;
import clean.architecture.core.entities.TodoItem;
import clean.architecture.core.interfaces.ITodoItemSearchService;
import clean.architecture.core.specifications.IncompleteItemsSpecification;
import clean.architecture.sharedkernel.interfaces.IRepository;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class TodoItemSearchService implements ITodoItemSearchService {

    private final IRepository<TodoItem> repository;

    public TodoItemSearchService(IRepository<TodoItem> repository) {
        this.repository = repository;
    }

    public void init() {
        log.info("TodoItemSearchService initialized!");
    }

    public Result<TodoItem> getNextIncompleteItem() {
        Specification incompleteSpec = new IncompleteItemsSpecification();
        try {
            List<TodoItem> items = repository.list(incompleteSpec);
            if (items.isEmpty()) {
                return Result.notFound();
            } else {
                return Result.success(items.get(0));
            }
        } catch (Exception ex) {
            log.error("getNextIncompleteItemAsync() encounter error.", ex);
            return Result.error(Collections.singletonList(ex.getMessage()));
        }
    }

    public Result<List<TodoItem>> getAllIncompleteItems(String searchString) {
        if (Strings.isNullOrEmpty(searchString)) {
            List<ValidationError> errors = new ArrayList<>();
            errors.add(new ValidationError("searchString", "searchString is required.", ValidationSeverity.Warning));
            return Result.invalid(errors);
        }

        Specification incompleteSpec = new IncompleteItemsSpecification();
        try {
            List<TodoItem> items = repository.list(incompleteSpec);
            return new Result<>(items);
        } catch (Exception ex) {
            log.error("getAllIncompleteItemsAsync({}) encounter error.", searchString, ex);
            return Result.error(Collections.singletonList(ex.getMessage()));
        }
    }


}
