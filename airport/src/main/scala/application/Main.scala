package application

import model._
import service._

object MyApplication {
  def main(args: Array[String]): Unit = 
    //to start the program 
    println("""
      ----------------------------------------
      Program started.
      ENTER "EXIT" ANYTIME TO END THE PROGRAM.
            """)
    // first question
    DisplayingService.getUserOption
}
