package clean.architecture.sharedkernel.interfaces;

import clean.architecture.common.Specification;
import clean.architecture.sharedkernel.BaseEntity;

import java.util.List;

public interface IRepository<T extends BaseEntity> {

    T getById(long id);

    List<T> list();

    List<T> list(Specification spec);

    T add(T entity);

    int update(T entity);

    int delete(T entity);

}
