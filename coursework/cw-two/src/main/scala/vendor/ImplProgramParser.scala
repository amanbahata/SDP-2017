package vendor

import scala.io.Source

/**
  * Created by aman1 on 12/05/2017.
  */
class ImplProgramParser extends ProgramParser {
  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  override def parse(file: String): InstructionList = {
    val fileLines = Source.fromFile(file).getLines()
    var instructionsList = Vector[Instruction]()
    for (line <- fileLines)
      instructionsList = instructionsList ++: parseString(line)

    instructionsList
  }

  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  override def parseString(string: String): InstructionList = {
    // Stores the contents of each line in the program
    val lineContainer: Array[String] = string.split("\n")
    var instructionsList = Vector[Instruction]()

    for (line <- lineContainer){
      var splitLine: String = line.toLowerCase
      var number = Vector[Int]()

      if (line.contains(" ")) {
        var lineSeparation = line.split(" ")
        splitLine = lineSeparation(0)
        number = number :+ splitLine(1).toInt
      }

      instructionsList = instructionsList :+ new Instruction(splitLine, number)
  }
    instructionsList
  }
}
