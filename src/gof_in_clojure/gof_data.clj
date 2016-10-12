(ns gof-in-clojure.gof-data)
(def causesOfRedesign {:explicitClass              "Creating objects by specifying a class explicitly"
                       :specificOperation          "Dependence on specific operations"
                       :hardwareSoftwarePlatform   "Dependence on hardware/software platform"
                       :objectRepresentations      "Dependence on object representations/implementations"
                       :algorithmic                "Algorithmic dependencies"
                       :tightCoupling              "Tight coupling"
                       :functionalityBySubclassing "Extending functionality by subclassing"
                       :inconvenientToAlter        "Inability to alter classes conveniently"})
(def patterns {:AbstractFactory        "Abstract Factory"
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

;; todo: resolve question as to OO/procedural attachment of function to data here
(defn is-pattern-remedy-to-cause-of-redesign? [pattern causeOfRedesign]
  (contains? remedies (cons causeOfRedesign (cons pattern '()))))