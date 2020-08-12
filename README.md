# tracing-sample project

This project uses Quarkus 1.7 to demonstrate different behavior for tracing in JVM vs. Native mode

## Running the application

Terminal #1
```
docker run -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 jaegertracing/all-in-one:latest
```

Terminal #2
```
git clone https://github.com/rsvoboda/tracing-sample.git
cd tracing-sample

sdk use java 20.1.0.r11-grl && export GRAALVM_HOME=$JAVA_HOME
mvn verify -Dnative
```

## View the traces
Open http://localhost:16686/ and Find traces for `test-traced-service` service