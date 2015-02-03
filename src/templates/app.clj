([:html
  [:head
   [:meta
    {:content "text/html; charset=UTF-8", :http-equiv "Content-Type"}]
   [:title "Welcome to accomplish"]]
  [:body
   [:div#navbar]
   [:div.container
    [:div.jumbotron
     [:h1 "Welcome to accomplish"]
     [:p "Time to start building your site!"]
     [:p
      [:a.btn.btn-primary.btn-lg
       {:href "http://luminusweb.net"}
       "Learn more »"]]]
    [:div.row-fluid [:div#docs.span9 "{{docs|safe}}"]]
    [:div.row-fluid
     [:div#app.span9
      [:p
       "If you're seeing this message, that means you haven't yet compiled your ClojureScript!"]
      [:p
       "Please run "
       [:code "lein cljsbuild auto dev"]
       " to start the ClojureScript compiler and reload the page."]
      [:p
       "See "
       [:a
        {:href "http://www.luminusweb.net/docs/clojurescript.md"}
        "ClojureScript"]
       " documentation for further details."]]]]
   "<!-- scripts and styles -->"
   [:link
    {:href
     "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css",
     :rel "stylesheet"}]
   [:link
    {:href
     "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css",
     :rel "stylesheet"}]
   "\n    {% style \"/css/screen.css\" %}\n\n    "
   [:script
    {:type "text/javascript",
     :src "//code.jquery.com/jquery-2.0.3.min.js"}]
   [:script
    {:src
     "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"}]
   [:script
    {:type "text/javascript"}
    "\n        var context = \"{{servlet-context}}\";\n    "]
   "\n    {% if dev %}\n      "
   [:script
    {:src "//cdnjs.cloudflare.com/ajax/libs/react/0.12.2/react.js"}]
   "\n      {% script \"/js/out/goog/base.js\" %}\n      {% script \"/js/app.js\" %}\n      "
   [:script
    {:type "text/javascript"}
    "goog.require(\"accomplish.app\");"]
   "\n    {% else %}\n      "
   [:script
    {:src
     "//cdnjs.cloudflare.com/ajax/libs/react/0.11.2/react.min.js"}]
   "\n      {% script \"/js/app.js\" %}\n    {% endif %}\n  "]])
