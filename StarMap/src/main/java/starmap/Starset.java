/*
 *  Set of stars and link to command loop for its presentation in a LWJGL Frame by Antti Rautiainen.
 */

package starmap;

import Lwjglwrapper.GLoopObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Starset {
    private List<Star> stars;
    private GLoopObject gLoopObject;
    
    private double edgelength = 0.6;
    
    public Starset(StarCube starcube, String... args) {
        gLoopObject = new StarGLoop(this, starcube);
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

    public GLoopObject getgLoopObject() {
        return gLoopObject;
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
