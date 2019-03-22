package lwjglwrapper;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
//import org.lwjgl.glfw.
//import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL11;
//import org.lwjgl.opengl.GLContext;
//import org.lwjgl.opengl.G

//import org.lwjgl.Sys;
import java.nio.ByteBuffer;
import org.lwjgl.Version;
//import static org.lwjgl.glfw.Callbacks.errorCallbackPrint;
  
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
  
/**
 * Generic frame for LWJGL. Command loop, window size and 
 * name my be defined by user. 
 * @author Antti Rautiainen
 */
public class LwjglFrame {
    
    private int width;
    private int height;
    private String name;
    
    private GLFWErrorCallback errorCallback;
    private GLFWKeyCallback   keyCallback;
    //private GLFWKeyFun GLFWkeyfun;
    
    private long window;
    
    public LwjglFrame(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }
   
    private void init() {
        //glfwSetErrorCallback(errorCallback = errorCallbackPrint(System.err));
        errorCallback = GLFWErrorCallback.createPrint(System.err);
 
        
        //if (glfwInit() != GL11.GL_TRUE) {
        if (glfwInit() != true) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
  
        window = glfwCreateWindow(width, height, name, NULL, NULL); 
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }
        
        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
		});
        
        //glfwSetKeyCallback(window, keyCallback = new GLFWKeyCallback() {
        //glfwSetKeyCallback(window, GLFWkeyfun = new GLFWkeyfun() { 
        //@Override
        //    public void invoke(long window, int key, int scancode, int action, int mods) {
        //        if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                    //glfwSetWindowShouldClose(window, GL_TRUE); // We will detect this in our rendering loop
        //            glfwSetWindowShouldClose(window, true); // We will detect this in our rendering loop
        //        }
        //    }
        
 
        //});
  
        //ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(
            window,
            //(GLFWVidMode.width(vidmode) - width) / 2,
            //(GLFWVidMode.height(vidmode) - height) / 2
            (vidmode.width() - width) / 2,
            (vidmode.height() - height) / 2
        );
  
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
    }
    
/**
 * Offers interface for using this LWJGL 
 * @author Antti Rautiainen
 */
    public void execute(GLoopObject command) {
        //Sys.getVersion();
        Version.getVersion();
  
        //try {
        init();
        loop(command);
        glfwDestroyWindow(window);
        //} //finally {
            // glfwTerminate(); //note: put this somewhere later on. 
        //}
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
        //GLContext.createFromCurrent();
        GL.createCapabilities();
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        //while (glfwWindowShouldClose(window) == GL_FALSE) {
        while (glfwWindowShouldClose(window) == false) {
            command.show();
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }
}