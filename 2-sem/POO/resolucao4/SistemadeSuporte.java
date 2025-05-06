package resolucao4;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class SistemadeSuporte {
    private List<PedidodeSuporte> pedidoL; 

    //Getter

    public List<PedidodeSuporte> get_linhasL(){
        ArrayList<PedidodeSuporte> aux = new ArrayList<>();
        for(PedidodeSuporte l: this.pedidoL){
            aux.add(l.clone());
        }
    return aux;
    }

    //Setter
    public void set_pedidoL(List<PedidodeSuporte> pedidoL){
        for(int i = 0; i < pedidoL.size() && i < this.pedidoL.size(); i++) {
            this.pedidoL.set(i, pedidoL.get(i).clone());
        }
    }  

    public SistemadeSuporte(){
        this.pedidoL = new ArrayList<>();
    }

    public SistemadeSuporte(List<PedidodeSuporte> p){
        this.pedidoL = new ArrayList<>();
        
        for(PedidodeSuporte aux: p){
            this.pedidoL.add(aux.clone());
        }
    }

    public SistemadeSuporte(SistemadeSuporte o){
        this.pedidoL = new ArrayList<>();
        
        for(PedidodeSuporte aux: o.pedidoL){
            this.pedidoL.add(aux.clone());
        }
    }

    public void inserePedido(PedidodeSuporte pedido){
        this.pedidoL.add(pedido.clone());
    }

    public PedidodeSuporte procuraPedido(String user, LocalDateTime data){
        PedidodeSuporte aux = new PedidodeSuporte();
        PedidodeSuporte aux_ret = new PedidodeSuporte();
        Iterator<PedidodeSuporte> it = this.pedidoL.iterator();
        while(it.hasNext()){
            aux = it.next();
            if (aux.get_nome().equals(user) == true && aux.get_initCounter().equals(data)== true){
                aux_ret = aux;
            }
        }
        return aux_ret.clone();
    }

    public void resolvePedido(PedidodeSuporte pedido, String tecnico, String info){
        
    }
}
