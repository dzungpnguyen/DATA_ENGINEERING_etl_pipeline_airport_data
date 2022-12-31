package model

import scala.util.Try

case class Runway ( id: Int,
                    airport_ref: Int,
                    airport_ident: String,
                    surface: String,
                    le_ident: String
                  )

object Runway {
  def fromCsvLine(line: List[String]): Option[Runway] =
    line.size match
      case _ if line.size > 8 => toRunway(line)
      case _ => None

  def toRunway(line: List[String]): Option[Runway] =
    ( Try(line(0).toInt).toOption, Try(line(1).toInt).toOption, Try(line(2).toString).toOption,
      Try(line(5).toString).toOption, Try(line(8).toString).toOption) match
      case (Some(r1), Some(r2), Some(r3), Some(r4), Some(r5)) => Some(Runway(r1, r2, r3, r4, r5))
      case _ => None
}