 

/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

import java.util.Map;
import java.util.List;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.HashMap;


/**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos 
 * espaços (as salas) que existem na casa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CasaInteligente {
   
    private String morada;
    private Map<String, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices

    /**
     * Constructor for objects of class CasaInteligente
     */
    public CasaInteligente() {
        // initialise instance variables
        this.morada = "";
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public CasaInteligente(String morada) {
        // initialise instance variables
        this.morada = morada;
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    
    public void setDeviceOn(String devCode) {
        this.devices.get(devCode).turnOn();
    }
    
    public boolean existsDevice(String id) {return this.devices.containsKey(id);}
    
    public void addDevice(SmartDevice s) {this.devices.put(s.getID(), s.clone());}
    
    public SmartDevice getDevice(String s) {return this.devices.get(s).clone();}
    
    public void setOn(String s, boolean b) {this.devices.get(s).setOn(b);}
    
    public void setAllOn(boolean b) {this.devices.keySet().forEach(d -> setOn(d,b));}
    
    public void addRoom(String s) {this.locations.put(s, locations);}
    
    public boolean hasRoom(String s) {return false;}
    
    public void addToRoom (String s1, String s2) {}
    
    public boolean roomHasDevice (String s1, String s2) {return false;}
    
}
