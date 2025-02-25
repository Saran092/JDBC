import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RenameColumn {
    public static void main(String[] args) {
        CreateCon obj = new CreateCon();
        try {
            Connection con = DriverManager.getConnection(obj.getUrl(), obj.getUsername(), obj.getPassword());
            String query = "Alter table users change column last_name sure_name varchar(255)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();
            System.out.println("Column Renamed Successfully..");
            con.close();
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }
}
