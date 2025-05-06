package resolucao5;
import resolucao3.Encomenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GestãoEncomendas {
    List<Encomenda> encomenda;

    //Getters
    public List<Encomenda> get_Encomendas(){
        ArrayList<Encomenda> encomenda = new ArrayList<>();
        for(Encomenda aux : this.encomenda){
            encomenda.add(aux.clone());
        }
        return encomenda;
    }

    //Setter
    public void set_Encomendas(List<Encomenda> encomenda){
        for(int i = 0; i<encomenda.size() && i < this.encomenda.size(); i++){
            this.encomenda.set(i,encomenda.get(i).clone());
        }
    }

    @Override
    public GestãoEncomendas clone() {
        return new GestãoEncomendas(this) ;
        }

    @Override
    public String toString() {
        ArrayList<Encomenda> aux = new ArrayList<>();
        for(Encomenda enc: this.encomenda){
            aux.add(enc.clone());
        }

        return "\n--- Encomendas ---\n" + aux.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        GestãoEncomendas c = (GestãoEncomendas) o ;
        return this.encomenda == c.get_Encomendas();
    }

    //metodo GestaoEncomenda sem parâmetros
    public GestãoEncomendas(){
        this.encomenda = new ArrayList<>();
    }

    //método GestaoEncomenda parametrizado
    public GestãoEncomendas(List<Encomenda> l){
        this.encomenda = new ArrayList<>();
        for(Encomenda encomenda: l){
            this.encomenda.add(encomenda.clone());
        }
    }

    //método parque a receber uma GestãoEncomenda
    public GestãoEncomendas(GestãoEncomendas p){
        this.encomenda = new ArrayList<>();
        for(Encomenda l: p.encomenda){
            this.encomenda.add(l.clone());
        }
    }

    public Set<Integer> todosCodigosEnc(){
        ArrayList<Integer> aux = new ArrayList<>();
        for(int i = 0; i < this.encomenda.size(); i++){
            aux.add(this.encomenda.get(i).clone().get_codigo());
        }
        Set<Integer> set = new HashSet<>(aux); 
        return set;
    }

    public void addEncomenda(Encomenda enc){
        this.encomenda.add(enc.clone());
    }

    public Encomenda getEncomenda(Integer codEnc){
        Iterator<Encomenda> it = this.encomenda.iterator();
        Encomenda aux = new Encomenda();
        Encomenda aux_ret = new Encomenda();
        while(it.hasNext()){
            aux = it.next();
            if(aux.get_codigo()==codEnc){
                aux_ret = aux;
            }
        }
        return aux_ret.clone();
    }

    public void removeEncomenda(Integer codEnc){
        this.encomenda.stream().filter(enc -> enc.get_codigo() != codEnc).map(Encomenda::clone);
    }

    public Integer encomendaComMaisProdutos(){
        Iterator<Encomenda> it = this.encomenda.iterator();
        Encomenda aux = new Encomenda();
        Encomenda aux_ret = new Encomenda();
        int max = 0;
        int n_total = 0;
        while(it.hasNext()){
            aux = it.next();
            n_total = aux.numeroTotalProdutos();
            if(max < n_total) {
                max = n_total;
                aux_ret = aux;
            }
        }
        return aux_ret.clone().get_codigo();
    }

    public Set<Integer> encomendasComProduto(String codProd){
        Iterator<Encomenda> it = this.encomenda.iterator();
        Encomenda enc = new Encomenda();
        Set<Integer> set = new HashSet<>(); 
        while(it.hasNext()){
            enc = it.next();
            if(enc.existeProdutoEncomenda(codProd) == true){
                set.add(enc.get_codigo());
            }
        }
        return set;
    }

    public Set<Integer> encomendasAposData(LocalDate d){
        Iterator<Encomenda> it = this.encomenda.iterator();
        Encomenda enc = new Encomenda();
        Set<Integer> set = new HashSet<>();
        while(it.hasNext()){
            enc = it.next();
            if(enc.get_dataE().isAfter(d)){
                set.add(enc.get_codigo());
            }
        }
        return set;
    }

    public Encomenda encomendaMaiorValor(){
        Iterator<Encomenda> it = this.encomenda.iterator();
        Encomenda aux = new Encomenda();
        Encomenda aux_ret = new Encomenda();
        double max = 0.0;
        double t_produtos = 0.0;
        while(it.hasNext()){
            aux = it.next();
            t_produtos = aux.calculaValorDesconto();
            if(max < t_produtos) {
                max = t_produtos;
                aux_ret = aux;
            }
        }
        return aux_ret.clone();
    }
    
    public Set<Encomenda> encomendasValorDecrescente(){
        Comparator<Encomenda> comp = Comparator.comparing(Encomenda::calculaValorTotal).reversed();
        return this.encomenda.stream().sorted(comp).map(Encomenda::clone).collect(Collectors.toSet());
    }
}
