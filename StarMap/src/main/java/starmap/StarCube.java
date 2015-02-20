package starmap;
import com.joml.matrix.Matrix3f;
import com.joml.vector.Vector3f;

/**
 * Geometric operations for 3d projections of stars. 
 * @author Antti Rautiainen 
 */
public class StarCube {
    private Vector3f center;
    private Vector3f observationSpot;
    private Matrix3f transformation;
    //private float edgelength; //in parsecs. not implemented - perhaps method? 

    public StarCube(Vector3f center, Vector3f observationSpot, Matrix3f transformation) {
        this.center = center;
        this.observationSpot = observationSpot;
        this.transformation = transformation;
    }

    public Vector3f getCenter() {
        return center;
    }

    public void setCenter(Vector3f center) {
        this.center = center;
    }
    
    public Vector3f getCenterSpherical() {
        Vector3f centerSpherical = new Vector3f();
        center.saveSphericalCoords(centerSpherical);
        return centerSpherical;
    }
    
    public void setCenterSpherical(float r, float theta, float phi) {
        center.setFromSphericalCoords(r, theta, phi);
    }
    
/**
 * this creates a cube with center in center, front edges of which 
 * are equally far from the zero, and width radians (right ascensions) 
 * in the declination level the of center.   
 */
    public StarCube(Vector3f center, float radians) {
    
        //1. Spherical transform center
        
        Vector3f rthetaphi = new Vector3f();
        center.saveSphericalCoords(rthetaphi);
        
        //calculate r' - transformed to right center
        
        Vector3f rshifted = new Vector3f();
        rshifted.setFromSphericalCoords(rthetaphi.x, rthetaphi.y, rthetaphi.z+(radians/2));
        
        //count zvector - 3rd column of transformation
        
        Vector3f zvector = new Vector3f(center); 
        zvector.mul((float) (Math.atan(radians/2) / (1.0 + Math.atan(radians/2))));
        
        //count xvector - 1st column of transformation
        
        Vector3f xvector = new Vector3f(rshifted);
        Vector3f helper = new Vector3f(zvector);
        xvector.mul(zvector.lengthSquared());
        helper.mul(Vector3f.dot(rshifted, zvector));
        xvector.sub(helper);
        xvector.mul(zvector.length()/xvector.length());
        
        //count yvector - 2nd column of transformation
        
        Vector3f yvector = new Vector3f();
        Vector3f.cross(xvector, zvector, yvector);
        yvector.mul(zvector.length()/yvector.length());
  
        this.center = center;
        this.observationSpot = new Vector3f(0,0,0);
        this.transformation = new Matrix3f(xvector,yvector,zvector);
        
    }

    public Vector3f getObservationSpot() {
        return observationSpot;
    }
     
    
/**
 * This transforms absolute coordinates to relative coordinates of the cube. 
 */    
    public Vector3f transform(double x, double y, double z) {
            Vector3f v = new Vector3f((float) x, (float) y, (float) z);
            Matrix3f A = new Matrix3f(transformation);
            A.invert();
            v.sub(center);
            v.mul(A);
            return v;                    
    }
    
  /**
  * This checks if given star is in this cube. Borders count! 
  */    
    boolean starInCube(Star star) {
        Vector3f relativecoords = transform(star.getX(), star.getY(),star.getZ()); 
        return relativecoords.x >= -1 && relativecoords.x <= 1  &&
               relativecoords.y >= -1 && relativecoords.y <= 1  &&
               relativecoords.z >= -1 && relativecoords.z <= 1;
    }
  
    
    
    @Override
    public String toString() {
        return center.toString() + transformation.toString();
    }
    
    
}
