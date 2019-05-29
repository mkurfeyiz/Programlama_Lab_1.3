/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab_3;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class Hibrit_Robotlar extends Gezgin_Robotlar implements Manipulator_Robotlar{
    
   Scanner input=new Scanner(System.in);
    int yukTasimaKapasitesi;
    int kol_uzunlugu;
    int tasima_hizi;
    Hibrit_Robotlar(int motorSayisi,int yuk,String yeni_robot,String yeni_robot2){
        super(motorSayisi,yuk);
        Spider spider=new Spider(motorSayisi,yuk,uzuv_sayisi);
        Paletli paletli=new Paletli(motorSayisi,yuk,uzuv_sayisi);
        Tekerlekli tekerlekli=new Tekerlekli(motorSayisi,yuk,uzuv_sayisi);
        Seri seri=new Seri(motorSayisi,yuk);
        Paralel paralel=new Paralel(motorSayisi,yuk);
        this.motorSayisi=motorSayisi;
        this.yuk=yuk;
        if(yeni_robot.equalsIgnoreCase("spider") && yeni_robot2.equalsIgnoreCase("seri")){
            System.out.println("Robotun bacak sayısını girin");
            this.uzuv_sayisi=input.nextInt();
            this.hiz=spider.hiz;
            this.yukTasimaKapasitesi=seri.yukTasimaKapasitesi;
            this.kol_uzunlugu=seri.kol_uzunlugu;
            this.tasima_hizi=seri.tasima_hizi;
        }
        else if(yeni_robot.equalsIgnoreCase("spider") && yeni_robot2.equalsIgnoreCase("paralel")){
            System.out.println("Robotun bacak sayısını girin");
            this.uzuv_sayisi=input.nextInt();
            this.hiz=spider.hiz;
            this.yukTasimaKapasitesi=paralel.yukTasimaKapasitesi;
            this.kol_uzunlugu=paralel.kol_uzunlugu;
            this.tasima_hizi=paralel.tasima_hizi;
        }
        else if(yeni_robot.equalsIgnoreCase("paletli") && yeni_robot2.equalsIgnoreCase("seri")){
            System.out.println("Robotun palet sayısını girin");
            this.uzuv_sayisi=input.nextInt();
            this.hiz=paletli.hiz;
            this.yukTasimaKapasitesi=seri.yukTasimaKapasitesi;
            this.kol_uzunlugu=seri.kol_uzunlugu;
            this.tasima_hizi=seri.tasima_hizi;
        }
        else if(yeni_robot.equalsIgnoreCase("paletli") && yeni_robot2.equalsIgnoreCase("paralel")){
            System.out.println("Robotun palet sayısını girin");
            this.uzuv_sayisi=input.nextInt();
            this.hiz=paletli.hiz;
            this.yukTasimaKapasitesi=paralel.yukTasimaKapasitesi;
            this.kol_uzunlugu=paralel.kol_uzunlugu;
            this.tasima_hizi=paralel.tasima_hizi;
        }
        else if(yeni_robot.equalsIgnoreCase("tekerlekli") && yeni_robot2.equalsIgnoreCase("seri")){
            System.out.println("Robotun tekerlek sayısını girin");
            this.uzuv_sayisi=input.nextInt();
            this.hiz=tekerlekli.hiz;
            this.yukTasimaKapasitesi=seri.yukTasimaKapasitesi;
            this.kol_uzunlugu=seri.kol_uzunlugu;
            this.tasima_hizi=seri.tasima_hizi;
        }
        else if(yeni_robot.equalsIgnoreCase("tekerlekli") && yeni_robot2.equalsIgnoreCase("paralel")){
            System.out.println("Robotun tekerlek sayısını girin");
            this.uzuv_sayisi=input.nextInt();
            this.hiz=tekerlekli.hiz;
            this.yukTasimaKapasitesi=paralel.yukTasimaKapasitesi;
            this.kol_uzunlugu=paralel.kol_uzunlugu;
            this.tasima_hizi=paralel.tasima_hizi;
        }
        else{
            System.out.println("Yanlış giriş yaptınız ! ");
        }
    }
    public void hibritSureHesapla(int mesafe1,int mesafe2,int engel_sayisi,String robot1,String robot2){
        this.toplam_sure+=(double)mesafe1/this.hiz+super.EngelGecmeSuresiBul(robot1, engel_sayisi);
        this.toplam_sure+=(double)mesafe2/this.tasima_hizi;
        System.out.println("Seçilen robotun,verilen yükü istenilen konuma taşıma süresi "+this.toplam_sure+" saniyedir.");
    }
}