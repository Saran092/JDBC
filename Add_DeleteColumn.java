import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Add_DeleteColumn{
    public static void main(String[] args) {
        String query;
        PreparedStatement pstmt = null;
        Statement st = null;
        ResultSet rs = null;
        CreateCon obj = new CreateCon();
        try {
            Connection con = DriverManager.getConnection(obj.getUrl(), obj.getUsername(), obj.getPassword());
            query = "Alter table users Add nickname Varchar(50) default 'Guest' ";
            pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();
            System.out.println("Column Add Successfully..");
            query = "Select nickname from users";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next())
                System.out.println("Nick Name : "+rs.getString("nickname"));
            query = "Alter table users drop column nickname";
            pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();
            System.out.println("Column Delete Successfully..");
            query = "Select * from users ";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next())
                System.out.println("Name : "+rs.getString("first_name"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}