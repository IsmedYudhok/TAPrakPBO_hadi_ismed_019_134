/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.*;
import java.util.*;
import model.*;
import database.Koneksi;
import DaoImplement.LoginImplement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.DataView;
/**
 *
 * @author ACER
 */
public class LoginDao implements LoginImplement {
    Connection connection;
    
    final String select = "SELECT *FROM  login ";
    final String insert = "INSERT INTO login (username,password) VALUES(?,?);";
    
    public LoginDao (){
    connection = Koneksi.connection();
    }
    
    @Override
    public void insert (LoginModel l){
        PreparedStatement statement = null; 
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, l.getUsername());
            statement.setString(2, l.getPassword());
            statement.setString(3, "user");
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                l.setUsername(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<LoginModel> getAll() {
        List<LoginModel> du = null;
        try {
            du = new ArrayList<LoginModel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                LoginModel user = new LoginModel();
               
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                
                du.add(user);
            }
        } catch(SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return du;
    }
    @Override
    public Integer check(LoginModel l) {
        Integer a = 0;
        
        String check = "SELECT * FROM login WHERE username = ? AND password = ?;";
        
        try {
            PreparedStatement st = connection.prepareStatement(check, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setString(1, l.getUsername());
            st.setString(2, l.getPassword());
            ResultSet rs = st.executeQuery();
            if (rs.next() == false) {
                            JOptionPane.showMessageDialog(null, "Invalid Username/Password!");
                        } else {
                            rs.beforeFirst();
                            while (rs.next()) {
                                String admin = rs.getString("username");
                                DataView dat = new DataView();
                                dat.setVisible(true);
                            }
                        }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
    }


