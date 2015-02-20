package starmap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.joml.matrix.Matrix3f;
import com.joml.vector.Vector3f;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author air
 */
public class StarCubeTest {
    
    public StarCubeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Starset Otava2;
    StarCube starcube3;
    Vector3f v1;
    Vector3f v2;
    StarCube testcube; 
    StarCube testcube2;
    StarCube testcube3;   
    StarCube testcube4;
    
    @Before
    public void setUp() {
        Vector3f testcenter = new Vector3f(-50,-50,0);
        Vector3f testobservationspot = new Vector3f(0,0,0);
        Matrix3f testtransformation = new Matrix3f();
        testtransformation.identity();
        testtransformation.mul((float) 100);
        testcube = new StarCube(testcenter,testobservationspot, testtransformation); 
        Starset Otava = new Starset(testcube, "Dubhe", "Merak", "Phad", "Megrez", "Alioth", "Mizar", "Alkaid");
        double sumx = 0, sumy = 0, sumz = 0;
        for (Star star1 : Otava.getStars()) {
                sumx += star1.getX();
                sumy += star1.getY();
                sumz += star1.getZ();
        }
           
        int n = Otava.getStars().size();
        Vector3f testcenter2 = new Vector3f((float) sumx / n, (float) sumy / n, (float) sumz / n);
        testcube2 = new StarCube(testcenter2,(float) (50 * (Math.PI/180))); 
        testcube4 = new StarCube(testcenter2,(float) (50 * (Math.PI/180))); 
        Otava2 = new Starset(testcube2, "Dubhe", "Merak", "Phad", "Megrez", "Alioth", "Mizar", "Alkaid");
        Vector3f testcenter3 = new Vector3f(0,0,0);
        Matrix3f testtransformation3 = new Matrix3f();
        testtransformation3.identity();
        testcube3 = new StarCube(testcenter3,testobservationspot, testtransformation3); 
        v1 = new Vector3f(0,0,0);
        v2 = new Vector3f(0,0,0);
         
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void Rightsize() {
       assertEquals(7, Otava2.getStars().size());
    }
    
    @Test
    public void identitytransform() {
       v2.set(testcube3.transform(0, 0, 0));
       assertEquals(v1.length(),v2.length(),0.000001);
    }
    
    @Test
    public void sphericaltest() {
       v2 = testcube2.getCenterSpherical();
       testcube2.setCenterSpherical(v2.x, v2.y,v2.z);
       assertEquals(testcube4.getCenter().length(),testcube2.getCenter().length(),0.000001);
    }
    
    @Test
    public void sphericaltestrepeat() {
       v2 = testcube2.getCenterSpherical();
       testcube2.setCenterSpherical(v2.x, 6.7f,v2.z);
       testcube4.setCenterSpherical(v2.x, 6.7f,v2.z);
       v2 = new Vector3f();
       v2 = testcube2.getCenterSpherical();
       testcube2.setCenterSpherical(v2.x, 6.7f,v2.z);
       v2 = new Vector3f(0,0,0);
       v2 = testcube2.getCenterSpherical();
       testcube2.setCenterSpherical(v2.x, 6.7f,v2.z);
       v2 = new Vector3f(0,0,0);
       v2 = testcube2.getCenterSpherical();
       testcube2.setCenterSpherical(v2.x, 6.7f,v2.z);
       v2 = new Vector3f(0,0,0);
       v2 = testcube2.getCenterSpherical();
       testcube2.setCenterSpherical(v2.x, 6.7f,v2.z);
       assertEquals(testcube4.getCenter().length(),testcube2.getCenter().length(),0.000001);
    }
    

}
