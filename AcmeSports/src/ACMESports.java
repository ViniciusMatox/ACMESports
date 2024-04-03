import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
        int codigoMedalha = entrada.nextInt();
        entrada.nextLine();
        while (codigoMedalha != -1) {
            int numeroAtleta = entrada.nextInt();
            entrada.nextLine();
                Atleta a = plantel.consultaAtleta(numeroAtleta);
                Medalha m = medalheiro.consultaMedalha(codigoMedalha);
                a.adicionaMedalha(m);
                m.adicionaAtleta(a);    
                System.out.println("3: " + codigoMedalha + numeroAtleta);
        }
    }
    private void dadosAtletaNum(){
        Atleta atleta;
        int numeroAtleta = entrada.nextInt();
        entrada.nextLine();
        atleta = plantel.consultaAtleta(numeroAtleta);
        if(atleta!=null){
            System.out.println("4" + atleta.toString());
        } else System.out.println("4: Atleta não encontrado");
    }
    private void dadosAtletaNome(){
        Atleta atleta;
        String nomeAtleta = entrada.nextLine();
        atleta = plantel.consultaAtleta(nomeAtleta);
        if (atleta!=null) {
            System.out.println("5: " + atleta.toString());
        } else System.out.println("5: Atleta não encontrado");
    }

    private void mostraDadosMedalha(){
        int codigoMedalha = entrada.nextInt();
        entrada.nextInt();
        Medalha medalha = medalheiro.consultaMedalha(codigoMedalha);
        entrada.nextLine();
        if (medalha!=null ) {
            System.out.println("6: " + medalha.getCodigo() + medalha.getTipo() + medalha.isIndividual() + medalha.getModalidade());
        }
    }

    private void mostraDadosAtletaPais(){
        ArrayList<Atleta>paises = new ArrayList<>();
        String pais = entrada.nextLine();
       for (Atleta atleta : plantel.getAtletas()){
            if (atleta.getPais().equals(pais)) {
                paises.add(atleta);
            }
            System.out.println("7: " + atleta.getNumero() + atleta.getNome() + atleta.getPais());
       }
    }

    private void mostraDadosAtletaMedalhas(){
        ArrayList<Atleta>medalhas = new ArrayList<>();
        int tipoMedalha = entrada.nextInt();
        entrada.nextLine();
        for (Atleta atleta : plantel.getAtletas()){
           for (Medalha medalha : atleta.getMedalhas()) {
                if (atleta.getMedalhas().equals(medalhas)) {
                    medalhas.add(atleta);
                }
           }
            System.out.println("8: " + atleta.getNumero() + atleta.getNome() + atleta.getPais());
        }
    }
    private void mostraDadosAtletaModalidade(){
        ArrayList<Medalha>modalidades = new ArrayList<>();
        String modalidade = entrada.nextLine();
        for (Atleta atleta : plantel.getAtletas()){
            if (atleta.getPais().equals(modalidade)) {
                modalidades.add(null)
            }
            System.out.println("9: " + atleta.get + atleta.getNome() + atleta.getPais());   
    }
}