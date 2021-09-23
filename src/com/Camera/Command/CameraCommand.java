package Camera.Command;

interface Command
{
	public void execute();
}


// classes
class Light
{
	public void turnOn()
	{
		System.out.println("Camera Light Is On");
	}
	public void turnOff()
	{
		System.out.println("Camera Light Is Of");
	}
}
class LightOnCommand implements Command
{
	Light light;

	//Light Control
	public LightOnCommand(Light light)
	{
	this.light = light;
	}
	public void execute()
	{
	light.turnOn();
	}
}
class LightOffCommand implements Command
{
	Light light;
	public LightOffCommand(Light light)
	{
		this.light = light;
	}
	public void execute()
	{
		light.turnOff();
	}
}

//Camera and its Command
class Camera
{
	public void startRecording()
	{
		System.out.println("Camera Recording");
	}
	public void stopRecording()
	{
		System.out.println("Camera recording Stopped");
	}
	public void cameraCapture()
	{
		System.out.println("Capturing Image");
	}
	
	}

class CameraCommand implements Command
{
	Camera camera;
	public CameraCommand(Camera camera)
	{
		this.camera = camera;
	}
	public void execute()
	{
	camera.stopRecording();
	}
}
class CameraWithCommand implements Command
{
	Camera camera;
	public CameraWithCommand(Camera camera)
	{
		this.camera = camera;
	}
	public void execute()
	{
		camera.startRecording();
                camera.stopRecording();
		camera.cameraCapture();
	}
}
// A Simple remote control with one button
class SimpleCameraControl
{
	Command slot; 

	public SimpleCameraControl()
	{
	}

	public void setCommand(Command command)
	{
		
		slot = command;
	}

	public void buttonWasPressed()
	{
		slot.execute();
	}
}


class RemoteControlTest
{
	public static void main(String[] args)
	{
		SimpleCameraControl control =
				new SimpleCameraControl();
		Light light = new Light();
		Camera camera = new Camera();

		// we can change command dynamically
		control.setCommand(new
					LightOnCommand(light));
		control.buttonWasPressed();
		control.setCommand(new
				CameraWithCommand(camera));
		control.buttonWasPressed();
		control.setCommand(new
				CameraCommand(camera));
		control.buttonWasPressed();
	}
}

