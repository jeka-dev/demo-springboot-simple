# Springboot JeKa - Simple Demo, configured with Java code

This shows how to build a Spring Boot application with JeKa, configuring the build with Java code instead of
properties, and how to create Docker and native images with no extra configuration.

The [main](https://github.com/jeka-dev/demo-springboot-simple) branch shows the same build configured with
properties only.

## Prerequisites

- [JeKa installed](https://jeka-dev.github.io/jeka/installation/). JeKa downloads the JDK it needs.
- Docker, for the Docker images. The native image is compiled inside Docker: you don't need GraalVM.

## Popular build commands

Run the tests and create the bootable jar in `jeka-output/`:
```shell
jeka project: test pack
```

Create the bootable jar only, after cleaning the output:
```shell
jeka project: pack --clean
```

Run the jar, then open http://localhost:8080 (it answers `Hello World`):
```shell
jeka project: runJar run.programArgs="" run.jvmOptions=""
```

Generate the IntelliJ module file:
```shell
jeka intellij: iml
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

Show details about the native Docker image:
```shell
jeka docker: infoNative
```

## How it works

- [jeka.properties](jeka.properties): JeKa and Java versions, `project` as default KBean, and `@build=on`, which makes
  JeKa initialize the `Build` KBean of *jeka-src*. Without it, only the default KBean and the KBeans it requires are
  initialized.
- [jeka-src/Build.java](jeka-src/Build.java): `@JkDep` adds the `springboot` plugin to the build classpath. The
  `@JkPostInit` methods add the dependencies to the project, and activate the `springboot` KBean
  (`required = true`), which creates the bootable jar and configures the Docker and native builds.

## Links

- [KBeans](https://jeka-dev.github.io/jeka/reference/kbeans/)
- [Build projects](https://jeka-dev.github.io/jeka/tutorials/build-projects/)
- [Spring Boot plugin](https://github.com/jeka-dev/jeka/tree/master/plugins/plugins.springboot)
- [docker KBean](https://jeka-dev.github.io/jeka/reference/kbeans-docker/)
