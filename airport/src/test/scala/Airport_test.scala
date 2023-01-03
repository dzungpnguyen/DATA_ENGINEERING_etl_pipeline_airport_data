package example

import main._
import Airport._
import Country._
import Runway._
import DisplayingService._
import ParsingService._
import StoringService._ 



class Airport_test extends AnyFlatSpec with Matchers {
  test("Airport fromCsvLine function")
    assert(Airport.fromCsvLine(List("0","1","c","d")) == None)
    assert(Airport.fromCsvLine(List("", "1","c","d","e","f","g","h","j")) == None)
    assert(Airport.fromCsvLine(List("0", "1","c","d","e","f","g","h","j")) == Some(0,1,"d","j"))

  test("toAirport function")
    assert(toAirport(List("0",""1"","","3","","","","","8")) ==Some(Airport(0,"1","3","8")))
    assert(toAirport(List("a",""1"","","3","","","","","8")) == None)
    assert(toAirport(List("0",""1"","","","","","","","8")) == None)

  test("Country fromCsvLine function")
    assert(Country.fromCsvLine(List("1")) == None)
    assert(Country.fromCsvLine(List("", "b","c")) == None)
    assert(Country.fromCsvLine(List("a", "b","c")) == None)
    assert(Country.fromCsvLine(List("1", "b", "c")) == Some(Country(1,"b","c")))

  test("toCountry function")
    assert(toCountry(List("0",""1"","2")) == Some(Country(0,"1","2")))
    assert(toCountry(List("a",""1"","2")) == None)
    assert(toCountry(List("0",""1"","")) == None)
  
  test("Runway fromCsvLine function")
    assert(Runway.fromCsvLine(List("1","2","c","d")) == None)
    assert(Runway.fromCsvLine(List("","2","c","d","e","f","g","h","j")) == None)
    assert(Runway.fromCsvLine(List("1","2","c","d","e","f","g","h","j")) == Some(Runway(1,2,"c","f","j")))

  test("toRunway function")
    assert(toRunway(List("0",""1"","","3","","","","","8")) ==Some(Runway(0,"1","3","8")))
    assert(toRunway(List("a",""1"","","3","","","","","8")) == None)
    assert(toRunway(List("0",""1"","","","","","","","8")) == None)
    

}
