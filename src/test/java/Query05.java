import java.sql.*;

public class Query05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "3235");

        //Statement st = con.createStatement();

        PreparedStatement ps= con.prepareCall("select * from ogrenciler");
        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd=rs.getMetaData();

        System.out.println("rsmd.getColumnName(1) = " + rsmd.getColumnName(1));
        System.out.println("rsmd.getColumnName(2) = " + rsmd.getColumnName(2));
        System.out.println("rsmd.getColumnName(3) = " + rsmd.getColumnName(3));
        System.out.println("rsmd.getColumnName(4) = " + rsmd.getColumnName(4));


    }
}
