package constants

import "jvmGo/ch05/instructions/base"
import "jvmGo/ch05/rtda"
// Do nothing
type NOP struct{ 
	base.NoOperandsInstruction 
}

func (self *NOP) Execute(frame *rtda.Frame) {

}