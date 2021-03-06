/* --------------------------------------------------------------------------
 * 
 * Author -------------- Cecilia Y. Sui 
 * Assignment ---------- Final Exam Project 
 * Course -------------- Computer Graphics
 * Instructor ---------- Dr. Crawley 
 * Date of Submission -- December 6, 2019
 * Language Used ------- Java & OpenGL
 * Class Imported ------ Camera from Camera.java (written by Dr. Eck)
 * --------------------- ObjectsToDraw (written by Cecilia S.)
 * Description --------- Use JOGL to draw the pyramid scene
 * 
--------------------------------------------------------------------------- */

// ----------------------------------------------------------------------------
// Imports 
// ----------------------------------------------------------------------------
import com.jogamp.opengl.*;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.awt.*;
import com.jogamp.opengl.util.awt.ImageUtil;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

// ----------------------------------------------------------------------------
// House3D class 
// ----------------------------------------------------------------------------
public class Final extends GLJPanel implements GLEventListener {
    public static void main(String[] args) {
        JFrame window = new JFrame("Final Exam Project -- Cecilia Y. Sui");
        Final panel = new Final();
        window.setContentPane(panel);
        window.pack();
        window.setLocation(100,100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        panel.requestFocusInWindow();
    }

    // ----------------------------------------------------------------------------
    // Declare private variables
    // ----------------------------------------------------------------------------
    private Camera camera;
    private ObjectsToDraw currObject; 
    private GLJPanel display;
    private int angle; 
    private Timer animationTimer;
    private int currentTexture;

    // ----------------------------------------------------------------------------
    // Constructor 
    // ----------------------------------------------------------------------------
    public Final() {
        //setPreferredSize( new Dimension(800,800) );
        //addGLEventListener(this);
        GLCapabilities caps = new GLCapabilities(null);
        display = new GLJPanel(caps);
        display.setPreferredSize( new Dimension(800,800) );
        display.addGLEventListener(this);
        setLayout(new BorderLayout());
        add(display,BorderLayout.CENTER);
        camera = new Camera();
        animationTimer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                update();
                display.repaint();
            }
        });
        animationTimer.start();
    }


    private String[] textureFileNames = {
        "marble.jpg", // 0
        "sand.jpg", // 1
        "bluewall.jpg", // 2
        "brick001.jpg", // 3
        "gold.jpg", // 4
        "pyramid.jpg", // 5
        "bluewall.jpg", // 6
        "pinkwall.jpg" // 7
    };

    private Texture[] textures = new Texture[textureFileNames.length];

    public void update(){
        angle += 30; 
        if (angle > 360){
            angle -= 360; 
        }
    }

    // ----------------------------------------------------------------------------
    // display method 
    // ----------------------------------------------------------------------------
    public void display(GLAutoDrawable drawable) {    
        GL2 gl2 = drawable.getGL().getGL2();
        gl2.glClearColor(0,0,0,0);
        gl2.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
        camera.apply(gl2);
        gl2.glBindTexture(GL2.GL_TEXTURE_2D, 0);

        float amb[] = {0.1f,0.1f,0.1f,1.0f}; 
        float dif[] = {0.1f,0.1f,0.1f,1.0f};
        float spe[] = {0.1f,0.8f,0.1f,1.0f};  
        
        gl2.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, amb,0); 
        gl2.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_DIFFUSE, dif,0); 
        gl2.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, spe,0); 
        gl2.glMaterialf(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, 128.0f); 

        // ----------------------------------------------------------------------------
        // ----- EDIT HERE ------
        // Scale the scene to see details and overview 
        // ----------------------------------------------------------------------------
        gl2.glScaled(0.6,0.6,0.6); 

        // ----------------------------------------------------------------------------
        // draw objects 
        // ----------------------------------------------------------------------------
        gl2.glPushMatrix(); 
        currObject = ObjectsToDraw.plane; 
        textures[1].bind(gl2);
        drawobject(gl2, currObject); 
        currObject = ObjectsToDraw.pyramid; 
        textures[5].bind(gl2); 
        drawobject(gl2, currObject); 
        gl2.glPopMatrix(); 

        gl2.glPushMatrix();
        gl2.glTranslated(4,0,4); 
        gl2.glScaled(2,2,2);
        drawobject(gl2, currObject);  
        gl2.glPopMatrix(); 

        gl2.glPushMatrix(); 
        gl2.glTranslated(-3,0,-3); 
        gl2.glScaled(0.5,0.5,0.5); 
        drawobject(gl2, currObject);
        gl2.glPopMatrix(); 

        gl2.glPushMatrix();
        GLUT glut = new GLUT();
        gl2.glTranslated(0, 2, 0);
        textures[4].bind(gl2);
        gl2.glRotated(angle,0,1,0); 
        glut.glutSolidTeapot(0.4);
        gl2.glPopMatrix();
        

    } 

    // ----------------------------------------------------------------------------
    // drawobject method (with normal vectors)
    // ----------------------------------------------------------------------------
    public void drawobject(GL2 gl2, ObjectsToDraw currObject){
        gl2.glPushMatrix();
        double Vx, Vy, Vz, Wx, Wy, Wz, Nx, Ny, Nz, x[], y[], z[]; 
        int i, j, vertexNum; 
        int[][] faces = currObject.faces; 
        double[][] vertices = currObject.vertices; 
        for(i = 0; i < faces.length; i++){
            gl2.glBegin(GL2.GL_TRIANGLE_FAN); 
            // get coordinates of 3 vertices 
            x = vertices[faces[i][0]]; 
            y = vertices[faces[i][1]]; 
            z = vertices[faces[i][2]]; 
            // convert to free vectors 
            Vx = y[0] - x[0]; 
            Vy = y[1] - x[1]; 
            Vz = y[2] - x[2]; 
            Wx = z[0] - x[0]; 
            Wy = z[1] - x[1]; 
            Wz = z[2] - x[2]; 
            // Compute cross product of V & W
            Nx = Vy * Wz - Vz * Wy; 
            Ny = Vz * Wx - Vx * Wz; 
            Nz = Vx * Wy - Vy * Wx;
            // get normal vector 
            gl2.glNormal3d(Nx, Ny, Nz); 
            for (j = 0; j < faces[i].length; j++){
                vertexNum = faces[i][j]; 
                if (j == 0) {
                    gl2.glTexCoord2d(0,0);
                }
                else if (j == 1){
                    gl2.glTexCoord2d(1,0); 
                }
                else if (j == 2){
                    gl2.glTexCoord2d(0.5,0.5); 
                }
                gl2.glVertex3dv(vertices[vertexNum], 0); 
            }
            gl2.glEnd(); 
        }
        gl2.glPopMatrix();
    }

    // ----------------------------------------------------------------------------
    // init method 
    // ----------------------------------------------------------------------------
    public void init(GLAutoDrawable graphics) {
        GL2 gl2 = graphics.getGL().getGL2();
        gl2.glClearColor(0, 0, 0, 1); 
        gl2.glEnable(GL2.GL_DEPTH_TEST);
        gl2.glEnable(GL2.GL_LIGHTING);
        gl2.glEnable(GL2.GL_NORMALIZE);
        gl2.glEnable(GL2.GL_RESCALE_NORMAL); 
        gl2.glEnable(GL2.GL_COLOR_MATERIAL);
        // Disable smoothing to get flat surfaces (sharp edeges)
        gl2.glShadeModel(GL2.GL_FLAT); 
        gl2.glPolygonOffset(1,2);
        camera = new Camera(); 
        // ----------------------------------------------------------------------------
        // ----- EDIT HERE ------
        // Change Camera setting to view the scene from different starting angles 
        // ----------------------------------------------------------------------------
        camera.lookAt(1,5,-50, 0,0,1, 0,1,0);
        camera.installTrackball(this);
        currObject = ObjectsToDraw.plane; 
        
        // ----------------------------------------------------------------------------
        // Light source: LIGHT0 -- Night Sky (dim)
        // ----------------------------------------------------------------------------
        gl2.glEnable(GL2.GL_LIGHT0);
        float diffuse[] = { 0.84f, 0.87f, 0.8f, 1.0f };
        float specular[] = { 0.2f, 0.4f, 0.5f, 1.0f };
        float ambient[] = { 0.54f, 0.57f, 0.5f, 1.0f };
        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse, 0);
        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specular, 0);
        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambient, 0);
  
        // ----------------------------------------------------------------------------
        // Textures
        // ----------------------------------------------------------------------------
        for (int i = 0; i < textureFileNames.length; i++) {
            try {
                URL textureURL;
                textureURL = getClass().getClassLoader().getResource("textures/" + textureFileNames[i]);
                if (textureURL != null) {
                    BufferedImage img = ImageIO.read(textureURL);
                    ImageUtil.flipImageVertically(img);
                    textures[i] = AWTTextureIO.newTexture(GLProfile.getDefault(), img, true);
                    textures[i].setTexParameteri(gl2, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
                    textures[i].setTexParameteri(gl2, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        textures[0].enable(gl2);
    }

    public void dispose(GLAutoDrawable graphics) {
    }
    public void reshape(GLAutoDrawable graphics, int x, int y, int width, int height) {
    }

}