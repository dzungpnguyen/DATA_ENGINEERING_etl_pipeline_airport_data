package model

import scala.util.Try

import model.Runway

final case class Country  ( id: Int,
                            code: String,
                            name: String
                          )

object Country {
  def fromCsvLine(line: List[String]): Option[Country] =
    line.size match
      case _ if line.size > 2 => toCountry(line)
      case _ => None

  def toCountry(line: List[String]) : Option[Country] =
    ( Try(line(0).toInt).toOption, Try(line(1).toString.substring(1, line(1).toString.length()-1)).toOption,
      Try(line(2).toString.substring(1, line(2).toString.length()-1)).toOption) match
      case (Some(c1), Some(c2), Some(c3)) => Some(Country(c1, c2, c3))
      case _ => None
}