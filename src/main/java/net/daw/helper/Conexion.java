/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.helper;


public class Conexion {

    public static enum Tipo_conexion {

        DataSource,
        DriverManager
    };

    public static Conexion.Tipo_conexion getConection() {
        return Conexion.Tipo_conexion.DataSource;
    }

    public static String getDatabaseName() {
        return "jpgodesart";
    }

    public static String getDatabaseLogin() {
        return "adminbrx2Jzn";
    }

    public static String getDatabasePassword() {
        return "v26pWZWz-_mk";
    }

    public static String getDatabasePort() {
        return "3306";
    }

    public static String getDatabaseHost() {
        return "127.4.202.2";
    }
}