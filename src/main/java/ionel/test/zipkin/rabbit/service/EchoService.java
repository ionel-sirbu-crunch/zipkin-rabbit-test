package ionel.test.zipkin.rabbit.service;

import ionel.test.zipkin.rabbit.dto.EchoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class EchoService {
    private static final Logger LOG = LoggerFactory.getLogger(EchoService.class);

    private final RabbitTemplate rabbitTemplate;
    private final MessageConverter messageConverter;

    public EchoService(RabbitTemplate rabbitTemplate, MessageConverter messageConverter) {
        this.rabbitTemplate = rabbitTemplate;
        this.messageConverter = messageConverter;
    }

    public String echo(EchoRequest echoRequest) {
        Message message = messageConverter.toMessage(echoRequest, new MessageProperties());
        Message response = rabbitTemplate.sendAndReceive("X-test", "echo", message);

        if (response != null) {
            return (String) messageConverter.fromMessage(response);
        }
        return "Silence...";
    }
}
