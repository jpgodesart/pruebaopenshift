/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ProyectoBean;
import net.daw.dao.ProyectoDao;
import net.daw.helper.Conexion;



/**
 *
 * @author rafa
 */
public class ProyectoRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            ProyectoDao oProyectoDAO = new ProyectoDao(Conexion.getConection());
            ProyectoBean oProyecto = new ProyectoBean();                                           
            oProyecto.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oProyecto != null) {
                oProyectoDAO.remove(oProyecto);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oProyecto.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("ProyectoRemoveJson: View Error: " + e.getMessage());
        }
    }
}
