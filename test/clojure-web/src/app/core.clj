(ns app.core
  (:gen-class)
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]))

(defroutes app
  (ANY "*" []
       (slurp (io/resource "index.html"))))

(defn -main []
  (jetty/run-jetty (site #'app) {:port 8080}))
