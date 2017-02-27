package sml

/**
  * Created by aman1 on 27/02/2017.
  */
class BnzInstruction(label: String, op: String, val op1: Int, label1: String)
  extends Instruction(label, op) {


  override def execute(m: Machine) {
    if (m.regs(op1) != 0) {
      m.pc = label1.drop(1).toInt
    }
  }

  override def toString(): String = {
    super.toString + " " + op1 + " to instruction labelled " + label1 + "\n"
  }
}

  object BnzInstruction {
    def apply(label: String, op1: Int, label1: String) =
      new BnzInstruction(label, "bnz", op1, label1)
  }


