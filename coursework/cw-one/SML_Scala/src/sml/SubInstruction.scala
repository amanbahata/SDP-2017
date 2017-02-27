package sml

/**
  * Created by aman1 on 27/02/2017.
  */
class SubInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op){

  override def toString(): String = {
    super.toString + " " + op1 + " - " + op2 + " to " + result
  }

  override def execute(m: Machine): Unit = {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 - value2
  }
}

object SubInstruction{
  def apply(label: String, result: Int, op1: Int, op2: Int) =
    new SubInstruction(label, "sub", result, op1, op2)
}
