package manageBean;
import backingBean.user;
import db.DbConnection;

import  javax.faces.bean.ManagedBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class RegisterBean {
private  user userObj;

    public user getUserObj() {
        return userObj;
    }

    public void setUserObj(user userObj) {
        this.userObj = userObj;
    }

    public RegisterBean()
    {
userObj = new user();
    }
    public String registerUser(){
        System.out.println("Function Access");

        System.out.println(userObj.getName());
        System.out.println(userObj.getEmail());
        System.out.println(userObj.getPassword());

        DbConnection db = new DbConnection();

        db.insertRecord(userObj.getName(),userObj.getEmail(),userObj.getPassword());

        System.out.println("Values Displayed ");
        return "";
    }

    public List<user> getUsers() throws SQLException {

        List<user> users = new ArrayList<user>();
DbConnection db = new DbConnection();
        ResultSet data = db.getRecords();
user muser;
 try {
     while (data.next()) {
         muser = new user();
         muser.setName(data.getString("name"));
         muser.setEmail(data.getString("email"));
         muser.setPassword(data.getString("password"));

         users.add(muser);
     }
 }catch (Exception ex)
 {
     ex.printStackTrace();
 }
return users;
    }
}
