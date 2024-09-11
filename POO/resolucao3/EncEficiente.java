package resolucao3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EncEficiente {
    private String nomeC;     // - nomeC: String
    private int nfC;          // - nfC: Int
    private String moradaE;   // - moradaE: String
    private int nE;           // - nE: Int
    private String dataE;     // - dataE: String
    private List<LinhaEncomenda> linhasE;    // - linhasE: ArrayList <>
    private int id;          //  - id: String

    private static int current_id = 1; // - current_id: Int
    
    public int get_currentId(){ 
        return EncEficiente.current_id;
    }

    public int get_id(){ 
        return this.id;
    }
    public String get_nomeC(){ 
        return this.nomeC;
    }
 
    public int get_nfC(){
        return this.nfC;
    }

    public String get_moradaE(){
        return this.moradaE;
    }

    public int get_nE(){
        return this.nE;
    }

    public String get_dataE(){
        return this.dataE;
    }

    public List<LinhaEncomenda> get_linhasE(){
        ArrayList<LinhaEncomenda> aux = new ArrayList<LinhaEncomenda>();
        for(LinhaEncomenda l: this.linhasE)
        {
            aux.add(l.clone());
        }
        return aux;
    }

    //Setters

    public void set_id(int id){
        this.id = id;
    }

    public void set_nomeC(String nomeC){
        this.nomeC = nomeC;
    }

    public void set_nfC(int nfC){
        this.nfC = nfC;
    }

    public void set_moradaE(String moradaE){
        this.moradaE = moradaE;
    }

    public void set_nE( int nE){
        this.nE = nE;
    }

    public void set_dataE( String dataE){
        this.dataE = dataE;
    }

    public void set_linhasE(List<LinhaEncomenda> linhasE){
        for(LinhaEncomenda l: linhasE)
        {
            this.linhasE.add(l.clone());
        }
    }

    public EncEficiente(){
        this.nomeC = "";
        this.nfC = 0;
        this.moradaE = "";
        this.nE = 0;
        this.dataE = "";
        this.linhasE = new ArrayList<LinhaEncomenda>();
        this.dataE = "";
        current_id = current_id ++;
        this.id = current_id ;
    }

    public EncEficiente(String nomeC, int nfC, String moradaE, int nE, String dataE, List<LinhaEncomenda> linhasE){
        this.nomeC = nomeC;
        this.nfC = nfC;
        this.moradaE = moradaE;
        this.nE = nE;
        this.dataE = dataE;
        this.id = current_id ++;
        this.linhasE = new ArrayList<LinhaEncomenda>();

        for(LinhaEncomenda l: this.linhasE){
            this.linhasE.add(l.clone());
        }
    }

    public EncEficiente(EncEficiente o){
        this.nomeC = o.get_nomeC();
        this.nfC = o.get_nfC();
        this.moradaE = o.get_moradaE();
        this.nE = o.get_nE();
        this.dataE = o.get_dataE();
        this.linhasE = o.get_linhasE();
        this.id = this.get_currentId();
    }

    @Override
    public EncEficiente clone() {
        return new EncEficiente(this) ;
        }

    @Override
    public String toString() {

        //fazer um for para clonar a lista para um array e depois poder usar o get_preço para saber o preço da encomenda
        return "\n--- EncEficiente ---\n" + "Nome = " + get_nomeC();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        EncEficiente c = (EncEficiente) o ;

        return  this.moradaE == c.get_moradaE() &&
                this.nE == c.get_nE() && this.dataE == c.get_dataE() && this.get_linhasE() == c.get_linhasE() &&
                this.linhasE.equals(c.linhasE) && this.id == c.get_id();
    }

    public double calculaValorTotal(){
        int x = 0;
        for(LinhaEncomenda l : this.linhasE){
            x += l.get_preco();
        }
        return x;
    }

    public double calculaValorDesconto(){
        int x = 0;
        for(LinhaEncomenda l : this.linhasE){
            x += l.get_desconto();
        }
        return x;
    }
    
    public int numeroTotalProdutos(){
        return this.linhasE.size();
    }

    public boolean existeProdutoEncomenda(String refProduto) {
        for (LinhaEncomenda l : this.linhasE) {
            if (l.get_referencia() == refProduto) {
                return true;
            }
        }
        return false;
    }

    public void adicionaLinha(LinhaEncomenda linha){
        this.linhasE.add(linha.clone());
    }

    public void removeProduto(String codProd){

        Iterator<LinhaEncomenda> it = this.linhasE.iterator();
        boolean removed = false;

        while(it.hasNext() && !removed)
        {
            LinhaEncomenda l = it.next();
            if(l.get_referencia()==codProd) {
                it.remove();
                removed = true;
            }
        }
    }
}
