# zipkin-rabbit-test
A test for trying to prove missing zipkin traces for timed-out RabbitMq requests.

---

### Prerequisites

A RabbitMq broker & a Zipkin collector are required. Both can be started via the provided `docker-compose.yml` file,
e.g. by running this in the root of the project:
```shell
docker-compose up -d
```

### Execution

This is a maven project, so it can be run with:
```shell
mvn clean spring-boot:run
```
Alternatively, it can be loaded & run from an IDE (e.g. IntelliJ IDEA).

Once the app is running, test with:
```shell
curl --location --request POST 'localhost:8080/test/echo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message": "hello there",
    "delay": 1000
}'
```
And to force a `Reply received after timeout` scenario, increase the value of `delay` to something like 10000.
It can be noted in the generated logs that tracing information is missing for those messages.