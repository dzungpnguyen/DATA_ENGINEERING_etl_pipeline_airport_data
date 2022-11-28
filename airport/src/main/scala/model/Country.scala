package model

final case class Country (id: String,
                    code: CountryCode, // type CountryCode
                    name: String,
                    continent: ContinentCode, // type ContinentCode
                    wikipedia_link: Option[Link], // type Link 
                    keywords: Option[String])

object Country {
  def toCountry(line: Array[String]) : Option[Country] = Option(Country.apply(line(0),
                                                                              line(1),
                                                                              line(2),
                                                                              line(3),
                                                                              Option(line(4)),
                                                                              Option(line(5))))
}
