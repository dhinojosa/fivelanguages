;; Defines an anonymous function
(def my-f (fn [x] (+ x 1)))
(println (my-f 4))

;; Using defn
;;(defn my-f [x] (+ x 1))
;;(println (my-f 4))

;; using the declared function
(println (map my-f [1 2 3 4]))

;; anonymous function
(println (map (fn [x] (+ x 1)) [1 2 3 4]))

;; anonymous function, % is placeholder for first parameter
(println (map #(+ % 1) [1 2 3 4]))

;; anonymous function, %1 is stating the first parameter explicitly
(println (map #(+ %1 1) [1 2 3 4]))

(defn my-f2 [x] (= (mod x 2) 0))

;; using the declared function
(println (filter my-f2 [1 2 3 4]))
;; anonymous function
(println (filter (fn [x] (= (mod x 2) 0)) [1 2 3 4]))
;; anonymous function, % is placeholder for first parameter
(println (filter #(= (mod % 2) 0) [1 2 3 4]))
;; anonymous function, %1 is stating the first parameter explicitly
(println (filter #(= (mod %1 2) 0) [1 2 3 4]))
