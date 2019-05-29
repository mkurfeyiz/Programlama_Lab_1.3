/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab_3;

/**
 *
 * @author user
 */
public class Seri implements Manipulator_Robotlar{
    int yukTasimaKapasitesi;
    int kol_uzunlugu;
    int tasima_hizi;
    int motorSayisi;
    int yuk;
    int x=0,y=0;
    double toplam_sure=0;
    Seri(int motorSayisi,int yuk){
        this.motorSayisi=motorSayisi;
        this.yuk=yuk;
        yukTasimaKapasitesi=10;
        kol_uzunlugu=10;
        tasima_hizi=20;
    }
    @Override
    public void sureyiGoster(int mesafe,String robot,int engel_sayisi){
        this.toplam_sure=((double)mesafe/this.tasima_hizi);
        System.out.println("Robotun,verilen yükü istenilen konuma taşıma süresi "+this.toplam_sure+" saniyedir.");
    }
    @Override
    public void ileri(int y){
        this.y=this.y+y*10;
    }
    @Override
    public void geri(int y){
        this.y=this.y-y*10;
    }
    @Override
    public void saga(int x){
        this.x=this.x+x*10;
    }
    @Override
    public void sola(int x){
        this.x=this.x-x*10;
    }
    @Override
    public void sonKonum(){
        System.out.println("Robotun yükü götürdüğü nokta "+this.x+","+this.y+" noktasıdır.");
    }
}