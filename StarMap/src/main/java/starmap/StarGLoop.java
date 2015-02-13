package starmap;

import Lwjglwrapper.GLoopObject;
import com.joml.vector.Vector3f;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

/**
 *  Functions to be called by LWJGL frame loop 
 *  @author Antti Rautiainen
 */
public class StarGLoop implements GLoopObject {

    private double edgelength = 0.6;
    Starset starset;
    StarCube starcube;
    
    public StarGLoop(Starset starset, StarCube starcube) {
        this.starset = starset;
        this.starcube = starcube;
    }
    
    @Override
    public void show() {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            
            GL11.glRotated(0.1, 0.0, 1.0, 1.0);
           
            //left side
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(-edgelength,-edgelength,-edgelength);
            GL11.glVertex3d(-edgelength,edgelength,-edgelength);
            GL11.glVertex3d(-edgelength,edgelength,edgelength);
            GL11.glVertex3d(-edgelength,-edgelength,edgelength);
            GL11.glEnd();
            
            //right side
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(edgelength,-edgelength,-edgelength);
            GL11.glVertex3d(edgelength,edgelength,-edgelength);
            GL11.glVertex3d(edgelength,edgelength,edgelength);
            GL11.glVertex3d(edgelength,-edgelength,edgelength);
            GL11.glEnd();
            
            //top
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(-edgelength,edgelength,-edgelength);
            GL11.glVertex3d(-edgelength,edgelength,edgelength);
            GL11.glVertex3d(edgelength,edgelength,edgelength);
            GL11.glVertex3d(edgelength,edgelength,-edgelength);
            GL11.glEnd();
            
            //bottom
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(-edgelength,-edgelength,-edgelength);
            GL11.glVertex3d(-edgelength,-edgelength,edgelength);
            GL11.glVertex3d(edgelength,-edgelength,edgelength);
            GL11.glVertex3d(edgelength,-edgelength,-edgelength);
            GL11.glEnd();
            
            /*
            for(Star star : starset.getStars()) {
                solidsphere((star.getX()+50)/100,(star.getY()+50)/100,star.getZ()/100,0.005,9);
            }
            */
            
            
            
            Vector3f starcoords = new Vector3f();
            for(Star star : starset.getStars()) {
                starcoords = starcube.transform(star.getX(), star.getY(),star.getZ());
                starcoords.mul((float) edgelength);
                //for debugging
                //System.out.print()
                solidsphere(starcoords.x,starcoords.y,starcoords.z,0.005,9);
            }
                    
                    
    }
    
    
    private void solidsphere(double x, double y, double z, double radius, int n) {
        double[][] points = new double[3][(int) Math.pow(2*n,3)];
        double multiplier;
        
        for(int i=0;i<2*n;i++) {
            for(int j=0;j<2*n;j++) {
                for(int k=0;k<2*n;k++) {
                    multiplier = radius / Math.sqrt(Math.pow(i-n,2)+Math.pow(j-n,2)+Math.pow(k-n,2));
                    points[0][i+j*2*n+k*4*n*n] = x+(i-n)*multiplier; 
                    points[1][i+j*2*n+k*4*n*n] = y+(j-n)*multiplier; 
                    points[2][i+j*2*n+k*4*n*n] = z+(k-n)*multiplier; 
                }
            }
        }
            
        GL11.glBegin(GL11.GL_POLYGON); //GL_POLYGON
        
       
        for(int i=0;i<2*n;i++) {
            for(int j=0;j<2*n;j++) {
                for(int k=0;k<2*n;k++) {
                    GL11.glVertex3d(points[0][i+j*2*n+k*4*n*n], points[1][i+j*2*n+k*4*n*n],points[2][i+j*2*n+k*4*n*n]);
                }
            }
        }
        
        GL11.glEnd();
            
    
    }    
        
    
}
