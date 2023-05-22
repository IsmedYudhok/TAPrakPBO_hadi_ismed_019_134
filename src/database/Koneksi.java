/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Koneksi{
    static Connection kon;
    
    public static Connection connection(){
        if (kon == null){
            MysqlDataSource data= new MysqlDataSource();
            data.setDatabaseName("gudang");
            data.setUser("root");
            data.setPassword("");
            try {
                kon = data.getConnection();
                System.out.println("Koneksi Berhasil!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Koneksi ");
            }
        }
        return kon;
    }
    
}
