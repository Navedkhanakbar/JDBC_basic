import java.sql.*;

public class Student_db {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_schema";
        String user = "root";
        String password= "Naved";


        try {
            //1. load drivers
            Class.forName("com.mysql.cj.jdbc.Driver");


            //2. connect to database
            Connection con = DriverManager.getConnection(url,user,password);


            //----------------create (Insert) -------------------
            String insertsql_query = "insert into student (first_name,age) value (?,?)";
            PreparedStatement prestmt = con.prepareStatement(insertsql_query);
            prestmt.setString(1,"Al-fiya");
            prestmt.setInt(2,22);
            int rowinserted = prestmt.executeUpdate();
            System.out.println("inserted rows " + rowinserted);

            //------------------read (Select) --------------------
            String select_query = "select * from student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(select_query);
            System.out.println("\n-----student record-----");
            while (rs.next()) {
                System.out.println("Student id "+ rs.getInt("id")+" | "
                        + "Student first name " + rs.getString("first_name")+ " | "
                        + "student age "+ rs.getInt("age"));
            }

            //---------------Update-----------------
            String update_query = "update student set age = ? where first_name = ?";
            PreparedStatement preupdate = con.prepareStatement(update_query);
            preupdate.setInt(1,22);
            preupdate.setString(2,"Al-fiya");
            var rowUpdated = preupdate.executeUpdate();
            System.out.println("Updated the student table on index number "+ rowUpdated);


            //-----------------delete------------------
            String del_row = "delete from student where first_name = ?";
            PreparedStatement delstmt = con.prepareStatement(del_row);
            delstmt.setString(1,"Al-fiya");
            var rowdeleted = delstmt.executeUpdate();
            System.out.println("deleted the rows that contains alfiya: "+ rowdeleted);


            //3.

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
