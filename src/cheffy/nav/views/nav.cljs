(ns cheffy.nav.views.nav
  (:require [cheffy.nav.views.authenticated :refer [authenticated]]
            [cheffy.nav.views.public :refer [public]] ))

(defn nav []
  (let [user false]
    (if user 
      [authenticated]
      [public])))