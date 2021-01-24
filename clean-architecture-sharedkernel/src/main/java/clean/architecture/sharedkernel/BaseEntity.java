package clean.architecture.sharedkernel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class BaseEntity {

    private final List<BaseDomainEvent> events = new ArrayList<>();
    // This can be modified to BaseEntity<TId> to support multiple key types (e.g. Guid)
    private long id;

}
