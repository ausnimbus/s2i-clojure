# AusNimbus Builder for Clojure [![Build Status](https://travis-ci.org/ausnimbus/s2i-clojure.svg?branch=master)](https://travis-ci.org/ausnimbus/s2i-clojure) [![Docker Repository on Quay](https://quay.io/repository/ausnimbus/s2i-clojure/status "Docker Repository on Quay")](https://quay.io/repository/ausnimbus/s2i-clojure)

[![Clojure](https://user-images.githubusercontent.com/2239920/27289084-09d5b78e-554c-11e7-853b-719361559a6e.jpg)](https://www.ausnimbus.com.au/)

[AusNimbus](https://www.ausnimbus.com.au/) builder for Clojure provides a fast, secure and reliable [Play Framework](https://www.ausnimbus.com.au/apps/play-framework-hosting/) and [Clojure hosting](https://www.ausnimbus.com.au/languages/java-hosting/) environment.

It uses [Leiningen](https://leiningen.org/) to build your uberjar.

Web processes must bind to port `8080`, and only the HTTP protocol is permitted for incoming connections.

## Environment Variables

The following environment variables are made available:

* **JAVA_OPTS**
  * Options passed to Java
  * Default: `-Xmx$((MEMORY_LIMIT * 90 / 100))m`

# Versions

- 2.7.1 (lein)
