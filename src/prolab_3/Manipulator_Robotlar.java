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
public interface Manipulator_Robotlar extends Robotlar{
    //Çoklu kalıtımı sağlamak adına manipulatorrobotları interface yaptık
    @Override
    public void ileri(int y);
    @Override
    public void geri(int y);
    @Override
    public void saga(int x);
    @Override
    public void sola(int x);
    @Override
    public void sonKonum();
    @Override
    public void sureyiGoster(int mesafe,String robot,int engel_sayisi);
}