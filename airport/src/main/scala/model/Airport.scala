package model

final case class Airport (id: String,
                    ident: String,
                    genre: String,
                    name: String,
                    latitude_deg: Option[Latitude], // type Latitude 
                    longitude_deg: Option[Longitude], // type Longitude
                    elevation_ft: Option[Elevation], // type Elevation
                    continent: Option[String],
                    iso_country: Option[String],
                    iso_region: Option[String],
                    municipality:Option[String],
                    scheduled_service: Option[Boolean], // type Boolean
                    gps_code: String,
                    iata_code: String,
                    local_code: String,
                    home_link: Option[Link], // type Link
                    wikipedia_link: Option[Link], // type Link
                    keywords: Option[String])

object Aiport {
  def toAirport(line: Array[String]) : Option[Airport] = Option(Airport.apply(line(0),
                                                                              line(1),
                                                                              line(2),
                                                                              line(3),
                                                                              Option(line(4)),
                                                                              Option(line(5)),
                                                                              Option(line(6)),
                                                                              Option(line(7)),
                                                                              Option(line(8)),
                                                                              Option(line(9)),
                                                                              Option(line(10)),))
                                                                              Option(line(11)),
                                                                              Option(line(12)),
                                                                              Option(line(13)),
                                                                              Option(line(14)),
                                                                              Option(line(15)),
                                                                              Option(line(16)),
                                                                              Option(line(17))
}