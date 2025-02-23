import java.sql.*;
public class InsertJDBC {
    
    public static void main(String args[])
    {
        CreateCon obj = new CreateCon();
        Connection con =null;
        PreparedStatement  pstmt=null;
        try{
            con =DriverManager.getConnection(obj.getUrl(),obj.getUsername(),obj.getPassword()); // 👈 Create Connection 
            String query = "Insert INTO users(first_name,last_name,email,password,age) values(?,?,?,?,?)"; // 👈 Query
            pstmt = con.prepareStatement(query); // 👈 PrepareStatement 
            pstmt.setString(1, "Saran"); // 👈 In your query you have a ? you want do this
            pstmt.setString(2,"Kandhasamy"); //👈 In your query you have a ? you want do this
            pstmt.setString(3,"sarank@gmail.com"); // 👈 In your query you have a ? you want do this
            pstmt.setString(4,"passwordS"); // 👈 In your query you have a ? you want do this
            pstmt.setInt(5, 21); // 👈 In your query you have a ? you want do this
            int rowsInsert = pstmt.executeUpdate(); // 👈 Except "Select" query you need to use executeUpdate()
            if(rowsInsert > 0)
                System.out.println("Record Insert Successfully");
            String sql = "Select user_id,first_name,last_name,age from users"; // 👈 Query
            Statement st  = con.createStatement(); // 👈 For Print you can use createStatement instend of PrepareStatement 
            ResultSet rs = st.executeQuery(sql); // 👈 For execute "Select" query use executeQuery 
            while(rs.next())
            {
                System.out.println("Id = "+ rs.getInt("user_id") + "First_Name = "+ rs.getString("first_name")+" Age = "+rs.getInt("age"));
            }

            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
