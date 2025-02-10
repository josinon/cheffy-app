(ns cheffy.auth.views.sign-up
  (:require [reagent.core :as r]
            [cheffy.components.page-nav :refer [page-nav]]
            ["@smooth-ui/core-sc" :refer [Row Col FormGroup Label Input Box Button]]
            [cheffy.components.form-group :refer [form-group]]
            [re-frame.core :as rf]))

(defn sign-up []
  (let [initial-values {:first-name "" :last-name "" :email "" :password ""}
        values (r/atom initial-values)]
    (fn []
      [:> Row {:justify-content "center"}
       [:> Col {:xs 12 :sm 6}
        [page-nav {:center "Sign up"}]

        [form-group {:id :first-name
                     :label "First Name"
                     :type "text"
                     :values values}]
        
        [form-group {:id :last-name
                     :label "Last Name"
                     :type "text"
                     :values values}]
        
        [form-group {:id :email
                     :label "Email"
                     :type "email"
                     :values values}]

        [form-group {:id :password
                     :label "Password"
                     :type "password"
                     :values values}]

        [:> Box {:display "flex"
                 :justify-content "space-between"}
         [:> Box {:py 1
                  :pr 2}
          [:a {:href "#log-in"
               :on-click #(rf/dispatch [:set-active-nav :log-in])}
           "Already have an account? Log in !"]]
         [:> Box
          [:> Button {:on-click #(rf/dispatch [:sign-up @values])}
           "Sign up"]]]]])))
  


  