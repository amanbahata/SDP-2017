package bc
import vm.VirtualMachine

/**
  * Created by Aman Enghida and Biruk Gebreselassie on 12/05/2017.
  */
class IprintByteCode extends ByteCode {
  /**
    * A unique byte value representing the bytecode. An implementation
    * will set this to the bytecode corresponding to the name of the
    * bytecode in [[ByteCodeValues]]
    */
  override val code: Byte = bytecode("print")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    println(vm.pop()._1)
    vm
  }
}
