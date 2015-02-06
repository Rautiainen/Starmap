package starmap;

import org.lwjgl.Sys;
import org.lwjgl.opengl.*;
import org.lwjgl.glfw.*;
  
import java.nio.ByteBuffer;
import static org.lwjgl.glfw.Callbacks.errorCallbackPrint;
  
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.glfw.GLFW.*;
  
public class StarFrame {
    
    private int WIDTH = 800;
    private int HEIGHT = 600;
    private double edgelength = 0.6;
    
    private GLFWErrorCallback errorCallback;
    private GLFWKeyCallback   keyCallback;
   
  
    private long window;
  
    public void execute() {
        Sys.getVersion();
  
        try {
            init();
            loop();
            glfwDestroyWindow(window);
        } finally {
            glfwTerminate();
        }
    }
    
    public void show(Starset starset) {
        Sys.getVersion();
  
        try {
            init();
            loop(starset);
            glfwDestroyWindow(window);
        } finally {
            glfwTerminate();
        }
    }
    
    private void init() {
        glfwSetErrorCallback(errorCallback = errorCallbackPrint(System.err));
 
        
        if ( glfwInit() != GL11.GL_TRUE )
            throw new IllegalStateException("Unable to initialize GLFW");
  
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
  
        window = glfwCreateWindow(WIDTH, HEIGHT, "Starmap", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");
  
        glfwSetKeyCallback(window, keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                    glfwSetWindowShouldClose(window, GL_TRUE); // We will detect this in our rendering loop
            }
        
 
        });
  
        ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(
            window,
            (GLFWvidmode.width(vidmode) - WIDTH) / 2,
            (GLFWvidmode.height(vidmode) - HEIGHT) / 2
        );
  
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
  
        
        
        glfwShowWindow(window);
    }
  
    private void initGL() {

		/* OpenGL */
	    	int width = 800;
            	int height = 800;

		GL11.glViewport(0, 0, width, height); // Reset The Current Viewport
		GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
		GL11.glLoadIdentity(); // Reset The Projection Matrix
		//GLU.gluPerspective(45.0f, ((float) width / (float) height), 0.1f, 100.0f); // Calculate The Aspect Ratio Of The Window
		GL11.glMatrixMode(GL11.GL_MODELVIEW); // Select The Modelview Matrix
		GL11.glLoadIdentity(); // Reset The Modelview Matrix

		GL11.glShadeModel(GL11.GL_SMOOTH); // Enables Smooth Shading
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Black Background
		GL11.glClearDepth(1.0f); // Depth Buffer Setup
		GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
		GL11.glDepthFunc(GL11.GL_LEQUAL); // The Type Of Depth Test To Do
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST); // Really Nice Perspective Calculations

	}
    
    private void loop() {
        GLContext.createFromCurrent();
  
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        while ( glfwWindowShouldClose(window) == GL_FALSE ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            
            GL11.glRotated(0.1, 0.0, 1.0, 1.0);
           
            //left side
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(0.0,0.0,0.0);
            GL11.glVertex3d(0.0,edgelength,0.0);
            GL11.glVertex3d(0.0,edgelength,edgelength);
            GL11.glVertex3d(0.0,0.0,edgelength);
            GL11.glEnd();
            
            //right side
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(edgelength,0.0,0.0);
            GL11.glVertex3d(edgelength,edgelength,0.0);
            GL11.glVertex3d(edgelength,edgelength,edgelength);
            GL11.glVertex3d(edgelength,0.0,edgelength);
            GL11.glEnd();
            
            //top
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(0.0,edgelength,0.0);
            GL11.glVertex3d(0.0,edgelength,edgelength);
            GL11.glVertex3d(edgelength,edgelength,edgelength);
            GL11.glVertex3d(edgelength,edgelength,0.0);
            GL11.glEnd();
            
            //bottom
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(0.0,0.0,0.0);
            GL11.glVertex3d(0.0,0.0,edgelength);
            GL11.glVertex3d(edgelength,0.0,edgelength);
            GL11.glVertex3d(edgelength,0.0,0.0);
            GL11.glEnd();
            
            solidsphere(0.2,0.2,0.2,0.02,9);
                    
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }
  
    
    private void loop(Starset starset) {
        GLContext.createFromCurrent();
  
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        while ( glfwWindowShouldClose(window) == GL_FALSE ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            
            GL11.glRotated(0.1, 0.0, 1.0, 1.0);
           
            //left side
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(0.0,0.0,0.0);
            GL11.glVertex3d(0.0,edgelength,0.0);
            GL11.glVertex3d(0.0,edgelength,edgelength);
            GL11.glVertex3d(0.0,0.0,edgelength);
            GL11.glEnd();
            
            //right side
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(edgelength,0.0,0.0);
            GL11.glVertex3d(edgelength,edgelength,0.0);
            GL11.glVertex3d(edgelength,edgelength,edgelength);
            GL11.glVertex3d(edgelength,0.0,edgelength);
            GL11.glEnd();
            
            //top
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(0.0,edgelength,0.0);
            GL11.glVertex3d(0.0,edgelength,edgelength);
            GL11.glVertex3d(edgelength,edgelength,edgelength);
            GL11.glVertex3d(edgelength,edgelength,0.0);
            GL11.glEnd();
            
            //bottom
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(0.0,0.0,0.0);
            GL11.glVertex3d(0.0,0.0,edgelength);
            GL11.glVertex3d(edgelength,0.0,edgelength);
            GL11.glVertex3d(edgelength,0.0,0.0);
            GL11.glEnd();
            
            for(Star star : starset.getStars()) {
                solidsphere((star.getX()+50)/100,(star.getY()+50)/100,star.getZ()/100,0.005,9);
            }
            
                    
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }
    
    public static void main(String[] args) {
        new StarFrame().execute();
    }
    
    //creates approximation of a sphere with (2n)^3 points
    
    public void solidsphere(double x, double y, double z, double radius, int n) {
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