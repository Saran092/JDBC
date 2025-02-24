import java.util.*;
import java.sql.*;
public class CreateDB {
    
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter your DataBase Name : ");
        String DBName = Sc.nextLine();
        CreateCon obj = new CreateCon();
        Connection con = null;
        try {
            con = DriverManager.getConnection(obj.getUrl(), obj.getUsername(), obj.getPassword());
            String sql = "Create table "+ DBName + "(id INT  Primary Key,name varchar(50))";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Create Successfully");
            con.close();
            Sc.close();
            
        } catch (Exception e) {
            System.out.println("ERROR : "+e.getMessage());
        }
    }
}
