/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import DaoImplement.LoginImplement;
import Dao.LoginDao;
import model.*;
import view.DataView;
import view.LoginView;
/**
 *
 * @author ACER
 */
    public class LoginController {
    DataView frame;
    LoginView framelogin;
    LoginImplement impluser;
    List<LoginModel> lm;
    
   
    
    public LoginController(DataView frame){
        this.frame = frame;
        impluser = new LoginDao();
        lm = impluser.getAll();
    }
    
    public LoginController(LoginView frame){
        this.framelogin = frame;
        impluser = new LoginDao();
    }

    public Integer login (LoginModel lm) {
        return impluser.check(lm);
    }
  
}
