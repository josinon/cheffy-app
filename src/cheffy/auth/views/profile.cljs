(ns cheffy.auth.views.profile
  (:require [cheffy.components.page-nav :refer [page-nav]]))

(defn profile []
  [page-nav {:center "Profile"}])