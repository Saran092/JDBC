import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteJDBC {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the name you want to delete for DB : ");
        String name = Sc.nextLine();
        CreateCon obj = new CreateCon();
        Connection con = null;
        try {
            con = DriverManager.getConnection(obj.getUrl(), obj.getUsername(), obj.getPassword()); // 👈 Create Connection 
            String query ="Delete from users where first_name = ?  "; // 👈 Query 
            PreparedStatement pstmt = con.prepareStatement(query); // 👈 PrepareStatement 
            pstmt.setString(1, name); // 👈 In your query you have a ? you want do this 
            int rowsDelete = pstmt.executeUpdate(); // 👈 Except "Select" query you need to use executeUpdate()
            if(rowsDelete > 0)
                System.out.println(" Delete Successfully ");
                con.close();
                Sc.close();
        } catch (SQLException e) {
            System.out.println("ERROR : "+e.getMessage());
        }
    }
}
