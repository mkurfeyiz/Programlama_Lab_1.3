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
public class Paletli extends Gezgin_Robotlar{
   Paletli(int motorSayisi,int yuk,int uzuv_sayisi){
        super(motorSayisi,yuk);
        this.motorSayisi=motorSayisi;
        this.yuk=yuk;
        this.uzuv_sayisi=uzuv_sayisi;
    }
    @Override
    public double EngelGecmeSuresiBul(String robot,int engel_sayisi){
        this.sure=motorSayisi*3;
        return this.sure;
    }
    @Override
    public void sureyiGoster(int mesafe,String robot,int engel_sayisi){
        this.toplam_sure=mesafe/this.hiz+this.EngelGecmeSuresiBul(robot,engel_sayisi);
        System.out.println("Gecen süre : "+this.toplam_sure);
    }
    
}