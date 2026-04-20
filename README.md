# lbc-interview

Code interview for "LBC".

## Requirements

- Java 24 (temurin-24.0.2)
- Gradle 9.4.1 (gradlew)

## Getting Started

1. Build a fat JAR with `./gradlew bootJar`
2. In your terminal window, run `java -jar build/libs/interview-0.0.1-SNAPSHOT.jar`
3. Run a curl request to
   `curl  http://localhost:8080/fizzbuzz\?int1\=3\&int2\=5\&limit\=1000000\&str1\=Ilove\&str2\=lbc`

## API

Run a fizz buzz computation:

```sh
curl http://localhost:8080/fizzbuzz\?int1\=3\&int2\=6\&limit\=1000\&str1\=Ilove\&str2\=lbc
```

Get statistics on the most frequently used request:

```sh
curl http://localhost:8080/fizzbuzz/statistics
```

## Demo

In the following video shows a sequence were we run 1,000,000 fizzbuzz computations. See that the memory pressure is
low, as we are streaming the response. The CPU runs a bit hot. We could throttle the CPU consumption, but as this is
just an interview, I left it as is.

https://github.com/user-attachments/assets/e9b7448c-75f0-4314-9a8a-fbfd827906b1

