package bc

import factory.ImplByteCodeFactory

/**
  * Created by aman1 on 12/05/2017.
  */
class ImplByteCodeParser extends ByteCodeParser with ByteCodeValues{
  /**
    * Parses a vector of `Byte` into a vector of `ByteCode`.
    *
    * You should use [[ByteCodeValues.bytecode]] to help translate
    * the individual `Byte`s into a correponding [[ByteCode]].
    *
    * @param bc a vector of bytes representing bytecodes
    * @return a vector of `ByteCode` objects
    */
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    val byteCfactory : ByteCodeFactory = new ImplByteCodeFactory
    var listOfByteCode = Vector[ByteCode]()

    var counter = 0
    while (counter <= bc.length-1){
      if (bc(counter) == bytecode("iconst")){
        listOfByteCode = listOfByteCode :+ byteCfactory.make(bc(counter),bc(counter+1).toInt)
        counter += 2
      } else {
        listOfByteCode = listOfByteCode :+ byteCfactory.make(bc(counter))
        counter += 1
      }
    }

    listOfByteCode
  }
}
