import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateJDBC {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the you want to change : ");
        String name = Sc.nextLine();
        CreateCon obj = new CreateCon();
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(obj.getUrl(), obj.getUsername(), obj.getPassword()); // 👈 Create Connection 
            String query = "Update users Set email = 'sarank@email.com' where first_name = ? "; // 👈 Query
            pstmt = con.prepareStatement(query); // 👈 PrepareStatement 
            pstmt.setString(1, name); // 👈 In your query you have a ? you want do this
            int rowsUpdate = pstmt.executeUpdate(); // 👈 Except "Select" query you need to use executeUpdate()
            if(rowsUpdate > 0)
                System.out.println(" Updated Successfully ");
            String sql = "Select email from users where first_name = ? "; // 👈 Query
            pstmt = con.prepareStatement(sql); // 👈 PrepareStatement
            pstmt.setString(1, name); // 👈 In your query you have a ? you want do this
            ResultSet rs = pstmt.executeQuery(); // 👈 For execute "Select"  query use executeQuery
            while (rs.next()) {
                System.out.println("Email " + rs.getString("email"));
            }
            con.close();
            Sc.close();            
        } catch (SQLException e) {
              System.out.println("ERROR : "+e.getMessage());
        }

    }
}
