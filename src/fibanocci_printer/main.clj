(ns fibanocci-printer.main
  (:gen-class))
(defn print-usage
  "print the useage of the program to stdout"
  []
  (println "Useage: executable num\n\t num: max value of fibanocci string to print"))



(defn fib
  "fib printer"
  [p1 p2 end] 
       (cond
         (> (+ p1 p2) end) (println "done")
         (= (+ p1 p2) end) (println (+ p1 p2))
         (< (+ p1 p2) end) (do (println (+ p1 p2)) (fib p2 (+ p2 p1) end))
          :else (println "Error: issue had")  ))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (cond
    (<  (count args) 1) (do (println "Error: Did not provide any arguments") (print-usage))
    (>  (count args) 1) (do (println "Error: Provided too many arguments") (print-usage))
    :else
    ;;(println (first args))
    (do (fib 0 1 (Integer/parseInt (first args))))
    ))
