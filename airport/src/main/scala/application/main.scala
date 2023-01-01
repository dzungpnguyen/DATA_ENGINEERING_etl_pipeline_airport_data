package application

import model.Airport
import model.Country
import model.Runway

import service.ParsingService
import service.DisplayingService

object MyApplication {
  def main(args: Array[String]): Unit =
    val result_runways = ParsingService.parseCSV("src/resources/runways.csv", Runway.fromCsvLine)
    val result_countries = ParsingService.parseCSV("src/resources/countries.csv", Country.fromCsvLine)
    val result_airports = ParsingService.parseCSV("src/resources/airports.csv", Airport.fromCsvLine)

    println("""
      ----------------------------------------
      Program started.
      ENTER "EXIT" ANYTIME TO END THE PROGRAM.
            """)

    DisplayingService.getUserOption
}