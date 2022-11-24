package model

// to do ...
  // find columns containing empty cells in csv file then rewrite type to Option[A]
final case class Airport (id: String,
                    ident: String,
                    genre: String,
                    name: String,
                    latitude_deg: Option[Float], // type Latitude 
                    longitude_deg: Option[Float], // type Longitude
                    elevation_ft: Option[Int], // type Elevation
                    continent: String,
                    iso_country: String,
                    iso_region: String,
                    municipality: String,
                    scheduled_service: String, // type Boolean
                    gps_code: String,
                    iata_code: String,
                    local_code: String,
                    home_link: String, // type Link
                    wikipedia_link: String, // type Link
                    keywords: String)

object Aiport {
  // to do ...
}