(ns gof-in-clojure.rest-test
  (:require [clojure.test :refer :all]
            [gof-in-clojure.rest :refer :all]))

(deftest test-base-case
  (testing "The cartesian product of 0 lists ought to be the empty list."
    (is (= '(())  (cartesian-product '())))))

(deftest test-single-vector
  (testing "The cartesian product of 1 lists ought to be itself decomposed."
    (is (= '((0) (1) (2) (3) (4))  (cartesian-product `(~(range 5)))))))

(deftest test-two-vectors
  (testing "The cartesian product of 2 lists ought to be a grid."
    (is (= '((0 0) (0 1) (0 2) (1 0) (1 1) (1 2))  (cartesian-product `(~(range 2) ~(range 3)))))))

(deftest test-three-vectors
  (testing "The cartesian product of 3 lists ought to be a parallelopiped.")
  (is (= '((0 0 0) (0 0 1) (0 0 2) (0 1 0) (0 1 1) (0 1 2) (1 0 0) (1 0 1) (1 0 2) (1 1 0) (1 1 1) (1 1 2))
         (cartesian-product `(~(range 2) ~(range 2) ~(range 3))))))


