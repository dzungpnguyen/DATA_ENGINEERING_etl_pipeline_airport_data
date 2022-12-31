package model

import scala.util.Try

final case class Airport  ( id: Int,
                            ident: String,
                            name: String,
                            iso_country: String
                          )

object Airport {
  def fromCsvLine(line: List[String]): Option[Airport] =
    line.size match
      case _ if line.size > 8 => toAirport(line)
      case _ => None

  def toAirport(line: List[String]) : Option[Airport] =
    ( Try(line(0).toInt).toOption, Try(line(1).toString.substring(1, line(1).toString.length()-1)).toOption,
      Try(line(3).toString.substring(1, line(3).toString.length()-1)).toOption, Try(line(8).toString.substring(1, line(8).toString.length()-1)).toOption) match
      case (Some(a1), Some(a2), Some(a3), Some(a4)) => Some(Airport(a1, a2, a3, a4))
      case _ => None
}