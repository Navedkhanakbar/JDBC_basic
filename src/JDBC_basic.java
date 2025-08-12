import java.sql.*;

public class JDBC_basic {

    public static void main(String[] args) {

        try{
            //1. load drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. connect to db
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_my_db", "root", "Naved");

            //3. create statement
            Statement stmt = con.createStatement();

//            Statement stmt2 = con.createStatement();

            //4. Execute query
            ResultSet rs = stmt.executeQuery("select * from employee");
//            var rows = stmt2.executeUpdate("UPDATE employee SET first_name='Al-fiya' WHERE emoloyee_id=1");


            //5. process result
            while (rs.next()) {
                System.out.println(rs.getInt("emoloyee_id")+ " " + rs.getString("first_name"));
            }

            var rows = stmt.executeUpdate("UPDATE employee SET first_name='al-fiya' WHERE emoloyee_id=1");

            //var column = stmt.executeUpdate("insert into employee value(2,'naved','khan',2.99,'2004-03-12')");

            //6. close resources

            rs.close();
            stmt.close();
            con.close();




        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
