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
    private float edgelength; //in parsecs.  

    public StarCube(Vector3f center, Vector3f observationSpot, Matrix3f transformation) {
        this.center = center;
        this.observationSpot = observationSpot;
        this.transformation = transformation;
    }

    public Vector3f getCenter() {
        return center;
    }
 
 /**
 * Sets center coordinates.  observationSpot always moves along the center. 
 * It is supposed that center always moves when set is called.  
 * @author Antti Rautiainen
     * @param center
 */  
    public void setCenter(Vector3f center) {
        Vector3f storage = new Vector3f(this.center);
        this.center = center;
        Vector3f.sub(center, storage, storage);
        observationSpot.add(storage);
    }
     
    public Vector3f getCenterSpherical() {
        Vector3f centerSpherical = new Vector3f();
        center.saveSphericalCoords(centerSpherical);
        return centerSpherical;
    }
    
    
 /**
 * Sets center coordinates, if given in spherical coordinates. 
 * @author Antti Rautiainen
 * This function does not include moving and is thus not used. 
     * @param r new distance
     * @param theta new angle
     * @param phi new angle
 */ 
    public void setCenterSpherical(float r, float theta, float phi) {
        center.setFromSphericalCoords(r, theta, phi);
    }

 /**
 * Moves center to a new distance r. observationSpot moves to the same direction and distance.
 * @author Antti Rautiainen
     * @param r new distance
 */ 
    public void moveCenterDistance(float r) {
        Vector3f centerSpherical = new Vector3f(getCenterSpherical());
        Vector3f storage = new Vector3f(this.center);
        center.setFromSphericalCoords(r, centerSpherical.y, centerSpherical.z);
        Vector3f.sub(center, storage, storage);
        observationSpot.add(storage);
    }
    
 /**
 * turns center to angles theta and phi, given in radians. When observationSpot is in 
 * zero, it does not move, but the transformation matrix turns. 
 * Otherwise it moves together with the center and transformation matrix does not turn.
 * @author Antti Rautiainen
     * @param theta new angle
     * @param phi new angle
 * 
 */ 
    public void moveCenterAngle(float theta, float phi) {
        Vector3f centerSpherical = new Vector3f(getCenterSpherical());
        Vector3f storage = new Vector3f(this.center);
        center.setFromSphericalCoords(centerSpherical.x, theta, phi);
        if (observationSpot.length() == 0) {
            setTransformation(getEdgelength());
        } else {
            Vector3f.sub(center, storage, storage);
            observationSpot.add(storage);
        }    
    }

 /**
 *  This sets transformation matrix, given center vector, observation spot and edgelength. 
 * xvector, yvector and zvector are corresponding directions 
 * of the star database coordinate system. In gsl, directions
 * are permutated and turned, and this is reflected here - transformation matrix
 *  describes how to transform star coordinates to gsl unit cube presentation.
 * @author antti rautiainen
 */   
    private void setTransformation(float edgelength) {
        Vector3f xvector = new Vector3f(center);
        Vector3f yvector = new Vector3f();
        Vector3f updirection = new Vector3f(0, 0, 1);
        Vector3f zvector = new Vector3f();
        xvector.sub(observationSpot);
        xvector.mul(-0.5f * edgelength / xvector.length());
        Vector3f.cross(xvector, updirection, yvector);
        //case when points directly up. Note that there is noncontinuity
        //from other directions approaching zenith than ra = 0. 
        if (yvector.length() == 0) {
            zvector = new Vector3f(center);
            zvector.sub(observationSpot);
            zvector.mul(-0.5f * edgelength / zvector.length());
            yvector = new Vector3f(0, -zvector.length(), 0);
            xvector = new Vector3f(-zvector.length(), 0, 0);
        } else {
            yvector.mul(-0.5f * edgelength / yvector.length());
            Vector3f.cross(xvector, yvector, zvector);        
            zvector.mul(0.5f * edgelength / zvector.length());
        }
        this.transformation = new Matrix3f(yvector, zvector, xvector);
        this.edgelength = edgelength;
    }
    
    public Vector3f getObservationSpot() {
        return observationSpot;
    }

/**
 * Sets observation spot. 
 *  center always moves along the observationSpot
 * @author Antti Rautiainen
 */
    public void setObservationSpot(Vector3f observationSpot) {
        Vector3f storage = new Vector3f(this.observationSpot);
        this.observationSpot = observationSpot;
        Vector3f.sub(observationSpot, storage, storage);
        center.add(storage);
    }
    
    public Vector3f getObservationSpotSpherical() {
        Vector3f observationSPotSpherical = new Vector3f();
        observationSpot.saveSphericalCoords(observationSPotSpherical);
        return observationSPotSpherical;
    }
    
/**
 * Sets observation spot from spherical coordinates.  
 *  center always moves along the observationSpot
 * @author Antti Rautiainen
 */
    public void setObservationSpotSpherical(float r, float theta, float phi) {
        Vector3f storage = new Vector3f(this.observationSpot);
        observationSpot.setFromSphericalCoords(r, theta, phi);
        Vector3f.sub(observationSpot, storage, storage);
        center.add(storage);
    }
    
    public float getEdgelength() {
        return edgelength;
    }

 /**
 * Setting length of the edge of the cube scales transformation matrix 
 * and moves observation spot, but not center. 
 * @author Antti Rautiainen
     * @param edgelength length of of an edge of the starcube
 */ 
    public void setEdgelength(float edgelength) {
        float oldedgelength = this.edgelength;
        this.edgelength = edgelength;
        float factor = edgelength / oldedgelength;
        this.transformation.mul(factor);
        Vector3f multipliedcenter = new Vector3f(center);
        multipliedcenter.mul(1 - factor);
        this.observationSpot.mul(factor);
        this.observationSpot.add(multipliedcenter);
    }
    
    
    
/**
 * this creates a cube with center in center, front edges of which 
 * are equally far from the zero, and width radians (right ascensions) 
 * in the declination level the of center.  
 * @author Antti Rautiainen
 */
    public StarCube(Vector3f center, float radians) {
        this.observationSpot = new Vector3f(0, 0, 0);
        this.center = center;
        Vector3f xvector = new Vector3f(center); 
        xvector.sub(observationSpot);
        xvector.mul((float) (Math.atan(radians / 2) / (1.0 + Math.atan(radians / 2))));
        setTransformation(2 * xvector.length());
    }

/**
 * This transforms absolute coordinates to relative coordinates of the cube. 
 * @author Antti Rautiainen
     * @param x component of a vector
     * @param y component of a vector
     * @param z component of a vector
     * @return a vector with relative coordinates
 * 
 */    
    public Vector3f transform(double x, double y, double z) {
        Vector3f v = new Vector3f((float) x, (float) y, (float) z);
        Matrix3f a = new Matrix3f(transformation);
        a.invert();
        v.sub(center);
        v.mul(a);
        return v;                    
    }
    
  /**
  * This checks if given star is in this cube. Borders count! 
  */    
    boolean starInCube(Star star) {
        Vector3f relativecoords = transform(star.getX(), star.getY(), star.getZ()); 
        return relativecoords.x >= -1 && relativecoords.x <= 1  &&
               relativecoords.y >= -1 && relativecoords.y <= 1  &&
               relativecoords.z >= -1 && relativecoords.z <= 1;
    }
    
     /**
  * Only used for debugging
  */
    /*
    @Override
    public String toString() {
        return center.toString() + transformation.toString() + observationSpot.toString();
    }
    */
    
}
