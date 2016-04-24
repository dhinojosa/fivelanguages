
(require '[clojure.test.generative :as test-gen])
(require '[clojure.data.generators :as gen])

(test-gen/defspec integers-closed-over-addition
  (fn [a b] (+' a b))                   ;; input fn
  [^gen/long a ^gen/long b]             ;; input spec
  (assert (integer? %)))                ;; 0 or more validator forms

