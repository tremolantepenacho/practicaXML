/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaxml;

import org.w3c.dom.*;
import javax.xml.parsers.* ;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.SAXException;
/**
 *
 * @author hector
 */
public class PracticaXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factoria.newDocumentBuilder();
            Document documento = builder.parse(new File ("jugadores.xml")) ;
            
            NodeList jugadores=documento.getElementsByTagName("usuario");
         // NodeList jugadores=documento.getDocumentElement().getChildNodes();
         //   NodeList jugadores=documento.getChildNodes();
           // jugadores=jugadores.item(0).getChildNodes();
         
            for (int i=0;i<jugadores.getLength();i++){
                System.out.println("---------------------------");
                System.out.println(jugadores.item(i).getNodeName());
                getDatosJugador(jugadores.item(i));
            //    System.out.println(jugadores.item(i).getNodeValue());
                
             
            }
         //   leerNodo(documento.getFirstChild()); // recupera el primer nodo
           // leerNodo(documento.getDocumentElement()); // recupera el elemento raíz
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(PracticaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public static void getDatosJugador(Node nodo) {
        
        NodeList datos=nodo.getChildNodes();
        System.out.println("Nombre: " + datos.item(0).getNodeValue());
        System.out.println("Horas: " + datos.item(1).getNodeValue());
        System.out.println("Puntuación: " + datos.item(2).getNodeValue());
        System.out.println("Nivel: " + datos.item(3).getNodeValue());
        System.out.println("");
        
       /* System.out.println("-------");
        NodeList listaHijos = nodo.getChildNodes();
        int num = listaHijos.getLength();
        for (int i = 0; i < num ; i++) {
            Node nodoActual = listaHijos.item(i);
            leerNodo(nodoActual);
        }*/
    }
    
}
