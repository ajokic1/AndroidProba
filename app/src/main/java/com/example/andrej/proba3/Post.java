package com.example.andrej.proba3;

import android.media.Image;

/**
 * Created by Andrej on 8.3.2017..
 */

public class Post {
    String ime;
    String fakultet;
    int slika;
    String tekst;

    public Post() {
    }

    public Post(String ime, String fakultet, int slika, String tekst) {
        this.ime = ime;
        this.fakultet = fakultet;
        this.slika = slika;
        this.tekst = tekst;
    }

    public String getIme() {
        return ime;
    }

    public String getFakultet() {
        return fakultet;
    }

    public int getSlika() {
        return slika;
    }

    public String getTekst() {
        return tekst;
    }
}
