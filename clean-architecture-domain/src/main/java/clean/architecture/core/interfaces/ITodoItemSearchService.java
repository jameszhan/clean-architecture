package clean.architecture.core.interfaces;

import clean.architecture.common.Result;
import clean.architecture.core.entities.TodoItem;

import java.util.List;

public interface ITodoItemSearchService {

    Result<TodoItem> getNextIncompleteItem();

    Result<List<TodoItem>> getAllIncompleteItems(String searchString);

}
