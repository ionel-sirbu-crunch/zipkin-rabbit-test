package ionel.test.zipkin.rabbit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.stereotype.Component;

@Component("leh")
public class LEH implements RabbitListenerErrorHandler {

    public LEH() {
        LOG.info("LEH initialised!");
    }

    private static final Logger LOG = LoggerFactory.getLogger(LEH.class);

    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) throws Exception {
        LOG.info("ionel debug");
        throw exception;
    }

}