/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TareaGetprettycolumns implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String data = "{\"data\": [\"id\", \"nombre\", \"descripcion\", \"id_estado\", \"id_proyecto\",\"id_usupro\"]}";
            return data;
        } catch (Exception e) {
            throw new ServletException("TareaGetprettycolumnsJson: View Error: " + e.getMessage());
        }
    }
}
