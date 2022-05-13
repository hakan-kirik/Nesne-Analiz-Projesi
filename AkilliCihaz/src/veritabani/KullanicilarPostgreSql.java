package veritabani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KullanicilarPostgreSql implements IKullanicilarPostgreSql {

	private Connection baglan() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akilliSogutucu",
                    "postgres", "proje");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

 

    public boolean kullaniciDogrula(Kullanici kullanici) {
        System.out.println("Kullanıcı doğrulanıyor...");

        boolean sonuc = false;

        String sql = "SELECT * FROM \"kullanicilar\" WHERE kullaniciadi = \'" + kullanici.getKullaniciAdi() +
                "\' AND sifre = \'" + kullanici.getSifre() + "\'" ;

        Connection conn = this.baglan();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            sonuc = rs.next();

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sonuc;
    }

   



}
