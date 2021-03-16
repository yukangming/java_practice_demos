package extended

import "jvmGo/ch06/instructions/base"
// import "jvmGo/ch06/instructions/loads"
// import "jvmGo/ch06/instructions/math"
// import "jvmGo/ch06/instructions/stores"
import "jvmGo/ch06/rtda"

type IFNULL struct{ base.BranchInstruction }

func (self *IFNULL) Execute(frame *rtda.Frame) {
	ref := frame.OperandStack().PopRef()
	if ref == nil {
		base.Branch(frame, self.Offset)
	}
}

// Branch if reference not null
type IFNONNULL struct{ base.BranchInstruction }

func (self *IFNONNULL) Execute(frame *rtda.Frame) {
	ref := frame.OperandStack().PopRef()
	if ref != nil {
		base.Branch(frame, self.Offset)
	}
}