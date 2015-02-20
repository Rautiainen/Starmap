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
    
    public StarGLoop(Starset starset) {
        this.starset = starset;
    }
    
    @Override
    public void show() {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
      
            //GL11.glRotated(0.25, 0.0, 1.0, 1.0);
           
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
              
            Vector3f starcoords = new Vector3f();
            double spot_x;
            double spot_y;
            double spot_z;
            double visualMag;
            double sphereradius;
            StarCube starcube = starset.getStarcube();
            for(Star star : starset.getStars()) {
                starcoords = starcube.transform(star.getX(), star.getY(),star.getZ());
                starcoords.mul((float) edgelength);
                spot_x = starcube.getObservationSpot().x;
                spot_y = starcube.getObservationSpot().y;
                spot_z = starcube.getObservationSpot().z;
                sphereradius = Math.max((9.0-star.visualMag(star, spot_x, spot_y, spot_z)) / 1000, 0) ;               
                //for debugging
                //System.out.print()
                //why has to flip these?
                solidsphere(-starcoords.x,-starcoords.y,-starcoords.z,sphereradius,5); //0.005
            }

            //solidsphere(0.5,0,0,0.3,5); //for debugging
            //solidsphere(0,edgelength,0,0.005,9);
            //solidsphere(0,0,edgelength,0.005,9);
                    
                    
    }


    /**
    * Draws a solid sphere by scaling a cube written with 6*4*2n*2n points (certain
    * points are repeated). each side of cube has 2n*2n solid squares. 
    * n=1 results a 24-edged polygon. 
    * @author Antti Rautiainen 
    */
    private void solidsphere(double x, double y, double z, double radius, int n) {
        
        double[][] points = new double[3][(int) (24 * Math.pow(2*n,2))];
        double multiplier;
                
        //left side 
        for(int i=0;i<2*n;i++) {
            for(int j=0;j<2*n;j++) {
                multiplier = radius / Math.sqrt(Math.pow(-1,2)+Math.pow(1-(1.0/n)*i,2)+Math.pow(1-(1.0/n)*j,2));
                points[0][4*i+j*8*n] = x+(-1)*multiplier; 
                points[1][4*i+j*8*n] = y+(1-(1.0/n)*i)*multiplier; 
                points[2][4*i+j*8*n] = z+(1-(1.0/n)*j)*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(-1,2)+Math.pow(1-(1.0/n)*(i+1),2)+Math.pow(1-(1.0/n)*j,2));
                points[0][4*i+j*8*n+1] = x+(-1)*multiplier; 
                points[1][4*i+j*8*n+1] = y+(1-(1.0/n)*(i+1))*multiplier; 
                points[2][4*i+j*8*n+1] = z+(1-(1.0/n)*j)*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(-1,2)+Math.pow(1-(1.0/n)*(i+1),2)+Math.pow(1-(1.0/n)*(j+1),2));
                points[0][4*i+j*8*n+2] = x+(-1)*multiplier; 
                points[1][4*i+j*8*n+2] = y+(1-(1.0/n)*(i+1))*multiplier; 
                points[2][4*i+j*8*n+2] = z+(1-(1.0/n)*(j+1))*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(-1,2)+Math.pow(1-(1.0/n)*i,2)+Math.pow(1-(1.0/n)*(j+1),2));
                points[0][4*i+j*8*n+3] = x+(-1)*multiplier; 
                points[1][4*i+j*8*n+3] = y+(1-(1.0/n)*i)*multiplier; 
                points[2][4*i+j*8*n+3] = z+(1-(1.0/n)*(j+1))*multiplier; 
            }
        }    
        //right side
        for(int i = 0; i < 2*n; i++) {
            for(int j=0;j<2*n;j++) {
                multiplier = radius / Math.sqrt(Math.pow(1,2)+Math.pow(1-(1.0/n)*i,2)+Math.pow(1-(1.0/n)*j,2));
                points[0][16*n*n + 4*i+j*8*n] = x+1*multiplier; 
                points[1][16*n*n + 4*i+j*8*n] = y+(1-(1.0/n)*i)*multiplier; 
                points[2][16*n*n + 4*i+j*8*n] = z+(1-(1.0/n)*j)*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1,2)+Math.pow(1-(1.0/n)*(i+1),2)+Math.pow(1-(1.0/n)*j,2));
                points[0][16*n*n + 4*i+j*8*n+1] = x+1*multiplier; 
                points[1][16*n*n + 4*i+j*8*n+1] = y+(1-(1.0/n)*(i+1))*multiplier; 
                points[2][16*n*n + 4*i+j*8*n+1] = z+(1-(1.0/n)*j)*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1,2)+Math.pow(1-(1.0/n)*(i+1),2)+Math.pow(1-(1.0/n)*(j+1),2));
                points[0][16*n*n + 4*i+j*8*n+2] = x+1*multiplier; 
                points[1][16*n*n + 4*i+j*8*n+2] = y+(1-(1.0/n)*(i+1))*multiplier; 
                points[2][16*n*n + 4*i+j*8*n+2] = z+(1-(1.0/n)*(j+1))*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1,2)+Math.pow(1-(1.0/n)*i,2)+Math.pow(1-(1.0/n)*(j+1),2));
                points[0][16*n*n + 4*i+j*8*n+3] = x+1*multiplier; 
                points[1][16*n*n + 4*i+j*8*n+3] = y+(1-(1.0/n)*i)*multiplier; 
                points[2][16*n*n + 4*i+j*8*n+3] = z+(1-(1.0/n)*(j+1))*multiplier; 
            }
        }
        //top side
        for(int i = 0; i < 2*n; i++) {
            for(int j=0;j<2*n;j++) {
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*i,2)+Math.pow(1,2)+Math.pow(1-(1.0/n)*j,2));
                points[0][32*n*n + 4*i+j*8*n] = x+(1-(1.0/n)*i)*multiplier; 
                points[1][32*n*n + 4*i+j*8*n] = y+multiplier; 
                points[2][32*n*n + 4*i+j*8*n] = z+(1-(1.0/n)*j)*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*(i+1),2)+Math.pow(1,2)+Math.pow(1-(1.0/n)*j,2));
                points[0][32*n*n + 4*i+j*8*n+1] = x+(1-(1.0/n)*(i+1))*multiplier; 
                points[1][32*n*n + 4*i+j*8*n+1] = y+1*multiplier; 
                points[2][32*n*n + 4*i+j*8*n+1] = z+(1-(1.0/n)*j)*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*(i+1),2)+Math.pow(1,2)+Math.pow(1-(1.0/n)*(j+1),2));
                points[0][32*n*n + 4*i+j*8*n+2] = x+(1-(1.0/n)*(i+1))*multiplier; 
                points[1][32*n*n + 4*i+j*8*n+2] = y+multiplier; 
                points[2][32*n*n + 4*i+j*8*n+2] = z+(1-(1.0/n)*(j+1))*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*i,2)+Math.pow(1,2)+Math.pow(1-(1.0/n)*(j+1),2));
                points[0][32*n*n + 4*i+j*8*n+3] = x+(1-(1.0/n)*i)*multiplier; 
                points[1][32*n*n + 4*i+j*8*n+3] = y+multiplier; 
                points[2][32*n*n + 4*i+j*8*n+3] = z+(1-(1.0/n)*(j+1))*multiplier; 
            }
        }
        //bottom side
        for(int i = 0; i < 2*n; i++) {
            for(int j=0;j<2*n;j++) {
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*i,2)+Math.pow(-1,2)+Math.pow(1-(1.0/n)*j,2));
                points[0][48*n*n + 4*i+j*8*n] = x+(1-(1.0/n)*i)*multiplier; 
                points[1][48*n*n + 4*i+j*8*n] = y-multiplier; 
                points[2][48*n*n + 4*i+j*8*n] = z+(1-(1.0/n)*j)*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*(i+1),2)+Math.pow(-1,2)+Math.pow(1-(1.0/n)*j,2));
                points[0][48*n*n + 4*i+j*8*n+1] = x+(1-(1.0/n)*(i+1))*multiplier; 
                points[1][48*n*n + 4*i+j*8*n+1] = y-1*multiplier; 
                points[2][48*n*n + 4*i+j*8*n+1] = z+(1-(1.0/n)*j)*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*(i+1),2)+Math.pow(-1,2)+Math.pow(1-(1.0/n)*(j+1),2));
                points[0][48*n*n + 4*i+j*8*n+2] = x+(1-(1.0/n)*(i+1))*multiplier; 
                points[1][48*n*n + 4*i+j*8*n+2] = y-multiplier; 
                points[2][48*n*n + 4*i+j*8*n+2] = z+(1-(1.0/n)*(j+1))*multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*i,2)+Math.pow(-1,2)+Math.pow(1-(1.0/n)*(j+1),2));
                points[0][48*n*n + 4*i+j*8*n+3] = x+(1-(1.0/n)*i)*multiplier; 
                points[1][48*n*n + 4*i+j*8*n+3] = y-multiplier; 
                points[2][48*n*n + 4*i+j*8*n+3] = z+(1-(1.0/n)*(j+1))*multiplier; 
            }
        }
        //front side
        for(int i = 0; i < 2*n; i++) {
            for(int j=0;j<2*n;j++) {
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*i,2)+ Math.pow(1-(1.0/n)*j,2)+Math.pow(1,2));
                points[0][64*n*n + 4*i+j*8*n] = x+(1-(1.0/n)*i)*multiplier; 
                points[1][64*n*n + 4*i+j*8*n] = y+(1-(1.0/n)*j)*multiplier; 
                points[2][64*n*n + 4*i+j*8*n] = z+multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*(i+1),2)+Math.pow((1-(1.0/n)*j),2)+Math.pow(1,2));
                points[0][64*n*n + 4*i+j*8*n+1] = x+(1-(1.0/n)*(i+1))*multiplier; 
                points[1][64*n*n + 4*i+j*8*n+1] = y+(1-(1.0/n)*j)*multiplier; 
                points[2][64*n*n + 4*i+j*8*n+1] = z+multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*(i+1),2)+Math.pow(1-(1.0/n)*(j+1),2)+Math.pow(1,2));
                points[0][64*n*n + 4*i+j*8*n+2] = x+(1-(1.0/n)*(i+1))*multiplier; 
                points[1][64*n*n + 4*i+j*8*n+2] = y+(1-(1.0/n)*(j+1))*multiplier; 
                points[2][64*n*n + 4*i+j*8*n+2] = z+multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*i,2)+Math.pow(1-(1.0/n)*(j+1),2)+Math.pow(1,2));
                points[0][64*n*n + 4*i+j*8*n+3] = x+(1-(1.0/n)*i)*multiplier; 
                points[1][64*n*n + 4*i+j*8*n+3] = y+(1-(1.0/n)*(j+1))*multiplier; 
                points[2][64*n*n + 4*i+j*8*n+3] = z+multiplier; 
            }
        }
        //back side. 
        for(int i = 0; i < 2*n; i++) {
            for(int j=0;j<2*n;j++) {
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*i,2)+ Math.pow(1-(1.0/n)*j,2)+Math.pow(-1,2));
                points[0][80*n*n + 4*i+j*8*n] = x+(1-(1.0/n)*i)*multiplier; 
                points[1][80*n*n + 4*i+j*8*n] = y+(1-(1.0/n)*j)*multiplier; 
                points[2][80*n*n + 4*i+j*8*n] = z-multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*(i+1),2)+Math.pow((1-(1.0/n)*j),2)+Math.pow(-1,2));
                points[0][80*n*n + 4*i+j*8*n+1] = x+(1-(1.0/n)*(i+1))*multiplier; 
                points[1][80*n*n + 4*i+j*8*n+1] = y+(1-(1.0/n)*j)*multiplier; 
                points[2][80*n*n + 4*i+j*8*n+1] = z-multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*(i+1),2)+Math.pow((1-(1.0/n)*(j+1)),2)+Math.pow(-1,2));
                points[0][80*n*n + 4*i+j*8*n+2] = x+(1-(1.0/n)*(i+1))*multiplier; 
                points[1][80*n*n + 4*i+j*8*n+2] = y+(1-(1.0/n)*(j+1))*multiplier; 
                points[2][80*n*n + 4*i+j*8*n+2] = z-multiplier; 
                multiplier = radius / Math.sqrt(Math.pow(1-(1.0/n)*i,2)+Math.pow((1-(1.0/n)*(j+1)),2)+Math.pow(-1,2));
                points[0][80*n*n + 4*i+j*8*n+3] = x+(1-(1.0/n)*i)*multiplier; 
                points[1][80*n*n + 4*i+j*8*n+3] = y+(1-(1.0/n)*(j+1))*multiplier; 
                points[2][80*n*n + 4*i+j*8*n+3] = z-multiplier; 
            }
        }
        
        GL11.glBegin(GL11.GL_QUADS); //GL_POLYGON
        
        for(int i=0;i< 24 *Math.pow(2*n,2);i++) {
            GL11.glVertex3d(points[0][i], points[1][i],points[2][i]);
        }
       
        GL11.glEnd();    
    
    }    
        
    
}
