package vm

import bc.{ByteCode, ByteCodeValues, ImplByteCodeParser, InvalidBytecodeException}
import factory.ImplProgramParser
import vendor.Instruction

/**
  * Created by aman1 on 13/05/2017.
  */
class ImplVirtualMachineParser extends VirtualMachineParser with ByteCodeValues{


  val byteParser = new ImplByteCodeParser
  val programParser = new ImplProgramParser
  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a file into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  override def parse(file: String): Vector[ByteCode] = {
    val result = programParser.parse(file)
    byteParser.parse(convertToByte(result))
  }

  def convertToByte(instArray: Vector[Instruction]): Vector[Byte] = {
    var byteArray : Vector[Byte] = Vector[Byte]()
    for ( i <- instArray){
      if (!bytecode.contains(i.name)){
        throw new InvalidBytecodeException("invalid")
      } else{
        byteArray = byteArray :+ bytecode(i.name)
        if (i.args.nonEmpty){
          byteArray = byteArray :+ i.args(0).toByte
        }
      }
    }
    byteArray
  }

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a string into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program string correctly.
    *
    * @param str a string containing a program
    * @return a vector of bytecodes
    */
  override def parseString(str: String): Vector[ByteCode] = {
    val instArray = programParser.parseString(str)
    byteParser.parse(convertToByte(instArray))
  }
}
