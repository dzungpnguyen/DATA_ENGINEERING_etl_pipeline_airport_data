package model

import scala.util.Try

final case class Airport  ( id: Int,
                            ident: String,
                            name: String,
                            iso_country: String // equals country.code
                          )

object Airport {
  def fromCsvLine(line: List[String]): Option[Airport] =
    line.size match
      //if line contains all the parameters ( iso_country is the 8th column)
      case _ if line.size > 8 => toAirport(line)
      // otherwise
      case _ => None

  def toAirport(line: List[String]) : Option[Airport] =
    //line(0) equals id column
    ( Try(line(0).toInt).toOption,
      //to remove "" in the original csv file 
      Try(line(1).toString.substring(1, line(1).toString.length()-1)).toOption,
      Try(line(3).toString.substring(1, line(3).toString.length()-1)).toOption,
      Try(line(8).toString.substring(1, line(8).toString.length()-1)).toOption) match
      //if all validated
      case (Some(a1), Some(a2), Some(a3), Some(a4)) => Some(Airport(a1, a2, a3, a4))
      // otherwise
      case _ => None 
}