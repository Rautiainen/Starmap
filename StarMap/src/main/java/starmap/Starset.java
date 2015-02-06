/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starmap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author air
 */
public class Starset {
    List<Star> stars;
    
    public Starset(String... args) {
        stars = new ArrayList<>();
        
        File csvStardata = new File("hygdata_v3.csv");
        //File csvStardata = new File("hygsmalldata.csv");
        
        Star star;
        Scanner scanner = null;
        String csvString;
        
        try {
            scanner = new Scanner(csvStardata);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        csvString = scanner.nextLine(); 
                
        while (scanner.hasNextLine()) {
            csvString = scanner.nextLine();
            //System.out.println(csvString); //for debugging
            star = new Star(csvString);
            for (String arg : args) {
                if (arg.equals(star.getProperName())) {
                stars.add(star);
                }
            }
        }
        
    }

    public List<Star> getStars() {
        return stars;
    }
    
    
    
    public void print() {
        for (Star star : stars) {
            System.out.println(star.toString());
        }
        
    }
    
    
}
