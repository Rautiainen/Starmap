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
    private StarCube starcube;
    private GLoopObject gLoopObject;
    private boolean bRotate;
    
    // private double edgelength = 0.6; //has this been used?
    
    /**
    * This constructor loads all stars of visual magnitude smaller than 8 a given StarCube
    */
    public Starset(StarCube starcube) {
        stars = new ArrayList<Star>();
        this.starcube = starcube;
        load(starcube);
        bRotate = false;
    }      
    
    /**
    * This constructor loads any set of stars, proper names of which given in args 
    */
    public Starset(StarCube starcube, String... args) {
        
        stars = new ArrayList<Star>();
        this.starcube = starcube;
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
        
        gLoopObject = new StarGLoop(this);
        bRotate = false;
    }

    /**
    * Starset Default constructor is scaled to center of Big dipper (Otava), 66 degrees slice of sky
    * and Big dipper is loaded. 
    */
    public Starset() {
        stars = new ArrayList<Star>();
        
        String args[] = {"Dubhe", "Merak", "Phad", "Megrez", "Alioth", "Mizar", "Alkaid"};
      
        File csvStardata = new File("hygdata_v3.csv");
        
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
        
        this.starcube = new StarCube(center(),(float) (66 * (Math.PI/180)));
        gLoopObject = new StarGLoop(this);
        bRotate = false;
    }
    
    /**
    * Counts center of the starset (average of coordinates). 
     * @return Vector3f
    */   
    public Vector3f center() {
        double sumx = 0, sumy = 0, sumz = 0;
        for (Star star1 : stars) {
                sumx += star1.getX();
                sumy += star1.getY();
                sumz += star1.getZ();
        }
        int n = stars.size();
        return new Vector3f((float) sumx / n, (float) sumy / n, (float) sumz / n);
    }
    
   
    public List<Star> getStars() {
        return stars;
    }  

    public StarCube getStarcube() {
        return starcube;
    }
    
    public GLoopObject getgLoopObject() {
        return gLoopObject;
    }
    
    public boolean getbRotate() {
        return bRotate;
    }
    
    public void setbRotate(boolean bRotate) {
        this.bRotate = bRotate;
    }
    
    
    public void print() {
        for (Star star : stars) {
            System.out.println(star.toString());
        }
        
    }
    
    /**
    * loads all stars of visual magnitude smaller than 8 a given StarCube
     * @param starcube
    */
    public void load(StarCube starcube) {
        File csvStardata = new File("hygdata_v3.csv");
        
        Star star;
        Scanner scanner = null;
        String csvString;
        
        try {
            scanner = new Scanner(csvStardata);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        csvString = scanner.nextLine(); 
        double x = starcube.getObservationSpot().x;
        double y = starcube.getObservationSpot().y;
        double z = starcube.getObservationSpot().z;
        
        stars.clear();
        
        while (scanner.hasNextLine()) {
            csvString = scanner.nextLine();
            //System.out.println(csvString); //for debugging
            star = new Star(csvString);

            if (starcube.starInCube(star) && star.visualMag(star,x,y,z) <= 8) {
                stars.add(star);
            }
        
        }

        gLoopObject = new StarGLoop(this);
     
    }
    
    public void printProperNames() {
        for (Star star : stars) {
            if (!star.getProperName().equals("")) {
                System.out.println(star.getProperName());
            } 
        }       
    }
    
}
    
