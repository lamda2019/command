package com.java.jikexueyuan.commandmode.command;

import com.java.jikexueyuan.commandmode.Control;
import com.java.jikexueyuan.commandmode.TraditionControl;
import com.java.jikexueyuan.commandmode.device.Light;
import com.java.jikexueyuan.commandmode.device.Stereo;

public class ControlTest {

	public static void main(String[] args) {
		CommandModeControl control = new CommandModeControl();
		MarcoCommand onmarco,offmarco;
		Light bedroomlight = new Light("BedRoom");
		Light kitchlight = new Light("Kitch");
		Stereo stereo = new Stereo();
		
		
		//实例化各个房间里的开关状态
		LightOnCommand bedroomlighton = new LightOnCommand(bedroomlight);
		LightOffCommand bedroomlightoff = new LightOffCommand(bedroomlight);
		LightOnCommand kitchlighton = new LightOnCommand(kitchlight);
		LightOffCommand kitchlightoff = new LightOffCommand(kitchlight);

		//开关各放队列中
		 Command[] oncommands={bedroomlighton,kitchlighton};
		 Command[] offcommands={bedroomlightoff,kitchlightoff};

		//批量操作开关
		onmarco=new MarcoCommand(oncommands);
		offmarco=new MarcoCommand(offcommands);

		//音响操作
		StereoOnCommand stereoOn = new StereoOnCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		StereoAddVolCommand stereoaddvol = new StereoAddVolCommand(stereo);
		StereoSubVolCommand stereosubvol = new StereoSubVolCommand(stereo);

		control.setCommand(0, bedroomlighton, bedroomlightoff);
		control.setCommand(1, kitchlighton, kitchlightoff);
		control.setCommand(2, stereoOn, stereoOff);
		control.setCommand(3, stereoaddvol, stereosubvol);
		control.setCommand(4, onmarco, offmarco);

		control.onButton(0);
		control.undoButton();
		//control.offButton(0);
		control.onButton(1);
		control.offButton(1);
		control.onButton(2);
		control.onButton(3);
				
		control.offButton(3);
		control.undoButton();
		control.offButton(2);
		control.undoButton();
		control.onButton(4);
		control.offButton(4);
	}

}
