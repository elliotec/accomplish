("<!DOCTYPE HTML>"
 [:html
  [:head
   [:title "Welcome to accomplish"]
   [:link
    {:href
     "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css",
     :rel "stylesheet"}]
   [:link
    {:href
     "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css",
     :rel "stylesheet"}]]
  [:body
   "\n    {% style \"/css/screen.css\" %}\n\n    "
   [:script
    {:type "text/javascript",
     :src "//code.jquery.com/jquery-2.0.3.min.js"}]
   [:script
    {:src
     "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"}]
   [:script
    {:type "text/javascript"}
    "\n        var context = \"{{servlet-context}}\";\n        $(function () {\n            $(\"#{{selected-page}}\").addClass(\"active\");\n        });\n    "]]
  [:body
   [:div.navbar.navbar-default.navbar-fixed-top
    [:div.container
     [:div.navbar-header
      [:button.navbar-toggle
       {:data-target ".navbar-collapse",
        :data-toggle "collapse",
        :type "button"}
       [:span.icon-bar]
       [:span.icon-bar]
       [:span.icon-bar]]
      [:a.navbar-brand {:href "{{servlet-context}}/"} "accomplish"]]
     "\n        {% block menu %}\n        {% include \"menu.html\" %}\n        {% endblock %}\n    "]]
   [:div.container "\n    {% block content %}\n    {% endblock %}\n"]]])
