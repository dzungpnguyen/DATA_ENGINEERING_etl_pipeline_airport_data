package model

case class Airport (id: String,
                    ident: String,
                    genre: String,
                    name: String,
                    latitude_deg: Option[Float],
                    longitude_deg: Option[Float],
                    elevation_ft: Option[Int],
                    continent: String,
                    iso_country: String,
                    iso_region: String,
                    municipality: String,
                    scheduled_service: String, // Boolean (?)
                    gps_code: String,
                    iata_code: String,
                    local_code: String,
                    home_link: String,
                    wikipedia_link: String,
                    keywords: String)