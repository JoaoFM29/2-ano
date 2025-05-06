package resolucao4;
import java.time.LocalDateTime;

public class PedidodeSuporte {
    private String nome;
    private LocalDateTime init_counter;
    private String assunto;
    private String descricao;
    private String funcionario;
    private LocalDateTime finish_counter;
    private String inf_pedido;

    public PedidodeSuporte (){ // + LinhaEncomenda()
        this.nome = "";
        this.init_counter = LocalDateTime.now();
        this.assunto = "";
        this.descricao = "";
        this.funcionario = "";
        this.finish_counter = LocalDateTime.now();
        this.inf_pedido = "";
    }

    public PedidodeSuporte (String nome, LocalDateTime init_counter, String assunto, String descricao, String funcionario, LocalDateTime finish_counter, String inf_pedido){ // + PedidodeSuporte(String, Long,String, String, String,Long ,String)
        this.nome = nome;
        this.init_counter = init_counter;
        this.assunto = assunto;
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.finish_counter = finish_counter;
        this.inf_pedido = inf_pedido;
    }

    public PedidodeSuporte (PedidodeSuporte p){ // + LinhaEncomenda(LinhaEncomenda)
        this.nome = p.get_nome();
        this.init_counter = p.get_initCounter();
        this.assunto = p.get_assunto();
        this.descricao = p.get_descricao();
        this.funcionario = p.get_funcionario();
        this.finish_counter = p.get_finishCounter();
        this.inf_pedido = p.get_infPedido();
    }

    //Getter
    public String get_nome(){ // + get_nome: String
        return this.nome;
    }

    public LocalDateTime get_initCounter(){ // + get_initCounter: Long
        return this.init_counter;
    }

    public String get_assunto(){ // + get_assunto: String
        return this.assunto;
    }

    public String get_descricao(){ // + get_descricao: String
        return this.descricao;
    }

    public String get_funcionario(){ // + get_funcionario: String
        return this.funcionario;
    }

    public LocalDateTime get_finishCounter(){ // + get_finishCounter: Long
        return this.finish_counter;
    }

    public String get_infPedido(){ // + get_infPedido: String
        return this.inf_pedido;
    }

    //Setter
    public void set_nome(String nome){ // + get_nome: String
         this.nome = nome;
    }

    public void set_initCounter(LocalDateTime init_counter){ // + get_initCounter: Long
        this.init_counter = init_counter;
    }

    public void set_assunto(String assunto){ // + get_assunto: String
        this.assunto = assunto;
    }

    public void set_descricao(String descricao){ // + get_descricao: String
        this.descricao = descricao;
    }

    public void set_funcionario(String funcionario){ // + get_funcionario: String
        this.funcionario = funcionario;
    }

    public void set_finishCounter(LocalDateTime finish_counter){ // + get_finishCounter: Long
        this.finish_counter = finish_counter;
    }

    public void set_infPedido(String infPedido){ // + get_infPedido: String
        this.inf_pedido = infPedido;
    }

    @Override
    public PedidodeSuporte clone() {
        return new PedidodeSuporte(this) ;
        }

    @Override
    public String toString() {
        return "\n--- Pedido de suporte ---\n" + "Fazer o toString";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        PedidodeSuporte c = (PedidodeSuporte) o ;
        return (this.nome == c.get_nome() && this.init_counter == c.get_initCounter() && this.assunto == c.get_assunto()) &&
                this.descricao == c.get_descricao() && this.funcionario == c.get_funcionario() && this.finish_counter == c.get_finishCounter() ;
    }


    
}