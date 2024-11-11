# Springboot Jeka - Simple Demo

This showcase how to build a Spring-Boot application with JeKa with default options.
It also outlines how a building docker and native images can be achieved at no additional cost.

Basic configuration (java+jeka versions) lies in [dependencies.txt](dependencies.txt) while project configuration is 
specified with [Java code](jeka-src/Build.java).

## Popular Build Commands

Create jar
```shell
jeka project: pack
```

Clean and Create a bootable jar.
```shell
jeka project: pack --clean
```

Create bootable jar skipping tests
```shell
jeka project: pack "-Djeka.skip.tests=true" --clean 
```

Run jar
```shell
jeka project: runJar run.programArgs="" run.jvmOptions=""
```

Synchronize IntelliJ
```shell
jeka intellij: iml
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

Show Details about of the Docker Native Image.
```shell
jeka docker: infoNative
```