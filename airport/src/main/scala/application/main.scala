package application

import model.Airport
import model.Country
import model.Runway

object MyApplication {
  def main(args: Array[String]) = {

    // airports
    val lst_airports = scala.io.Source.fromFile("src/resources/airports.csv").getLines().iterator
      .map(_.split(","))
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
                                obj(17)
                              )
            )
    // lst_airports.foreach(println)

    // countries
    val lst_countries = scala.io.Source.fromFile("src/resources/countries.csv").getLines().iterator
      .map(_.split(","))
      .filter(arr => arr.length == 6)
      .map(obj => Country.apply(obj(0),
                                obj(1),
                                obj(2),
                                obj(3),
                                obj(4),
                                obj(5),
                              )
            )

    // runways
    val lst_runways = scala.io.Source.fromFile("src/resources/runways.csv").getLines().iterator
      .map(_.split(","))
      .filter(arr => arr.length == 20)
      .map(obj => Runway.apply(obj(0),
                                obj(1),
                                obj(2),
                                obj(3).toIntOption,
                                obj(4).toIntOption,
                                obj(5),
                                obj(6).toBooleanOption,
                                obj(7).toBooleanOption,
                                obj(8),
                                obj(9).toFloatOption,
                                obj(10).toFloatOption,
                                obj(11).toIntOption,
                                obj(12).toFloatOption,
                                obj(13).toFloatOption,
                                obj(14),
                                obj(15).toFloatOption,
                                obj(16).toFloatOption,
                                obj(17).toIntOption,
                                obj(18).toFloatOption,
                                obj(19).toFloatOption
                              )
            )

  }
}

//   def getAllAirports(lst: Iterator[String]) {
//     lst.map(_.split(","))
//         .filter(arr => arr.length == 18)
//         .map(obj => Airport.apply(obj(0),
//                                   obj(1),
//                                   obj(2),
//                                   obj(3),
//                                   obj(4).toFloatOption,
//                                   obj(5).toFloatOption,
//                                   obj(6).toIntOption,
//                                   obj(7),
//                                   obj(8),
//                                   obj(9),
//                                   obj(10),
//                                   obj(11),
//                                   obj(12),
//                                   obj(13),
//                                   obj(14),
//                                   obj(15),
//                                   obj(16),
//                                   obj(17)))
//   }

//   def getAllCountries(lst: Iterator[String]) {
//     lst.map(_.split(","))
//         .filter(arr => arr.length == 6)
//         .map(obj => Country.apply(obj(0),
//                                   obj(1),
//                                   obj(2),
//                                   obj(3),
//                                   obj(4),
//                                   obj(5),
//                                   )
//               )
//   }
  
//   def getAllRunways(lst: Iterator[String]) {
//     lst.map(_.split(","))
//         .filter(arr => arr.length == 20)
//         .map(obj => Runway.apply(obj(0),
//                                   obj(1),
//                                   obj(2),
//                                   obj(3).toIntOption,
//                                   obj(4).toIntOption,
//                                   obj(5),
//                                   obj(6).toBooleanOption,
//                                   obj(7).toBooleanOption,
//                                   obj(8),
//                                   obj(9).toFloatOption,
//                                   obj(10).toFloatOption,
//                                   obj(11).toIntOption,
//                                   obj(12).toFloatOption,
//                                   obj(13).toFloatOption,
//                                   obj(14),
//                                   obj(15).toFloatOption,
//                                   obj(16).toFloatOption,
//                                   obj(17).toIntOption,
//                                   obj(18).toFloatOption,
//                                   obj(19).toFloatOption
//                                 )
//               )
//   }
// }