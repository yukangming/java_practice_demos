package control

import "jvmGo/ch05/instructions/base"
import "jvmGo/ch05/rtda"

type GOTO struct{ base.BranchInstruction }

func (self *GOTO) Execute(frame *rtda.Frame) {
	base.Branch(frame, self.Offset)
}