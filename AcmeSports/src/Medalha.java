import java.util.ArrayList;
import java.util.Scanner;



public class Medalha {

    private int codigo;
    private int tipo;
    private boolean individual;
    private String modalidade;
    private ArrayList<Atleta>listaAtletas;



    public Medalha(int codigo, int tipo, boolean individual, String modalidade) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.individual = individual;
        this.modalidade = modalidade;
        this.listaAtletas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isIndividual() {
        return individual;
    }

    public void setIndividual(boolean individual) {
        this.individual = individual;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public void adicionaAtleta(Atleta atleta){
        listaAtletas.add(atleta);
    }

    @Override
    public String toString() {
        return "Medalha{" +
                "codigo=" + codigo +
                ", tipo=" + tipo +
                ", individual=" + individual +
                ", modalidade='" + modalidade + '\'' +
                ", listaAtletas=" + listaAtletas +
                '}';
    }
}