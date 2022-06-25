import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "3235");

        Statement st = con.createStatement();

        // SORU1: Bölümler tablosunda yeni bir kayıt (80, 'ARGE', 'ISTANBUL')

      //int s1= st.executeUpdate("insert into bolumler values(80, 'ARGE', 'ISTANBUL')");

      //System.out.println(s1+"Satir eklendi");

       // executeUpdate eklenen satir sayısını döndürür.


        // SORU2; Bölümler tablosuna birden fazla kayıt ekleyelim.
/*
        String [] veri1 ={"insert into bolumler values(95, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values(85, 'OFİS1', 'ANKARA')",
                "insert into bolumler values(75, 'OFİS2', 'İZMİR')"};

        int count=0;
        for (String each:veri1) {

            count=count+st.executeUpdate(each);
        }
        System.out.println(count + " data eklendi ");
        */
        // 2.yol
/*
        String [] veri2 ={"insert into bolumler values(95, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values(85, 'OFİS1', 'ANKARA')",
                "insert into bolumler values(75, 'OFİS2', 'İZMİR')"};

        for (String each:veri2) {

            st.addBatch(each);// yukarıdaki verilerin tamamını bir araya topluyor
        }
        st.executeBatch();  // Bir araya getirilen verileri tek seferde gönderiyor.

        System.out.println("Veriler database' e eklendi");
*/

        // SORU2; Bölümler tablosuna birden fazla kayıt ekleyelim.

        String [] veri3 ={"insert into bolumler values(100, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values(101, 'OFİS1', 'ANKARA')",
                "insert into bolumler values(103, 'OFİS2', 'İZMİR')",
                "insert into bolumler values(102, 'OFİS2', 'İZMİR')",
                "insert into bolumler values(104, 'OFİS2', 'İZMİR')"};

        for (String each :veri3) {

            st.addBatch(each);
        }
        st.executeBatch();
        System.out.println("verile database eklendi");
    }
}
