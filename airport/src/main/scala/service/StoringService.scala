// insert data to immutable collection
package service

import service.ParsingService

object StoringService {
  def getObjects[A](fileName: String, lineToObject: List[String] => Option[A]): List[A] = {
    val read_result = ParsingService.parseCSV(fileName, lineToObject)
    read_result.validLines
  }
}