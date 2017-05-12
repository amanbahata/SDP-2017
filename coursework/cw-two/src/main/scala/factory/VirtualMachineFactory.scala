package factory

import bc.{ByteCodeFactory, ByteCodeParser}
import vendor.ProgramParser
import vm.{VirtualMachine, VirtualMachineParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {
  // TODO
  def byteCodeFactory: ByteCodeFactory = new ByteCodeFactory

  // TODO
  def vendorParser: ProgramParser = new ImplProgramParser

  // TODO
  def byteCodeParser: ByteCodeParser = new ByteCodeParser

  // TODO
  def virtualMachineParser: VirtualMachineParser = new VirtualMachineParser

  // TODO
  def virtualMachine: VirtualMachine = new VirtualMachine
}
