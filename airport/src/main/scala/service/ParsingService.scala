package service

// import model.Airport
// import model.Country
import model.Runway

import scala.io.Source

final case class readResult[A](validLines: List[A], nbInvalidLines: Int)

object ParsingService {
  def parseCSV[A](fileName: String, lineToObject: List[String] => Option[A]): readResult[A] = {
    // read CSV file 
    val lst = Source.fromFile(fileName).getLines()
                      .drop(1) // remove headers
                      // seperate lines by ","
                      .map(_.split(',')
                            .toList)
                      // convert each line to an Object
                      .map(lineToObject)  // Iterator[Option[A]]
                      .toList // List[Option[A]]
    // list of parsed (valid) line : List[A]
    val parsedLines = lst.filter(_ != None)
    // list of invalid lines
    val invalidLines = lst.filter(_ == None)
    // results
    readResult(parsedLines.flatten, invalidLines.size)
  }
}