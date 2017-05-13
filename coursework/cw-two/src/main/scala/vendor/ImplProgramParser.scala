package vendor



/**
  * Created by Aman Enghida and Biruk Gebreselassie on 12/05/2017.
  */
class ImplProgramParser extends ProgramParser {
  override type InstructionList = Vector[Instruction]
  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  override def parse(file: String): InstructionList = {
    import scala.io.Source
    val fileLines = Source.fromFile(file).getLines()
    var instructionsList = Vector[Instruction]()
    for (line <- fileLines) {
        instructionsList = instructionsList ++: parseString(line)
      }
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
    val lineContainer: Array[String] = string.split("\n")
    var instructionsList = Vector[Instruction]()
    //Iterate over each line contained in a program and prepare container for the numbers.
    for (line <- lineContainer){
      var splitLine: String = line.toLowerCase
      var number: Vector[Int] = Vector[Int]()
      //check a single line is composed of iconst NUM and split it.
      if (line.contains(" ")) {
        val lineSeparation = line.split(" ")
        splitLine = lineSeparation(0)
        number = number :+ lineSeparation(1).toInt
      }

      instructionsList = instructionsList :+ new Instruction(splitLine, number)
  }
    instructionsList
  }
}
