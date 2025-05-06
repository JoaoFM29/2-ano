package resolucao5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Parque {
    private List<Lugar> lugar; 
    
    //Getters
    public List<Lugar> get_lugar(){
        ArrayList<Lugar> aux = new ArrayList<>();
        for(Lugar l: this.lugar){
            aux.add(l.clone());
        }
        return aux;
    }

    //Setters
    public void set_lugar(List<Lugar> l){
        for(int i = 0; i < l.size() && i < this.lugar.size(); i++) {
            this.lugar.set(i, l.get(i).clone());
        }
    }

    @Override
    public Parque clone() {
        return new Parque(this) ;
        }

    @Override
    public String toString() {
        ArrayList<Lugar> aux = new ArrayList<>();
        for(Lugar l: this.lugar){
            aux.add(l.clone());
        }

        return "\n--- Parque ---\n" + aux.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        Parque c = (Parque) o ;
        return this.lugar == c.get_lugar();
    }

    //metodo parque sem parâmetros
    public Parque(){
        this.lugar = new ArrayList<>();
    }

    //método parque parametrizado
    public Parque(List<Lugar> l){
        this.lugar = new ArrayList<>();
        for(Lugar lugar: l){
            this.lugar.add(lugar.clone());
        }
    }

    //método parque a receber um Parque
    public Parque(Parque p){
        this.lugar = new ArrayList<>();
        for(Lugar l: p.lugar){
            this.lugar.add(l.clone());
        }
    }


    public List<String> devolve_matriculas(){
        ArrayList<String> aux = new ArrayList<String>();
        for(Lugar l: this.lugar){
            aux.add(l.get_matricula());
        }
        return aux;
    }

    public void nova_matricula(Lugar l){
        this.lugar.add(l.clone());
    }

    public void remove_matricula(Lugar l){
        Lugar aux = new Lugar();
        Iterator<Lugar> it = this.lugar.iterator();
        while(it.hasNext()){
            aux = it.next();
            if(l.get_matricula() == aux.get_matricula()){
                it.remove();
                break;
            } 
        }
    }

    public void set_tempoM(String matricula, int tempo){
        Lugar aux = new Lugar();
        Iterator<Lugar> it = this.lugar.iterator();
        while(it.hasNext()){
            aux = it.next();
            if(matricula== aux.get_matricula()){
                aux.set_minutos(tempo);
                break;
            } 
        }
    }

    public int ext_Tminutos(){
        Iterator<Lugar> it = this.lugar.iterator();
        Lugar aux = new Lugar();
        int minutos = 0;
        while(it.hasNext()){
            aux = it.next();
            minutos += aux.get_minutos();
        }
        return minutos;
    }

    public int int_Tminutos(){
        return this.lugar.stream().mapToInt(Lugar :: get_minutos).sum();
    }

    public boolean verifica_lugar(Lugar l){
        return this.lugar.stream().anyMatch(aux->aux.get_matricula()==l.get_matricula());
    }

    public List<Lugar> ext_lugarTempo(List<Lugar> l, int minutos){
        Iterator<Lugar> it = this.lugar.iterator();
        Lugar aux_iter = new Lugar();
        ArrayList<Lugar> lugar = new ArrayList<>();
        while(it.hasNext()){
            aux_iter = it.next();
            if(aux_iter.get_minutos()>minutos && aux_iter.get_permanente() == true){
                lugar.add(aux_iter.clone());
            }
        }
        return lugar;
    }

    public Set<Lugar> int_lugarTempo(List<Lugar> l, int minutos){
        return this.lugar.stream().filter(aux -> aux.get_minutos() > minutos)
                                  .filter(aux -> aux.get_permanente()==true)
                                  .map(Lugar::clone)
                                  .collect(Collectors.toSet());
    }

    public List<Lugar> lugar_clonados(List<Lugar> l){
        return this.lugar.stream().map(Lugar::clone).collect(Collectors.toList());
    }

    public String inf_LugarM (String matricula){

        Iterator<Lugar> it = this.lugar.iterator();
        Lugar aux_iter = new Lugar();
        Lugar aux_ret = new Lugar();
        while(it.hasNext() && aux_iter.get_matricula() != null){
            aux_iter = it.next();
            if(aux_iter.get_matricula()== matricula){
                aux_ret = aux_iter.clone();
            }
        }
        return aux_ret.toString();
    }

}
