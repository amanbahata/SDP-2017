package factory

import vendor.{Instruction, ProgramParser}

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
    //    val lineContainer: Array[String] = string.split("\n")
    var instructionsList = Vector[Instruction]()
    var number = Vector[Int]()

    var splitLine = string.split(" ")
    var operand = splitLine(0)
    if (splitLine.length > 1) {
      val num = splitLine(1).toInt
      number = number :+ num
    }
    instructionsList = instructionsList :+ new Instruction(operand, number)
    instructionsList
  }
}
