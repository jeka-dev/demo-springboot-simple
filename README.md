# Springboot Jeka - Simple Demo

This showcase how to build a Spring-Boot application with JeKa with default options.
It also outlines how a building docker and native images can be achieved at no additional cost.

We don't need Java code to configure the build : all configuration lies in [dependencies.txt](dependencies.txt) 
and [jeka.properties](jeka.properties).

## Popular Build Commands

Create jar:
```shell
jeka pack
```

Clean and Create a bootable jar:
```shell
jeka pack --clean
```

Create bootable jar skipping tests:
```shell
jeka pack "-Djeka.skip.tests=true" --clean 
```

Run jar
```shell
jeka runJar run.programArgs="" run.jvmOptions=""
```

Synchronize IntelliJ
```shell
jeka intellij: sync
```

### Docker JVM

The following commands requires a Docker cli (such as Docker Desktop) on the host.

Create a Docker Image of the Spring-Boot Application.
```shell
jeka docker: build
```

Show Details about of the Docker Image.
```shell
jeka docker: info
```

### Docker Native

Native compilation does not have any requisite.

Create a Docker Image containing the Native Executable of the Application (smaller and faster).
```shell
jeka docker: buildNative
```

Create a minimalist native Docker Image:
```shell
jeka docker: buildNative nativeBaseImage=gcr.io/distroless/static-debian12:nonroot native: staticLink=MUSL
```

Execute the Docker Image:
```shell
docker run --rm -p 8080:8080 native-demo-springboot-simple:latest
```

Show Details about of the Docker Native Image:
```shell
jeka docker: infoNative
```
