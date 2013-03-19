# angellist-scrapper

Scrap Angellist public pages for trend data.

## Usage

(require '[angellist-scrapper.core :as core] )
(pprint (core/latest-trend))

({:id "71830",
  :name "Drawn to Scale",
  :url "https://angel.co/drawn-to-scale",
  :title
  "Spire: the first SQL database for Big Data Applications, built on Hadoop",
  :rank 229}
 {:id "164130",
  :name "ImageBrief",
  :url "https://angel.co/imagebrief",
  :title
  "Disrupting stock image libraries by crowdsourcing image requests",
  :rank 240}
    ...

(pprint (core/latest-startups))
({:id "88405",
  :url "https://angel.co/argophilia-travel",
  :name "Argophilia Travel",
  :title "Executing Where Others Forgot"}
 {:id "149395",
  :url "https://angel.co/stadiumred-1",
  :name "Stadiumred",
  :title
  "Democratizing the way music is created and monetized (Studio/Record Label in the Cloud)"}
 {:id "132132",
  :url "https://angel.co/yasabe",
  :name "YaSabe",
  :title "Local search destination catering to US Hispanic consumers."}
 {:id "52656",
  :url "https://angel.co/portlandseedfund",
  :name "Portland Seed Fund",
  :title ""}


## License

Copyright © 2013 Teo Choong Ping

Distributed under the Eclipse Public License, the same as Clojure.
