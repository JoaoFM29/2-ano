package resolucao3;

import java.util.Arrays;

public class Futebol {
    private jogo estado = jogo.TERMINADO;
    private int[] resultado = {0, 0};
    private int golosC;
    private int golosF;

    enum jogo
    {
        INICIADO,
        TERMINADO,
        DECORRER,
    }

    //Getters

    public jogo get_estado()
    {
        return this.estado;
    }

    public int[] get_resultado(){
        return this.resultado;
    }

    public int get_golosC(){
        return this.golosC;
    }

    public int get_golosF(){
        return this.golosF;
    }

    public jogo getI(){
        return jogo.INICIADO;
    }

    public jogo getT(){
        return jogo.TERMINADO;
    }

    public jogo getD(){
        return jogo.DECORRER;
    }

    //Setters

    public void set_Estado(jogo estado){
        this.estado = estado;
    }

    public void set_Resultado(int[] resultado){
        this.resultado = resultado;
    }

    public void set_GoloC(int golosC){
        this.golosC = golosC;
    }

    public void set_GoloF( int golosF){
        this.golosF = golosF;
    }

    public Futebol(){
        this.estado = jogo.TERMINADO;
        this.resultado[0] = 0;
        this.resultado[1] = 0;
        this.golosC = 0;
        this.golosF = 0;
    }

    public Futebol(jogo estado, int golosC, int golosF, int[] resultado){
        this.estado = estado;
        this.golosC = golosC;
        this.golosF = golosF;
        this.resultado = resultado;
    }

    public Futebol(Futebol o){
        this.estado = o.get_estado();
        this.golosC = o.get_golosC(); 
        this.golosF = o.get_golosF();
        this.resultado = o.get_resultado();     
    }

    @Override
    public Futebol clone() {
        return new Futebol(this) ;
        }

    @Override
    public String toString() {
        return "\n--- Jogo ---\n" + "Resultado = " + resultadoActual();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        Futebol c = (Futebol) o ;
        return (this.estado == c.get_estado() && this.resultado == c.get_resultado()) ;
    }

    public void startGame(){
        this.estado = jogo.INICIADO;
    }

    public void endGame(){
        this.estado = jogo.TERMINADO;
    }

    public void goloVisitado(){
        this.golosC +=1;
        this.resultado[0] = this.golosC;
    }

    public void goloVisitante(){
        this.golosF +=1;
        this.resultado[1] = this.golosF;
    }

    public String resultadoActual(){
        String score = new String();
        score = Arrays.toString(resultado);
        return score;
    }



}
