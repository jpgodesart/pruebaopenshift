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
import net.daw.bean.UsutareaBean;
import net.daw.dao.UsutareaDao;
import net.daw.helper.Conexion;


public class UsutareaGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
               UsutareaDao oUsutareaDAO = new UsutareaDao(Conexion.getConection());
                UsutareaBean oUsutarea = new UsutareaBean();
                oUsutarea.setId(Integer.parseInt(request.getParameter("id")));
                oUsutareaDAO.get(oUsutarea);
                data = new Gson().toJson(oUsutarea);
                
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("UsutareaGetJson: View Error: " + e.getMessage());
        }
    }
}