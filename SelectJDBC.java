import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectJDBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the age you want to display : ");
        int age = sc.nextInt();
        CreateCon obj = new CreateCon();
        Connection con = null;
        try{
            con = DriverManager.getConnection(obj.getUrl(), obj.getUsername(), obj.getPassword()); // 👈 Create Connection 
            String query ="Select first_name,age from users where age >= ? "; // 👈 Query
            PreparedStatement pstmt = con.prepareStatement(query); // 👈 PrepareStatement 
            pstmt.setInt(1, age); // 👈 In your query you have a ? you want do this
            ResultSet rs = pstmt.executeQuery(); // 👈 For execute "Select" query use executeQuery 
            while (rs.next()) {
                System.out.println("Name : "+ rs.getString("first_name")+" Age : "+rs.getInt("age"));
            }
            con.close();
            sc.close();

        }
        catch(SQLException e)
        {
            System.out.println("ERROR : "+ e.getMessage());
        }
    }
}
