
package gestor_pokemon;

import conexiondb.ConexionMySQL;

public class VariablesGlobales {
    
    public static ConexionMySQL conexion = new ConexionMySQL("localhost", "pokemondb", "root", "root");
    
}
