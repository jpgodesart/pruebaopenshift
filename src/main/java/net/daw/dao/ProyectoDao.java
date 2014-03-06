/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.bean.ProyectoBean;
import net.daw.helper.Conexion;


public class ProyectoDao extends GenericDaoImplementation<ProyectoBean> {

    public ProyectoDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "proyecto");
    }

}
