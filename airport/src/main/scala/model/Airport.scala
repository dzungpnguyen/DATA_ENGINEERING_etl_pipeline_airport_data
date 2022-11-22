val filePath = "./airports.csv" 
val file - 
case class DoConfig (docDepotId: Int,
                      docShiftStart : String,
                      docShiftEnd: String,
                      docLastDepart: String,
                      docNumberVansDefault:Int
                    )

// Avoid file not found
// Close source after reading
scala.util.Using(scala.io.Source.fromFile(file)) { source =>
  source.getLines.toList
}
.toEither
.flatMap { lines =>
  // Split row on ":"
  lines.flatMap(x => x.split(": ").lastOption)
    // Keep valid rows
    .pipe {
      case List(depotId, shiftStart, shiftEnd, lastDepart, numberVansDefault) =>
        depotId.toIntOption.flatMap { depotId =>
          numberVansDefault.toIntOption.map { numberVansDefault =>
            (depotId, shiftStart, shiftEnd, lastDepart, numberVansDefault)
          }
        }
      case _ => 
        None
    }
    .map((DoConfig.apply _).tupled)
    .toRight(new Throwable("Invalid format"))
}


object ReadCsv {
  def main(args:Array[String]) {
    val filePath = "./content.csv"
    val file = new File(filePath)
    val readBuffer = Source.fromFile(file)
    readBuffer.getLines().foreach(println)
    readBuffer.close()
  }
}