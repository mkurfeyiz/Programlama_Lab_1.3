/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//ERDEM ÖZER 170201015
//MUHAMMED KURFEYİZ 170201083


package prolab_3;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Erdem Özer
 */
public class ProLab_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      ArrayList<String> robotListesi = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        int secim = 0, tempMesafe = 0;
        int birim = 0;
        String rota;
        String cevap;
        int motor = 0,yuk = 0,uzuv = 0;
        String robot;
        String yeni_robot1="",yeni_robot2="";
        System.out.println("Kaç robot kullanılacak ?");
        int sayi = input.nextInt();
        for (int i = 0; i < sayi; i++) {
            System.out.println("Tanımlanacak robot tipi nedir ?");
            robot = input.next();
            robotListesi.add(robot);
            if (robot.equalsIgnoreCase("spider")) {
                System.out.println("Robotun bacak sayisi girin : ");
                uzuv = input.nextInt();
                System.out.println("Robotun motor sayisini girin : ");
                motor = input.nextInt();
                System.out.println("Robota verilecek yükü girin : ");
                yuk = input.nextInt();
                Spider yeni_robot = new Spider(motor, yuk, uzuv);
            } else if (robot.equalsIgnoreCase("paletli")) {
                System.out.println("Robotun palet sayisi girin : ");
                uzuv = input.nextInt();
                System.out.println("Robotun motor sayisini girin : ");
                motor = input.nextInt();
                System.out.println("Robota verilecek yükü girin : ");
                yuk = input.nextInt();
                Paletli yeni_robot = new Paletli(motor, yuk, uzuv);
            } else if (robot.equalsIgnoreCase("tekerlekli")) {
                System.out.println("Robotun teker sayisi girin : ");
                uzuv = input.nextInt();
                System.out.println("Robotun motor sayisini girin : ");
                motor = input.nextInt();
                System.out.println("Robota verilecek yükü girin : ");
                yuk = input.nextInt();
                Tekerlekli yeni_robot = new Tekerlekli(motor, yuk, uzuv);
            } else if (robot.equalsIgnoreCase("seri")) {
                System.out.println("Robotun motor sayisini girin : ");
                motor = input.nextInt();
                System.out.println("Robota verilecek yükü girin : ");
                yuk = input.nextInt();
                Seri yeni_robot = new Seri(motor, yuk);
                while(yeni_robot.yukTasimaKapasitesi<yuk){
                    System.out.println("Seçilen robot verilen yükü taşıyamaz !");
                    System.out.println("Yeni yük giriniz");
                    yuk=input.nextInt();
                    yeni_robot.yuk=yuk;
                }
            } else if (robot.equalsIgnoreCase("paralel")) {
                System.out.println("Robotun motor sayisini girin : ");
                motor = input.nextInt();
                System.out.println("Robota verilecek yükü girin : ");
                yuk = input.nextInt();
                Paralel yeni_robot = new Paralel(motor, yuk);
                while(yeni_robot.yukTasimaKapasitesi<yuk){
                    System.out.println("Seçilen robot verilen yükü taşıyamaz !");
                    System.out.println("Yeni yük giriniz");
                    yuk=input.nextInt();
                    yeni_robot.yuk=yuk;
                }
                //System.out.println(paralel.yuk);
            } else if (robot.equalsIgnoreCase("hibrit")) {
                System.out.println("Gezgin robot türünü seçin");
                yeni_robot1=input.next();
                System.out.println("Manipulator robot türünü seçin");
                yeni_robot2=input.next();
                System.out.println("Robotun motor sayisini girin : ");
                motor = input.nextInt();
                System.out.println("Robota verilecek yükü girin : ");
                yuk = input.nextInt();
                //System.out.println(hibrit.hiz+" "+hibrit.uzuv_sayisi+" "+hibrit.tasima_hizi);
            } else {
                System.out.println("Yanlış robot ismi girdiniz !");
                System.out.println("Robot ismini tekrar giriniz ");
                robotListesi.remove(i);
                i--;
            }
        }
        System.out.println("Hangi sıradaki robot kullanılacak ?");
        int sira = input.nextInt();
        //System.out.println(robotListesi.get(sira-1));
        int[][] izgara=new int[20][20];
        int mesafe=0;
        int engel_sayisi=0;
        int x,y;
        int i_x=0,i_y=0;
        if(robotListesi.get(sira-1).equalsIgnoreCase("spider") || robotListesi.get(sira-1).equalsIgnoreCase("paletli") || robotListesi.get(sira-1).equalsIgnoreCase("tekerlekli")){
            Gezgin_Robotlar yeni_robot=new Gezgin_Robotlar(motor,yuk);
            System.out.println("Seçilen robotun hız değerini girin");
            yeni_robot.hiz=input.nextInt();
            if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){    
                while(yeni_robot.hiz<10 || yeni_robot.hiz>19){
                    if(yeni_robot.hiz<10){
                        System.out.println("Spider robotların minimum hız değeri 10'dur");
                        System.out.println("Hız değerini tekrar giriniz");
                    }
                    else if(yeni_robot.hiz>19){
                        System.out.println("Spider robotlar,paletli robotlardan veya tekerlekli robotlardan daha hızlı veya aynı hızda olamaz !");
                        System.out.println("Hız değerini tekrar giriniz");
                    }
                    yeni_robot.hiz=input.nextInt();
                }
            }
            else if(robotListesi.get(sira-1).equalsIgnoreCase("paletli")){
                while(yeni_robot.hiz<20 || yeni_robot.hiz>29){
                    if(yeni_robot.hiz<20){
                        System.out.println("Paletli robotların minimum hız değeri 20'dur");
                        System.out.println("Hız değerini tekrar giriniz");
                    }
                    else if(yeni_robot.hiz>29){
                        System.out.println("Paletli robotlar,tekerlekli robotlardan daha hızlı veya aynı hızda olamaz !");
                        System.out.println("Hız değerini tekrar giriniz");
                    }
                    yeni_robot.hiz=input.nextInt();
                }
            }
            else if(robotListesi.get(sira-1).equalsIgnoreCase("tekerlekli")){
                while(yeni_robot.hiz<30){
                    System.out.println("Tekerlekli robotların minimum hız değeri 30'dur");
                    System.out.println("Hız değerini tekrar giriniz");
                    yeni_robot.hiz=input.nextInt();
                }
            }
            System.out.println("Izgara üzerine engel koymak istiyor musunuz ? (E/H) : ");
            cevap=input.next();
            while(!cevap.equalsIgnoreCase("e") || !cevap.equalsIgnoreCase("h")){
                System.out.println("Yanlış cevap verdiniz !");
                System.out.println("Cevabınızı tekrar  giriniz ");
                cevap=input.next();
                if("E".equalsIgnoreCase(cevap) || "H".equalsIgnoreCase(cevap)){
                    break;
                }
            }
            if(cevap.equalsIgnoreCase("e")){
                //CIZILECEK IZGARA 200,200 DEN BASLAYIP 400,400 E GIDICEK
                for(int i=0;i<20;i++){
                    for(int j=0;j<20;j++){
                        izgara[i][j]=1;
                    }
                }
                System.out.println("Kaç adet engel girilecek ?");
                engel_sayisi=input.nextInt();
                System.out.println("Engellerin konulacağı koordinatları giriniz");
                for(int i=0;i<engel_sayisi;i++){
                    System.out.println("x : ");
                    x=input.nextInt();
                    System.out.println("y : ");
                    y=input.nextInt();
                    while(x<200 || x>400 || y<200 || y>400){
                        System.out.println("Izgara dışında koordinat girildi !");
                        System.out.println("Koordinatları tekrar girin ");
                        System.out.println("x : ");
                        x=input.nextInt();
                        System.out.println("y : ");
                        y=input.nextInt();
                    }
                    izgara[(int)(x%200)/10][(int)(y%200)/10]=0;
                }
                System.out.println("Robotun başlangıç konumunu girin ");
                System.out.println("x : ");
                yeni_robot.x=input.nextInt();
                System.out.println("y : ");
                yeni_robot.y=input.nextInt();
                while(izgara[(int)(yeni_robot.x%200)/10][(int)(yeni_robot.y%200)/10]==0){
                    System.out.println("Seçilen konum engel üzerine denk geldi !");
                    System.out.println("Koordinatları tekrar girin ");
                    System.out.println("x : ");
                    yeni_robot.x=input.nextInt();
                    System.out.println("y : ");
                    yeni_robot.y=input.nextInt();
                    while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                        System.out.println("Izgara dışında koordinat girildi !");
                        System.out.println("Koordinatları tekrar girin ");
                        System.out.println("x : ");
                        yeni_robot.x=input.nextInt();
                        System.out.println("y : ");
                        yeni_robot.y=input.nextInt();
                    }
                }
                while(secim==0){
                    engel_sayisi=0;
                    System.out.println("Robotun gideceği yönü belirleyiniz ");
                    rota=input.next();
                    System.out.println("Kaç birim gideceğini giriniz ");
                    birim=input.nextInt();
                    if(rota.equalsIgnoreCase("ileri")){
                        yeni_robot.ileri(birim);
                        mesafe+=birim;
                        for(int i=((yeni_robot.x%200)/10)-birim;i<((yeni_robot.x%200)/10);i++){
                            if(izgara[i][(yeni_robot.y%200)/10]==0){
                                engel_sayisi++;
                            }
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.y-=birim*10;
                            mesafe-=birim;
                            engel_sayisi--;
                            System.out.println("Yönlendirme iptal edildi ");
                        }
                        if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){
                            for(int i=(yeni_robot.x%200)/10;i<birim;i++){
                                if(izgara[i][(int)(yeni_robot.y%200)/10]==0){
                                    System.out.println("Verilen yönde engel var ve Spider robotlar engellerden geçemez !");
                                    System.out.println("Robot,engelin gerisindeki konumda kaldı");
                                    yeni_robot.y-=10;
                                    mesafe-=birim;
                                    mesafe+=(birim-1);
                                    secim=1;
                                    System.out.println("Yönlendirme işlemi,engel sebebiyle durduruldu");
                                }
                            }
                        }
                        
                    }
                    else if(rota.equalsIgnoreCase("geri")){
                        yeni_robot.geri(birim);
                        mesafe+=birim;
                        for(int i=i_x;i<i_x+birim;i++){
                            if(izgara[i][(int)(yeni_robot.y%200)/10]==0){
                                engel_sayisi++;
                            }
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.y+=birim*10;
                            mesafe-=birim;
                            engel_sayisi--;
                            System.out.println("Yönlendirme iptal edildi");
                        }
                        if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){
                            for(int i=(yeni_robot.x%200)/10;i<i_x+birim;i++){
                                if(izgara[i][(int)(yeni_robot.y%200)/10]==0){
                                    System.out.println("Verilen yönde engel var ve Spider robotlar engellerden geçemez !");
                                    System.out.println("Robot,engelin ilerisindeki konumda kaldı");
                                    yeni_robot.y+=10;
                                    mesafe-=birim;
                                    mesafe+=(birim-1);
                                    secim=1;
                                    System.out.println("Yönlendirme işlemi,engel sebebiyle durduruldu");
                                }
                            }
                        }
                    }
                    else if(rota.equalsIgnoreCase("saga")){
                        yeni_robot.saga(birim);
                        mesafe+=birim;
                        for(int i=i_y;i<i_y+birim;i++){
                            if(izgara[i_x][i]==0){
                                engel_sayisi++;
                            }
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.x-=birim*10;
                            mesafe-=birim;
                            engel_sayisi--;
                            System.out.println("Yönlendirme iptal edildi ");
                        }
                        if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){
                            for(int i=i_y;i<i_y+birim;i++){
                                if(izgara[i][i_x]==0){
                                    System.out.println("Verilen yönde engel var ve Spider robotlar engellerden geçemez !");
                                    System.out.println("Robot,engelin solundaki konumda kaldı");
                                    yeni_robot.x-=10;
                                    mesafe-=birim;
                                    mesafe+=(birim-1);
                                    secim=1;
                                    System.out.println("Yönlendirme işlemi,engel sebebiyle durduruldu");
                                }
                            }
                        }
                    }
                    else if(rota.equalsIgnoreCase("sola")){
                        yeni_robot.sola(birim);
                        mesafe+=birim;
                        for(int i=i_y;i<i_y+birim;i++){
                            if(izgara[i_x][i]==0){
                                engel_sayisi++;
                            }
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.x+=birim*10;
                            mesafe-=birim;
                            engel_sayisi--;
                            System.out.println("Yönlendirme iptal edildi ");
                        }
                        if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){
                            for(int i=i_y;i<i_y+birim;i++){
                                if(izgara[i][i_x]==0){
                                    System.out.println("Verilen yönde engel var ve Spider robotlar engellerden geçemez !");
                                    System.out.println("Robot,engelin sağındaki konumda kaldı");
                                    yeni_robot.x+=10;
                                    mesafe-=birim;
                                    mesafe+=(birim-1);
                                    secim=1;
                                    System.out.println("Yönlendirme işlemi,engel sebebiyle durduruldu");
                                }
                            }
                        }
                    }
                    System.out.println("Başka yönlendirme yapmak istiyor musunuz ?(Devam etmek için 0'a basınız.)");
                    secim=input.nextInt();
                }
                /*if(robotListesi.get(sira-1).equalsIgnoreCase("paletli")){
                    yeni_robot.EngelGecmeSuresiBul(robotListesi.get(sira-1),engel_sayisi);
                }
                else if(robotListesi.get(sira-1).equalsIgnoreCase("tekerlekli")){
                    yeni_robot.EngelGecmeSuresiBul(robotListesi.get(sira-1),engel_sayisi);
                }*/
                yeni_robot.sureyiGoster(mesafe*10, robotListesi.get(sira-1),engel_sayisi);
                yeni_robot.sonKonum();
                //System.out.println(engel_sayisi);
            }
            else if(cevap.equalsIgnoreCase("h")){
                for(int i=0;i<20;i++){
                    for(int j=0;j<20;j++){
                        izgara[i][j]=1;
                    }
                }
                System.out.println("Robotun başlangıç konumunu girin ");
                System.out.println("x : ");
                yeni_robot.x=input.nextInt();
                System.out.println("y : ");
                yeni_robot.y=input.nextInt();
                while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                        System.out.println("Izgara dışında koordinat girildi !");
                        System.out.println("Robotun başlangıç koordinatlarını tekrar giriniz ");
                        System.out.println("x : ");
                        yeni_robot.x=input.nextInt();
                        System.out.println("y : ");
                        yeni_robot.y=input.nextInt();
                }
                while(secim==0){
                    System.out.println("Robotun gideceği yönü belirleyiniz ");
                    rota=input.next();
                    System.out.println("Kaç birim gideceğini giriniz ");
                    birim=input.nextInt();
                    if(rota.equalsIgnoreCase("ileri")){
                        yeni_robot.ileri(birim);
                        mesafe+=birim;
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.y-=birim*10;
                            mesafe-=birim;
                            System.out.println("Yönlendirme iptal edildi ");
                        }
                    }
                    else if(rota.equalsIgnoreCase("geri")){
                        yeni_robot.geri(birim);
                        mesafe+=birim;
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.y+=birim*10;
                            mesafe-=birim;
                            System.out.println("Yönelndirme iptal edildi ");
                        }
                    }
                    else if(rota.equalsIgnoreCase("saga")){
                        yeni_robot.saga(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.x-=birim*10;
                            mesafe-=birim;
                            System.out.println("Yönelndirme iptal edildi ");
                        } 
                    }
                    else if(rota.equalsIgnoreCase("sola")){
                        yeni_robot.sola(birim);
                        mesafe+=birim;
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.x+=birim*10;
                            mesafe-=birim;
                        }
                    }
                    else{
                        System.out.println("Yanlış bir isim yazdınız !");
                        System.out.println("Robotun gideceği yönü tekrar giriniz ");
                        continue;
                    }
                    System.out.println("Başka bir yönlendirme yapmak istiyor musunuz ?(Devam etmek için 0'a basınız.) ");
                    secim=input.nextInt();
                }
               /*if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){
                    yeni_robot.hiz=10;
                }
                else if(robotListesi.get(sira-1).equalsIgnoreCase("paletli")){
                    yeni_robot.hiz=20;
                }
                else if(robotListesi.get(sira-1).equalsIgnoreCase("tekerlekli")){
                    yeni_robot.hiz=30;
                }*/
                yeni_robot.sureyiGoster(mesafe*10, robotListesi.get(sira-1),engel_sayisi);
                yeni_robot.sonKonum();
            }
            else{
                System.out.println("Yanlış cevap verdiniz !");
                System.out.println("Tüm robot bilgilerini tekrar giriniz");
            }
        }
        else if(robotListesi.get(sira-1).equalsIgnoreCase("seri") || robotListesi.get(sira-1).equalsIgnoreCase("paralel")){
           if(robotListesi.get(sira-1).equalsIgnoreCase("seri")){
               Seri yeni_robot=new Seri(motor,yuk);
               System.out.println("Robotun başlangıç koordinatlarını giriniz ");
               System.out.println("x : ");
               yeni_robot.x=input.nextInt();
               System.out.println("y : ");
               yeni_robot.y=input.nextInt();
               while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                   System.out.println("Izgara dışında koordinat girdiniz !");
                   System.out.println("Koordinatları tekrar giriniz ");
                   System.out.println("x : ");
                   yeni_robot.x=input.nextInt();
                   System.out.println("y : ");
                   yeni_robot.y=input.nextInt();
               }
               while(secim==0){
                    System.out.println("Robotun yükü taşıyacağı yönü belirleyiniz ");
                    rota=input.next();
                    System.out.println("Robotun verilen yükü kaç birim taşıyacağını giriniz ");
                    birim=input.nextInt();
                    if(rota.equalsIgnoreCase("ileri")){
                        yeni_robot.ileri(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.y-=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.y+=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.y=yeni_robot.y-10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("geri")){
                        yeni_robot.geri(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.y+=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.y-=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.y=yeni_robot.y+10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("saga")){
                        yeni_robot.saga(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.x-=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.x+=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.x=yeni_robot.x-10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("sola")){
                        yeni_robot.sola(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.x+=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.x-=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.x=yeni_robot.x+10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else{
                        System.out.println("Yanlış bir isim yazdınız !");
                        System.out.println("Robotun gideceği yönü tekrar giriniz ");
                        continue;
                    }
                    System.out.println("Başka bir yönlendirme yapmak istiyor musunuz ?(Devam etmek için 0'a basınız.) ");
                    secim=input.nextInt();
                }
               yeni_robot.sureyiGoster(mesafe*10, robotListesi.get(sira-1), engel_sayisi);
               yeni_robot.sonKonum();
            }//SERI VEYA PARALEL OLMASINA GORE 2 FARKLI DURUM.USTTE SERI OLMASI DURUMUNDA YAPILACAKLAR GIRILIYOR.
           else if(robotListesi.get(sira-1).equalsIgnoreCase("paralel")){
               Paralel yeni_robot=new Paralel(motor,yuk);
               System.out.println("Robotun başlangıç koordinatlarını giriniz ");
               System.out.println("x : ");
               yeni_robot.x=input.nextInt();
               System.out.println("y : ");
               yeni_robot.y=input.nextInt();
               while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                   System.out.println("Izgara dışında koordinat girdiniz !");
                   System.out.println("Koordinatları tekrar giriniz ");
                   System.out.println("x : ");
                   yeni_robot.x=input.nextInt();
                   System.out.println("y : ");
                   yeni_robot.y=input.nextInt();
               }
               while(secim==0){
                    System.out.println("Robotun yükü taşıyacağı yönü belirleyiniz ");
                    rota=input.next();
                    System.out.println("Robotun verilen yükü kaç birim taşıyacağını giriniz ");
                    birim=input.nextInt();
                    if(rota.equalsIgnoreCase("ileri")){
                        yeni_robot.ileri(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.y-=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.y+=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.y=yeni_robot.y-10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("geri")){
                        yeni_robot.geri(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü kaç birim taşıyacağını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.y+=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.y-=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.y=yeni_robot.y+10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("saga")){
                        yeni_robot.saga(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.x-=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.x+=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.x=yeni_robot.x-10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("sola")){
                        yeni_robot.sola(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.x+=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.x-=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.x=yeni_robot.x+10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else{
                        System.out.println("Yanlış bir isim yazdınız !");
                        System.out.println("Robotun gideceği yönü tekrar giriniz ");
                        continue;
                    }
                    System.out.println("Başka bir yönlendirme yapmak istiyor musunuz ?(Devam etmek için 0'a basınız.) ");
                    secim=input.nextInt();
                }
               yeni_robot.sureyiGoster(mesafe*10, robotListesi.get(sira-1), engel_sayisi);
               yeni_robot.sonKonum();
           }
        }
        else if(robotListesi.get(sira-1).equalsIgnoreCase("hibrit")){
            Hibrit_Robotlar yeni_robot=new Hibrit_Robotlar(motor,yuk,yeni_robot1,yeni_robot2);
            while(yeni_robot.yukTasimaKapasitesi<yuk){
                System.out.println("Seçilen robot verilen yükü taşıyamaz !");
                System.out.println("Yeni yük giriniz");
                yuk=input.nextInt();
                yeni_robot.yuk=yuk;
            }
            System.out.println("Seçilen robotun hız değerini girin");
            yeni_robot.hiz=input.nextInt();
            if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){    
                while(yeni_robot.hiz<10 || yeni_robot.hiz>19){
                    if(yeni_robot.hiz<10){
                        System.out.println("Spider robotların minimum hız değeri 10'dur");
                        System.out.println("Hız değerini tekrar giriniz");
                    }
                    else if(yeni_robot.hiz>19){
                        System.out.println("Spider robotlar,paletli robotlardan veya tekerlekli robotlardan daha hızlı veya aynı hızda olamaz !");
                        System.out.println("Hız değerini tekrar giriniz");
                    }
                    yeni_robot.hiz=input.nextInt();
                }
            }
            else if(robotListesi.get(sira-1).equalsIgnoreCase("paletli")){
                while(yeni_robot.hiz<20 || yeni_robot.hiz>29){
                    if(yeni_robot.hiz<20){
                        System.out.println("Paletli robotların minimum hız değeri 20'dur");
                        System.out.println("Hız değerini tekrar giriniz");
                    }
                    else if(yeni_robot.hiz>29){
                        System.out.println("Paletli robotlar,tekerlekli robotlardan daha hızlı veya aynı hızda olamaz !");
                        System.out.println("Hız değerini tekrar giriniz");
                    }
                    yeni_robot.hiz=input.nextInt();
                }
            }
            else if(robotListesi.get(sira-1).equalsIgnoreCase("tekerlekli")){
                while(yeni_robot.hiz<30){
                    System.out.println("Tekerlekli robotların minimum hız değeri 30'dur");
                    System.out.println("Hız değerini tekrar giriniz");
                    yeni_robot.hiz=input.nextInt();
                }
            }
            System.out.println("Izgara üzerine engel koymak istiyor musunuz ? (E/H) : ");
            cevap=input.next();
            while(!cevap.equalsIgnoreCase("e") || !cevap.equalsIgnoreCase("h")){
                System.out.println("Yanlış cevap verdiniz !");
                System.out.println("Cevabınızı tekrar  giriniz ");
                cevap=input.next();
                if("E".equalsIgnoreCase(cevap) || "H".equalsIgnoreCase(cevap)){
                    break;
                }
            }
            if(cevap.equalsIgnoreCase("e")){
                for(int i=0;i<20;i++){
                    for(int j=0;j<20;j++){
                        izgara[i][j]=1;
                    }
                }
                System.out.println("Kaç tane engel girilecek ?");
                engel_sayisi=input.nextInt();
                for(int i=0;i<engel_sayisi;i++){
                    System.out.println("Engellerin konulacağı koordinatları belirleyiniz ");
                    System.out.println("x : ");
                    x=input.nextInt();
                    System.out.println("y : ");
                    y=input.nextInt();
                    while(x<200 || x>400 || y<200 || y>400){
                        System.out.println("Izgara dışında konum girildi !");
                        System.out.println("Engellerin konulacağı konumları tekrar giriniz");
                        System.out.println("x : ");
                        x=input.nextInt();
                        System.out.println("y : ");
                        y=input.nextInt();
                    }
                    izgara[(x%200)/10][(y%200)/10]=0;
                }
                System.out.println("Robotun başlangıç konumunu girin ");
                System.out.println("x : ");
                yeni_robot.x=input.nextInt();
                System.out.println("y : ");
                yeni_robot.y=input.nextInt();
                while(izgara[(int)(yeni_robot.x%200)/10][(int)(yeni_robot.y%200)/10]==0){
                    System.out.println("Seçilen konum engel üzerine denk geldi !");
                    System.out.println("Koordinatları tekrar girin ");
                    System.out.println("x : ");
                    yeni_robot.x=input.nextInt();
                    System.out.println("y : ");
                    yeni_robot.y=input.nextInt();
                    while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                        System.out.println("Izgara dışında koordinat girildi !");
                        System.out.println("Koordinatları tekrar girin ");
                        System.out.println("x : ");
                        yeni_robot.x=input.nextInt();
                        System.out.println("y : ");
                        yeni_robot.y=input.nextInt();
                    }
                }
                while(secim==0){
                    engel_sayisi=0;
                    System.out.println("Robotun gideceği yönü belirleyiniz ");
                    rota=input.next();
                    System.out.println("Kaç birim gideceğini giriniz ");
                    birim=input.nextInt();
                    if(rota.equalsIgnoreCase("ileri")){
                        yeni_robot.ileri(birim);
                        mesafe+=birim;
                        for(int i=((yeni_robot.x%200)/10)-birim;i<((yeni_robot.x%200)/10);i++){
                            if(izgara[i][(int)(yeni_robot.y%200)/10]==0){
                                engel_sayisi++;
                            }
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.y-=birim*10;
                            mesafe-=birim;
                            engel_sayisi--;
                            System.out.println("Yönlendirme iptal edildi ");
                        }
                        if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){
                            for(int i=(yeni_robot.x%200)/10-birim;i<((yeni_robot.x%200)/10);i++){
                                if(izgara[i][(int)(yeni_robot.y%200)/10]==0){
                                    System.out.println("Verilen yönde engel var ve Spider robotlar engellerden geçemez !");
                                    System.out.println("Robot engelin gerisindeki konumda kaldı");
                                    yeni_robot.y-=10;
                                    mesafe-=birim;
                                    mesafe+=(birim-1);
                                    secim=1;
                                    System.out.println("Yönlendirme işlemi,engel sebebiyle durduruldu");
                                }
                            }
                        }
                    }
                    else if(rota.equalsIgnoreCase("geri")){
                        yeni_robot.geri(birim);
                        mesafe+=birim;
                        for(int i=((yeni_robot.x%200)/10)-birim;i<((yeni_robot.x%200)/10);i++){
                            if(izgara[i][(int)(yeni_robot.y%200)/10]==0){
                                engel_sayisi++;
                            }
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.y+=birim*10;
                            mesafe-=birim;
                            engel_sayisi--;
                            System.out.println("Yönlendirme iptal edildi");
                        }
                        if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){
                            for(int i=((yeni_robot.x%200)/10)-birim;i<((yeni_robot.x%200)/10);i++){
                                if(izgara[i][(int)(yeni_robot.y%200)/10]==0){
                                    System.out.println("Verilen yönde engel var ve Spider robotlar engellerden geçemez !");
                                    System.out.println("Robot,engelin ilerisindeki konumda kaldı");
                                    yeni_robot.y+=10;
                                    mesafe-=birim;
                                    mesafe+=(birim-1);
                                    secim=1;
                                    System.out.println("Yönlendirme işlemi,engel sebebiyle durduruldu");
                                }
                            }
                        }
                    }
                    else if(rota.equalsIgnoreCase("saga")){
                        yeni_robot.saga(birim);
                        mesafe+=birim;
                        for(int i=((yeni_robot.y%200)/10)-birim;i<((yeni_robot.y%200)/10);i++){
                            if(izgara[(int)(yeni_robot.x%200)/10][i]==0){
                                engel_sayisi++;
                            }
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.x-=birim*10;
                            mesafe-=birim;
                            engel_sayisi--;
                            System.out.println("Yönlendirme iptal edildi ");
                        }
                        if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){
                            for(int i=((yeni_robot.y%200)/10)-birim;i<((yeni_robot.y%200)/10);i++){
                                if(izgara[(int)(yeni_robot.x%200)/10][i]==0){
                                    System.out.println("Verilen yönde engel var ve Spider robotlar engellerden geçemez !");
                                    System.out.println("Robot,engelin solundaki konumda kaldı");
                                    yeni_robot.x-=10;
                                    mesafe-=birim;
                                    mesafe+=(birim-1);
                                    secim=1;
                                    System.out.println("Yönlendirme işlemi,engel sebebiyle durduruldu");
                                }
                            }
                        }
                    }
                    else if(rota.equalsIgnoreCase("sola")){
                        yeni_robot.sola(birim);
                        mesafe+=birim;
                        for(int i=((yeni_robot.y%200)/10)-birim;i<((yeni_robot.y%200)/10);i++){
                            if(izgara[(int)(yeni_robot.x%200)/10][i]==0){
                                engel_sayisi++;
                            }
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.x+=birim*10;
                            mesafe-=birim;
                            engel_sayisi--;
                            System.out.println("Yönlendirme iptal edildi ");
                        }
                        if(robotListesi.get(sira-1).equalsIgnoreCase("spider")){
                            for(int i=((yeni_robot.y%200)/10)-birim;i<((yeni_robot.y%200)/10);i++){
                                if(izgara[(int)(yeni_robot.x%200)/10][i]==0){
                                    System.out.println("Verilen yönde engel var ve Spider robotlar engellerden geçemez !");
                                    System.out.println("Robot,engelin sağındaki konumda kaldı");
                                    yeni_robot.x+=10;
                                    mesafe-=birim;
                                    mesafe+=(birim-1);
                                    secim=1;
                                    System.out.println("Yönlendirme işlemi,engel sebebiyle durduruldu");
                                }
                            }
                        }
                    }
                    System.out.println("Başka yönlendirme yapmak istiyor musunuz ?(Devam etmek için 0'a basınız.)");
                    secim=input.nextInt();
                }
                System.out.println("Robot "+yeni_robot.x+","+yeni_robot.y+" noktasında sabitlendi");
                tempMesafe=mesafe;
                mesafe=0;
                    secim=0;
                    while(secim==0){
                    System.out.println("Robotun yükü taşıyacağı yönü belirleyiniz ");
                    rota=input.next();
                    System.out.println("Robotun verilen yükü kaç birim taşıyacağını giriniz ");
                    birim=input.nextInt();
                    if(rota.equalsIgnoreCase("ileri")){
                        yeni_robot.ileri(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.y-=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.y+=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.y=yeni_robot.y-10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("geri")){
                        yeni_robot.geri(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.y+=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.y-=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.y=yeni_robot.y+10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("saga")){
                        yeni_robot.saga(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.x-=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.x+=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.x=yeni_robot.x-10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("sola")){
                        yeni_robot.sola(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.x+=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.x-=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.x=yeni_robot.x+10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else{
                        System.out.println("Yanlış bir isim yazdınız !");
                        continue;
                    }
                    System.out.println("Başka bir yönlendirme yapmak istiyor musunuz ?(Devam etmek için 0'a basınız.) ");
                    secim=input.nextInt();
                    }
                    yeni_robot.hibritSureHesapla(tempMesafe*10, mesafe*10, engel_sayisi, yeni_robot1, yeni_robot2);
                    yeni_robot.sonKonum();
            }
            else if(cevap.equalsIgnoreCase("h")){
                for(int i=0;i<20;i++){
                    for(int j=0;j<20;j++){
                        izgara[i][j]=1;
                    }
                }
                System.out.println("Robotun başlangıç konumunu girin ");
                System.out.println("x : ");
                yeni_robot.x=input.nextInt();
                System.out.println("y : ");
                yeni_robot.y=input.nextInt();
                while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                        System.out.println("Izgara dışında koordinat girildi !");
                        System.out.println("Robotun başlangıç koordinatlarını tekrar giriniz ");
                        System.out.println("x : ");
                        yeni_robot.x=input.nextInt();
                        System.out.println("y : ");
                        yeni_robot.y=input.nextInt();
                }
                while(secim==0){
                    System.out.println("Robotun gideceği yönü belirleyiniz ");
                    rota=input.next();
                    System.out.println("Kaç birim gideceğini giriniz ");
                    birim=input.nextInt();
                    if(rota.equalsIgnoreCase("ileri")){
                        yeni_robot.ileri(birim);
                        mesafe+=birim;
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.y-=birim*10;
                            mesafe-=birim;
                            System.out.println("Yönlendirme iptal edildi ");
                        }
                    }
                    else if(rota.equalsIgnoreCase("geri")){
                        yeni_robot.geri(birim);
                        mesafe+=birim;
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.y+=birim*10;
                            mesafe-=birim;
                            System.out.println("Yönelndirme iptal edildi ");
                        }
                    }
                    else if(rota.equalsIgnoreCase("saga")){
                        yeni_robot.saga(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.x-=birim*10;
                            mesafe-=birim;
                            System.out.println("Yönelndirme iptal edildi ");
                        } 
                    }
                    else if(rota.equalsIgnoreCase("sola")){
                        yeni_robot.sola(birim);
                        mesafe+=birim;
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Robot ızgaranın dışına çıktı !");
                            yeni_robot.x+=birim*10;
                            mesafe-=birim;
                        }
                    }
                    else{
                        System.out.println("Yanlış bir isim yazdınız !");
                        System.out.println("Robotun gideceği yönü tekrar giriniz ");
                        continue;
                    }
                    System.out.println("Başka bir yönlendirme yapmak istiyor musunuz ?(Devam etmek için 0'a basınız.) ");
                    secim=input.nextInt();
                }
                System.out.println("Robot "+yeni_robot.x+","+yeni_robot.y+" noktasında sabitlendi");
                tempMesafe=mesafe;
                mesafe=0;
                secim=0;
                while(secim==0){
                    System.out.println("Robotun yükü taşıyacağı yönü belirleyiniz ");
                    rota=input.next();
                    System.out.println("Robotun verilen yükü kaç birim taşıyacağını giriniz ");
                    birim=input.nextInt();
                    if(rota.equalsIgnoreCase("ileri")){
                        yeni_robot.ileri(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.y-=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.y+=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.y=yeni_robot.y-10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("geri")){
                        yeni_robot.geri(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.y+=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.y-=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.y=yeni_robot.y+10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("saga")){
                        yeni_robot.saga(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.x-=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.x+=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.x=yeni_robot.x-10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else if(rota.equalsIgnoreCase("sola")){
                        yeni_robot.sola(birim);
                        mesafe=mesafe+birim;
                        while(yeni_robot.kol_uzunlugu<mesafe){
                            System.out.println("Seçilen robotun kol uzunluğu,verilen yükü istenilen mesafeye götürmek için yetersiz !");
                            System.out.println("Robotun yükü taşıyacağı birim sayısını tekrar giriniz ");
                            mesafe=mesafe-birim;
                            yeni_robot.x+=birim*10;
                            birim=input.nextInt();
                            mesafe=mesafe+birim;
                            yeni_robot.x-=birim*10;
                        }
                        while(yeni_robot.x<200 || yeni_robot.x>400 || yeni_robot.y<200 || yeni_robot.y>400){
                            System.out.println("Yük ızgara dışına çıktı !");
                            yeni_robot.x=yeni_robot.x+10*birim;
                            mesafe=mesafe-birim;
                            System.out.println("Verilen yönlendirme iptal edildi");
                        }
                    }
                    else{
                        System.out.println("Yanlış bir isim yazdınız !");
                        System.out.println("Robotun gideceği yönü tekrar giriniz ");
                        continue;
                    }
                    System.out.println("Başka bir yönlendirme yapmak istiyor musunuz ?(Devam etmek için 0'a basınız.) ");
                    secim=input.nextInt();
                }
                yeni_robot.hibritSureHesapla(tempMesafe*10, mesafe*10, engel_sayisi, yeni_robot1, yeni_robot2);
                yeni_robot.sonKonum();
            }
            else{
                System.out.println("Yanlış cevap verdiniz !");
                System.out.println("Tüm robot bilgilerini tekrar giriniz");
            }
        }
    }
}