package ionel.test.zipkin.rabbit.api;

import ionel.test.zipkin.rabbit.dto.EchoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EchoListener {
    private static final Logger LOG = LoggerFactory.getLogger(EchoListener.class);

    @RabbitListener(id = "test-echo", bindings = {
            @QueueBinding(value = @Queue("test-echo-queue"), exchange = @Exchange("X-test"), key = "echo")
    })
    @NewSpan
    public String echo(@Payload EchoRequest echoRequest) {
        LOG.info("Echo start");
        try {
            Thread.sleep(echoRequest.getDelay());
        } catch (InterruptedException e) {
            LOG.error("Interrupted!", e);
            return "Hey, don't interrupt me!";
        }
        LOG.info("Echo end");
        return echoRequest.getMessage();
    }
}
