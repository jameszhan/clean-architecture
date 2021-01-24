package clean.architecture.data;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoItemMapper {

  TodoItemDO getById(long id);

  List<TodoItemDO> list();

  List<TodoItemDO> listUncompleted();

  int add(TodoItemDO entity);

  int update(TodoItemDO entity);

  int delete(Long id);

}
