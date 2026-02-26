
import java.util.Scanner;
public class Main
{
 
	public static void main(String[] args)
	{
	    Scanner input =new Scanner(System.in);
	    PassManager manager=new PassManager();
	    
	 while (true)
	 {
            System.out.println("\n1.Save Password");
            System.out.println("2.Change Password");
            System.out.println("3.View Passwords");
            System.out.println("4.Delete Password");
            System.out.println("5.Exit");
            System.out.print("Choose option:");

            int choice=input.nextInt();
            input.nextLine(); 

            switch (choice)
            {
                case 1:
                   System.out.println("Enter app Name");
                   String app=input.nextLine();
                   System.out.println("Enter Password");
                   String pass=input.nextLine();
                   manager.savepass(app,pass);
                    break;
                case 2:
                    System.out.println("Enter app Name");
                    app=input.nextLine();
                    System.out.print("Enter old password");
                    String oldPass = input.nextLine();
                    System.out.print("Enter new password");
                    String newPass = input.nextLine();
                    manager.changepass(app,oldPass,newPass);
                    break;
                case 3:
                    manager.viewPasswords();
                    break;
                case 4:
                    System.out.print("Enter app name: ");
                    app=input.nextLine();
                    manager.Deletepass(app);
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
	}
}