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
import net.daw.bean.TareaBean;
import net.daw.dao.TareaDao;
import net.daw.helper.Conexion;

/**
 *
 * @author al037684
 */
public class TareaRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            TareaDao oTareaDAO = new TareaDao(Conexion.getConection());
            TareaBean oTarea = new TareaBean();                                           
            oTarea.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oTarea != null) {
                oTareaDAO.remove(oTarea);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oTarea.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("TareaRemoveJson: View Error: " + e.getMessage());
        }
    }
}
