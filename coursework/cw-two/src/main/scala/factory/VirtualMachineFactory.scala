package factory

import bc.{ByteCodeFactory, ByteCodeParser, ImplByteCodeParser}
import vendor.{ImplProgramParser, ProgramParser}
import vm.{ImplVirtualMachine, ImplVirtualMachineParser, VirtualMachine, VirtualMachineParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {

  def byteCodeFactory: ByteCodeFactory = new ImplByteCodeFactory


  def vendorParser: ProgramParser = new ImplProgramParser


  def byteCodeParser: ByteCodeParser = new ImplByteCodeParser


  def virtualMachineParser: VirtualMachineParser = new ImplVirtualMachineParser


  def virtualMachine: VirtualMachine = new ImplVirtualMachine
}
