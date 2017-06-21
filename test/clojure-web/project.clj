(defproject app "0.0.1-SNAPSHOT"
  :description "Clojure Web App"
  :license {:name "Eclipse Public License v1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.6.0"]
                 [ring/ring-core "1.6.0"]
                 [ring/ring-jetty-adapter "1.6.0"]]
  :main ^:skip-aot app.core
  :ring {:handler app.core/handler
         :main app.core}
  :profiles {:uberjar {:aot :all}})
