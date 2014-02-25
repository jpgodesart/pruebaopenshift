/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.bean.UsuproBean;
import net.daw.helper.Conexion;


public class UsuproDao extends GenericDaoImplementation<UsuproBean> {

    public UsuproDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "usupro");
    }

}
