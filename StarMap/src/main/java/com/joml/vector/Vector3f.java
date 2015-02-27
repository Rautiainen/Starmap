/*
 * Feel free to do whatever you want with this code, all I've done is
 * pull together common knowledge into one easy package. Use it as a
 * base for your own work, copy/paste bits or integrate it into your
 * existing project, it's all good. Just add a thanks to me somewhere.
 */
package com.joml.vector;

import com.joml.matrix.Matrix3f;

/**
 * Vector3f
 * 
 * Contains the definition of a Vector comprising 3 floats and associated transformations.
 * 
 * @author Richard Greenlees
 */
public class Vector3f {

    public float x;
    public float y;
    public float z;

    public Vector3f() {
    
    }

    public Vector3f(float x, float y, float z) {
    	this.x = x;
	this.y = y;
	this.z = z;
    }
        
    public Vector3f(Vector3f clone) {
        this.x = clone.x;
        this.y = clone.y;
        this.z = clone.z;
    }

        /** Sets the x, y and z attributes to match the supplied vector */
    public void set(Vector3f v) {
	x = v.x;
	y = v.y;
	z = v.z;
    }

        /** Sets the x, y and z attributes to the supplied float values */
    public void set(float x, float y, float z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

        /** Subtracts the supplied vector from this one */
    public void sub(Vector3f v) {
        x -= v.x;
	y -= v.y;
	z -= v.z;
    }
        
        /** Subtracts v2 from v1 and stores the results in dest. Does not modify v1 or v2 */
    public static void sub(Vector3f v1, Vector3f v2, Vector3f dest) {
        dest.set(v1.x - v2.x,
                 v1.y - v2.y,
                 v1.z - v2.z);
    }
        
        /** Adds the supplied vector to this one */
    public void add(Vector3f v) {
	x += v.x;
	y += v.y;
	z += v.z;
    }
        
        /** Adds v2 to v1 and stores the results in dest. Does not modify v1 or v2 */
    public static void add(Vector3f v1, Vector3f v2, Vector3f dest) {
        dest.set(v1.x + v2.x,
            v1.y + v2.y,
            v1.z + v2.z);
    }

        /** Returns the length squared of this vector */
    public float lengthSquared() {
	return x * x + y * y + z * z;
    }

        /** Returns the length of this vector */
    public float length() {
	return (float) Math.sqrt(lengthSquared());
    }
        
        /** Used internally for the distance function */
    private static float lengthSquared(Vector3f source) {
       return source.x * source.x + source.y * source.y + source.z * source.z;
    }
        
    /** Used internally for the distance function */
    private static float length(Vector3f source) {
        return (float) Math.sqrt(lengthSquared(source));
    }
        


        /** Normalizes this vector */
    public void normalize() {
	float d = length();
        x /= d;
        y /= d;
	z /= d;
    }
        
        /** Normalize the original vector and store the results in dest. Does not modify the original */
    public static void normalize(Vector3f original, Vector3f dest) {
        float d = length(original);
	dest.set(original.x / d,
        original.y / d,
        original.z / d);
    }

        /** Set this vector to be the cross of v1 and v2 */
    public void cross(Vector3f v1, Vector3f v2) {
	set(v1.y * v2.z - v1.z * v2.y,
        v1.z * v2.x - v1.x * v2.z,
        v1.x * v2.y - v1.y * v2.x);
    }
        
     /** Calculate the cross of v1 and v2 and store the results in dest. Does modify v1 or v2 */
    public static void cross(Vector3f v1, Vector3f v2, Vector3f dest) {
        dest.set(v1.y * v2.z - v1.z * v2.y,
                 v1.z * v2.x - v1.x * v2.z,
                v1.x * v2.y - v1.y * v2.x);
    }
        
        /** Returns the distance between the start and end vectors. Does not modify either */
    public static float distance(Vector3f start, Vector3f end) {
        return (float) Math.sqrt((end.x - start.x) * (end.x - start.x) +
                                 (end.y - start.y) * (end.y - start.y) +
                                 (end.z - start.z) * (end.z - start.z));
    }
        
        /** Return the dot product of the supplied v1 and v2 vectors */
    public static float dot(Vector3f v1, Vector3f v2) {
        return (v1.x * v2.x) + (v1.y * v2.y) + (v1.z * v2.z);
    }
        
        /** Calculates the normal of a surface defined by points v1, v2 and v3 and stores it in dest. v1, v2 and v3 are not modified */
    public static void normal(Vector3f v1, Vector3f v2, Vector3f v3, Vector3f dest) {
        dest.set (((v2.y - v1.y) * (v3.z - v1.z)) - ((v2.z - v1.z) * (v3.y - v1.y)),
                  ((v2.z - v1.z) * (v3.x - v1.x)) - ((v2.x - v1.x) * (v3.z - v1.z)),
                  ((v2.x - v1.x) * (v3.y - v1.y)) - ((v2.y - v1.y) * (v3.x - v1.x)));
    }
        
    public String toString() {
        return "Vector3f { " + x + ", " + y + ", " + z + " }";
    }
        
        
    //Additional methods by Antti Rautiainen

    /**
    * Multiplies this vector by the supplied matrix. 
    * @author Antti Rautiainen
    * @param left, matrix which multiplices
    */
    public void mul(Matrix3f left) {
        set(left.m00 * x + left.m01 * y + left.m02 * z,
            left.m10 * x + left.m11 * y + left.m12 * z,
            left.m20 * x + left.m21 * y + left.m22 * z);
    }
    
    /**
    * Multiply this vector by the scalar value 
    * @author Antti Rautiainen
    * @param scalar , which multiplies
    */
    public void mul(float scalar) {
        x *= scalar;
        y *= scalar;
        z *= scalar;
        
    }
    
    /**
    * Save corresponding spherical coordinates to r, phi, theta.
    * @author Antti Rautiainen
    * @param rthetaphi, r phi and theta saved to a vector
    */
    public void saveSphericalCoords(Vector3f rthetaphi) {
        rthetaphi.x = length();
        if (rthetaphi.x == 0) {
            rthetaphi.y = 0;
        } else {
            rthetaphi.y =  (float) Math.acos(z / rthetaphi.x);  //declination/inclination  gives a range from 0 to pi. 
        }
        rthetaphi.z = (float) Math.atan2(y, x);       //right ascension/azimuth gives a range from 0 to 2pi. 
    }
    
    /**
    * Setting a vector from spherical coordinates r, phi, theta.
    * @author Antti Rautiainen
     * @param r
     * @param theta
     * @param phi
    */
    public void setFromSphericalCoords(float r, float theta, float phi) {
        float rsintheta = (float) (r * Math.sin(theta));
        x = (float) (rsintheta * Math.cos(phi));
        y = (float) (rsintheta * Math.sin(phi));
        z =  (float) (r * Math.cos(theta));
    }
    
    /**
    * Converts astronomic units to SI units
    * @author Antti Rautiainen
    */
    public void astronomicalUnitstoSI() {
        y = (float) (Math.PI / 180.0) * (90 - y);
        z = (float) ((Math.PI / 12.0) * z - positive10(z - 12) * 2 * Math.PI);
    }
    
    /**
    * Converts SI units to astronomic units
    * @author Antti Rautiainen
    */
    public void siUnitstoAstronomical() {
        y = (float) (90 - ((180.0 / Math.PI) * y));
        z = (float) ((12.0 / Math.PI) * z) +  negative10(z) * 24;
    }
    
    /**
    * @author Antti Rautiainen
     * @param input
     * @return 1 if not negative, otherwise 0
    */
    public float notnegative10(float input) {
        //return (float) ((1 + Math.signum(Math.signum(x) + 0.5))/2.0);
        float output;
        if (input >= 0) {
            output = 1;
        } else {
            output = 0;
        }
        return output;
    }
    
    /**
    * @author Antti Rautiainen
     * @param input
     * @return 1 if negative, otherwise 0
     *
    */
    public float negative10(float input) {
        return 1.0f - notnegative10(input);
    }
    
    /**
    * @author Antti Rautiainen
     * @param input
     * @return 1 if positive, otherwise 0
     * 
    */
    public float positive10(float input) {
       //  return (float) ((1 + Math.signum(Math.signum(x) - 0.5))/2.0);
        float output;
        if (input > 0) {
            output = 1;
        } else {
           output = 0;
        }
        return output;
    }
    
}