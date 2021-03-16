package constants

import "jvmGo/ch06/instructions/base"
import "jvmGo/ch06/rtda"
// Do nothing
type NOP struct{ 
	base.NoOperandsInstruction 
}

func (self *NOP) Execute(frame *rtda.Frame) {

}