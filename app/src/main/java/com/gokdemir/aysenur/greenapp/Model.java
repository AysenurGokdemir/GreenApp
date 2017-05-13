package com.gokdemir.aysenur.greenapp;

/**
 * Created by Aysenur on 2.05.2017.
 */

public class Model {
    String sonuc,boy,kilo,isim;
    public Model(){}
public Model(String boy,String kilo,String sonuc,String isim){
    this.boy=boy;
    this.isim=isim;
    this.kilo=kilo;
    this.sonuc=sonuc;

}
    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public String getBoy() {
        return boy;
    }

    public void setBoy(String boy) {
        this.boy = boy;
    }

    public String getKilo() {
        return kilo;
    }

    public void setKilo(String kilo) {
        this.kilo = kilo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
