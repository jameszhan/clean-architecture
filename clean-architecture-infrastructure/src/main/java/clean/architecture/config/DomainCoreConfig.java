package clean.architecture.config;

import clean.architecture.core.interfaces.ITodoItemSearchService;
import clean.architecture.core.services.TodoItemSearchService;
import clean.architecture.data.EfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainCoreConfig {

    @Autowired
    private EfRepository repository;

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean(ITodoItemSearchService.class)
    public TodoItemSearchService buildTodoItemSearchService() {
        return new TodoItemSearchService(repository);
    }

}