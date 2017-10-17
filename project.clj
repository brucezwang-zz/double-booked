(defproject double-booked "0.1.0"
  :description "A simple program taking in a set of events in the
  form of a start date and end date which returns all pairs of events
  that overlap. Dates use java.util.Calendar"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot double-booked.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
