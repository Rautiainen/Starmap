/*
 *  Generic frame for LWJGL by Antti Rautiainen. Command loop, window size and 
 * name my be defined by user. 
 */


package Lwjglwrapper;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;


import org.lwjgl.Sys;
import java.nio.ByteBuffer;
import static org.lwjgl.glfw.Callbacks.errorCallbackPrint;
  
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.glfw.GLFW.*;
  
public class LwjglFrame {
    
    private int width;
    private int height;
    private String name;
    
    private GLFWErrorCallback errorCallback;
    private GLFWKeyCallback   keyCallback;
    
    private long window;
    
    public LwjglFrame(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }
   
     
      
    private void init() {
        glfwSetErrorCallback(errorCallback = errorCallbackPrint(System.err));
 
        
        if ( glfwInit() != GL11.GL_TRUE )
            throw new IllegalStateException("Unable to initialize GLFW");
  
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
  
        window = glfwCreateWindow(width, height, name, NULL, NULL); 
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
            (GLFWvidmode.width(vidmode) - width) / 2,
            (GLFWvidmode.height(vidmode) - height) / 2
        );
  
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
  
        
        
        glfwShowWindow(window);
    }
    
    public void execute(GLoopObject command) {
        Sys.getVersion();
  
        try {
            init();
            loop(command);
            glfwDestroyWindow(window);
        } finally {
            glfwTerminate();
        }
    }
    
    
    private void initGL() {

		/* OpenGL */
	    	
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
    
    private void loop(GLoopObject command) {
        GLContext.createFromCurrent();
  
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        while ( glfwWindowShouldClose(window) == GL_FALSE ) {
                        
            command.show();
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }
}