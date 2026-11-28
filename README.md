# Springboot JeKa - Simple Demo

This shows how to build a Spring Boot application with JeKa, with default options, and how to create Docker
and native images with no extra configuration.

The build needs no Java code: the configuration lies in [jeka.project.deps](jeka.project.deps)
and [jeka.properties](jeka.properties). The [code-config](https://github.com/jeka-dev/demo-springboot-simple/tree/code-config)
branch shows the same build configured with Java code.

## Prerequisites

- [JeKa installed](https://jeka-dev.github.io/jeka/installation/). JeKa downloads the JDK it needs.
- Docker, for the Docker images. The native image is compiled inside Docker: you don't need GraalVM.

## Popular build commands

Run the tests and create the bootable jar in `jeka-output/`:
```shell
jeka test pack
```

Create the bootable jar only, after cleaning the output:
```shell
jeka pack --clean
```

Run the jar, then open http://localhost:8080 (it answers `Hello World`):
```shell
jeka runJar run.programArgs="" run.jvmOptions=""
```

Synchronize IntelliJ:
```shell
jeka intellij: sync
```

### Docker JVM

Create a Docker image of the Spring Boot application:
```shell
jeka docker: build
```

Show details about the Docker image:
```shell
jeka docker: info
```

### Docker native

Create a Docker image containing the native executable of the application (smaller and faster):
```shell
jeka docker: buildNative
```

Create a minimalist native Docker image:
```shell
jeka docker: buildNative nativeBaseImage=gcr.io/distroless/static-debian13:nonroot native: staticLink=MUSL
```

Run the image, then open http://localhost:8080:
```shell
docker run --rm -p 8080:8080 native-demo-springboot-simple:latest
```

Show details about the native Docker image:
```shell
jeka docker: infoNative
```

## How it works

- [jeka.properties](jeka.properties): JeKa and Java versions, `project` as default KBean (so `jeka pack` means
  `jeka project: pack`), and the `springboot` plugin, loaded with `jeka.classpath` and activated with `@springboot=`.
  The plugin creates the bootable jar and configures the Docker and native builds for Spring Boot.
- [jeka.project.deps](jeka.project.deps): the Spring Boot BOM in `[version]`, so starters need no version.

## Links

- [Build projects](https://jeka-dev.github.io/jeka/tutorials/build-projects/)
- [Spring Boot plugin](https://github.com/jeka-dev/jeka/tree/master/plugins/plugins.springboot)
- [docker KBean](https://jeka-dev.github.io/jeka/reference/kbeans-docker/) and
  [native KBean](https://jeka-dev.github.io/jeka/reference/kbeans-native/)
