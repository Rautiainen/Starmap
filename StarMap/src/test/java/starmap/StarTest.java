package starmap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import starmap.Star;

/**
 *
 * @author air
 */
public class StarTest {
    
    public StarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Star star;
    
    @Before
    public void setUp() {
         star = new Star("1,1,224700,,,,,0.000060,1.089009,219.7802,-5.20,-1.88,0.0,9.100,2.390,F5,0.482,219.740502,0.003449,4.177065,0.00000004,-0.00000554,-0.00000200,0.000015693409775347223,0.01900678824815125,-0.000000025210311388888885,-0.000000009114497,,,,1,1,,9.638290236239703,,,");
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void RightProperName() {
       assertEquals("", star.getProperName());
    }
    
    @Test
    public void RightRa() {
       assertEquals(0.000060, star.getRa(),0.0000001);
    }
    
    @Test
    public void RightDistance() {
       assertEquals(219.7802, star.getDistance(),0.0000001);
    }
    
    @Test
    public void RightX() {
       assertEquals(219.740502, star.getX(),0.0000001);
    }
    
    @Test
    public void RightY() {
       assertEquals(0.003449, star.getY(),0.0000001);
    }
    
    @Test
    public void RightZ() {
       assertEquals(4.177065, star.getZ(),0.0000001);
    }
    
    @Test
    public void visualMagtest() {
        assertEquals(star.getMagnitude(), star.visualMag(star, 0.0, 0.0, 0.0),0.0001);
   }
    
  
    

    
    
}
