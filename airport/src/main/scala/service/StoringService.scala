// insert data to immutable collection
package service

import service.ParsingService

object StoringService {
  def getObjects[A](fileName: String, lineToObject: List[String] => Option[A]): List[A] =
    ParsingService.parseCSV(fileName, lineToObject).validLines
}