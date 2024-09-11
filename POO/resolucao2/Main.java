package resolucao2;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args)
        {

        Scanner sc = new Scanner(System.in);
        Ficha2 f2 = new Ficha2();

 
    //Exercicio 1 a)
        System.out.print (" Indique o tamanho do array a usar: ");
        
        int length = sc.nextInt();
        int[] array = new int[length];

        for (int i = 0; i < length ; i ++) 
            {
                System.out.print (" Indique um valor para inserir no array: ");
                array[i] = sc.nextInt();
            }
        f2.setArray(array);
        System.out.println("O minimo do array é: " + f2.min()); 

        //Exercicio 1 b)
        System.out.print ("Insere dois valores :\n");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int[] arrayAux = f2.setArray2(a, b);
        System.out.println ("O array dentro dos valores dados é \n" + Arrays.toString(arrayAux));

        //Exercicio 1 c)
        System.out.print (" Indique o tamanho de um segundo array a usar: ");
        
        int length2 = sc.nextInt();
        int[] array2 = new int[length2];

        for (int i = 0; i < length2 ; i ++) 
            {
                System.out.print (" Indique um valor para inserir no array novo: ");
                array2[i] = sc.nextInt();
            }
        f2.setArray3(array, array2);
        int [] arrayAux2 = f2.NumEqual();
        System.out.println("Os numeros iguais dos arrays criados são : " + Arrays.toString(arrayAux2));

        //Exercício 3 a) b) c)
        System.out.print (" Indique o tamanho para usar num array de strings: ");
        int length3 = sc.nextInt();
        String[] array3 = new String[length3];

        for (int i = 0; i < length3 ; i ++) 
            {
                System.out.print ("Indique uma string para inserir no array: ");
                array3[i] = sc.next();
            }

        String[] arrayString = f2.stringEqual(array3);
        String[] arrayString2 = f2.arrayCSE(arrayString);
        System.out.println("O array composto pelas strings dadas é : " + Arrays.toString(arrayString) + " e a maior string é " + f2.stringMaior(arrayString) +
                            " as string que aparecem mais que uma vez são " + Arrays.toString(arrayString2));
        
        //A alinea d) é simples basta adpatar a função usada para a c) 

        //Exercício 6 a)
        /*
            a) Utilizar dois for para ler as linhas e as colunas da matriz 
            b) A cada elemento [i][i] de uma matriz somar a outra na posiçao tambem [i][i] e guardar o valor noutra matriz
            c) Percorrer a matriz toda a ir verficando um a um se é igual a outro noutra matriz na mesma posiçao
            d) Preencher outra matriz com os simétricos dos valores da matriz argumento
        */

        //Exercício 7
        int[] chave = new int[5];
        int[] estrela = new int[2];
        System.out.print ("------- JOGO DO EUROMILHOES -------\n");
        for (int i = 0; i < chave.length ; i ++) 
        {
            System.out.print (" Indique um valor para a chave: ");
            chave[i] = sc.nextInt();
        }
        for (int i = 0; i < estrela.length ; i ++) 
        {
            System.out.print (" Indique um valor para a estrela: ");
            estrela[i] = sc.nextInt();
        }
        
        f2.random(chave, estrela);
        sc.close();
        }
}