package factory

import bc._

/**
  * Created by aman1 on 12/05/2017.
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
    case byte if bytecode("iadd") == byte  => new IaddByteCode
    case byte if bytecode("iconst") == byte  => new IconstByteCode(args.head)
    case byte if bytecode("isub")  == byte => new IsubByteCode
    case byte if bytecode("imul")  == byte => new ImulByteCode
    case byte if bytecode("idiv")  == byte => new IdivByteCode
    case byte if bytecode("irem")  == byte => new IremByteCode
    case byte if bytecode("ineg")  == byte => new InegByteCode
    case byte if bytecode("iinc")  == byte => new IncBytecode
    case byte if bytecode("idec")  == byte => new IdecByteCode
    case byte if bytecode("iswap") == byte => new ISwapByteCode
    case byte if bytecode("idup") == byte => new IdupByteCode
    case byte if bytecode("print") == byte => new IprintByteCode
    case _ => throw new InvalidBytecodeException("Invalid Value")
  }
}
