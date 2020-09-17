
public class Main 
{
	public static void main(String[] args) 
	{
		
		Channel ch = new Channel();
		
		Server srvr = new Server(ch);
		Thread server = new Thread(srvr, "Server");
		
		Client cl = new Client(ch);
		Thread client1 = new Thread(cl, "Client 1");
		Client cl2 = new Client(ch);
		Thread client2 = new Thread(cl2, "Client 2");
		
		server.start();
		client1.start();
		client2.start();
		
	}
}
