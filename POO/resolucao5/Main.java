package resolucao5;

public class Main {

    public static void main(String[] args)
    {
        Lugar j = new Lugar("78-NZ-36", "João",  10, true);
        Lugar n = new Lugar("84-NE-26", "Norberto", 5, true);
        Lugar s = new Lugar("19-PG-25", "Susana", 7, true);

        Parque parque = new Parque();
        parque.nova_matricula(j);
        parque.nova_matricula(n);
        parque.nova_matricula(s);
        parque.set_tempoM("78-NZ-36", 3);
        int minutos = parque.int_Tminutos();
        String aux = parque.inf_LugarM("78-NZ-36");
        System.out.println(minutos);
        System.out.println(parque);
        System.out.println(aux);
        
    }
    
}