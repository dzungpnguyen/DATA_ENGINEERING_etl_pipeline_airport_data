package model

final case class Airport (id: String,
                    ident: String,
                    genre: String,
                    name: String,
                    latitude_deg: Latitude, 
                    longitude_deg: Longitude,
                    elevation_ft: Option[Int],
                    continent: Option[String],
                    iso_country: Option[String],
                    iso_region: Option[String],
                    municipality:Option[String],
                    scheduled_service: Option[Boolean], // type Boolean
                    gps_code: String,
                    iata_code: String,
                    local_code: String,
                    home_link: Option[String], // type Link ?
                    wikipedia_link: Option[String], // type Link ?
                    keywords: Option[String])

object Aiport {
  def toAirport(line: Array[String]) : Option[Airport] = Option(Airport.apply(line(0),
                                                                              line(1),
                                                                              line(2),
                                                                              line(3),
                                                                    // *** to do *** //
                                                                              // Option(line(4)),
                                                                              // Option(line(5)),
                                                                              // Option(line(6)),
                                                                              // Option(line(7)),
                                                                              // Option(line(8)),
                                                                              // Option(line(9)),
                                                                              // Option(line(10)),
                                                                              // Option(line(11)),
                                                                              // Option(line(12)),
                                                                              // Option(line(13)),
                                                                              // Option(line(14)),
                                                                              // Option(line(15)),
                                                                              // Option(line(16)),
                                                                              // Option(line(17))
                                                                    // *** to do *** //
                                                                              )
                                                                )
}

// *** to do ... *** //

// 1. check lại columns trong file csv, col nào có champ nul thì để type trong final case class dạng Option[A]
// 2. create type Latitude, Longitude (and type Link if possible)
// 3. line 27-42: sửa lại cho đúng với type trong final case class
//     VD: type của elevation_ft = Option[Int]. Nhưng Option(line(6)) trả ra option[String] -----> đổi thành line(6).toIntOption
// 4. tương tự với Country model