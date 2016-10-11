(ns gof-in-clojure.DesignPatternsGofFlashcardGeneration)

(declare cartesian-product)
(defn cartesian-product-on-nonempty-list [multiplicands]
      (for [firstElement (first multiplicands)
            remainingElements (cartesian-product (rest multiplicands))]
           (cons firstElement remainingElements)))

(defn cartesian-product [multiplicands]
      (if (empty? multiplicands)
        '(())                                               ;; base case is list-of-lists b/c 1 way to cross-product 0 lists
        (cartesian-product-on-nonempty-list multiplicands)
        )
      )

(def causesOfRedesign {:explicitClass              "Creating objects by specifying a class explicitly"
                       :specificOperation          "Dependence on specific operations"
                       :hardwareSoftwarePlatform   "Dependence on hardware/software platform"
                       :objectRepresentations      "Dependence on object representations/implementations"
                       :algorithmic                "Algorithmic dependencies"
                       :tightCoupling              "Tight coupling"
                       :functionalityBySubclassing "Extending functionality by subclassing"
                       :inconvenientToAlter        "Inability to alter classes conveniently"})
(def patterns '{:AbstractFactory       "Abstract Factory"
                :Builder               "Builder"
                :FactoryMethod         "Factory Method"
                :Prototype             "Prototype"
                :Singleton             "Singleton"
                :Adapter               "Adapter"
                :Bridge                "Bridge"
                :Composite             "Composite"
                :Decorator             "Decorator"
                :Facade                "Facade"
                :Flyweight             "Flyweight"
                :Proxy                 "Proxy"
                :ChainOfResponsibility "Chain of Responsibility"
                :Command               "Command"
                :Interpreter           "Interpreter"
                :Iterator              "Iterator"
                :Mediator              "Mediator"
                :Memento               "Memento"
                :Observer              "Observer"
                :State                 "State"
                :Strategy              "Strategy"
                :TemplateMethod        "Template Method"
                :Visitor               "Visitor"})

(def remedies #{'(:explicitClass :AbstractFactory)
                '(:explicitClass :FactoryMethod)
                '(:explicitClass :Prototype)
                '(:specificOperation :ChainOfResponsibility)
                '(:specificOperation :Command)
                '(:hardwareSoftwarePlatform :AbstractFactory)
                '(:hardwareSoftwarePlatform :Bridge)
                '(:objectRepresentations :AbstractFactory)
                '(:objectRepresentations :Bridge)
                '(:objectRepresentations :Proxy)
                '(:objectRepresentations :Memento)
                '(:algorithmic :Builder)
                '(:algorithmic :Iterator)
                '(:algorithmic :Strategy)
                '(:algorithmic :TemplateMethod)
                '(:algorithmic :Visitor)
                '(:tightCoupling :AbstractFactory)
                '(:tightCoupling :Bridge)
                '(:tightCoupling :Facade)
                '(:tightCoupling :ChainOfResponsibility)
                '(:tightCoupling :Command)
                '(:tightCoupling :Mediator)
                '(:tightCoupling :Observer)
                '(:functionalityBySubclassing :Bridge)
                '(:functionalityBySubclassing :Composite)
                '(:functionalityBySubclassing :Decorator)
                '(:functionalityBySubclassing :ChainOfResponsibility)
                '(:functionalityBySubclassing :Observer)
                '(:functionalityBySubclassing :Strategy)
                '(:inconvenientToAlter :Adapter)
                '(:inconvenientToAlter :Decorator)
                '(:inconvenientToAlter :Visitor)})

(defn is-pattern-remedy-to-cause-of-redesign? [pattern causeOfRedesign]
      (contains? remedies (cons causeOfRedesign (cons pattern '()))))

(defn cause-of-redesign-pattern-remedy-matrix-as-string-list
  []
  (map (fn [causeOfRedesignPatternPair]
         (str "True/false: the "
              ((first (rest causeOfRedesignPatternPair)) patterns)
              " pattern is a remedy to this cause of redesign: "
              ((first causeOfRedesignPatternPair) causesOfRedesign)
              ". {{c1::"                                    ;; formatting is for import to flashcard software Anki, tab-delimited cloze
              (is-pattern-remedy-to-cause-of-redesign? (first (rest causeOfRedesignPatternPair)) (first causeOfRedesignPatternPair))
              "}}")
         )
       (cartesian-product (cons (keys causesOfRedesign) (cons (keys patterns) '()))))
  )

