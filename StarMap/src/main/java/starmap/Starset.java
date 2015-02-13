package starmap;

import Lwjglwrapper.GLoopObject;
import com.joml.matrix.Matrix3f;
import com.joml.vector.Vector3f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Set of stars and link to command loop for its presentation in a LWJGL Frame 
 *  @author Antti Rautiainen 
 */
public class Starset {
    private List<Star> stars;
    private GLoopObject gLoopObject;
    
    private double edgelength = 0.6;
    
    public Starset(StarCube starcube, String... args) {
        gLoopObject = new StarGLoop(this, starcube);
        stars = new ArrayList<Star>();
        
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

    /**
    * Starset by default is scaled to center of Big dipper (Otava), 50 degrees slice of sky
    */
    public Starset() {
        stars = new ArrayList<Star>();
        
        String args[] = {"Dubhe", "Merak", "Phad", "Megrez", "Alioth", "Mizar", "Alkaid"};
      
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
            star = new Star(csvString);
            for (String arg : args) {
                if (arg.equals(star.getProperName())) {
                stars.add(star);
                }
            }
        }
        
        double sumx = 0, sumy = 0, sumz = 0;
        for (Star star1 : stars) {
                sumx += star1.getX();
                sumy += star1.getY();
                sumz += star1.getZ();
        }
           
        int n = stars.size();
        Vector3f bigDipperCenter = new Vector3f((float) sumx / n, (float) sumy / n, (float) sumz / n);
        
        StarCube starcube = new StarCube(bigDipperCenter,(float) (50 * (Math.PI/180))); 
        gLoopObject = new StarGLoop(this, starcube);
        
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
