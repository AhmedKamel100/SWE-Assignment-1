import java.util.HashMap;
import java.util.Map;

public class PassManager {
   private Map<String,String>passwords;
    public PassManager()
    {
        passwords=new HashMap<>();
    }
     public void savepass( String app, String pass)
    {
        if(passwords.get(app)!=null)
        {
            System.out.println("app already exist");
        }
        else{
            passwords.put(app,pass);
            System.out.println("password for "+app+" saved successfully");
        }
    }
     public void changepass(String app, String oldpass, String newpass )
     {
        if(passwords.get(app)==null)
        {
            System.out.println("There is no app with this name");
        }
        else{
            if(passwords.get(app).equals(oldpass))
            {
                passwords.put(app,newpass);
                System.out.println("password cahnged successfully");
            }
            else{
                System.out.println("wrong password");
            }
        }
    }
     public void viewPasswords( )
     {
        if (passwords.isEmpty()) 
        {
            System.out.println("No passwords saved");
            return;
        }
        for (String app : passwords.keySet()) {
            System.out.println(app + " -> " + passwords.get(app));
        }
    }
    public void Deletepass(String app)
    {
        if(passwords.get(app)==null)
        {
            System.out.println("There is no app with this name");
        }
        else{
            passwords.remove(app);
            System.out.println("Deleted successfully");
        }
    }
}