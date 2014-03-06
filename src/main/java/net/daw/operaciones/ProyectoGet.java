/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.daw.bean.ProyectoBean;
import net.daw.dao.ProyectoDao;
import net.daw.helper.Conexion;


public class ProyectoGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                ProyectoDao oProyectoDAO = new ProyectoDao(Conexion.getConection());
                ProyectoBean oProyecto = new ProyectoBean();
                oProyecto.setId(Integer.parseInt(request.getParameter("id")));
                oProyectoDAO.get(oProyecto);
              
                GsonBuilder gsonBuilder = new GsonBuilder();
                //gsonBuilder.setDateFormat("dd/MM/yyyy");
                Gson gson = gsonBuilder.create();
                data = gson.toJson(oProyecto);      
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("ProyectoGetJson: View Error: " + e.getMessage());
        }
    }
}