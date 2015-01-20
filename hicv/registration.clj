([:html
  [:body
   "{% extends \"base.html\" %}\n{% block menu %}\n{% endblock %}\n{% block content %}\n"
   [:form
    {:method "POST", :action "{{servlet-context}}/register"}
    [:div.form-group.col-lg-3
     [:label {:for "id"} "user id"]
     "\n    {% if id-error %}\n      "
     [:div.alert.alert-danger "{{id-error}}"]
     "\n    {% endif %}\n    "
     [:p
      [:input#id.form-control
       {:value "{{id}}", :type "text", :tabindex "1", :name "id"}]]
     [:label {:for "pass"} "password"]
     "\n    {% if pass-error %}\n      "
     [:div.alert.alert-danger "{{pass-error}}"]
     "\n    {% endif %}\n    "
     [:p
      [:input#pass.form-control
       {:type "password", :tabindex "2", :name "pass"}]]
     [:label {:for "pass1"} "retype password"]
     "\n    {% if pass1-error %}\n      "
     [:div.alert.alert-danger "{{pass1-error}}"]
     "\n    {% endif %}\n    "
     [:p
      [:input#pass1.form-control
       {:type "password", :tabindex "3", :name "pass1"}]]
     [:input.btn
      {:value "create account", :type "submit", :tabindex "4"}]]]
   "\n{% endblock %}\n\n"]])
