package ionel.test.zipkin.rabbit.api;

import ionel.test.zipkin.rabbit.dto.EchoRequest;
import ionel.test.zipkin.rabbit.service.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
    private static final Logger LOG = LoggerFactory.getLogger(RestApi.class);

    private final EchoService echoService;

    public RestApi(EchoService echoService) {
        this.echoService = echoService;
    }

    @PostMapping("/echo")
    public String echo(@RequestBody EchoRequest echoRequest) {
        LOG.info("Echo start ({})", echoRequest);
        String response = echoService.echo(echoRequest);
        LOG.info("Echo end ({}) -> {}", echoRequest, response);
        return response;
    }

}
