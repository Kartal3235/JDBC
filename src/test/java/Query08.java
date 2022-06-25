import java.sql.*;

public class Query08 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "3235");


        // STATEEMENT, PREPAREDSTATEMENT FARKI

        // STATEMENT:
        //Statement st = con.createStatement();
        //st.executeUpdate("insert into ogrenciler values (200,'Ali can',10,'E')");

        // PREPAREDSTATEMENT:ifadeler parametre kullanarak yollanabilir.
        PreparedStatement ps = con.prepareStatement("insert into ogrenciler values (?,?,?,?)");
        ps.setInt(1,201);
        ps.setString(2,"Veli Kac");
        ps.setString(3,"11");
        ps.setString(4,"E");
        ps.executeUpdate();
        System.out.println("Veri girişi yapıldı");
    }
}

