package users;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by gcioffi on 14/09/2016.
 */

public class ListaUtenze extends Application {

    private ArrayList<Utenza> listaUtenze;

    public ListaUtenze() {

        this.listaUtenze = new ArrayList<>();
        addUtente(new Utenza("gcioffi@indra.es", "ciaociao"));
        addUtente(new Utenza("giuseppe@indra.es", "ciaooo"));

    }

    public ArrayList<Utenza> getListaUtenze() {

        return this.listaUtenze;
    }

    public void setListaUtenze(ArrayList listaUtenze) {

        this.listaUtenze = listaUtenze;
    }

    public boolean addUtente(Utenza utente){

        for (Utenza u: this.listaUtenze) {
            if(u.equals(utente)) {
                System.out.println("Utenza non aggiunta");
                return false;
            }
        }

        this.listaUtenze.add(utente);
        System.out.println("Nuova utenza aggiunta: " + utente.getEmail() + " " + utente.getPassword());
        return true;
    }

}
