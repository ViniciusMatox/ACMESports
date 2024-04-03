import java.util.Scanner;
import java.util.ArrayList;

public class Atleta {
    private int numero;
    private String nome;
    private String pais;

    private ArrayList<Medalha>listaMedalhas;
    private Scanner in = new Scanner(System.in);


    public Atleta(int numero, String nome, String pais) {
        this.numero = numero;
        this.nome = nome;
        this.pais = pais;

    }

    public int getNumero() {
        return numero;
    }
    public ArrayList<Medalha>getMedalhas(){
        return this.listaMedalhas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }



    public void adicionaMedalha(Medalha medalha){
        listaMedalhas.add(medalha);
    }
    public int consultaQuantidadeMedalha(){
        return listaMedalhas.size();
    }

    @Override
    public String toString() {
        return "{" +
                " Numero='" + getNumero() + "'" +
                ", Nome='" + getNome() + "'" +
                ", Pais='" + getPais() + "'" +
                "}";
    }
}