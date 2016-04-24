;; Lists (not typical):

(def my-list '(1 2 3 4 5))
(conj my-list 6) ;; placed in the beginning


;;Vectors (Preferred over lists):

(def my-vector [1 2 3 4])
(def my-vector-2 (vector 1 2 3 4))
(conj my-vector 5) ;; placed at the end
(some #{4} my-vector) ;; does my-vector contain item, a bit weird
                      ;; that's because strong possibility you need 
                      ;; a set!
;;Sets:
(def my-set (set [1 2 3 4]))
(def my-set-2 #{1 2 3 4})
(conj my-set 5)
(contains? my-set 4)

;;Maps:

;; :One, :Two, and :Three are Clojure Keywords
;; much like Ruby Symbols and Scala Symbols

(def my-map {1 :One 2 :Two 3 :Three}); :before are keywords
(assoc my-map 4 :Four) ;Add an item to the map
(contains? my-map 3)
(my-map 2) ;Retreive by key
