package service;

import pruebainicial.Calculadora;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author Raul
 */

public class CalculadoraTest {
/**
* Prueba cadena vacia 
*/
@Test
public void cadenaVacia() throws Exception{
    assertEquals(Calculadora.add(""), 0);
}
/**
* Prueba un solo numero
*/
@Test
public void unicoNumero(){
    try {
        assertEquals(Calculadora.add("1"), 1);
        assertEquals(Calculadora.add("5"), 5);
        assertEquals(Calculadora.add("9"), 9);
    } catch (Exception ex) {
        fail("Error probando la calculadora con un único número");
    }
}
/**
* Prueba dos numeros separados por coma
*/
@Test
public void dosNumerosComa(){
    try {
        assertEquals(Calculadora.add("1,5"), 6);
        assertEquals(Calculadora.add("2,6"), 8);
        assertEquals(Calculadora.add("31,2"), 33);
    } catch (Exception ex) {
        fail("Error probando la calculadora con dos numeros separados por una coma");
    }
}
/**
* Prueba multiples numeros separados por coma
*/
@Test
public void multiplesNumerosSeparadosPorComa() {
    try {
        assertEquals(Calculadora.add("1,6,11,6"), 24);
        assertEquals(Calculadora.add("1,2,3,5,6,7,8"), 32);
        assertEquals(Calculadora.add("1,4,12,5,20"), 42);
    } catch (Exception ex) {
        fail("Error probando la calculadora con varios números separados por una coma");
    }
}
/**
* Prueba (\n) como un separador valido
*/
@Test
public void separadorNuevaLinea() {
    try {
        assertEquals(Calculadora.add("2,4\n6"), 12);
        assertEquals(Calculadora.add("2\n4,6"), 12);
        assertEquals(Calculadora.add("2\n4\n6"), 12);
        assertEquals(Calculadora.add("2\n4"), 6);
        assertEquals(Calculadora.add("2\n4\n6\n8\n10"), 30);
        assertEquals(Calculadora.add("2\n4\n6\n8\n10,12"), 42);
    } catch (Exception ex) {
        fail("Error probando la calculadora con separador(es) de nueva línea");
    }
}
/**
* Prueba delimitadores personalizados
*/
@Test
public void pruebaDelimitadoresPersonalizados() {
    try {
        assertEquals(Calculadora.add("//;\n2;1"), 3);
        assertEquals(Calculadora.add("//r\n2r1"), 3);
        assertEquals(Calculadora.add("//-\n2-1"), 3);
        assertEquals(Calculadora.add("//*\n2*1"), 3);
        assertEquals(Calculadora.add("//*\n3*2*1"), 6);
        assertEquals(Calculadora.add("//.\n2.1"), 3);
        assertEquals(Calculadora.add("//.\n3.2.1"), 6);
        assertEquals(Calculadora.add("//.\n3.2.1"), 6);
    } catch (Exception ex) {
        fail("Error probando la calculadora con delimitadores personalizados");
    }
}
/**
* prueba excepción un número negativo
*/
@Test
public void excepcionNegativos() {
    try{
        Calculadora.add("-6,4,-2");
        fail("No se lanzo una excepción cuando se intento sumar un número negativo: //*\n1*-2");
    } catch(Exception ex) {
        assertEquals("Negatives not allowed: -6, -2", ex.getMessage());
    }
    try{
        Calculadora.add("//*\n4*-3");
        fail("No se lanzo una excepción cuando se intento sumar un número negativo: //*\n1*-2");
    } catch(Exception ex) {
        assertEquals("Negatives not allowed: -3", ex.getMessage());
    }
    try{
        Calculadora.add("//*\n2*-4*6*8*-10*12*-14");
        fail("No se lanzo una excepción cuando se intento sumar un número negativo: //*\n1*-2*2*3*-5*8*-1");
    } catch(Exception ex) {
        assertEquals("Negatives not allowed: -4, -10, -14", ex.getMessage());
    }
}
}