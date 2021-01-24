package clean.architecture.sharedkernel;

import clean.architecture.sharedkernel.interfaces.INotification;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

public abstract class BaseDomainEvent implements INotification {

    @Getter
    @Setter
    private Date dateOccurred = Calendar.getInstance().getTime();

}
