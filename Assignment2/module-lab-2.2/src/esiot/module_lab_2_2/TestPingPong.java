package esiot.module_lab_2_2;

/**
 * 
 * Testing simple message passing.
 * 
 * To be used with an Arduino connected via Serial Port
 * running module-lab-2.2/remote_pingpong/remote_pingpong.ino
 * 
 * @author aricci
 *
 */
public class TestPingPong {

	public static void main(String[] args) throws Exception {
		
		//CommChannel channel = new SerialCommChannel(args[0],9600);	
		
		 CommChannel channel = new SerialCommChannel("COM5",9600);	
		
		
		/* Waiting Arduino rebooting */
		
		System.out.println("Waiting Arduino for rebooting...");		
		Thread.sleep(4000);
		System.out.println("Ready.");		

		System.out.println("Done. Let's start.");		
		
		while (true){
			System.out.println("Sending ping");
			channel.sendMsg("ping");
			String msg = channel.receiveMsg();
			System.out.println("Received: "+msg);		
			Thread.sleep(500);
		}
	}

}