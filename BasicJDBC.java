import java.sql.*;

public class Demo {
    public static void main(String[] args) {
        String sql = "Select id,name from product where type ='Laptop'";
        CreateCon obj = new CreateCon();
        try{

            Connection con = DriverManager.getConnection(obj.getUrl(),obj.getUsername(),obj.getPassword()); // 👈 get Connection to the Database
            System.out.println("Database Connected Successfully");
            Statement st = con.createStatement(); // 👈 Create a statement
            ResultSet rs = st.executeQuery(sql); // 👈 execute the SQL Query
            while(rs.next()) // 👈 travels to that position
                System.out.println("Id :" +rs.getInt("id") + " ,Name : " + rs.getString("name"));
            con.close(); // 👈 Don't forget to close the connection
        }
        catch (SQLException e)
        {
            System.out.println("\n"+e.getMessage());
        }
        
    }
}