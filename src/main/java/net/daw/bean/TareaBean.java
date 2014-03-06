/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

import java.util.Date;


public class TareaBean {
    
    private Integer id = 0;
    private String nombre = "";
    private String descripcion = "";
    private Integer id_estado = 0;
    private Integer id_proyecto = 0;
    private Integer id_usuario = 0;
    
    
    
    public TareaBean () {       
    }
    
    public TareaBean(Integer intId) {
        this.id = intId;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public Integer getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }



    
    
    
}
