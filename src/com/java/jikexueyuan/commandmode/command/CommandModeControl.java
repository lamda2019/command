package com.java.jikexueyuan.commandmode.command;

import java.util.Stack;

import com.java.jikexueyuan.commandmode.Control;
import com.java.jikexueyuan.commandmode.device.Light;
import com.java.jikexueyuan.commandmode.device.Stereo;

public class CommandModeControl implements Control{
	private Command[] onCommands;
	private Command[] offCommands;
	private Stack<Command> stack=new Stack<Command>();
	public CommandModeControl()
	{
		onCommands=new Command[5];
		 offCommands=new Command[5];
		
		 Command noCommand=new NoCommand();
		 //初始化
		 for(int i=0,len=onCommands.length;i<len;i++) {
			 onCommands[i]=noCommand;
			 offCommands[i]=noCommand;
		 }
		 
	}
	
	public void setCommand(int slot,Command onCommand,Command offCommand)
	{
		onCommands[slot]=onCommand;
		 offCommands[slot]=offCommand;
		
	}

	@Override
	public void onButton(int slot) {
		
		onCommands[slot].execute();
		stack.push(onCommands[slot]);
	}

	@Override
	public void offButton(int slot) {
		
		offCommands[slot].execute();
		stack.push(offCommands[slot]);
	}

	@Override
	public void undoButton() {
		// TODO Auto-generated method stub
		stack.pop().undo();
	}

}
