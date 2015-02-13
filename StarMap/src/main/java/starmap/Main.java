/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starmap;

//import com.joml.matrix.Matrix3f;
//import com.joml.vector.Vector3f;
//import java.io.FileNotFoundException;

/**
 *
 * @author air
*/

public class Main {
    public static void main(String[] args) {
        Starset bigDipper = new Starset();
        new StarFrame().execute(bigDipper.getgLoopObject());
        }
}