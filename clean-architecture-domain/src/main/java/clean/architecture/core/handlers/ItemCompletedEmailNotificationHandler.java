package clean.architecture.core.handlers;

import clean.architecture.core.events.ToDoItemCompletedEvent;
import clean.architecture.sharedkernel.interfaces.INotification;

public class ItemCompletedEmailNotificationHandler implements INotification<ToDoItemCompletedEvent> {
}
