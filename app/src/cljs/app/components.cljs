(ns app.components
  (:require [reagent.core :as r]
            [app.db :as db]
            [app.colors :as colors]))

(defn theme-select
  []
  [:div.btn-group.themedrop {:id "themedrop"}
   [:button.btn.btn-default {:type "button"}
    "Theme Samples"]
   [:button.btn.btn-default.dropdown-toggle
    {:type "button" :data-toggle "dropdown"}
    [:span.caret]
    [:span.sr-only]
    ]
   [:ul.dropdown-menu {:aria-labelledby "themedrop"}
    [:li [:a
          {:href "#" :on-click #(db/switch-theme db/preset)} "preset"]]
    [:li [:a
          {:href "#" :on-click #(db/switch-theme db/warm-night)} "warm-night"]]
    [:li [:a
          {:href "#" :on-click #(db/switch-theme db/white-sand)}
          "white-sand"] ]
    [:li [:a
          {:href "#" :on-click #(db/switch-theme db/greymatters)}"greymatters"]]
    [:li [:a
          {:href "#" :on-click #(db/switch-theme db/oldlace)} "oldlace"]]
    [:li [:a
          {:href "#" :on-click #(db/switch-theme db/soft-charcoal)} "soft-charcoal"]]]])

(defn button-component
  "button-component returns the markup for a bootstrap default button"
  [text handler]
  [:button.btn.btn-default
   {:type "button" :on-click handler}
   text])

(defn inc-contrast-component
  []
  [:button.btn.btn-default
   {:on-click #(colors/inc-contrast)} [:span.conticons [:i.fa.fa-adjust] [:i.fa.fa-plus]]])

(defn red-contrast-component
  []
  [:button.btn.btn-default
   {:type "button" :on-click #(colors/red-contrast)} [:span.conticons [:i.fa.fa-adjust] [:i.fa.fa-minus]]])

(defn adjustbg-component
  []
  [:div.adbggroup
   [:div.input-group
    [:span.col-xs-2.col-xs-offset-2
     [:input
      {:type "checkbox" :value @db/adjustbg :on-change
       #(db/toggle-adjust)}]]
    [:span.col-xs-2.pull-right "Adjust BG"]
    ]])



(defn random-colors-component
  []
  [:div.randbuttons.row
   [button-component "Warm Colors"
    #(colors/set-random-palette (colors/warm-palette))]
   [button-component "Soft Colors"
    #(colors/set-random-palette (colors/soft-palette))]
   [button-component "Pop Colors"
    #(colors/set-random-palette (colors/pop-palette))]
   [button-component "Muted colors"
    #(colors/set-random-palette (colors/muted-palette))]])
