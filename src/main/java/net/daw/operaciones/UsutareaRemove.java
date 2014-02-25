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
import net.daw.bean.UsutareaBean;
import net.daw.dao.UsutareaDao;
import net.daw.helper.Conexion;



/**
 *
 * @author rafa
 */
public class UsutareaRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            UsutareaDao oUsutareaDAO = new UsutareaDao(Conexion.getConection());
            UsutareaBean oUsutarea = new UsutareaBean();                                           
            oUsutarea.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oUsutarea != null) {
                oUsutareaDAO.remove(oUsutarea);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oUsutarea.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("UsutareaRemoveJson: View Error: " + e.getMessage());
        }
    }
}
