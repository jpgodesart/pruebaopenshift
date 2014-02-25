/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

/**
 *
 * @author rafa
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.daw.bean.UsuproBean;
import net.daw.dao.UsuproDao;
import net.daw.helper.Conexion;


public class UsuproGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
               UsuproDao oUsuproDAO = new UsuproDao(Conexion.getConection());
                UsuproBean oUsupro = new UsuproBean();
                oUsupro.setId(Integer.parseInt(request.getParameter("id")));
                oUsuproDAO.get(oUsupro);
                data = new Gson().toJson(oUsupro);
                
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("UsuproGetJson: View Error: " + e.getMessage());
        }
    }
}