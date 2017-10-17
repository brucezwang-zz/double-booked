(ns double-booked.core
  (:import java.util.GregorianCalendar)
  (:gen-class))

(defn before? [d1 d2]
  (. (first d1) compareTo (first d2)))

(defn dateSort [dates]
  (sort before? dates))

(defn overlaps [cur dates]
  (letfn [(overCase [times]
    (cond (empty? times) nil
          (> (. (second cur) compareTo (first (first times))) 0)
              (cons (seq [cur (first times)]) (overCase (rest times)))
          :else nil))]
      (overCase dates)))

(defn allOverlaps [dates]
  (cond (empty? (rest dates)) nil
        :else (concat (overlaps (first dates) (rest dates))
          (allOverlaps (rest dates)))))

(defn intS [str num]
  (Integer/parseInt (nth str num)))

(defn argsToDates [ar]
  (cond
    (< (count ar) 10) nil
    :else (cons (seq [(new GregorianCalendar (intS ar 0) (- (intS ar 1) 1)
                          (intS ar 2) (intS ar 3) (intS ar 4))
                      (new GregorianCalendar (intS ar 5) (- (intS ar 6) 1)
                          (intS ar 7) (intS ar 8) (intS ar 9))])
                (argsToDates (drop 10 ar)))))

(defn -main [& args]
  (let [eventList (dateSort (argsToDates (seq args)))]
      (cond (empty? eventList) (println "No Double Booked Events!")
            :else (println (allOverlaps eventList)))))
