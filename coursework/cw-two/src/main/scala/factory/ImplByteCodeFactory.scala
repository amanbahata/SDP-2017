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
    case byte if bytecode("iadd")  => new IaddByteCode
    case byte if bytecode("isub")  => new IsubByteCode
    case byte if bytecode("imul")  => new ImulByteCode
    case byte if bytecode("idiv")  => new IdivByteCode
    case byte if bytecode("irem")  => new IremByteCode
    case byte if bytecode("ineg")  => new InegByteCode
    case byte if bytecode("iinc")  => new IncBytecode
    case byte if bytecode("idec")  => new IdecByteCode
    case byte if bytecode("iswap")  => new ISwapByteCode
    case byte if bytecode("idup")  => new IdupByteCode
    case byte if bytecode("print")  => new IprintByteCode
    case byte if bytecode("iconst")  => new IconstByteCode(args.head)
    case _ => throw new InvalidBytecodeException("Invalid Value")
  }
}
