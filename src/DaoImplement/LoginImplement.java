/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoImplement;
import java.util.List;
import model.*;

/**
 *
 * @author ACER
 */
public interface LoginImplement {
    public void insert (LoginModel l);
    public List<LoginModel> getAll();
    public Integer check (LoginModel l);
}
