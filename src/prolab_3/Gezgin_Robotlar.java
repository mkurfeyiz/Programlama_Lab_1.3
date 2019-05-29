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
public class Gezgin_Robotlar implements Robotlar{
    int hiz;
    int motorSayisi;
    int yuk;
    int uzuv_sayisi;
    int x=0,y=0;
    double sure=0;
    double toplam_sure=0;
    Gezgin_Robotlar(int motorSayisi,int yuk){
        this.motorSayisi=motorSayisi;
        this.yuk=yuk;
    }
    public double EngelGecmeSuresiBul(String robot,int engel_sayisi){
        if(robot.equalsIgnoreCase("spider")){
            this.sure=0;
        }
        else if(robot.equalsIgnoreCase("paletli")){
            this.sure=engel_sayisi*motorSayisi*3;
        }
        else if(robot.equalsIgnoreCase("tekerlekli")){
            this.sure=engel_sayisi*motorSayisi*0.5;
        }
        return this.sure;
    }
    @Override
    public void sureyiGoster(int mesafe,String robot,int engel_sayisi){
        if(robot.equalsIgnoreCase("spider")){
            engel_sayisi=0;
        }
        this.toplam_sure=((double)(mesafe-engel_sayisi)/this.hiz)+this.EngelGecmeSuresiBul(robot,engel_sayisi);
        System.out.println("Seçilen robotun,verilen yükü istenen konuma taşıma süresi "+this.toplam_sure+" saniyedir.");
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
        System.out.println("Robotun ızgaradaki son konumu "+this.x+","+this.y+" noktasıdır.");
    }
}