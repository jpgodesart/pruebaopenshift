/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.TareaBean;
import net.daw.dao.TareaDao;
import net.daw.helper.Conexion;

/**
 *
 * @author al037684
 */
public class TareaGet implements GenericOperation {
 
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                TareaDao oTareaDAO = new TareaDao(Conexion.getConection());
                TareaBean oTarea = new TareaBean();
                oTarea.setId(Integer.parseInt(request.getParameter("id")));
                oTareaDAO.get(oTarea);                                
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("dd/MM/yyyy");
                Gson gson = gsonBuilder.create();
                data = gson.toJson(oTarea);                
                //data = new Gson().toJson(oTarea);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("TareaGetJson: View Error: " + e.getMessage());
        }
    }
}
