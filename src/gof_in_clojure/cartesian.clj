(ns gof-in-clojure.cartesian)

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