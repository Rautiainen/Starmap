/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starmap;

import com.joml.matrix.Matrix3f;
import com.joml.vector.Vector3f;
import java.io.FileNotFoundException;

/**
 *
 * @author air
 */
public class Main {
    public static void main(String[] args) {
        
        Vector3f testcenter = new Vector3f(-50,-50,0);
        Matrix3f testtransformation = new Matrix3f();
        testtransformation.identity();
        testtransformation.mul((float) 100);
        StarCube testcube = new StarCube(testcenter,testtransformation); 
        System.out.print(testcube); 
        Starset Otava = new Starset(testcube, "Dubhe", "Merak", "Phad", "Megrez", "Alioth", "Mizar", "Alkaid");
        Otava.print();
        /*
        double width = 0;
        double newwidth;
        for (Star star1 : Otava.getStars()) {
            for (Star star2: Otava.getStars()) {
                newwidth = Math.abs(star1.getRa() - star2.getRa());
                if (newwidth > width) {
                    width = newwidth;
                }
            }
        }
                
        System.out.print((360.0/24.0) * width);
        */
        double sumx = 0, sumy = 0, sumz = 0;
        for (Star star1 : Otava.getStars()) {
                sumx += star1.getX();
                sumy += star1.getY();
                sumz += star1.getZ();
                System.out.println(star1.getProperName());
                System.out.println(star1.getDistance());
        }
           
        int n = Otava.getStars().size();
        Vector3f testcenter2 = new Vector3f((float) sumx / n, (float) sumy / n, (float) sumz / n);
        
        StarCube testcube2 = new StarCube(testcenter2,(float) (50 * (Math.PI/180))); 
        System.out.print(testcube2);
        Starset Otava2 = new Starset(testcube2, "Dubhe", "Merak", "Phad", "Megrez", "Alioth", "Mizar", "Alkaid");
                
        // new StarFrame().show(Otava);
 
        //new StarFrame().execute(Otava.getgLoopObject());
        
        new StarFrame().execute(Otava2.getgLoopObject());
     
        }
    }

