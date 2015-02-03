(defproject
  accomplish
  "0.1.0-SNAPSHOT"
  :description
  "An app to track my accomplishments at Overstock."
  :url
  "http://accomplish.ninja"
  :dependencies
  [[org.clojure/clojurescript "0.0-2644"]
   [prone "0.8.0"]
   [log4j
    "1.2.17"
    :exclusions
    [javax.mail/mail
     javax.jms/jms
     com.sun.jdmk/jmxtools
     com.sun.jmx/jmxri]]
   [selmer "0.7.7"]
   [com.taoensso/tower "3.0.2"]
   [markdown-clj "0.9.58" :exclusions [com.keminglabs/cljx]]
   [im.chit/cronj "1.4.3"]
   [com.taoensso/timbre "3.3.1"]
   [com.h2database/h2 "1.4.182"]
   [noir-exception "0.2.3"]
   [korma "0.4.0"]
   [cljs-ajax "0.3.4"]
   [lib-noir "0.9.5"]
   [org.clojure/clojure "1.6.0"]
   [environ "1.0.0"]
   [ring-server "0.3.1"]
   [reagent-forms "0.2.9"]
   [secretary "1.2.1"]
   [hiccup "1.0.5"]
   [garden "1.2.5"]]
  :repl-options
  {:init-ns accomplish.repl}
  :jvm-opts
  ["-server"]
  :plugins
  [[lein-ring "0.9.0"]
   [lein-environ "1.0.0"]
   [lein-ancient "0.5.5"]
   [lein-cljsbuild "1.0.4"]
   [lein-garden "0.2.5"]
   [hiccup-watch "0.1.1"]
   [hiccup-bridge "1.0.1"]
   ]
  :ring
  {:handler accomplish.handler/app,
   :init accomplish.handler/init,
   :destroy accomplish.handler/destroy,
   :uberwar-name "accomplish.war"}
  :profiles
  {:uberjar
   {:cljsbuild
    {:jar true,
     :builds
     {:app
      {:source-paths ["env/prod/cljs"],
       :compiler {:optimizations :advanced, :pretty-print false}}}},
    :hooks [[leiningen.cljsbuild]
           [leiningen.garden]],
    :omit-source true,
    :env {:production true},
    :aot :all},
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:cljsbuild {:builds {:app {:source-paths ["env/dev/cljs"]}}},
    :dependencies
    [[ring-mock "0.1.5"]
     [ring/ring-devel "1.3.2"]
     [pjstadig/humane-test-output "0.6.0"]],
    :injections
    [(require 'pjstadig.humane-test-output)
     (pjstadig.humane-test-output/activate!)],
    :env {:dev true}}}
  :cljsbuild
  {:builds
   {:app
    {:source-paths ["src/cljs"],
     :compiler
     {:output-dir "resources/public/js/out",
      :externs ["react/externs/react.js"],
      :optimizations :none,
      :output-to "resources/public/js/app.js",
      :source-map "resources/public/js/out.js.map",
      :pretty-print true}}}}

  :garden
  {:builds [{:id "screen"
             :source-paths ["src/styles"]
             :stylesheet accomplish.core/screen
             :compiler {:output-to "resources/public/css/screen.css"
                        :pretty-print? false}}]}
  :hiccup-watch {:input-dir "src/templates" :output-dir "src/templates"}
  :uberjar-name
  "accomplish.jar"
  :min-lein-version "2.0.0")
