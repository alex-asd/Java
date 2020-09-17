
public class PersonTwoTest {

	public static void main(String[] args)
	{
		/*MyDate jonBday = new MyDate(22, 02, 1997);
		MyDate nedBday = new MyDate(02, 10, 1970);
		MyDate noOneBday = new MyDate(1, 1, 1);
		MyDate oneDayAhead = new MyDate(MyDate.today());
		oneDayAhead.nextDay();
		PersonTwo jon = new PersonTwo("Jon Snow", "The Wall", jonBday);
		PersonTwo ned = new PersonTwo("Eddard Stark", nedBday);
		PersonTwo noOne = new PersonTwo(noOneBday);
		PersonTwo test = new PersonTwo(oneDayAhead);
		
		System.out.println(jon.getBirthday());
		System.out.println(jon.getAge());
		System.out.println(ned.getBirthday());
		System.out.println(ned.getAge());
		System.out.println(noOne.getBirthday());
		System.out.println(noOne.getAge());
		System.out.println(test.getAge());
		
		System.out.println(jon);
		
		System.out.println(jon.equals(ned));*/
		MyDate caitBday = new MyDate(02, 10, 1970);
		
		PersonTwo cait = new PersonTwo("Caitlyn Stark", "Winterfell", caitBday);
		cait.rememberThis("neshto123123213213");
		cait.rememberThis("neshto2sasassasaasas");
		cait.rememberThis("nema pasasasssasaasas");
		System.out.println(cait.getIQ());
		System.out.println(cait.whatAreYouThinkingAbout());
		System.out.println(cait.doYouRemember("neshto"));
		
	}
}
