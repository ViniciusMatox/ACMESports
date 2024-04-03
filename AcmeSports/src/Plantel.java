import java.util.ArrayList;

public class Plantel {
    private ArrayList<Atleta> atletas;

    public Plantel() {
        this.atletas = new ArrayList<>();
    }

    public ArrayList<Atleta> getAtletas() {
        return this.atletas;
    }

    public void setAtletas(ArrayList<Atleta> atletas) {
        this.atletas = atletas;
    }

    public boolean cadastraAtleta(Atleta atleta) {
        for (Atleta a : atletas) {
            if (a.getNumero() == atleta.getNumero()) {
                return false;
            }
        }
        atletas.add(atleta);
        return true;
    }

    public Atleta consultaAtleta(String nome) {
        for (Atleta a : atletas) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }

    public Atleta consultaAtleta(int numero) {
        for (Atleta a : atletas) {
            if (a.getNumero() == numero) {
                return a;
            }
        }
        return null;
    }

    public Atleta ConsultaAtletaMaisMedalhas() {
        if (atletas.isEmpty()) {
            return null;
        }
        Atleta atletaComMaisMedalhas = null;
        int maxMedalhas = -1;
        int i = 0;
        while (i < atletas.size()) {
            Atleta a = atletas.get(i);
            int quantidadeMedalhas = a.consultaQuantidadeMedalha();
            if (quantidadeMedalhas > maxMedalhas) {
                maxMedalhas = quantidadeMedalhas;
                atletaComMaisMedalhas = a;
            }
            i++;
        }
        return atletaComMaisMedalhas;
    }


    @Override
    public String toString() {
        return "{" +
                " Atletas='" + getAtletas() + "'" +
                "}";
    }
}