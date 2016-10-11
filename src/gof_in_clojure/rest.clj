(ns gof-in-clojure.rest)
(use 'gof-in-clojure.data)

(declare cartesian-product)
(defn cartesian-product-on-nonempty-list [multiplicands]
  (for [firstElement (first multiplicands)
        remainingElements (cartesian-product (rest multiplicands))]
    (cons firstElement remainingElements)))

(defn cartesian-product [multiplicands]
  (if (empty? multiplicands)
    '(())                                                   ;; basecase list-of-lists b/c 1 way to cross-product 0 lists
    (cartesian-product-on-nonempty-list multiplicands)
    )
  )


(defn is-pattern-remedy-to-cause-of-redesign? [pattern causeOfRedesign]
  (contains? remedies (cons causeOfRedesign (cons pattern '()))))

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

