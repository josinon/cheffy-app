(ns cheffy.inbox.views.inboxes
  (:require [cheffy.components.page-nav :refer [page-nav]]))

(defn inboxes []
  [page-nav {:center  "Inboxes"}])