import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class AddColumnJDBC{
    public static void main(String[] args) {
        CreateCon obj = new CreateCon();
        try {
            Connection con = DriverManager.getConnection(obj.getUrl(), obj.getUsername(), obj.getPassword());
            String query = "Alter table users Add nickname Varchar(50)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();
            System.out.println("Column Add Successfully..");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}