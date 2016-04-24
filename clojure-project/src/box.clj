(defprotocol Functor
  (mapf [item f]))

(defrecord Box [value]
  Functor
  (mapf [this f] (f (get this :value))))

(def box (Box. 14))
(prn (mapf box #(* % 2)))
