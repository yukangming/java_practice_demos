package extended

import "jvmGo/ch06/instructions/base"
// import "jvmGo/ch06/instructions/loads"
// import "jvmGo/ch06/instructions/math"
// import "jvmGo/ch06/instructions/stores"
import "jvmGo/ch06/rtda"

type GOTO_W struct {
	offset int
}

func (self *GOTO_W) FetchOperands(reader *base.BytecodeReader) {
	self.offset = int(reader.ReadInt32())
}
func (self *GOTO_W) Execute(frame *rtda.Frame) {
	base.Branch(frame, self.offset)
}