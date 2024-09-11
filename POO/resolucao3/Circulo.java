package resolucao3;

public class Circulo {
    private double x;
    private double y;
    private double raio;

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio(){
        return this.raio;
    }

    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 3;
    }

    public Circulo(double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo(Circulo c){
        this.x = c.getX(); // dava para por c.x porque o x é uma instancia privada nesta class e não há problema
        this.y = c.getY(); // ""
        this.raio = c.getRaio(); // ""
    }
    
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    @Override
    public Circulo clone() {
        return new Circulo(this) ;
        }

    @Override
    public String toString() {
        return "\n--- Circulo ---" + "\nx = " + this.x + "\ny = " + this.y + "\nraio = " + this.raio ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (( o == null ) || ( this.getClass () != o.getClass ()))  return false ;

        Circulo c = (Circulo) o ;
        return (this.x == c.getX () && this.y == c.getY () && this.raio == c.getRaio()) ;
    }

    public void deslocaR(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public double calculaArea(){
        //AREA = PI * raio^2
        return Math.PI * Math.pow(this.raio, 2);
    }
    
    public double calculaPerimetro(){
        //PERIMETRO = 2 * PI * raio
        return 2*Math.PI*this.raio;
    }


}
