/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ProyectoBean;
import net.daw.bean.UsuarioBean;
import net.daw.dao.ProyectoDao;
import net.daw.helper.Conexion;




public class ProyectoRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, String> data = new HashMap<>();
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {   
        try {
            ProyectoDao oProyectoDAO = new ProyectoDao(Conexion.getConection());
            ProyectoBean oProyecto = new ProyectoBean();
            
        //Parte para saber el tipo de usuario

            
            oProyecto.setId(Integer.parseInt(request.getParameter("id")));            
            
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
        
        }else{
            data.put("status", "error");
            data.put("message", "No tienes permisos");
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;
        }
    }
}
