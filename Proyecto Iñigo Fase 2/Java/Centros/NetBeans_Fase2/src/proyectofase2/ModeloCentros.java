/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofase2;

import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msimm
 */
public class ModeloCentros {

    ConexionDB cdb = new ConexionDB();
    Connection conexion;
    Statement  statement = null;
    String sql = null;
 
    public ModeloCentros(Connection con) {
        this.setConexion(con);
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public void addCentro(int codigo, String provincia, String nombre, int numero, String ciudad, String calle, int codigo_postal, int telefono ){
        
        try {
             statement = getConexion().createStatement();
            sql = "INSERT INTO CENTRO_TRABAJO " +
            "(COD_CENTRO ,PROVINCIA_CENTRO ,NOMBRE_CENTRO , NUMERO_CENTRO , CIUDAD_CENTRO , CALLE_CENTRO ,CODIGO_POSTAL_CENTRO , TELEFONO_CENTRO) " +
            "VALUES ( " + codigo + ", '" + provincia + "', '" + nombre + "', " + numero + ", '" + ciudad + "', '" + calle + "', " + codigo_postal + ", " + telefono + ")" ;

           // execute insert SQL stetement
            statement.executeUpdate(sql);
            statement.close();
            sql = null;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void deleteCentro (int codigo ){
    
        
        try {
            statement = getConexion().createStatement();
            
            sql = "DELETE FROM CENTRO_TRABAJO WHERE COD_CENTRO =" + codigo ;
            
            statement.executeUpdate(sql);
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCentros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public  void updateCentro (int codigo, String provincia, String nombre, int numero, String ciudad, String calle, int codigo_postal, int telefono ){
    
        try {
            statement = getConexion().createStatement();
            
            sql = "UPDATE CENTRO_TRABAJO SET COD_CENTRO="  + codigo + ",PROVINCIA_CENTRO= '" + provincia + "' ,NOMBRE_CENTRO= '" + nombre + 
                  "', NUMERO_CENTRO=" + numero + ",CIUDAD_CENTRO= '" + ciudad + "' ,CALLE_CENTRO= '" + calle + 
                  "' ,CODIGO_POSTAL_CENTRO= " + codigo_postal + ", TELEFONO_CENTRO= " + telefono + " WHERE COD_CENTRO = " + codigo ;
            
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCentros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                    
                    
    
    }
            
     

    
}
