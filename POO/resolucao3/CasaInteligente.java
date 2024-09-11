package resolucao3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Comparator;

import resolucao3.Lampada.state;

public class CasaInteligente {
    private double consumo = 0;
    private long last_counter = 0;
    private long current_counter = 0;
    private List<Lampada> listaL; 
    

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

        public List<Lampada> get_linhasL(){
            ArrayList<Lampada> aux = new ArrayList<>();
            for(Lampada l: this.listaL){
                aux.add(l.clone());
            }
        return aux;
        }

    //SETTERS

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
    public void set_linhasL(List<Lampada> linhasL){
        ArrayList<Lampada> aux = new ArrayList<>();
        for(Lampada l : listaL){
            aux.add(l.clone());
        }
    }

    public CasaInteligente(){
        this.consumo = 0;
        this.last_counter = 0;
        this.current_counter = 0;
        this.listaL = new ArrayList<>();
    }

    public CasaInteligente(double consumo, long last_counter, long current_counter, List<Lampada> l){
        this.consumo = consumo;
        this.last_counter = last_counter;
        this.current_counter = current_counter;
        this.listaL = new ArrayList<>();
        
        for(Lampada aux: l){
            this.listaL.add(aux.clone());
        }
    }

    public CasaInteligente(CasaInteligente o){
        this.consumo = o.getConsumo(); 
        this.last_counter = o.getLastC();
        this.current_counter = o.getCurrentC(); 
        this.listaL = new ArrayList<>();
        
        for(Lampada aux: o.listaL){
            this.listaL.add(aux.clone());
        }
    }

    @Override
    public CasaInteligente clone() {
        return new CasaInteligente(this);
        }

    @Override
    public String toString() {
        Iterator<Lampada> it = this.listaL.iterator();
        double consumo = Double.MIN_VALUE;
        while(it.hasNext()){
            consumo += it.next().getConsumo();
        }
        this.consumo = consumo;
        return "\n--- EncEficiente ---\n" + "Consumo = " + consumo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        CasaInteligente c = (CasaInteligente) o ;
        return (this.consumo == c.getConsumo() && this.listaL.equals(c.listaL) );
    }

    public void addLampada(Lampada l){
        this.listaL.add(l.clone());
    }

    public void ligaLampadaNormal(int index){
        Lampada aux = this.listaL.get(index).clone();
        this.listaL.get(index).setState(aux.getON());
    }

    public void ligaLampadaEco(int index){
        Lampada aux = this.listaL.get(index).clone();
        this.listaL.get(index).setState(aux.getECO());
    }

    public int qtEmEco(){
        int count = 0;
        Iterator<Lampada> it = this.listaL.iterator();
        while(it.hasNext()){
            Lampada l = it.next();
            if( l.getState() == state.ECO) {
                it.remove();
                count ++;}
        }
        return count;
    }

    public void removeLampada(int index){
        int indice = 1;
        Iterator<Lampada> it = this.listaL.iterator();
        while(it.hasNext() && indice < index){
            it.next();
            indice ++;
        }
        if(it.hasNext()){
            it.next();
            it.remove();
        }
    }

    public void ligaTodasEco(){
        Iterator<Lampada> it = this.listaL.iterator();
        while(it.hasNext()){
            it.next().setState(state.ECO);
        }
    }

    public void ligaTodasMax(){
        Iterator<Lampada> it = this.listaL.iterator();
        while(it.hasNext()){
            it.next().setState(state.ON);
        }
    }

    public double consumoTotal(){
        int count = 0;
        Iterator<Lampada> it = this.listaL.iterator();
        while(it.hasNext()){
            count += it.next().getConsumo();
        }
        return count;
    }

    public double consumoTotal2(){
        return this.listaL.stream().mapToDouble(Lampada:: getConsumo).sum();
    }

    public Set<Lampada> lampadasEmModoEco(){
        return this.listaL.stream().filter(l -> l.getState() == state.ECO).map(Lampada::clone).collect(Collectors.toSet());
    }

    public void reset(){
        this.listaL.forEach(Lampada :: setReset);
    }
    
    public Set<Lampada> podiumEconomia(){
        Comparator<Lampada> comp = Comparator.comparing(Lampada::getConsumo);
        return this.listaL.stream().sorted(comp).limit(3).map(Lampada::clone).collect(Collectors.toSet());
    }
}
