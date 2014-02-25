/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.bean.UsutareaBean;
import net.daw.helper.Conexion;


public class UsutareaDao extends GenericDaoImplementation<UsutareaBean> {

    public UsutareaDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "usutarea");
    }

}
