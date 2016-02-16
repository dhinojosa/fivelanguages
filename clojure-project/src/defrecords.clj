
(defprotocol Functor
  (mapf [item f])
  )

(defrecord Box [value]
  Functor
  (mapf [this f] (Box. (f (get this :value)))))

(def box (Box. 30))

(prn box)

(prn (mapf box #(* % 2)))
