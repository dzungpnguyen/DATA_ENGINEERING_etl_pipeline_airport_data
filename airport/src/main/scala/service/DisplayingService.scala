// excute SQL 

package service

import scala.io.StdIn.readLine

import service.StoringService

object DisplayingService {

  val list_countries = StoringService.getObjects("src/resources/countries.csv", Country.fromCsvLine)
  val list_airports = StoringService.getObjects("src/resources/airports.csv", Airport.fromCsvLine)
  val list_runways = StoringService.getObjects("src/resources/runways.csv", Runway.fromCsvLine)

  def getUserOption(): Unit = {
    println("----------------------------------------")
    println("Query or Reports?")
    val userOption = readLine()
    userOption.toLowerCase() match {
      case "query" => queryOption()
      case "reports" => reportsOption()
      case "exit" => exit()
      case _ => {
        println("Keyword not found. Please re-enter your answer.")
        getUserOption()
      }
    }
  }

  def queryOption(): Unit = {
    println("----------------------------------------")
    println("Enter a country code or a country name:")
    // get user's answer
    val identifier = readLine()
    // get user's country
    val userCountry = list_countries.filter(x => { x.code.equals(identifier.toUpperCase) || x.name.toUpperCase.equals(identifier.toUpperCase) })
    userCountry.size match {
      // country not found
      case 0 => {
        if (identifier.toLowerCase.equals("exit")){
          exit()
        } else {
          println("Country not found. Please re-enter your answer.")
          queryOption()
        }
      }
      // country found
      case _ => {
        userCountry.foreach(country => {
          println("Country Code | Country Name | Airport ID | Runway ID")
          println("-------------+--------------+------------+----------")
          list_airports.foreach(airport => {
            if (airport.iso_country.equals(country.code))
              list_runways.foreach(runway => {
                if (runway.airport_ident.equals(airport.ident))
                  printf("-- %s --|-- %s --|-- %s --|-- %s --\n", country.code, country.name, airport.id, runway.id)
              })
          })
        })
      }
    }
  }

  def reportsOption(): Unit = {
    println("----------------------------------------")
    println("Choose your report type by entering its number:\n1. 10 countries with highest number of airports and countries with lowest number of airports.\n2. Type of runways per country.\n3. Top 10 most common runway latitude.\n*** Enter exit to end the program ***")
    val reportType = readLine()
    reportType.toLowerCase match {
      case "1" => topNumberOfAirports()
      case "2" => runwaysType()
      case "3" => mostCommonRunwayLatitude()
      case "exit" => exit()
      case _ => {
        println("Report type not found. Please re-enter your answer.")
        reportsOption()
      }
    }
  }

  def topNumberOfAirports(){}
  def runwaysType(){}
  def mostCommonRunwayLatitude(){}

  def exit(): Unit = {
    println("----------------------------------------")
    println("Program ended.")
  }
}