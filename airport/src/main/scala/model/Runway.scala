package model

// to do ...
  // same as Airport
case class Runway (id: Int,
                    airport_ref: Int,
                    airport_ident: NonEmptyString,
                    length_ft: Option[Int],
                    width_ft: Option[Int],
                    surface: String,
                    lighted: Option[Boolean],
                    closed: Option[Boolean],
                    le_ident: String,
                    le_latitude_deg: Latitude,
                    le_longitude_deg: Longitude,
                    le_elevation_ft: Option[Int],
                    le_heading_degT: Option[Float],
                    le_displaced_threshold_ft: Option[Float],
                    he_ident: Option[String],
                    he_latitude_deg: Latitude,
                    he_longitude_deg: Longitude,
                    he_elevation_ft: Option[Int],
                    he_heading_degT: Option[Float],
                    he_displaced_threshold_ft: Option[Float])

object Runway {
  def toRunway(line: Array[String]) : Option[Runway] = Option(Runway.apply(line(0).toInt,
                                                                            line(1).toInt,
                                                                            NonEmptyString(line(2)),
                                                                            line(3).toIntOption,
                                                                            line(4).toIntOption,
                                                                            line(5),
                                                                            line(6).toBooleanOption,
                                                                            line(7).toBooleanOption,
                                                                            line(8),
                                                                            Latitude(line(9).toFloatOption),
                                                                            Longitude(line(10).toFloatOption),
                                                                            line(11).toIntOption,
                                                                            line(12).toFloatOption,
                                                                            line(13).toFloatOption,
                                                                            Option(line(14)),
                                                                            Latitude(line(15).toFloatOption),
                                                                            Longitude(line(16).toFloatOption),
                                                                            line(17).toIntOption,
                                                                            line(18).toFloatOption,
                                                                            line(19).toFloatOption
                                                                            )
                                                              )
}


// -------------------- //
// *** Custom types *** //
// -------------------- //

final case class NonEmptyString private (str:String) extends AnyVal
object NonEmptyString {
  def fromString (str:String) = {
    if (str.length > 0)
      Some(NonEmptyString(str))
    else
      None
  }
}

final case class Latitude private (lat:Option[Float]) extends AnyVal
object Latitude {
  def fromLatitude (lat:Option[Float]) = {
    if (lat >= -90.0 && lat <= 90.0)
      Some(Latitude(lat))
    else
      None
  }
}

final case class Longitude private (lon:Option[Float]) extends AnyVal
object Longitude {
  def fromLongitude (lon:Option[Float]) = {
    if (lon >= -180.0 && lon <= 180.0)
      Some(Longitude(lon))
    else
      None
  }
}