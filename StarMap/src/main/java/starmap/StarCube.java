/*
 * Geometric operations for 3d projections of stars. 
 * Author Antti Rautiainen. 
 */

package starmap;
import com.joml.matrix.Matrix3f;
import com.joml.vector.Vector3f;

public class StarCube {
    private Vector3f center;
    private Matrix3f transformation;
    private float edgelength; //in parsecs. Not yet implemented. 
    
    public StarCube(Vector3f center, Matrix3f transformation) {
        this.center = center;
        this.transformation = transformation;
    }

    //this creates a cube with center in center, front edges of which 
    //are equally far from the zero, 
    //and width radians (right ascensions) 
    //in the declination level the of center. 
    
    public StarCube(Vector3f center, float radians) {
    //1. polar transform center
     
        float r = center.length();
        float phi = (float) Math.atan(center.y/ center.x);       //ascension. 
        float theta = (float) Math.cos(center.x / r);
     
    //count r' - transformed to right center
    
        Vector3f rshifted = new Vector3f(); 
        phi = phi + (radians/2);
        rshifted.x = (float) (r * Math.sin(theta)*Math.cos(phi));
        rshifted.y = (float) (r * Math.sin(theta)*Math.sin(phi));
        rshifted.z = center.z;
    
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
        this.transformation = new Matrix3f(xvector,yvector,zvector);
        
    }
     
    
    //not tested;
    
    public Vector3f transform(double x, double y, double z) {
            Vector3f v = new Vector3f((float) x, (float) y, (float) z);
            Matrix3f A = new Matrix3f(transformation);
            A.invert();
            v.sub(center);
            v.mul(A);
            return v;                    
    }

    @Override
    public String toString() {
        return center.toString() + transformation.toString();
    }
    
    
}
