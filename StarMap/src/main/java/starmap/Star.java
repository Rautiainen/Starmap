package starmap;

/**
 * Class for storing star data from HYG Database by David Nash. 
 * @author Antti Rautiainen 
 */
public class Star {
    private int starID;     
    private String hip;    // might be ""
    private String hd;     //might be ""  
    private String hr;     //might be ""
    private String gilese; //might be ""
    private String bayerFLamsteed;
    private String properName; 
    private double ra;
    private double declination;
    private double distance;
    private double pmra;
    private double pmdec;
    private double rv;
    private double magnitude;
    private double absmag;
    private String spectrum;
    private String ci;
    private double x;
    private double y; 
    private double z;
    
    public Star (String csvLine) {
        String[] parts = csvLine.split(",");
        starID = Integer.parseInt(parts[0]);
        hip = parts[1];
        hd =  parts[2];
        hr = parts[3];
        gilese = parts[4];
        bayerFLamsteed = parts[5];
        properName = parts[6];
        ra = Double.parseDouble(parts[7]);
        declination = Double.parseDouble(parts[8]);
        distance = Double.parseDouble(parts[9]);
        pmra = Double.parseDouble(parts[10]);
        pmdec = Double.parseDouble(parts[11]);
        rv = Double.parseDouble(parts[12]);
        magnitude = Double.parseDouble(parts[13]);
        absmag = Double.parseDouble(parts[14]);
        spectrum = parts[15];
        ci = parts[16]; //might be ""
        x = Double.parseDouble(parts[17]);
        y = Double.parseDouble(parts[18]);
        z = Double.parseDouble(parts[19]);
    }

    public String getProperName() {
        return properName;
    }

    public double getRa() {
        return ra;
    }

    public double getDistance() {
        return distance;
    }
    
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    
    @Override
    public String toString() {
       return starID + "," 
               + hd + "," 
               + hr + "," 
               + gilese + "," 
               + bayerFLamsteed + "," 
               + properName + "," 
               + ra + "," 
               + declination + "," 
               + distance + "," 
               + pmra + "," 
               + pmdec + "," 
               + rv + "," 
               + magnitude + "," 
               + absmag + "," 
               + spectrum + "," 
               + ci + "," 
               + x + "," 
               + y + "," 
               + z;
     }
    
    
}
