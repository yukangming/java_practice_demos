package math

import "jvmGo/ch05/instructions/base"
import "jvmGo/ch05/rtda"

// see: https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html#jvms-6.5.ixor
// Boolean XOR int
type IXOR struct{ base.NoOperandsInstruction }

func (self *IXOR) Execute(frame *rtda.Frame) {
	stack := frame.OperandStack()
	v1 := stack.PopInt()
	v2 := stack.PopInt()
	result := v1 ^ v2
	stack.PushInt(result)
}

// Boolean XOR long
type LXOR struct{ base.NoOperandsInstruction }

func (self *LXOR) Execute(frame *rtda.Frame) {
	stack := frame.OperandStack()
	v1 := stack.PopLong()
	v2 := stack.PopLong()
	result := v1 ^ v2
	stack.PushLong(result)
}