(ns cheffy.nav.views.nav
  (:require
   [re-frame.core :as rf]
   [cheffy.nav.views.authenticated :refer [authenticated]]
   [cheffy.nav.views.public :refer [public]]))

(defn nav []
  (let [logged-in? @(rf/subscribe [:logged-in?])]
    (if logged-in? 
      [authenticated]
      [public])))