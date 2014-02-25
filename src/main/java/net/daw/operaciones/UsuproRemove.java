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
import net.daw.bean.UsuproBean;
import net.daw.dao.UsuproDao;
import net.daw.helper.Conexion;



/**
 *
 * @author rafa
 */
public class UsuproRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            UsuproDao oUsuproDAO = new UsuproDao(Conexion.getConection());
            UsuproBean oUsupro = new UsuproBean();                                           
            oUsupro.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oUsupro != null) {
                oUsuproDAO.remove(oUsupro);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oUsupro.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("UsuproRemoveJson: View Error: " + e.getMessage());
        }
    }
}
