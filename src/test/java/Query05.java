import java.sql.*;

public class Query05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "3235");

        //Statement st = con.createStatement();

        PreparedStatement ps= con.prepareCall("select * from ogrenciler");
        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd=rs.getMetaData();

        System.out.println("1.Sutunun ismi: " + rsmd.getColumnName(1));
        System.out.println("2.Sutunun ismi: " + rsmd.getColumnName(2));
        System.out.println("3.Sutunun ismi:  " + rsmd.getColumnName(3));
        System.out.println("4.Sutunun ismi: " + rsmd.getColumnName(4));

        System.out.println("Toplam sutun sayısı: "+rsmd.getColumnCount());
        System.out.println("=============================================================================");
        System.out.println("1.sutunun data type : "+rsmd.getColumnTypeName(1));
        System.out.println("2.sutunun data type : "+rsmd.getColumnTypeName(2));
        System.out.println("3.sutunun data type : "+rsmd.getColumnTypeName(3));
        System.out.println("4.sutunun data type : "+rsmd.getColumnTypeName(4));

        System.out.println("=============================================================================");

        System.out.println("Tablonun ismi: "+rsmd.getTableName(1));
        System.out.println("Sutun sayısı: "+rsmd.getColumnCount());

        while (rs.next()){
            System.out.printf("%-6d %-15.15s %-8s\n", rs.getInt(1), rs.getString(2), rs.getString(3)+rs.getString(4));
        }

    }
}
