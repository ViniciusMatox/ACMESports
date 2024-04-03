import java.util.ArrayList;

public class Medalheiro {
    private ArrayList<Medalha> listaMedalhas;

    public Medalheiro(){
        this.listaMedalhas = new ArrayList<>();
    }

    public void setListaMedalhas(ArrayList<Medalha> listaMedalhas) {
        this.listaMedalhas = listaMedalhas;
    }

    public ArrayList<Medalha> getListaMedalhas() {
        return listaMedalhas;
    }

    public boolean cadastraMedalha(Medalha m){
        int i = 0;
        boolean encontrou = false;
        while (i < listaMedalhas.size() && !encontrou) {
            m = listaMedalhas.get(i);
            if (m.getCodigo() == m.getCodigo()) {
                encontrou = true;
            }
            i++;
        }

        if (!encontrou) {
            listaMedalhas.add(m);
            return true;
        } else {
            return false;
        }
    }
    public Medalha consultaMedalha(int codigo){
            int i = 0;
            while (i < listaMedalhas.size()) {
                Medalha m = listaMedalhas.get(i);
                if (m.getCodigo() == codigo) {
                    return m;
                }
                i++;
            }
            return null;
        }

    public ArrayList<Medalha> consultaMedalhas(String modalidade) {
        ArrayList<Medalha> medalhaConsultada = new ArrayList<>();
        int i = 0;
        while (i < listaMedalhas.size()) {
            Medalha m = listaMedalhas.get(i);
            if (m.getModalidade().equals(modalidade)) {
                medalhaConsultada.add(m);
            }
            i++;
        }
        return medalhaConsultada;
    }




}