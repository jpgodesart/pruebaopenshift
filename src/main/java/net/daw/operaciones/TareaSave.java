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
import net.daw.bean.TareaBean;
import net.daw.dao.TareaDao;
import net.daw.helper.Conexion;
import net.daw.helper.EncodingUtil;


/**
 *
 * @author al037684
 */
public class TareaSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            TareaDao oTareaDAO = new TareaDao(Conexion.getConection());
            TareaBean oTarea = new TareaBean();            
            Gson gson=  new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oTarea = gson.fromJson(jason, oTarea.getClass());
            Map<String, String> data = new HashMap<>();
            if (oTarea != null) {
                oTarea = oTareaDAO.set(oTarea);
                data.put("status", "200");
                data.put("message", Integer.toString(oTarea.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("TareaSaveJson: View Error: " + e.getMessage());
        }
    }
}
