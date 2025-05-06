import java.util.Scanner;

public class TestePrograma{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Ficha1 f1 = new Ficha1();

        System.out.println("1 - Indique temperatura em Celsius");
        double grausC = sc.nextDouble();

        System.out.println("2 - Indique dois números");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println("3 - Indique um nome e um valor decimal");
        String name = sc.next();
        double saldo = sc.nextDouble();

        System.out.println("4 - Indique um número e uma taxa de conversão, respetivamente");
        double euros = sc.nextDouble();
        double taxa = sc.nextDouble();

        System.out.println("5 - Indique dois valores");
        int n3 = sc.nextInt();
        int n4 = sc.nextInt();

        System.out.println("6 - Digite um valor para calcular o seu fatorial");
        int n5 = sc.nextInt();

        double n6 = 1;
        double n7 = 0;
        while(n6 != 0.0)
                {
                        System.out.printf("\nInsere um valor para uma base e outro para a altura do triangulo, respetivamente: \n");
                        n6 = sc.nextDouble();
                        n7 = sc.nextDouble();
                        double area = f1.triangulo(n6, n7);
                        System.out.printf("%s%5f", "A area do triangulo para as medidas dadas é ", area);
                }

        int jogar = 1;
        while(jogar == 1)
        {
                System.out.println("Insere num número inteiro");
                int x = sc.nextInt();
                boolean primo = f1.ehPrimo(x);
                if(primo)
                {
                        System.out.println("O número " + x + " é primo");
                }
                else 
                {
                        System.out.println("O número " + x + " não é primo");
                }
                System.out.println("Se dejesa continuar a jogar carregue em 1, caso contrário, carregue em 0");
                jogar = sc.nextInt();
        }

//incompleta(o que falta esta explicado na função data)
        System.out.println("Digite a sua data de nascimento pela seguinte ordem: dd mm aaaa");
        long[] data = new long[3];
        data[0] = sc.nextLong();
        data[1] = sc.nextLong();
        data[2] = sc.nextLong();
        long x = f1.data(data);
        System.out.println("A sua idade em horas é " +  x);

        double grausF = f1.celsiusParaFarenheit(grausC);
        int maior = f1.maxNrs(n1, n2);
        String nome = f1.criaDescricaoConta(name, saldo);
        double eparaLibras = f1.eurosParaLibras(euros, taxa);
        String descrescente = f1.decrescente(n3, n4);
        double media = f1.Media(n3, n4);
        long fatorial = f1.factorial(args[0], n5); // se quiseremos que seja o ususario a digitar temos que alterar algumas coisas simples

        System.out.println("O valor da temperatura que inseriu em farenheit é: " + grausF);
        System.out.println("O maior valor dos números que inseriu é: " + maior);
        System.out.println("O saldo da conta de "+ nome);
        System.out.println( euros  + " convertido em libras é " + eparaLibras);
        System.out.println( "Dos números que inseriu  na linha 8 e 9, escrevendo em ordem descrescente ficam " + descrescente +  " e a média entre eles é " + media);
        System.out.println("O fatorial do valor é " + fatorial);
        
        // O exercício 7 é usar funções já definidas
        sc.close();

    }
}