/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joml.vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import starmap.Star;
import starmap.Starset;

/**
 *
 * @author air
 */
public class Vector3fTest {
    
    public Vector3fTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Starset starset;
    Star star;
    Vector3f v1;
    Vector3f v2;
    Vector3f v3;
    Vector3f v4;
    Vector3f v5;
    Vector3f v6;
    Vector3f zerovector;
    Vector3f rthetaphi1;
    Vector3f rthetaphi2;
    Vector3f rthetaphi3;
    Vector3f rthetaphi4;
    Vector3f rthetaphi5;
    Vector3f rthetaphi6;
    
    
    @Before
    public void setUp() {
        starset = new Starset();
        star = starset.getStars().get(5);
        v1 = new Vector3f((float) 1.0, (float) 0.0, (float) 0.0);
        v2 = new Vector3f((float) 0.0, (float) 1.0, (float) 0.0);
        v3 = new Vector3f((float) 0.0, (float) 0.0, (float) 1.0);
        v4 = new Vector3f((float) -1.0, (float) 0.0, (float) 0.0);
        v5 = new Vector3f((float) 0.0, (float) -1.0, (float) 0.0);
        v6 = new Vector3f((float) 0.0, (float) 0.0, (float) -1.0);
        zerovector =  new Vector3f((float) 0.0, (float) 0.0, (float) 0.0);
        rthetaphi1 = new Vector3f((float) 0.0, (float) 0.0, (float) 0.0);
        rthetaphi2 = new Vector3f((float) 0.0, (float) 0.0, (float) 0.0);
        rthetaphi3 = new Vector3f((float) 0.0, (float) 0.0, (float) 0.0);
        rthetaphi4 = new Vector3f((float) 0.0, (float) 0.0, (float) 0.0);
        rthetaphi5 = new Vector3f((float) 0.0, (float) 0.0, (float) 0.0);
        rthetaphi6 = new Vector3f((float) 0.0, (float) 0.0, (float) 0.0);
        v1.saveSphericalCoords(rthetaphi1);
        v2.saveSphericalCoords(rthetaphi2);
        v3.saveSphericalCoords(rthetaphi3);
        v4.saveSphericalCoords(rthetaphi4);
        v5.saveSphericalCoords(rthetaphi5);
        v6.saveSphericalCoords(rthetaphi6);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void notnegative10test() {
        assertEquals(0.0, v1.notnegative10((float) -1.0),0.0001);
    }
     
    @Test
    public void negative10test() {
        assertEquals(1.0,v1.negative10((float) -1.0),0.0001);
    }
    
    @Test 
    public void zerorightascension() {
        rthetaphi1.siUnitstoAstronomical();
        assertEquals(0.0, rthetaphi1.z,0.0001);
    }
    
    @Test 
    public void sixrightascension() {
        rthetaphi2.siUnitstoAstronomical();
        assertEquals(6.0, rthetaphi2.z,0.0001);
    }
    
    
    @Test 
    public void twelverightascension() {
        rthetaphi4.siUnitstoAstronomical();
        assertEquals(12.0, rthetaphi4.z,0.0001);
    }
    
    @Test 
    public void eighteenrightascension() {
        rthetaphi5.siUnitstoAstronomical();
        assertEquals(18.0, rthetaphi5.z,0.0001);
    }
    
    @Test 
    public void SIUnitstoAstronomical1y() {
        v1.saveSphericalCoords(rthetaphi2);
        rthetaphi1.siUnitstoAstronomical();
        rthetaphi1.astronomicalUnitstoSI();
         assertEquals(rthetaphi2.y,rthetaphi1.y,0.0001);
    }
    
    @Test 
    public void SIUnitstoAstronomical1z() {
        v1.saveSphericalCoords(rthetaphi2);
        rthetaphi1.siUnitstoAstronomical();
        rthetaphi1.astronomicalUnitstoSI();
         assertEquals(rthetaphi2.z, rthetaphi1.z,0.0001);
         
    }
    
    @Test 
    public void SIUnitstoAstronomical2y() {
        v2.saveSphericalCoords(rthetaphi1);
        rthetaphi2.siUnitstoAstronomical();
        rthetaphi2.astronomicalUnitstoSI();
         assertEquals(rthetaphi1.y,rthetaphi2.y,0.0001);
         
    }
    
    @Test 
    public void SIUnitstoAstronomical2z() {
        v2.saveSphericalCoords(rthetaphi1);
        rthetaphi2.siUnitstoAstronomical();
        rthetaphi2.astronomicalUnitstoSI();
        assertEquals(rthetaphi1.z,rthetaphi2.z,0.0001); 
    }
    
    @Test 
    public void SIUnitstoAstronomical3y() {
        v3.saveSphericalCoords(rthetaphi1);
        rthetaphi3.siUnitstoAstronomical();
        rthetaphi3.astronomicalUnitstoSI();
         assertEquals(rthetaphi1.y,rthetaphi3.y,0.0001);
         
    }
    
    @Test 
    public void SIUnitstoAstronomical3z() {
        v3.saveSphericalCoords(rthetaphi1);
        rthetaphi3.siUnitstoAstronomical();
        rthetaphi3.astronomicalUnitstoSI();
        assertEquals(rthetaphi1.z,rthetaphi3.z,0.0001); 
    }
    
    @Test 
    public void SIUnitstoAstronomical4y() {
        v4.saveSphericalCoords(rthetaphi1);
        rthetaphi4.siUnitstoAstronomical();
        rthetaphi4.astronomicalUnitstoSI();
         assertEquals(rthetaphi1.y,rthetaphi4.y,0.0001);
         
    }
    
    @Test 
    public void SIUnitstoAstronomical4z() {
        v4.saveSphericalCoords(rthetaphi1);
        rthetaphi4.siUnitstoAstronomical();
        rthetaphi4.astronomicalUnitstoSI();
        assertEquals(rthetaphi1.z,rthetaphi4.z,0.0001); 
    }
    
    @Test 
    public void SIUnitstoAstronomical5y() {
        v5.saveSphericalCoords(rthetaphi1);
        rthetaphi3.siUnitstoAstronomical();
        rthetaphi3.astronomicalUnitstoSI();
        assertEquals(rthetaphi1.y,rthetaphi5.y,0.0001);
         
    }
    
    @Test 
    public void SIUnitstoAstronomical5z() {
        v5.saveSphericalCoords(rthetaphi1);
        rthetaphi5.siUnitstoAstronomical();
        rthetaphi5.astronomicalUnitstoSI();
        assertEquals(rthetaphi1.z,rthetaphi5.z,0.0001); 
    }
    
    @Test 
    public void SIUnitstoAstronomical6y() {
        v6.saveSphericalCoords(rthetaphi1);
        rthetaphi6.siUnitstoAstronomical();
        rthetaphi6.astronomicalUnitstoSI();
        assertEquals(rthetaphi1.y,rthetaphi6.y,0.0001);
         
    }
    
    @Test 
    public void SIUnitstoAstronomical6z() {
        v6.saveSphericalCoords(rthetaphi1);
        rthetaphi6.siUnitstoAstronomical();
        rthetaphi6.astronomicalUnitstoSI();
        assertEquals(rthetaphi1.z,rthetaphi6.z,0.0001); 
    }
    
    @Test
    public void SIUnitstoAstronomicalDistance() {
         Vector3f v = new Vector3f((float) star.getX(), (float) star.getY(), (float) star.getZ());
         Vector3f rthetaphi = new Vector3f();
         v.saveSphericalCoords(rthetaphi);
         rthetaphi.siUnitstoAstronomical();
         assertEquals(star.getDistance(),rthetaphi.x,0.0001);
         
    }
    
    @Test
    public void SIUnitstoAstronomicalDeclination() {
         Vector3f v = new Vector3f((float) star.getX(), (float) star.getY(), (float) star.getZ());
         Vector3f rthetaphi = new Vector3f();
         v.saveSphericalCoords(rthetaphi);
         rthetaphi.siUnitstoAstronomical();
         assertEquals(star.getDeclination(),rthetaphi.y, 0.0001);     
    }
    
    @Test
    public void SIUnitstoAstronomicalAscension() {
         Vector3f v = new Vector3f((float) star.getX(), (float) star.getY(), (float) star.getZ());
         Vector3f rthetaphi = new Vector3f();
         v.saveSphericalCoords(rthetaphi);
         rthetaphi.siUnitstoAstronomical();
         assertEquals(star.getRa(),rthetaphi.z,0.0001);
         
    }
    
    @Test
    public void SItoastronomicalUnitsX() {
         Vector3f rthetaphi = new Vector3f((float) star.getDistance(), (float) star.getDeclination(), (float) star.getRa());
         rthetaphi.astronomicalUnitstoSI();
         Vector3f v = new Vector3f();
         v.setFromSphericalCoords(rthetaphi.x, rthetaphi.y,rthetaphi.z);
         assertEquals(star.getX(),v.x, 0.0001);     
    }
    
    @Test
    public void SItoastronomicalUnitsY() {
         Vector3f rthetaphi = new Vector3f((float) star.getDistance(), (float) star.getDeclination(), (float) star.getRa());
         rthetaphi.astronomicalUnitstoSI();
         Vector3f v = new Vector3f();
         v.setFromSphericalCoords(rthetaphi.x, rthetaphi.y,rthetaphi.z);
         assertEquals(star.getY(),v.y,0.0001);
         
    }
    
    @Test
    public void SItoastronomicalUnitsZ() {
         Vector3f rthetaphi = new Vector3f((float) star.getDistance(), (float) star.getDeclination(), (float) star.getRa());
         rthetaphi.astronomicalUnitstoSI();
         Vector3f v = new Vector3f();
         v.setFromSphericalCoords(rthetaphi.x, rthetaphi.y,rthetaphi.z);
         assertEquals(star.getZ(),v.z,0.0001);
         
    }
    
    @Test
    public void zerovectortosphericals() {
        zerovector.saveSphericalCoords(rthetaphi1);
        assertEquals(0,rthetaphi1.y,0.0001);
    }
    
}
