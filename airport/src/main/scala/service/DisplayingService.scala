// excute SQL 

package service

import scala.io.StdIn.readLine
import scala.collection.immutable.ListMap

import model.Country
import model.Airport
import model.Runway

import service.StoringService

object DisplayingService {

  val list_countries = StoringService.getObjects("src/resources/countries.csv", Country.fromCsvLine)
  val list_airports = StoringService.getObjects("src/resources/airports.csv", Airport.fromCsvLine)
  val list_runways = StoringService.getObjects("src/resources/runways.csv", Runway.fromCsvLine)

  // mapping country code -> country name
  // if name not found, return original code
  val mapCountry = list_countries.map(_.code).zip(list_countries.map(_.name)).toMap.withDefault(i => i)

  def getUserOption: Unit =
    println("----------------------------------------")
    println("Query or Reports?")
    val userOption = readLine
    userOption.toLowerCase match
      case "query" => queryOption
      case "reports" => reportsOption
      case "exit" => exit
      case _ =>
        println("Keyword not found. Please re-enter your answer.")
        getUserOption

  def queryOption: Unit =
    println("----------------------------------------")
    println("Enter a country code or a country name:")
    // get user's answer
    val identifier = readLine
    // get user's country
    val userCountry = list_countries.filter(x => x.code.equals(identifier.toUpperCase) || x.name.toUpperCase.equals(identifier.toUpperCase))
    userCountry.size match
      // country not found
      case 0 =>
        if (identifier.toLowerCase.equals("exit")) then
          exit
        else
          println("Country not found. Please re-enter your answer.")
          queryOption
      // country found
      case _ =>
        userCountry.foreach(country =>
          println("Country Code | Country Name | Airport ID | Runway ID")
          println("-------------+--------------+------------+----------")
          list_airports.foreach(airport =>
            if (airport.iso_country.equals(country.code)) then
              list_runways.foreach(runway =>
                if (runway.airport_ident.equals(airport.ident)) then
                  printf("-- %s --|-- %s --|-- %s --|-- %s --\n", country.code, country.name, airport.id, runway.id)
              )
          )
        )

  def reportsOption: Unit =
    println("----------------------------------------")
    println("Choose your report type by entering its number:\n1. 10 countries with highest number of airports and countries with lowest number of airports.\n2. Type of runways per country.\n3. Top 10 most common runway latitude.\n*** Enter exit to end the program ***")
    val reportType = readLine
    reportType.toLowerCase match
      case "1" => topNumberOfAirports
      case "2" => runwaysType
      case "3" => mostCommonRunwayLatitude
      case "exit" => exit
      case _ =>
        println("Report type not found. Please re-enter your answer.")
        reportsOption

  def topNumberOfAirports: Unit =
    // mapping country -> count Airport
    val mapCountryCount = list_airports.map(_.iso_country).map(mapCountry(_)).groupBy(identity).mapValues(_.size)

    println("----------------------------------------")
    println("Top 10 countries with highest number of airports")
    println("Country   |   Number of airports")
    // top 10 highest
    ListMap(mapCountryCount.toSeq.sortWith(_._2 > _._2):_*).take(10).foreach(x => println(x._1 + "--+--" + x._2))

    println("----------------------------------------")
    println("Top 10 countries with lowest number of airports")
    println("Country   |   Number of airports")
    // top 10 lowest
    ListMap(mapCountryCount.toSeq.sortWith(_._2 < _._2):_*).take(10).foreach(x => println(x._1 + "--+--" + x._2))
  
  def runwaysType: Unit = println("ok")
  def mostCommonRunwayLatitude: Unit = println("ok")

  def exit: Unit =
    println("----------------------------------------")
    println("Program ended.")

}