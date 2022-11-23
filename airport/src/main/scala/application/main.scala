package application

import model.Airport

object Show_airport {
  def main(args: Array[String]) = {

    // airports
    val lst_airports = scala.io.Source.fromFile("src/resources/airports.csv").getLines()
    getAllAirports(lst_airports)
    // lst_airports.foreach(println)


    // countries
    val lst_countries = scala.io.Source.fromFile("src/resources/countries.csv").getLines()
    getAllCountries(lst_countries)


    // runways
        // to do...
  }

  def getAllAirports(lst: Iterator[String]) {
    // split row by ","
    lst.map(_.split(","))
        // keep valid row
        .filter(arr => arr.length == 18)
        // generate object
        .map(obj => Airport.apply(obj(0),
                                  obj(1),
                                  obj(2),
                                  obj(3),
                                  obj(4).toFloatOption,
                                  obj(5).toFloatOption,
                                  obj(6).toIntOption,
                                  obj(7),
                                  obj(8),
                                  obj(9),
                                  obj(10),
                                  obj(11),
                                  obj(12),
                                  obj(13),
                                  obj(14),
                                  obj(15),
                                  obj(16),
                                  obj(17)))
  }

  def getAllCountries(lst: Iterator[String]) {
    // to do...
  }
  
  def getAllRunways(lst: Iterator[String]) {
    // to do...
  }
}