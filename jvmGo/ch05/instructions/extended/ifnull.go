package extended

import "jvmGo/ch05/instructions/base"
// import "jvmGo/ch05/instructions/loads"
// import "jvmGo/ch05/instructions/math"
// import "jvmGo/ch05/instructions/stores"
import "jvmGo/ch05/rtda"

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