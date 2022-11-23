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
    val lst_runway = scala.io.Source.fromFile("src/resources/runways.csv").getLines()
    getAllRunways(lst_runway)
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
    // split row by ","
    lst.map(_.split(","))
        // keep valid row
        .filter(arr => arr.length == 6)
        // generate object
        .map(obj => Airport.apply(obj(0),
                                  obj(1),
                                  obj(2),
                                  obj(3),
                                  obj(4),
                                  obj(5),
                                  )
              )
  }
  
  def getAllRunways(lst: Iterator[String]) {
    // split row by ","
    lst.map(_.split(","))
        // keep valid row
        .filter(arr => arr.length == 20)
        // generate object
        .map(obj => Airport.apply(obj(0),
                                  obj(1),
                                  obj(2),
                                  obj(3).toIntOption,
                                  obj(4).toIntOption,
                                  obj(5),
                                  obj(6).toBooleanOption,
                                  obj(7).toBooleanOption,
                                  obj(8),
                                  obj(9).toIntOption,
                                  obj(10).toIntOption,
                                  obj(11),
                                  obj(12).toIntOption,
                                  obj(13).toIntOption,
                                  obj(14).toIntOption,
                                  obj(15).toIntOption,
                                  obj(16).toIntOption,
                                  obj(17),
                                  obj(18),
                                  obj(19).toIntOption
                                )
              )
  }
}