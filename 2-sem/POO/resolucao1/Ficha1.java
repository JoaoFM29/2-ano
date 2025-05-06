public class Ficha1{

    public double celsiusParaFarenheit(double graus)
    {
        return graus * 1.8 + 32;
    }
    public int maxNrs(int n1, int n2)
    {
        if (n1 < n2)
            {
                return n2;
            }
        else 
            {
                return n1;
            }
    }
    public String criaDescricaoConta(String nome, double saldo)
    {
        return nome + "é " + saldo;
    }

    public double eurosParaLibras(double valor, double taxaConversao)
    {
        return valor - taxaConversao;
    }

    public int Media(int n3, int n4){
        return (n3+n4)/2;
    }

    public String decrescente(int n3, int n4){
        if(n3<n4) 
            {
                return n3 + " " + n4;
            }
        else 
            {
                return n4 + " " + n3;
            }
    }

    public long factorial(String fatorial, int num)
    {

        int n = 0 ;
        if(fatorial != null)
        {
            n = Integer.parseInt(fatorial);
            num = n;
        }

        int f = num;
        while(num > 1)
        {
            f = f * (num-1);
            num --;
        }
        return f;
    }

    public double triangulo(double base, double altura)
    {
        return (base * altura )/2;
    }

    public boolean ehPrimo(int numero) 
    {
        for (int j = 2; j < numero; j++)
        {
            if (numero % j == 0)
                return false;   
        }
        return true;
    }

    public long data(long[] array)
    {
        long x = array[0] * 24 + array[1]*30*24 + array[1]*365*24;
        //subtrair à data atual em horas este valor de x e essa é as horas de vida da data dada como argumento.
        return x ;
    };
}