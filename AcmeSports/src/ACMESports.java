import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;


public class ACMESports {

    private Scanner entrada = null;                 // Atributo para entrada de dados
    private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
	private Medalheiro medalheiro;
	private Plantel plantel;
	private int numero;
	private String nome;

    public ACMESports() {
        try {
			BufferedReader streamEntrada = new BufferedReader(new FileReader("dadosin.txt"));
			entrada = new Scanner(streamEntrada);
			PrintStream streamSaida = new PrintStream(new File("dadosout.txt"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
		entrada.useLocale(Locale.ENGLISH);
		medalheiro = new Medalheiro();
		plantel = new Plantel();


    }


    private void restauraES() {
        System.setOut(saidaPadrao);
        entrada = new Scanner(System.in);
    }
    public void Executar(){

    }
    private void cadastraAtleta(){
        registrarAtleta();
		registrarMedalhas();
		atletaNaMedalha();
		informacoesAtletas(numero);
		informacoesAtletas(nome);
		informacoesMedalhas();
		mostrarPaisDosAtletas();
		mostraAtletasMedalhasInfo();
		mostrarAtlteasDeModalidade();
		mostrarAtletacomMaisMedalhas();

    }
    private void registrarAtleta(){
        int numero = entrada.nextInt();
        entrada.nextLine();

        while (numero!=-1) {
            String nome = entrada.nextLine();
            String pais = entrada.nextLine();
            Atleta atletaRegistrado = new Atleta(numero, nome, pais);
            plantel.cadastraAtleta(atletaRegistrado);
            System.out.println("1: " + atletaRegistrado.getNumero() + atletaRegistrado.getNome() + atletaRegistrado.getPais());
        }
    }
    private void registrarMedalhas(){
        int codigo = entrada.nextInt();
        entrada.nextLine();
        while (codigo!=-1) {
            int tipo = entrada.nextInt();
            entrada.nextLine();
            boolean individual = entrada.nextBoolean();
            entrada.nextLine();
            String tipoModalidade = entrada.nextLine();
            Medalha m = new Medalha(codigo, tipo, individual, tipoModalidade);
            System.out.println("2: " + m.getCodigo() + m.getTipo() + m.isIndividual() + m.getModalidade());
        }
    }
    private void atletaNaMedalha(){
        int numeroAtleta = entrada.nextInt();
        entrada.nextLine();
        int codigoMedalha = entrada.nextInt();
        entrada.nextLine();
       Atleta a = plantel.consultaAtleta(numeroAtleta);
       Medalha m = medalheiro.consultaMedalha(codigoMedalha);
       m
        
    }

}