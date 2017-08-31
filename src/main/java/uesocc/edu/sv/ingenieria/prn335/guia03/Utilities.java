
package uesocc.edu.sv.ingenieria.prn335.guia03;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.enterprise.context.Dependent;

/**
 *
 * @author linux
 */
@LocalBean
@Dependent
public class Utilities implements Serializable{
    //Este método devuelve las 20 primeras letras del texto ingresado
    //@param texto recibe el texto a resumir
     // @return devuelve las primeras 20 letras el texto
    public String getResume(String texto){
        String cadena="";
        for(int i=0;i<20;i++){
            cadena=cadena+texto.charAt(i);
        }
        texto=cadena;
        return texto;   
    }
    // Este metodo devuelve las palabras ya capitalizadas del texto ingresado y evita los dobles espacios
    //@param texto recibe el texto que va ser capitalizado
     // @return Retorna el texto sin dobles espacios y las palabras con inicial mayuscula
    public String capitalizar(String texto) {
        String cadena="";
        texto.replaceAll("  ", " ");
        cadena += String.valueOf(texto.charAt(0)).toUpperCase();
        for(int i=1; i<texto.length();i++){
            if(texto.charAt(i-1)==' ' || texto.charAt(i)==' ' ){
                cadena += String.valueOf(texto.charAt(i)).toUpperCase();
                
            }else{
                cadena += texto.charAt(i);
            }
        }
        return cadena;
    
    }
// este metodo busca coincidencias en frase,devolviendo cuantos fueron del texto ingresado
    //@param frase cadena de texto que contiene la frase a buscar
      //@param texto cadena de texto donde se buscaran las coincidencias
     // @return cantidad de coincidencias de la frase en el texto
  public int contarCoincidencias(String frase, String texto) {
        int cantidad=0, niv = 0;
        String busqueda;
        if (frase.length() < texto.length()) {
            for (int rec = frase.length(); rec <= texto.length(); rec++, niv++) {
                busqueda = "";
                for (int rec2 = 0 + niv; rec2 < frase.length() + niv; rec2++) {
                    busqueda += String.valueOf(texto.charAt(rec2));
                }
                if (frase.equalsIgnoreCase(busqueda)) {
                    cantidad++;
                }
            }

        } else {
            cantidad=0;
        }
        return cantidad;
    }
}
