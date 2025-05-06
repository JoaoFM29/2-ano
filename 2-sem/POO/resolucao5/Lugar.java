package resolucao5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Lugar {
    
    private String matricula ;
    private String nome ;
    private int minutos ;
    private boolean permanente ;

    public Lugar (){
        this.matricula = "";
        this.nome = "";
        this.minutos = 0;
        this.permanente = false;
    }

    public Lugar (String matricula, String nome, int minutos, boolean permanente){
        this.matricula = matricula;
        this.nome = nome;
        this.minutos = minutos;
        this.permanente = permanente;
    }

    public Lugar(Lugar l){
        this.matricula = l.get_matricula();
        this.nome = l.get_nome();
        this.minutos = l.get_minutos();
        this.permanente = l.get_permanente();
    }

    //Getters
    public String get_matricula(){
        return this.matricula;
    }

    public String get_nome(){
        return this.nome;
    }

    public int get_minutos(){
        return this.minutos;
    }

    public boolean get_permanente(){
        return this.permanente;
    }

    //Setters
    public void set_matricula(String matricula){
        this.matricula = matricula;
    }

    public void set_nome(String nome){
        this.nome = nome;
    }

    public void set_minutos(int minutos){
        this.minutos = minutos;
    }

    public void set_permanente(Boolean permanente){
        this.permanente = permanente;
    }
    @Override
    public Lugar clone() {
        return new Lugar(this) ;
        }

    @Override
    public String toString() {
        return "\nLugar do carro -> " + this.matricula + "\nProprietário do veículo -> " +this.nome +"\nTempo limite -> " + this.minutos + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        Lugar c = (Lugar) o ;
        return (this.matricula == c.get_matricula() && this.nome == c.get_nome() && this.minutos == c.get_minutos()) &&
                this.permanente == c.get_permanente();
    }
}
