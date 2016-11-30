(defproject easy-button "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.pi4j/pi4j-core "1.1"]]

  :uberjar-name "easy-button.jar"

  :main easy-button.core

  :profiles {:uberjar {:aot :all}}
  )
