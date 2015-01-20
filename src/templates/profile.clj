([:html
  [:body
   "{% extends \"base.html\" %}\n{% block menu %}\n{% endblock %}\n{% block content %}\n  "
   [:h2 "User details for {{user.id}}"]
   [:form
    {:method "POST", :action "{{servlet-context}}/update-profile"}
    [:div.form-group.col-lg-3
     [:label {:for "id"} "first name"]
     [:p
      [:input#first-name.form-control
       {:value "{{user.first_name}}",
        :type "text",
        :tabindex "1",
        :name "first-name"}]]
     [:label {:for "id"} "last name"]
     [:p
      [:input#last-name.form-control
       {:value "{{user.last_name}}",
        :type "text",
        :tabindex "1",
        :name "last-name"}]]
     [:label {:for "id"} "email"]
     [:p
      [:input#email.form-control
       {:value "{{user.email}}",
        :type "text",
        :tabindex "1",
        :name "email"}]]
     [:input.btn
      {:value "update profile", :type "submit", :tabindex "4"}]]]
   "\n{% endblock %}\n"]])
