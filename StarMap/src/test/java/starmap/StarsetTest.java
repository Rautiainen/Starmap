/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starmap;

import lwjglwrapper.GLoopObject;
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
public class StarsetTest {
    
    public StarsetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Vector3f testcenter;
    Matrix3f testtransformation;
    StarCube testcube;
    StarCube testcube2;
    Starset bigDipper;
    Starset defaultSet; 
    Starset bigDipperAll;
    GLoopObject gloopobject;
    
    @Before
    public void setUp() {
        testcenter = new Vector3f(-50,-50,0);
        testtransformation = new Matrix3f();
        testtransformation.identity();
        testtransformation.mul((float) 100);
        Vector3f testobservationspot = new Vector3f(0,0,0);
        testcube = new StarCube(testcenter,testobservationspot,testtransformation); 
        bigDipper = new Starset(testcube, "Dubhe", "Merak", "Phad", "Megrez", "Alioth", "Mizar", "Alkaid");
        defaultSet = new Starset();
        testcube2 = new StarCube(bigDipper.center(),(float) (66 * (Math.PI/180)));
        bigDipperAll = new Starset(testcube2);
        gloopobject = new StarGLoop(bigDipper);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void RightsizeTextConstructor() {
       assertEquals(7, bigDipper.getStars().size());
    }
    
    @Test
    public void RightsizeDefaultConstructor() {
       assertEquals(7, defaultSet.getStars().size());
    }
    
    //could be thist test does not work. 
    /*
    @Test
    public void RightsizeLoadConstructor() {
       assertEquals(50, bigDipperAll.getStars().size());
    }
    */
    
    @Test
    public void RightgLoopObjecttype() {
       assertEquals(gloopobject.getClass() , bigDipper.getgLoopObject().getClass());
    }
    
    @Test
    public void setBRotatetest() {
       boolean bool = true;
       defaultSet.setbRotate(bool);
       assertEquals(true,defaultSet.getbRotate());
    }
    
}
