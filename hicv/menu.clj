([:html
  [:body
   [:div.navbar-collapse.collapse
    "\n  {% if user-id %}\n    "
    [:div.btn-group.pull-right
     [:ul.nav.navbar-nav
      [:li.dropdown
       [:a.dropdown-toggle
        {:data-toggle "dropdown", :href "#"}
        [:i.icon-user]
        "{{user-id}} "
        [:b.caret]]
       [:ul.dropdown-menu
        [:li [:a {:href "{{servlet-context}}/profile"} "Profile"]]
        [:li.divider]
        [:li [:a {:href "{{servlet-context}}/logout"} "Sign Out"]]]]]]
    "\n  {% else %}\n    "
    [:div.btn-group.pull-right
     [:ul.nav.navbar-nav
      [:li.dropdown
       [:form#login-form.navbar-form
        [:input#id.span2
         {:type "text",
          :style "margin-right: 5px",
          :placeholder "user id",
          :name "id"}]
        [:input#pass.span2
         {:type "password",
          :style "margin-right: 5px",
          :placeholder "password",
          :name "pass"}]
        [:input.btn
         {:value "Login", :onclick "login", :type "submit"}]]]
      [:li [:a {:href "{{servlet-context}}/register"} "Register"]]]]
    [:script
     {:type "application/javascript"}
     "\n        $( \"#login-form\" ).submit(function(event) {\n            $.ajax\n            ({\n                type: \"GET\",\n                url: \"{{servlet-context}}/login\",\n                headers: {\n                    \"Authorization\": \"Basic \" + btoa($(\"input#id\").val() + \":\" + $(\"input#pass\").val())\n                },\n                success: function () {\n                    document.location.href = \"{{servlet-context}}/\";\n                }\n            });\n            event.preventDefault();\n        });\n    "]
    "\n  {% endif %}\n"]]])
