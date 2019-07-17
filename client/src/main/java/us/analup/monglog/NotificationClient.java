package us.analup.monglog;

/**
 * Hello world!
 *
 */
public class NotificationClient {
	
	
	public NotificationClient(){
		try {
			new ClassloadManager(false);
			System.out.println("ready ...");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new NotificationClient();
	}
}
