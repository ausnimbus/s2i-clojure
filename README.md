# AusNimbus Builder for Clojure [![Build Status](https://travis-ci.org/ausnimbus/s2i-clojure.svg?branch=master)](https://travis-ci.org/ausnimbus/s2i-clojure) [![Docker Repository on Quay](https://quay.io/repository/ausnimbus/s2i-clojure/status "Docker Repository on Quay")](https://quay.io/repository/ausnimbus/s2i-clojure)

[![Clojure](https://user-images.githubusercontent.com/2239920/27289084-09d5b78e-554c-11e7-853b-719361559a6e.jpg)](https://www.ausnimbus.com.au/)

[AusNimbus](https://www.ausnimbus.com.au/) builder for Clojure provides a fast, secure and reliable [Play Framework](https://www.ausnimbus.com.au/apps/play-framework-hosting/) and [Clojure hosting](https://www.ausnimbus.com.au/languages/java-hosting/) environment.

This document describes the behaviour and environment configuration when running your Clojure apps on AusNimbus.

## Runtime Environments

AusNimbus supports the latest stable Java release.

The currently supported versions are `jdk8`

## Web Process

Your application's web processes must bind to port `8080`.

AusNimbus handles SSL termination at the load balancer.

## Dependency Management

[Leiningen](https://leiningen.org/) is used to build your uberjar.

## Environment Configuration

The following environment variables are available for you to configure your Clojure environment:

NAME        | Description
------------|-------------
JAVA_OPTS   | Options passed to Java. (Default: `-Xmx$((MEMORY_LIMIT * 90 / 100))m`)

## Extending

AusNimbus builders are split into two stages:

- Build
- Runtime

Both stages are completely extensible, allowing you to customize or completely overwrite each stage.

### Build Stage (assemble)

If you want to customize the build stage, you need to add the executable `.s2i/bin/assemble` file in your repository.

This file should contain the logic required to build and install any dependencies your application requires.

If you only want to extend the build stage, you may use this example:

```sh
#!/bin/bash

echo "Logic to include before"

# Run the default builder logic
. /usr/libexec/s2i/assemble

echo "Logic to include after"
```

### Runtime Stage (run)

If you only want to change the executed command for the run stage you may the following environment variable.

NAME        | Description
------------|-------------
APP_RUN     | Define a custom command to start your application.

**NOTE:** `APP_RUN` will overwrite any builder's runtime configuration (including the [Debug Mode](#Debug Mode) section)

Alternatively you may customize or overwrite the entire runtime stage by including the executable file `.s2i/bin/run`

This file should contain the logic required to execute your application.

If you only want to extend the run stage, you may use this example:

```sh
#!/bin/bash

echo "Logic to include before"

# Run the default builder logic
. /usr/libexec/s2i/run
```

As the run script executes every time your application is deployed, scaled or restarted it's recommended to keep avoid including complex logic which may delay the start-up process of your application.

### Persistent Environment Variables

The recommend approach is to set your environment variables in the AusNimbus dashboard.

However it is possible to store environment variables in code using the `.s2i/environment` file.

The file expects a key=value format eg.

```
KEY=VALUE
FOO=BAR
```

## Debug Mode

The AusNimbus builder provides a convenient environment variable to help you debug your application.

NAME        | Description
------------|-------------
DEBUG       | Set to "TRUE" to enable Debug Mode
