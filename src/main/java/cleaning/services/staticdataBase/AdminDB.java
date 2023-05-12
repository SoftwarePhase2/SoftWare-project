package cleaning.services.staticdatabase;

import java.util.ArrayList;
import java.util.List;
import model.AdminInfo;

public class AdminDB {
	static List <AdminInfo> admins=new ArrayList<AdminInfo>();
        
	private AdminDB() {
	    throw new IllegalStateException("Utility class");
	}
        static{
        	admins.add(new AdminInfo("ahmad","123456"));
        	admins.add(new AdminInfo("ahmad","true Pass"));
        	admins.add(new AdminInfo("mohammad","654da"));
        	admins.add(new AdminInfo("salah","Salah"));
        	
        }
        


	public static List<AdminInfo> getAdmins() {
		return admins;
	}

	public static void addAdmin(String username,String password) {
		admins.add(new AdminInfo(username, password));
	}

	
}
