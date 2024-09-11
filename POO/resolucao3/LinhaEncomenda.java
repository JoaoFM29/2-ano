package resolucao3;

public class LinhaEncomenda {

    private String referencia; // - referencia: String
    private String descricao; //  - descricao: String
    private double preco;     //  - preco: Double
    private int quantidade;   //  - quantidade: Int
    private double imposto;   //  - imposto: Double
    private double desconto;  //  - desconto: Double


    public LinhaEncomenda (){ // + LinhaEncomenda()
        this.referencia = "";
        this.descricao = "";
        this.preco = 0.0;
        this.quantidade = 0;
        this.imposto = 0.0;
        this.desconto = 0.0;
    }

    public LinhaEncomenda (String referencia, String descricao, Double preco, int quantidade, double imposto, double desconto){ // + LinhaEncomenda(String, String, Double, Int, Double, Double)
        this.referencia = referencia;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imposto =imposto;
        this.desconto = desconto;
    }

    public LinhaEncomenda (LinhaEncomenda l){ // + LinhaEncomenda(LinhaEncomenda)
        this.referencia = l.get_referencia();
        this.descricao = l.get_descricao();
        this.preco = l.get_preco();
        this.quantidade = l.get_quantidade();
        this.imposto = l.get_imposto();
        this.desconto = l.get_imposto();
    }

    //Getter
    public String get_referencia(){ // + get_referencia: String
        return this.referencia;
    }

    public String get_descricao(){ // + get_descricao: String
        return this.descricao;
    }

    public double get_preco(){ // + get_preco: double
        return this.preco;
    }

    public int get_quantidade(){ // + get_quantidade: int
        return this.quantidade;
    }

    public double get_imposto(){ // + get_imposto: doule
        return this.imposto;
    }

    public double get_desconto(){ // + get_desconto: doule
        return this.desconto;
    }

    //Setters
    public void set_descricao(String descricao){ // + set_descricao(String): void
        this.descricao = descricao;
    }

    public void set_preco(double preco){ // + set_preco(double): void
        this.preco = preco;
    }

    public void set_quantidade(int quantidade){ // + set_quantidade(int): void
        this.quantidade = quantidade;
    }

    public void set_imposto(double imposto){ // + set_imposto(double): void
        this.imposto = imposto;
    }

    public void set_desconto(double desconto){ // + set_desconto(double): void
        this.desconto = desconto;
    }

    @Override
    public LinhaEncomenda clone() {
        return new LinhaEncomenda(this) ;
        }

    @Override
    public String toString() {
        return "\n--- Linha de encomenda ---\n" + "Referencia = " + get_referencia();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        LinhaEncomenda c = (LinhaEncomenda) o ;
        return (this.referencia == c.get_referencia() && this.descricao == c.get_descricao() && this.preco == c.get_preco() &&
                this.quantidade == c.get_quantidade() && this.imposto == c.get_imposto() && this.desconto == c.get_desconto()) ;
    }


    public double calculaValorLinhaEnc(){
        return this.preco* this.quantidade * (1+this.imposto-this.desconto);
    }

    public double calculaValorDesconto(){
        return this.preco*this.quantidade* this.desconto;
    }
}
