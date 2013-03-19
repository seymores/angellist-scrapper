(ns angellist-scrapper.core
  (:use [net.cgrand.enlive-html :as html])
  (:require [clj-http.client :as client])
  (:import java.net.URL))

(def trending-url "https://angel.co/trending")
(def new-url "https://angel.co/finder?AL_Signal=1%2C2%2C3%2C4&AL_claimed=true&per_page=25&render_tags=1&sort=joined")

(defn fetch-url
  [url]
  "Grab the HTML page with the given URL"
  (html/html-resource (URL. url)))

(defn parse-trend-row
  [row]
  "Parse trending data row to grab the relevant data, return them as a hash-map"
  (let [id    (-> row :attrs :data-startup_id)
        name  (-> row :attrs :data-startup_name)
        url   (-> row :attrs :data-url)
        title (-> (html/select row [:div (attr? :title)]) first :content first .trim)
        followers  (-> (html/select row [:div.followers]) first :content second :content first .trim Integer/parseInt)]
  {:id id, :name name, :url url, :title title, :followers followers}))

(defn latest-trend
  []
  "Get the latest startups trend list"
  (let [data    (fetch-url trending-url)
        rows    (html/select data [:div (attr? :data-startup_id)])
        result  (map parse-trend-row rows )]
    result))

(defn parse-new-startup-row
  [row]
  "Parse latest startup data row, return as hash-map"
  (let [id    (-> row :content second :content first :content first :attrs :data-id)
        url   (-> row :content second :content first :attrs :href)
        name  (-> row :content second :content first :content first :attrs :alt)
        title (-> (html/select row [:div.resume]) first :content first .trim)]
    {:id id, :url url, :name name, :title title}))
  
(defn latest-startups
  []
  "Get the latest startups trend list"
  (let [data    (fetch-url new-url)
        rows    (html/select data [:div.item-investor])
        result  (map parse-new-startup-row rows )]
    result))
