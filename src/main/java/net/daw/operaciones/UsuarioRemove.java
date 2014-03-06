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
import net.daw.bean.UsuarioBean;
import net.daw.dao.UsuarioDao;
import net.daw.helper.Conexion;




public class UsuarioRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        
        Map<String, String> data = new HashMap<>();
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {   

        try {
            UsuarioDao oUsuarioDAO = new UsuarioDao(Conexion.getConection());
            UsuarioBean oUsuario = new UsuarioBean();                                           
            oUsuario.setId(Integer.parseInt(request.getParameter("id")));            

            if (oUsuario != null) {
                oUsuarioDAO.remove(oUsuario);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oUsuario.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("UsuarioRemoveJson: View Error: " + e.getMessage());
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
