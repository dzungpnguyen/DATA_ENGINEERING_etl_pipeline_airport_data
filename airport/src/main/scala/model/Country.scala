package model

final case class Country (id: String, // type Digit6
                    code: CountryCode, // type LocationCode
                    name: String,
                    continent: ContinentCode, // type LocationCode
                    wikipedia_link: String, // create type Link si possible 
                    keywords: Option[String])

object Country {
  def toCountry(line: Array[String]) : Option[Country] = Option(Country.apply(line(0),
                                                                              line(1),
                                                                              line(2),
                                                                              line(3),
                                                                              Option(line(4)),
                                                                              Option(line(5))))
}


// ****** to do ****** //

// 1. create type Digit6 (Number with 6 digits)
// 2. create type LocationCode (String with 2 characters)
// 3. re-convert type in object Country (line 11-16)