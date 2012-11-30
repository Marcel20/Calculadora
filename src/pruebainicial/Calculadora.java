package pruebainicial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Raul
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public static int add(String cadena) throws Exception {
        if (cadena.isEmpty()) {
        return 0;
        } else { 
        String [] operandos;
        if (cadena.startsWith("//")) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(cadena);
        matcher.matches();
        String miDelimitador = matcher.group(1);
        operandos = matcher.group(2).split(Pattern.quote(miDelimitador));
        } else {
        operandos = cadena.split(",|\n");
        }
        String mensajeExcepcion = "Negatives not allowed: ";
        Boolean negativos = false;
        Integer resultado = 0;
        for( int i = 0 ; i < operandos.length ; i++ ){
        int operandoActual = Integer.parseInt(operandos[i]);
        if (operandoActual < 0) {
        mensajeExcepcion += operandos[i] + ", ";
        negativos = true;
        }

        resultado += operandoActual;
        }
        
        if (negativos) {                
             String mensajeSinUltimaComa = mensajeExcepcion.substring(0, mensajeExcepcion.length() - 2 );                
             throw new Exception(mensajeSinUltimaComa);            
        }
        return resultado;
        }
    }
}
