package resolucao3;

public class Main {

    public static void main(String[] args)
    {
        Circulo c = new Circulo();
        Lampada l = new Lampada();
        Lampada l1 = new Lampada();
        Lampada l2 = new Lampada();
        l2.lampON();
        Lampada l3 = new Lampada();
        Futebol f = new Futebol();
        LinhaEncomenda le = new LinhaEncomenda("444", "Chinelos", 1.0, 5, 0.10, 0.02);
        LinhaEncomenda le2 = new LinhaEncomenda("333", "Roupa", 3.0, 2, 0.15, 0.05);
        LinhaEncomenda[] array = new LinhaEncomenda[2];
        Encomenda e = new Encomenda();
        CasaInteligente casa = new CasaInteligente();
        casa.addLampada(l2);

        array[0] = le2.clone();
        array[1] = le.clone();
        l3.lampON();
        l.lampON();
        l1.lampON();
        f.goloVisitante();
        e.set_nomeC("João");
        e.set_linhasE(array);
        l3.lampOFF();
        

        System.out.println(c.toString());
        l.lampOFF();
        System.out.println(l.toString());
        System.out.println(f.toString());
        System.out.println(e.toString());
        l1.lampOFF();
        casa.addLampada(l);
        casa.addLampada(l1);
        casa.addLampada(l3);
        l2.lampOFF();
        System.out.println(casa.podiumEconomia());
        
    }
    
}
