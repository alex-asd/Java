
public interface IChannel 
{
	String call(String message);
	String accept();
	void reply(String answer);
}
