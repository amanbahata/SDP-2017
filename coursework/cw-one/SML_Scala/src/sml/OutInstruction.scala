package sml

/**
  * Created by aman1 on 27/02/2017.
  */
case class OutInstruction(label: String, opcode: String, register: Int)
  extends Instruction(label, opcode) {

  var value = 0

  override def execute(m: Machine) {
    value = m.regs(register)
    println("Register "+register + " content is " + value)
  }

  override def toString(): String = {
    super.toString + " register " + register + " content." + "\n"
  }
}

object OutInstruction {
  def apply(label: String, register: Int) =
    new OutInstruction(label, "out", register)
}