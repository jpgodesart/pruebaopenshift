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
import net.daw.bean.UsutareaBean;
import net.daw.dao.UsutareaDao;
import net.daw.helper.Conexion;
import net.daw.helper.EncodingUtil;

/**
 *
 * @author rafa
 */
public class UsutareaSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            UsutareaDao oUsutareaDAO = new UsutareaDao(Conexion.getConection());
            UsutareaBean oUsutarea = new UsutareaBean();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oUsutarea = gson.fromJson(jason, oUsutarea.getClass());
            Map<String, String> data = new HashMap<>();
            if (oUsutarea != null) {
                oUsutarea = oUsutareaDAO.set(oUsutarea);
                data.put("status", "200");
                data.put("message", Integer.toString(oUsutarea.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("UsutareaSaveJson: View Error: " + e.getMessage());
        }
    }
}
