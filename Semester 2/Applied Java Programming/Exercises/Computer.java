public class Computer
{
 public static void main(String[] args)
 {
 Mailbox mailbox = new Mailbox(20);
 Program program1 = new Program("Windows", "update", 30);
 Program program2 = new Program("AVG", "update virus database", 5);
 Program program3 = new Program("FBackup",
 "perform a scheduled backup", 3);
 Program program4 = new Program("Skype",
 "notify you about a person logging in", 17);
 System.out.println("---->Turning on the computer");
 program1.start();
 program2.start();
 program3.start();
 program4.start();
 mailbox.start();
 }
}