package resolucao3;
import java.lang.Math;

public class Lampada {
    private state current_state = state.OFF;
    private double consumo = 0;
    private long last_counter = 0;
    private long current_counter = 0;


    static enum state{
        ON,
        OFF,
        ECO,  
    }

    //GETTERS
    
    public long getCurrentC(){
        return this.current_counter;
    }

    public long getLastC(){
        return this.last_counter;
    }

    public double getConsumo(){
        return this.consumo;
    }

    public state getState(){
        return this.current_state;
    }

    public state getON(){
        return state.ON;
    }

    public state getOFF(){
        return state.OFF;
    }

    public state getECO(){
        return state.ECO;
    }

    public Lampada(){
        this.current_state = state.OFF;
        this.consumo = 0;
        this.last_counter = 0;
        this.current_counter = 0;
    }

    public Lampada(state estado, double consumo, long last_counter, long current_counter){
        this.current_state = estado;
        this.consumo = consumo;
        this.last_counter = last_counter;
        this.current_counter = current_counter;
    }

    public Lampada(Lampada o){
        this.current_state = o.getState();
        this.consumo = o.getConsumo(); 
        this.last_counter = o.getLastC();
        this.current_counter = o.getCurrentC();     
    }

    //SETTERS

    public void setState(state estado){
        this.current_state = estado;
    }

    public void setConsumo(double consumo){
        this.consumo = consumo;
    }

    public void setLastC(long last_counter){
        this.last_counter = last_counter;
    }

    public void setCurrentC(long current_counter){
        this.current_counter = current_counter;
    }

    public void setReset(){
        this.consumo = 0;
    }

    @Override
    public Lampada clone() {
        return new Lampada(this) ;
        }

    @Override
    public String toString() {
        return "\n--- Lampada ---" + "\nconsumo = " + this.consumo + " euros" + "\nestado = " + this.current_state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        Lampada c = (Lampada) o ;
        return (this.current_state == c.getState() && this.consumo == c.getConsumo()) ;
    }

    public void lampON(){
        this.current_state = state.ON;
        this.last_counter = current_counter;
        this.current_counter += System.currentTimeMillis();
    }

    public void lampOFF(){
        long time = System.currentTimeMillis();
        this.current_state = state.OFF;
        this.current_counter = time - last_counter;
        this.last_counter = time; 
        this.consumo = current_counter * 1.66666667 * Math.pow(10, (-5)) * 0.50 ; // consumo em minutos 
    }
    
    public void lampECO(){
        this.current_state = state.ECO;
        this.last_counter = current_counter;
        this.current_counter += System.currentTimeMillis();
    }

    public double totalConsumo(){
        return this.consumo;

    }
    
}
