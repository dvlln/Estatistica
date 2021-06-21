import java.io.FileNotFoundException;
import java.io.IOException;

//como não há um meio de fazer OVERRIDE nos metodos lerArquivo, eles tem de ser usados separadamente - comentando os outros.
//apos boas horas eu desisti do OVERRIDE e mudei o nome. `-´
//Queria declarar aqui meu descontentamento que array de objetos não podem ser responsivos. linguagem toxica.

public class firstCode{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        //                             Rascunho
        /*
        // tamanho do espaço amostral
        int N = 10;
        
        // iremos trabalhar com vetores int e double
        int[] vetorInt = new int[N];
        double[] vetorDouble = new double[N];
        
        // inicializando os valores dos vetores
        for (int i = 0; i < N; i++) {
            vetorInt[i] = (int)(Math.random()*N*N);
            vetorDouble[i] = (double)(Math.random()*N*N);
        }
        
        System.out.println("");

        // testando o vetor de inteiros
        System.out.println("Vetor de Inteiros Original");
        Estatistica.exibe(vetorInt);
        System.out.println("");
        System.out.println("Vetor de Inteiros Ordenado");
        Estatistica.rol(vetorInt);
        Estatistica.exibe(vetorInt);
        
        System.out.println("--------------------------");

        //// testando o vetor de double
        System.out.println("Vetor de Double Original");
        Estatistica.exibe(vetorDouble);
        System.out.println("");
        System.out.println("Vetor de Double Ordenado");
        Estatistica.rol(vetorDouble);
        Estatistica.exibe(vetorDouble);
        */

        //                             Inteiros
        /*
        System.out.println("\nInteiros");
        int[] vetorInt;
        vetorInt = Estatistica.lerArquivoI();
        //Estatistica.exibe(vetorInt);
        
        System.out.println("-------------------------");
        
        System.out.println("");
        //System.out.println("Vetor de Inteiros Ordenado");
        //Estatistica.rol(vetorInt);
        //Estatistica.exibe(vetorInt);
        
        
        System.out.println("\n");
        Estatistica.media(vetorInt);
        Estatistica.mediana(vetorInt);
        System.out.println("Moda:");
        Estatistica.moda(vetorInt);
       */ 
        
        //                             Dobros
        
        System.out.println("\nDobros: ");
        double[] vetorDouble;
        vetorDouble = Estatistica.lerArquivoD();
        Estatistica.exibe(vetorDouble);

        System.out.println("-------------------------");
        
        System.out.println("");
        System.out.println("Vetor de Dobros Ordenado");
        //Estatistica.rol(vetorDouble);
        Estatistica.exibe(vetorDouble);
        
        
        System.out.println("\n");
        Estatistica.media(vetorDouble);
        Estatistica.mediana(vetorDouble);
        Estatistica.moda(vetorDouble);
        

        System.out.println("");
    }
}