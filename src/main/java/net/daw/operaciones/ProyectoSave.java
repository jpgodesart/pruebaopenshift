/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ProyectoBean;
import net.daw.dao.ProyectoDao;
import net.daw.helper.Conexion;
import net.daw.helper.EncodingUtil;



/**
 *
 * @author rafa
 */
public class ProyectoSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            ProyectoDao oProyectoDAO = new ProyectoDao(Conexion.getConection());
            ProyectoBean oProyecto = new ProyectoBean();
            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oProyecto = gson.fromJson(jason, oProyecto.getClass());
            Map<String, String> data = new HashMap<>();
            if (oProyecto != null) {
                oProyecto = oProyectoDAO.set(oProyecto);
                data.put("status", "200");
                data.put("message", Integer.toString(oProyecto.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("ProyectoSaveJson: View Error: " + e.getMessage());
        }
    }
}
