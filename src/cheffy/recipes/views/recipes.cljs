(ns cheffy.recipes.views.recipes
  (:require [cheffy.components.page-nav :refer [page-nav]]))

(defn recipes []
  [page-nav {:center  "Recipes"}])