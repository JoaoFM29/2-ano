package resolucao2;
import java.util.Arrays;
import java.util.Random;

public class Ficha2 {

    private int[] numeros;
    private int[] numeros2;
    private int[] numeros3;
    private String[] stringEqual;
    private String[] stringEqual2;

    public void setArray(int [] nums)
    {
        numeros = Arrays.copyOf(nums, nums.length);
    }

    public int min()
    {
        int n = Integer.MAX_VALUE; // ou inteiros[0] e depois do for começar com o i = 1
        for(int num: numeros)
        {
            if(num < n) n = num;
        }
        return n;
    }

    public int[] setArray2(int a, int b)
    {
        return Arrays.copyOfRange(numeros, a, b);
    }

    public void setArray3(int[] a, int[] b)
    {
        numeros2 = Arrays.copyOf(a, a.length);
        numeros3 = Arrays.copyOf(b, b.length);
    }

    public int[] NumEqual()
    {
        int lenght1 = numeros2.length;
        int lenght2 = numeros3.length;
        int[] array;
        int k = 0;

        if(lenght1<lenght2)
        {
            array = new int[lenght1];
           
        }
        else 
        {
            array = new int[lenght2]; 
        }
        Arrays.sort(numeros2);
        Arrays.sort(numeros3);

        for(int i = 0; i < numeros2.length; i++)
        {
            for(int j = 0; j < numeros3.length; j++)
            {
                if(numeros2[i] < numeros3[j]) break;
                if(numeros2[i] == numeros3[j]) 
                    {
                        if(k > 0 && array[k-1] == numeros2[i]);
                        else 
                            {
                                array[k] = numeros2[i]; k++;
                            }
                    }
            }
        }
    return array;
    }

    public String[] stringEqual(String[] array)
    {
        stringEqual = Arrays.copyOf(array, array.length);
        return stringEqual;
    }

    public int stringMaior(String[] array)
    {
        int max = 0;
        int i;
        stringEqual = Arrays.copyOf(array, array.length);
        for(i =0; i< stringEqual.length; i++)
        {
            if(stringEqual[i].length() > max){ max = stringEqual[i].length();} 
        }
        return max ;
    }

    private static Boolean procuraNomeNaLista(String[] lista, int posicaoAtual, String nome)
    {
        for(int i = 0; i < posicaoAtual; i++)
            {
                if(lista[i].equals(nome)) 
                    {
                        return true;
                    }
            }
        return false;
    }

    public String[] arrayCSE(String[] array)
    {
        int i, j = 0;
        stringEqual2 = Arrays.copyOf(array, array.length);
        String[] aux = new String[stringEqual2.length];
        for (i = 0; i < stringEqual2.length; i++) 
        {
            if (procuraNomeNaLista(stringEqual2, i, stringEqual2[i]))
            {
                System.out.println("ja existe esse nome");
            } else {
                aux[j] = stringEqual2[i];
                j++;
                System.out.println("Registrado");
            }
        }
        return aux;
    }

    private Boolean procuraChaveNaLista(int[] chave, int chaveAux)
    {
        for(int i = 0; i < chave.length; i++)
            {
                if(chave[i] == chaveAux) 
                    {
                        return true;
                    }
            }
        return false;
    }

    public void random(int[] c, int[] e) 
        {

            Random gerador = new Random();
            Random gerador2 = new Random();
            int[] chave = new int[c.length];
            int[] estrela = new int[e.length];
            int contChave = 0;
            int contEstrela = 0;
            
            //gera as chaves aleatoriamente
            for (int i = 0; i < chave.length; i++) 
                {
                    chave[i] = (gerador.nextInt(1,50));
                }
            //gera as estrelas aleatoriamente
            for (int i = 0; i < estrela.length; i++) 
                {
                    estrela[i] = (gerador2.nextInt(1, 9));
                }

            //verifica e há alguma chave igual
            for(int i = 0; i < chave.length; i ++)
            {
                if(procuraChaveNaLista(chave, c[i]))
                {
                    System.out.println("Acertou na chave: " + c[i]);
                    contChave ++;
                }
            }

            //verifica se há alguma estrela igual
            for(int i = 0; i < estrela.length; i ++)
            {
                if(procuraChaveNaLista(estrela, e[i]))
                {
                    System.out.println("Acertou na estrela: " + e[i]);
                    contEstrela ++;
                }
            }

            if(contChave == 5 && contEstrela == 2)
            {
                for(int i = 0; i < 50; i++)
                {
                    System.out.println("A chave do EuroMilhoes é \n" + Arrays.toString(chave) + Arrays.toString(estrela));
                }
            }
            else
            {
                System.out.println("A chave do EuroMilhoes é \n" + Arrays.toString(chave) + Arrays.toString(estrela));
            }
            
        }
    }


