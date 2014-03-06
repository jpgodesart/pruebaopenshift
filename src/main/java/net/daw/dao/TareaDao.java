/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.bean.TareaBean;
import net.daw.helper.Conexion;


public class TareaDao extends GenericDaoImplementation<TareaBean> {   
    
    public TareaDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion,"tarea");
    }
    
}
