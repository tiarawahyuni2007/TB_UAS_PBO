import java.util.Scanner;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap; 

//class App;
public class App {

    static Connection con;

    //constructor class App
    public App(){

    }

    public static void main(String[] args){
    String url = "jdbc:mysql://localhost:3306/rental_mobil";
    //exception
    try {
        //collection framework hashmap
        HashMap<String, String> admin = new HashMap<String, String>();
        admin.put("tiara", "tiara");
        admin.put("wahyuni", "wahyuni");
        admin.put("rama", "rama");

    
        Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,"root","");
        Scanner i = new Scanner(System.in);
        LocalDateTime myDateObj = LocalDateTime.now();//set tanggal dan waktu secara realtime

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        
        boolean lanjut = true;
        Rental j = new Rental();
        String iadm;
		System.out.println("Driver Set for Admin READY!");
        System.out.print("Admin     : ");
        //method string lowercase
        iadm = i.nextLine().toLowerCase();
        //percabangan
        if(admin.get(iadm)!=null){
            //looping
                do{
                    Clean.clearScreen();
                    System.out.println("\n\n==================================");
                    System.out.println("|         list of actions          |");
                    System.out.println("==================================");
                    System.out.println("1. Lihat Riwayat Data transaksi");
                    System.out.println("2. Tambah Data Transaksi");
                    System.out.println("3. Edit Data Transaksi");
                    System.out.println("4. Hapus Data Transaksi");
                    System.out.println("5. Cari Data Transaksi");
                    System.out.print("no : ");
                    int menu = Integer.parseInt(i.nextLine());
                    if (menu==1){
                        Clean.clearScreen();
                        j.riwayatTransaksi(iadm);
                    }
                    else if(menu==2){
                       Clean.clearScreen();
                        j.tambahTransaksi(iadm);
                    }
                    else if(menu==3){
                        Clean.clearScreen();
                       j.editTransaksi(iadm);
                    }
                    else if(menu==4){
                        Clean.clearScreen();
                        j.hapusTransaksi(iadm);
                     }
                    else if(menu==5){
                        Clean.clearScreen();
                        j.cariTransaksi(iadm);
                     }    
                    else{
                        Clean.clearScreen();
                        System.out.println("Menu tidak tersedia");
                    }             
                    System.out.print("\n\nKembali? (y/n) : ");
                    String y = i.nextLine();
                    lanjut = y.equalsIgnoreCase("y");
                }while(lanjut); 
            }
                     
            else{
                System.out.println("Account not Found. Program hanya dapat diakses oleh admin yang terdaftar dan berwenang");         
            }
        System.out.println("\nTerima kasih telah menggunakan program ini! \nTiara Wahyuni, "+formattedDate);
        i.close();
    }
    catch (ClassNotFoundException ex) {
        System.err.println("Driver error");
        System.exit(0);
    }
    catch(SQLException e){
        System.err.println("Failed to Connect");
    }
    }
}

