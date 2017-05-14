package factory

import bc._

/**
  * Created by Aman Enghida and Biruk Gebreselassie on 12/05/2017.
  */
class ImplByteCodeFactory extends ByteCodeFactory with ByteCodeValues{


  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[bc.ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method should throw an [[bc.InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = byte match {
    case iadd if bytecode("iadd") == byte => new IaddByteCode
    case iconst if bytecode("iconst") == byte  => new IconstByteCode(args.head)
    case isub if bytecode("isub")  == byte => new IsubByteCode
    case imul if bytecode("imul")  == byte => new ImulByteCode
    case idiv if bytecode("idiv")  == byte => new IdivByteCode
    case irem if bytecode("irem")  == byte => new IremByteCode
    case ineg if bytecode("ineg")  == byte => new InegByteCode
    case iinc if bytecode("iinc")  == byte => new IncBytecode
    case idec if bytecode("idec")  == byte => new IdecByteCode
    case iswap if bytecode("iswap") == byte => new ISwapByteCode
    case idup if bytecode("idup") == byte => new IdupByteCode
    case print if bytecode("print") == byte => new IprintByteCode
    case _ => throw new InvalidBytecodeException("Invalid Value, please provide a valid format.")
  }
}
