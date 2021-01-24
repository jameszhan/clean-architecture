package clean.architecture.core.interfaces;

import java.util.concurrent.Future;

public interface IMessageSender<T> {

    Future<T> sendMessageAsync(String topic, String subject, String body);

}
