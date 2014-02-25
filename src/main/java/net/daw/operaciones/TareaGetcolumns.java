/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.dao.TareaDao;
import net.daw.helper.Conexion;

/**
 *
 * @author al037684
 */
public class TareaGetcolumns implements GenericOperation {
 
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<String> alColumns = null;
        try {
            TareaDao oTareaDAO = new TareaDao(Conexion.getConection());
            alColumns = oTareaDAO.getColumnsNames();
            String data = new Gson().toJson(alColumns);
            data = "{\"data\":" + data + "}";
            return data;
        } catch (Exception e) {
            throw new ServletException("TareaGetcolumnsJson: View Error: " + e.getMessage());
        }
    }
    
}
