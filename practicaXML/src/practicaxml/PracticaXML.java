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
            
            NodeList usuarios=documento.getElementsByTagName("usuario");
       
            System.out.println(usuarios.getLength());
            for (int i=0;i<usuarios.getLength();i++){
                System.out.println("---------------------------");
                getDatosJugador(usuarios.item(i));
                
             
            }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(PracticaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public static void getDatosJugador(Node nodo) {
        
        Element elem = (Element)nodo; 
        NodeList datos=elem.getChildNodes();
        for (int j=0;j<datos.getLength();j++){
            if (datos.item(j).getNodeType()==1){
                System.out.println(datos.item(j).getNodeName()+":"+datos.item(j).getTextContent());
            }
        
       }
    }
}
