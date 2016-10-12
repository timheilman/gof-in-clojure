(ns gof-in-clojure.format-gof-data)
(use 'gof-in-clojure.gof-data)
(use 'gof-in-clojure.cartesian)

(defn cause-of-redesign-pattern-remedy-matrix-as-string-list
  []
  (map (fn [causeOfRedesignPatternPair]
         (str "True/false: the "
              ((first (rest causeOfRedesignPatternPair)) patterns)
              " pattern is a remedy to this cause of redesign: "
              ((first causeOfRedesignPatternPair) causesOfRedesign)
              ". {{c1::"                                    ;; import formatting to software "Anki", tab-delimited cloze
              (is-pattern-remedy-to-cause-of-redesign? (first (rest causeOfRedesignPatternPair))
                                                       (first causeOfRedesignPatternPair))
              "}}")
         )
       (cartesian-product (cons (keys causesOfRedesign) (cons (keys patterns) '()))))
  )

