import java.sql.SQLException;
//interface Mobil
public interface Mobil {

    public int kodeMobil(int iharga) throws SQLException;
    public String admin(String iadm);
    public String pelanggan(String ipelanggan);
    public int harga(int iharga);
    public String tanggal(int iharga);
    public float car1(int iharga);
    public float car2(int iharga);
}
