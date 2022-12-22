package model

final case class Airport ()

object Airport {
  def fromCsvLine(line: List[String]): Option[Airport] = {
    // to do ...
  }

  def toAirport(line: List[String]) : Option[Airport] = {
    // to do ...
  }
}

// *** to do ... *** //
// 1. define Airport object with params id, ident, iso_country
// 2. complete 2 functions