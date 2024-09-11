package resolucao3;

import java.time.LocalDate;
import java.util.Arrays;

//assumindo que com linha de encomenda é o carrinho do cliente, ou seja, lá contem o preço dos produtos encomendados
public class Encomenda {
    private String nomeC;     // - nomeC: String
    private int nfC;          // - nfC: Int
    private String moradaE;   // - moradaE: String
    private int nE;           // - nE: Int
    private LocalDate dataE;     // - dataE: LocalDate
    private LinhaEncomenda[] linhasE;    // - linhasE: Int[]
    private int codigo;

    public int get_codigo(){ 
        return this.codigo;
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

    public LocalDate get_dataE(){
        return this.dataE;
    }

    public LinhaEncomenda[] get_linhasE(){
        LinhaEncomenda[] aux = new LinhaEncomenda[this.linhasE.length];
        aux = Arrays.copyOf(this.linhasE, this.linhasE.length);
        return aux;
    }

    //Setters
    public void set_codigo(int codigo){
        this.codigo = codigo;
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

    public void set_dataE( LocalDate dataE){
        this.dataE = dataE;
    }

    public void set_linhasE(LinhaEncomenda[] linhasE){
        for(int i = 0; i < linhasE.length; i++){
            this.linhasE[i] = linhasE[i].clone();
        }
    }

    public Encomenda(){
        this.nomeC = "";
        this.nfC = 0;
        this.moradaE = "";
        this.nE = 0;
        this.dataE = LocalDate.now();
        this.linhasE = new LinhaEncomenda[2];
        this.codigo = 0;
    }

    public Encomenda(String nomeC, int nfC, String moradaE, int nE, LocalDate dataE, LinhaEncomenda[] linhasE, int codigo){
        this.nomeC = nomeC;
        this.nfC = nfC;
        this.moradaE = moradaE;
        this.nE = nE;
        this.dataE = dataE;
        this.codigo = codigo;
        this.linhasE = new LinhaEncomenda[2];

        for(int i = 0; i < 2; i++){
            this.linhasE[i] = (linhasE[i]).clone();
        }
    }

    public Encomenda(Encomenda o){
        this.nomeC = o.get_nomeC();
        this.nfC = o.get_nfC();
        this.moradaE = o.get_moradaE();
        this.nE = o.get_nE();
        this.dataE = o.get_dataE();
        this.linhasE = o.get_linhasE();   
        this.codigo = o.get_codigo(); 
    }

    @Override
    public Encomenda clone() {
        return new Encomenda(this) ;
        }

    @Override
    public String toString() {
        return "\n--- Encomenda ---\n" + "Nome = " + get_nomeC() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        Encomenda c = (Encomenda) o ;
        return this.moradaE == c.get_moradaE() &&
                this.nE == c.get_nE() && this.dataE == c.get_dataE() && this.get_linhasE() == c.get_linhasE() && this.codigo == c.get_codigo();              
    }

    public double calculaValorTotal(){
        int preco_total = 0;
        LinhaEncomenda[] aux = Arrays.copyOf(this.linhasE, this.linhasE.length);
        for(int i = 0; i< aux.length; i++){
            preco_total += aux[i].calculaValorLinhaEnc();
        }
        return preco_total;
    }

    public double calculaValorDesconto(){
        int desconto_total = 0;
        LinhaEncomenda[] aux = Arrays.copyOf(this.linhasE, this.linhasE.length);
        for(int i = 0; i< aux.length; i++){
            desconto_total += aux[i].calculaValorDesconto();
        }
        return desconto_total;
    }

    public int numeroTotalProdutos(){
        LinhaEncomenda[] aux = Arrays.copyOf(this.linhasE, this.linhasE.length);
        return aux.length;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        boolean ok = false;
        for(int i = 0; i < this.linhasE.length; i++){
            ok = (this.linhasE[i].clone().get_referencia() == refProduto);
            if(ok == true) break;
        }
        return ok;
    }

    public void adicionaLinha(LinhaEncomenda linha){
        LinhaEncomenda[] aux = Arrays.copyOf(this.linhasE, this.linhasE.length);
        LinhaEncomenda[] aux2 = new LinhaEncomenda[aux.length +1];
        
        aux2 = Arrays.copyOf(this.linhasE, aux.length);
        aux2[aux2.length-1] = linha;
        this.linhasE = aux2;
    }

    public void removeProduto(String codProd){
        LinhaEncomenda[] aux = Arrays.copyOf(this.linhasE, this.linhasE.length);
        LinhaEncomenda[] aux2 = new LinhaEncomenda[aux.length-1];
        int x = procura(codProd);
        if(x != -1)//caso encontre o codigo do produto remove o, senão não faz nada
            {
                for(int i = 0; i < x; i++ ){
                    aux2[i] = aux[i];
                }
                for(int i = x; i<aux2.length; i++){
                    aux2[i] = aux[i];
                }
            }
    }

    private int procura(String codProd){
        LinhaEncomenda[] aux = Arrays.copyOf(this.linhasE, this.linhasE.length);
        for(int i = 0; i < this.linhasE.length; i++){
            if(aux[i].get_referencia() != codProd);
            else return i;
        }
        return -1;
    }
}