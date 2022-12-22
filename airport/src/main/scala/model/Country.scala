package model

final case class Country ()
  // to do ...

object Country {
  def fromCsvLine(line: List[String]): Option[Runway] = {
    // to do ...
  }

  def toCountry(line: List[String]) : Option[Country] = {
    // to do ...
  }
}


// ****** to do ****** //
// 1. define Country object with params id, code, name
// 2. define LocationCodeType for param code (String with 2 chars)
// 3. complete 2 functions