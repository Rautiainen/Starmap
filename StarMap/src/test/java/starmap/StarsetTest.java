/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starmap;

import Lwjglwrapper.GLoopObject;
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
    Starset Otava;
    GLoopObject gloopobject;
    
    @Before
    public void setUp() {
        testcenter = new Vector3f(-50,-50,0);
        testtransformation = new Matrix3f();
        testtransformation.identity();
        testtransformation.mul((float) 100);
        testcube = new StarCube(testcenter,testtransformation); 
        Otava = new Starset(testcube, "Dubhe", "Merak", "Phad", "Megrez", "Alioth", "Mizar", "Alkaid");
        gloopobject = new StarGLoop(Otava,testcube);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void Rightsize() {
       assertEquals(7, Otava.getStars().size());
    }
    
    
    @Test
    public void RightgLoopObjecttype() {
       assertEquals(gloopobject.getClass() , Otava.getgLoopObject().getClass());
    }
}
