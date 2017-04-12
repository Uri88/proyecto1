/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofase2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author msimm
 */
public class ConexionDB {

    private Connection con;
    
    public Connection getConexionDB() {
    
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.9:1521:db12102","practica", "practica");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return con;
    }
    
    /**}
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Statement  statement = null;
        Connection conexion = null;
        
        try {
            ConexionDB cdb = new ConexionDB();
            
             conexion = cdb.getConexionDB();
            
             statement = conexion.createStatement();
            String insertTableSQL = "INSERT INTO CENTRO_TRABAJO " +
       "(COD_CENTRO ,PROVINCIA_CENTRO ,NOMBRE_CENTRO , NUMERO_CENTRO , CIUDAD_CENTRO , CALLE_CENTRO ,CODIGO_POSTAL_CENTRO , TELEFONO_CENTRO) "+
      "VALUES (1,'aa','aa',1,'aa','aa',11,11)";

           // execute insert SQL stetement
            statement.executeUpdate(insertTableSQL);
            statement.close();
            conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }

}

