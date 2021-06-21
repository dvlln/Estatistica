import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Estatistica {

    static DecimalFormat df = new DecimalFormat(".00");
    static int cont = 0, flag1 = 0; // contator de quantos numeros repetiram || flag se houve moda


    //                          EXIBE E ORDENA VETOR

    // Exibe um vetor de inteiros
    public static void exibe(int vet[]) {
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }
    }

    // Ordena um vetor de inteiros
    public static void rol(int vet[]) {
        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < vet.length - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    int aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
    }

    // Exibe um vetor de dobros
    public static void exibe(double vet[]) {
        for (int i = 0; i < vet.length; i++) {
            System.out.println(df.format(vet[i]));
        }
    }

    // Ordena um vetor de dobros
    public static void rol(double vet[]) {
        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < vet.length - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    double aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
    }


    //                              LER ARQUIVO

    // Le arquivo com valores INT
    public static int[] lerArquivoI() throws FileNotFoundException, IOException {
        int vet[];
        String arqLeitura = "";
        String linha;

        JFileChooser chooser = new JFileChooser();
        // filtro de tipo de arquivo
        FileFilter filter = new FileNameExtensionFilter("Só TXT !", "txt");
        chooser.addChoosableFileFilter(filter);

        // diálogo de escolha do arquivo
        int returnVal = chooser.showOpenDialog(chooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            arqLeitura = chooser.getSelectedFile().getAbsolutePath();
        }

        // esse bloco de código serve somente para descobrir quantas linhas tem no
        // arquivo
        int N = 0;
        BufferedReader buffRead = new BufferedReader(new FileReader(arqLeitura));
        linha = buffRead.readLine();
        while (linha != null) {
            N++;
            linha = buffRead.readLine();
        }
        buffRead.close();

        vet = new int[N];

        if (N > 0) {
            int i = 0;
            buffRead = new BufferedReader(new FileReader(arqLeitura));
            System.out.println("Lendo o arquivo " + arqLeitura);
            System.out.println("Numero de Linhas: " + N);
            linha = buffRead.readLine();

            while (linha != null) {
                vet[i++] = Integer.parseInt(linha);
                linha = buffRead.readLine();
            }
            buffRead.close();
        } else {
            System.out.println("Arquivo vazio !");
        }
        return vet;
    }

    // Le arquivo com valores DOUBLE
    public static double[] lerArquivoD() throws FileNotFoundException, IOException {
        double vet[];
        String arqLeitura = "";
        String linha;

        JFileChooser chooser = new JFileChooser();
        // filtro de tipo de arquivo
        FileFilter filter = new FileNameExtensionFilter("Só TXT !", "txt");
        chooser.addChoosableFileFilter(filter);

        // diálogo de escolha do arquivo
        double returnVal = chooser.showOpenDialog(chooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            arqLeitura = chooser.getSelectedFile().getAbsolutePath();
        }

        // esse bloco de código serve somente para descobrir quantas linhas tem no
        // arquivo
        int N = 0;
        BufferedReader buffRead = new BufferedReader(new FileReader(arqLeitura));
        linha = buffRead.readLine();
        while (linha != null) {
            N++;
            linha = buffRead.readLine();
        }
        buffRead.close();

        vet = new double[N];

        if (N > 0) {
            int i = 0;
            buffRead = new BufferedReader(new FileReader(arqLeitura));
            System.out.println("Lendo o arquivo " + arqLeitura);
            System.out.println("Numero de Linhas: " + N);
            linha = buffRead.readLine();

            while (linha != null) {
                vet[i++] = Double.parseDouble(linha);
                linha = buffRead.readLine();
            }
            buffRead.close();
        } else {
            System.out.println("Arquivo vazio !");
        }
        return vet;
    }


    //                            MEDIA E MEDIANA

    // Media de inteiros
    public static void media(int vet[]) {
        int aux = 0;
        for (int i = 0; i < vet.length; i++) {
            aux += vet[i];
        }
        System.out.println("Media: " + aux / vet.length);
    }

    // Media de dobros
    public static void media(double vet[]) {
        double aux = 0;
        for (int i = 0; i < vet.length; i++) {
            aux += vet[i];
        }
        System.out.println("Media: " + df.format(aux / vet.length));
    }

    // Mediana de inteiros
    public static void mediana(int vet[]) {
        int meio;
        rol(vet);
        if (vet.length % 2 == 0) {
            int meio1 = vet[vet.length / 2];
            int meio2 = vet[(vet.length / 2) - 1];
            meio = (meio2 + meio1) / 2;
        } else {
            meio = vet[vet.length / 2];
        }

        System.out.println("Mediana: " + meio);
    }

    // Mediana de dobros
    public static void mediana(double vet[]) {
        double meio;
        rol(vet);
        if (vet.length % 2 == 0) {
            double meio1 = vet[vet.length / 2];
            double meio2 = vet[(vet.length / 2) - 1];
            meio = (meio2 + meio1) / 2;
        } else {
            meio = vet[vet.length / 2];
        }

        System.out.println("Mediana: " + df.format(meio));
    }


    //                                MODA 

    // Moda de inteiros - matriz
    public static void moda(int vet[]) {
        int[][] moda = {};
        
        for (int i = 0; i < vet.length - 1; i++) {
            if(vet[i] == vet[i+1]){
                int flag2=0;
                for(int l=0; l<moda.length;l++){
                    if(moda[l][0]==vet[i]){
                        moda[l][1] += 1;
                        flag2=1;
                    }
                }
                if(flag2==0){
                    moda = addVetor(vet[i], moda);
                }
                flag1=1;
            }
        }

        
        if(flag1==1){
            for (int i = 0; i < moda.length; i++) {
                System.out.println(moda[i][0]+" - "+moda[i][1]);
            }
        }
        else{
            System.out.println("Nenhum numero repetiu :c");
        }
    }
    
    // Moda de dobros
    public static void moda(double vet[]) {
        double[][] moda = {};
        
        for (int i = 0; i < vet.length - 1; i++) {
            int flag2=0;
            if(vet[i] == vet[i+1]){
                for(int l=0; l<moda.length;l++){
                    if(moda[l][0]==vet[i]){
                        moda[l][1] += 1;
                        flag2=1;
                    }
                }
                if(flag2==0){
                    moda = addVetor(vet[i], moda);
                }
                flag1=1;
            }
        }
        
        if(flag1==1){
            for (int i = 0; i < moda.length; i++) {
                System.out.println(moda[i][0]+" - "+((int)moda[i][1]));
            }
        }
        else{
            System.out.println("Nenhum numero repetiu :c");
        }
    }

    // Adiciona ao vetor de inteiros da moda
    public static int[][] addVetor(int num, int[][] vet){
        int[][] arm = new int[vet.length+1][2];

        for(int i=0; i<vet.length; i++){
            arm[i][0] = vet[i][0];
            arm[i][1] = vet[i][1];
        }

        arm[arm.length-1][0] = num;
        arm[arm.length-1][1] = 1;

        return arm;
    }
    
    // Adicona ao vetor de dobros da moda
    public static double[][] addVetor(double num, double[][] vet){
        double[][] arm = new double[vet.length+1][2];

        for(int i=0; i<vet.length; i++){
            arm[i][0] = vet[i][0];
            arm[i][1] = vet[i][1];
        }

        arm[arm.length-1][0] = num;
        arm[arm.length-1][1] = 1;

        return arm;
    }
    
}
