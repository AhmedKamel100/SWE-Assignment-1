
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class passmanamger
{
    static Map<String,String>passwords=new HashMap<>();
    static Scanner input=new Scanner(System.in);
    static void savepass()
    {
        System.out.println("Enter app name");
        String app=input.nextLine();
        if(passwords.get(app)!=null)
        {
            System.out.println("app already exist");
        }
        else{
            System.out.println("Enter password");
            String pass=input.nextLine();
            passwords.put(app,pass);
            System.out.println("password for "+app+" saved successfully");
        }
    }
    static void changepass(){
        System.out.println("Enter app name");
        String app=input.nextLine();
        if(passwords.get(app)==null)
        {
            System.out.println("There is no app with this name");
        }
        else{
            System.out.println("Enter old password");
            String oldpass=input.nextLine();
            if(passwords.get(app).equals(oldpass))
            {
                System.out.println("Enter new password");
                String newpass=input.nextLine();
                passwords.put(app,newpass);
                System.out.println("password cahnged successfully");
            }
            else{
                System.out.println("wrong password");
            }
        }
    }
    static void Deletepass(){
        System.out.println("Enter app name");
        String app=input.nextLine();
        if(passwords.get(app)==null)
        {
            System.out.println("There is no app with this name");
        }
        else{
            passwords.remove(app);
            System.out.println("Deleted successfully");
        }
    }
     static void viewPasswords(){
        if (passwords.isEmpty()) {
            System.out.println("No passwords saved");
            return;
        }
        for (String app : passwords.keySet()) {
            System.out.println(app + " -> " + passwords.get(app));
        }
    }
	public static void main(String[] args) {
	 while (true) {
            System.out.println("\n1.Save Password");
            System.out.println("2.Change Password");
            System.out.println("3.View Passwords");
            System.out.println("4.Delete Password");
            System.out.println("5.Exit");
            System.out.print("Choose option:");

            int choice=input.nextInt();
            input.nextLine(); 

            switch (choice){
                case 1:
                    savepass();
                    break;
                case 2:
                    changepass();
                    break;
                case 3:
                    viewPasswords();
                    break;
                case 4:
                    Deletepass();
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