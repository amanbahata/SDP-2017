package bc
import vm.VirtualMachine

/**
  * Created by aman1 on 12/05/2017.
  */
class ISwapByteCode extends ByteCode{
  /**
    * A unique byte value representing the bytecode. An implementation
    * will set this to the bytecode corresponding to the name of the
    * bytecode in [[ByteCodeValues]]
    */
  override val code: Byte = bytecode("iswap")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val value1 = vm.pop()._1
    val value2 = vm.pop()._1
    vm.push(value1)
    vm.push(value2)
    vm
  }
}
