package model

// to do ...
  // same as Airport
case class Runway (id: String,
                    airport_ref: String,
                    airport_ident: String,
                    length_ft: Option[Int],
                    width_ft: Option[Int],
                    surface: String,
                    lighted: Option[Boolean],
                    closed: Option[Boolean],
                    le_ident: String,
                    le_latitude_deg: Option[Float],
                    le_longitude_deg: Option[Float],
                    le_elevation_ft: Option[Int],
                    le_heading_degT: Option[Float],
                    le_displaced_threshold_ft: Option[Float],
                    he_ident: String,
                    he_latitude_deg: Option[Float],
                    he_longitude_deg: Option[Float],
                    he_elevation_ft: Option[Int],
                    he_heading_degT: Option[Float],
                    he_displaced_threshold_ft: Option[Float])

object Runway {
  def toRunway(line: Array[String]) : Option[Runway] = Option(Runway.apply(line(0),
                                                                              line(1),
                                                                              line(2),
                                                                              line(3),
                                                                              Option(line(4)),
                                                                              Option(line(5)),
                                                                              Option(line(6)),
                                                                              Option(line(7)),
                                                                              Option(line(8)),
                                                                              Option(line(9)),
                                                                              Option(line(10)),
                                                                              Option(line(11)),
                                                                              Option(line(12)),
                                                                              Option(line(13)),
                                                                              Option(line(14)),
                                                                              Option(line(15)),
                                                                              Option(line(16)),
                                                                              Option(line(17)),
                                                                              Option(line(18)),
                                                                              Option(line(19))
                                                                           ) 
  )
}
