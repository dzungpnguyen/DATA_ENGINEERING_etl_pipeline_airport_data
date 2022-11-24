package model

final case class Country (id: String,
                    code: String,
                    name: String,
                    continent: String,
                    wikipedia_link: String, // type Link ?
                    keywords: Option[String])

object Country {
  def toCountry(line: Array[String]) : Option[Country] = Option(Country.apply(line(0),
                                                                              line(1),
                                                                              line(2),
                                                                              line(3),
                                                                              line(4),
                                                                              Option(line(5))))
}