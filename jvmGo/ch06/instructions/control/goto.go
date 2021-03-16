package control

import "jvmGo/ch06/instructions/base"
import "jvmGo/ch06/rtda"

type GOTO struct{ base.BranchInstruction }

func (self *GOTO) Execute(frame *rtda.Frame) {
	base.Branch(frame, self.Offset)
}