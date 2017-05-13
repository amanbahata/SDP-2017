package factory

import bc.{ByteCodeFactory, ByteCodeParser, ImplByteCodeParser}
import vendor.ProgramParser
import vm.{ImplVirtualMachine, ImplVirtualMachineParser, VirtualMachine, VirtualMachineParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {
  // TODO
  def byteCodeFactory: ByteCodeFactory = new ImplByteCodeFactory

  // TODO
  def vendorParser: ProgramParser = new ImplProgramParser

  // TODO
  def byteCodeParser: ByteCodeParser = new ImplByteCodeParser

  // TODO
  def virtualMachineParser: VirtualMachineParser = new ImplVirtualMachineParser

  // TODO
  def virtualMachine: VirtualMachine = new ImplVirtualMachine
}
