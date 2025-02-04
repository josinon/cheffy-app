(ns cheffy.views
  (:require
   [re-frame.core :as re-frame]
   [cheffy.events :as events]
   [cheffy.routes :as routes]
   [cheffy.subs :as subs]
   [cheffy.theme :refer [cheffy-theme]]
   [cheffy.nav.views.nav :refer [nav]]
   [cheffy.become-a-chef.views.become-a-chef :refer [become-a-chef]]
   [cheffy.auth.views.profile :refer [profile]]
   [cheffy.inbox.views.inboxes :refer [inboxes]]
   [cheffy.recipes.views.recipes :refer [recipes]] 
   [cheffy.auth.views.login :refer [login]]
   [cheffy.auth.views.sign-up :refer [sign-up]]
   ["@smooth-ui/core-sc" :refer [Normalize Grid Row Col ThemeProvider]]))

;; home

(defn pages 
  [page-name]
  (case page-name
    :profile [profile]
    :become-a-chef [become-a-chef]
    :inboxes [inboxes]
    :recipes [recipes]
    :login [login]
    :sign-up [sign-up]
    [recipes]))

(defn home-panel []
  (let [active-nav @(re-frame/subscribe [:active-nav]) ]
    [:<>
     [:> Normalize]
     [:> ThemeProvider {:theme cheffy-theme}
      [:> Grid { :fluid false }
       [:> Row 
        [:> Col
         [nav]
         [pages active-nav]]]]
      ]]))

(defmethod routes/panels :home-panel [] [home-panel])

;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:on-click #(re-frame/dispatch [::events/navigate :home])}
     "go to Home Page"]]])

(defmethod routes/panels :about-panel [] [about-panel])

;; main

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    (routes/panels @active-panel)))
