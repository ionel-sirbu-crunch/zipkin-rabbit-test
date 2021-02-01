package ionel.test.zipkin.rabbit.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class EchoRequest {
    private final String message;
    private final int delay;

    @JsonCreator
    public EchoRequest(String message, int delay) {
        this.message = message;
        this.delay = delay;
    }

    public String getMessage() {
        return message;
    }

    public int getDelay() {
        return delay;
    }

    @Override
    public String toString() {
        return "EchoRequest{" +
                "message='" + message + '\'' +
                ", delay=" + delay +
                '}';
    }
}
