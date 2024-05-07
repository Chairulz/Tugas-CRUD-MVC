/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author afriz
 */
public class connector {
    static Connection connect;
    
    public static Connection connection(){
        if(connect == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("movie_db");
            data.setUser("root");
            data.setPassword("");
            try{
                connect = data.getConnection();
                System.out.println("Koneksi Berhasil!");
            }catch(SQLException ex){
                ex.printStackTrace();
                System.out.println("Koneksi Gagal!");
            }
        }
        return connect;
    }
}
