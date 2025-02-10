(ns cheffy.auth.views.login
  (:require [reagent.core :as r]
            [cheffy.components.page-nav :refer [page-nav]]
            ["@smooth-ui/core-sc" :refer [Row Col FormGroup Label Input Box Button]]
            [cheffy.components.form-group :refer [form-group]]
            [re-frame.core :as rf]))

(defn login []
  (let [initial-values {:email "" :password ""}
        values (r/atom initial-values)]
    (fn []
      [:> Row {:justify-content "center"}
       [:> Col {:xs 12 :sm 6}
        [page-nav {:center "In Log"}]
        
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
         [:> Box { :py 1
                  :pr 2}
          [:a {:href "#sign-up"
               :on-click #(rf/dispatch [:set-active-nav :sign-up])}
           "New to cheffy? Create an account!"]]
         [:> Box 
          [:> Button {:on-click #(rf/dispatch [:log-in @values])}
           "Log in"]]
         ]]])))
  


  