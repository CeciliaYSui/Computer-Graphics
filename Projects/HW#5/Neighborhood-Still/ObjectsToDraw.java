/* --------------------------------------------------------------------------
 * 
 * Author -------------- Cecilia Y. Sui 
 * Assignment ---------- 3D House
 * Course -------------- Computer Graphics
 * Instructor ---------- Dr. Crawley 
 * Date of Submission -- November 2, 2019
 * Language Used ------- Java & OpenGL
 * Description --------- Storage of vertices and faces data 
 * 
--------------------------------------------------------------------------- */


public class ObjectsToDraw {
    // ----------------------------------------------------------------------------
    // Initialization
    // ----------------------------------------------------------------------------
    public double[][] vertices;
    public int[][] faces;
   
    // ----------------------------------------------------------------------------
    // Constructor 
    // ----------------------------------------------------------------------------
    public ObjectsToDraw(double[][] vertices, int[][] faces) {
        this.vertices = vertices;
        this.faces = faces;
    }
    

    // ----------------------------------------------------------------------------
    // Neighborhood Plane 
    // ----------------------------------------------------------------------------
    public static ObjectsToDraw plane = new ObjectsToDraw(
        new double[][] {
            {-20,-0.001,15},{20,-0.001,15},{20,-0.001,-18},{-20,-0.001,-18},
            {-20,-0.3,15},{20,-0.3,15},{20,-0.3,-18},{-20,-0.3,-18}
        }, 
        new int[][] {
            {0,2,1},{0,3,2},{4,1,5},{4,0,1},{1,6,5},{1,2,6},
            {2,7,6},{2,3,7},{4,3,0},{4,7,3},{5,7,4},{5,6,7}
        }
    ); 

    // ----------------------------------------------------------------------------
    // Neighborhood Road 
    // ----------------------------------------------------------------------------
    public static ObjectsToDraw road = new ObjectsToDraw(
        new double[][] {
            {-20,0.001,-1},{20,0.001,-1},{20,0.001,-2},{-20,0.001,-2},
            {-20,0,-1},{20,0,-1},{20,0,-2},{-20,0,-2}
        }, 
        new int[][] {
            {0,2,1},{0,3,2},{4,1,5},{4,0,1},{1,6,5},{1,2,6},
            {2,7,6},{2,3,7},{4,3,0},{4,7,3},{5,7,4},{5,6,7}
        }
    ); 

    // ----------------------------------------------------------------------------
    // house#1  
    // ----------------------------------------------------------------------------
    public static ObjectsToDraw house1_lower = new ObjectsToDraw(
        new double[][] {
            {0,0,0}, {1.3,0,0}, {0,1,0}, {1.3,1,0}, 
            {1.3,0,1}, {0,0,1}, {0,1,1}, {1.3,1,1}
        }, 
        new int[][] {
            {0,1,2},{3,2,1},{1,4,3},{7,3,4},{4,5,7},{6,7,5},{5,0,6},{2,6,0},{2,3,6},{7,6,3},{1,0,4},{5,4,0}
        }
    ); 

    public static ObjectsToDraw house1_upper = new ObjectsToDraw(
        new double[][] {
            {0,1.1,0}, {1.3,1.1,0}, {0,2.1,0}, {1.3,2.1,0}, 
            {1.3,1.1,1}, {0,1.1,1}, {0,2.1,1}, {1.3,2.1,1}
        }, 
        new int[][]{
            {0,1,2},{3,2,1},{1,4,3},{7,3,4},{4,5,7},{6,7,5},{5,0,6},{2,6,0},{2,3,6},{7,6,3},{1,0,4},{5,4,0}
        }
    ); 

    public static ObjectsToDraw house1_door = new ObjectsToDraw(
        new double[][]{
            {0.85,0,-0.05},{0.45,0,-0.05},{0.45,0.5,-0.05},{0.85,0.5,-0.05}, 
            {0.85,0,0},{0.45,0,0},{0.45,0.5,0},{0.85,0.5,0}
        }, 
        new int[][]{
            {0,1,2},{3,2,1},{1,4,3},{7,3,4},{4,5,7},{6,7,5},{5,0,6},{2,6,0},{2,3,6},{7,6,3},{1,0,4},{5,4,0}
        }
    ); 

    public static ObjectsToDraw house1_floor1 = new ObjectsToDraw(
        new double[][] {
            {-0.1,1,-0.1}, {1.4,1,-0.1},{-0.1,1.1,-0.1}, {1.4,1.1,-0.1},
            {1.4,1,1.1}, {-0.1,1,1.1}, {-0.1,1.1,1.1}, {1.4,1.1,1.1} 
        }, 
        new int[][]  {
            {0,1,2},{3,2,1},{1,4,3},{7,3,4},{4,5,7},{6,7,5},{5,0,6},{2,6,0},{2,3,6},{7,6,3},{1,0,4},{5,4,0}
        }
    ); 

    public static ObjectsToDraw house1_floor2 = new ObjectsToDraw(
        new double[][] {
            {-0.1,2.1,-0.1}, {1.4,2.1,-0.1},{-0.1,2.2,-0.1}, {1.4,2.2,-0.1},
            {1.4,2.1,1.1}, {-0.1,2.1,1.1}, {-0.1,2.2,1.1}, {1.4,2.2,1.1} 
        }, 
        new int[][] {
            {0,1,2},{3,2,1},{1,4,3},{7,3,4},{4,5,7},{6,7,5},{5,0,6},{2,6,0},{2,3,6},{7,6,3},{1,0,4},{5,4,0}
        }
    ); 


    public static ObjectsToDraw house2_roof = new ObjectsToDraw(
        new double[][]{
            {0,2,-5}, {2,2,-5}, {2,2,-3}, {0,2,-3}, {1,3,-4}
        }, 
        new int[][] {
            {4,0,1}, {4,1,2}, {4,2,3}, {4,3,0}
        }
    ); 

    public static ObjectsToDraw house2_base = new ObjectsToDraw(
        new double[][] {
            {0,0,-5}, {2,0,-5}, {0,2,-5}, {2,2,-5},
            {2,0,-3}, {0,0,-3}, {0,2,-3}, {2,2,-3}  
        }, 
        new int[][] {
            {0,1,2},{3,2,1},{1,4,3},{7,3,4},{4,5,7},{6,7,5},{5,0,6},{2,6,0},{2,3,6},{7,6,3},{1,0,4},{5,4,0}
        }
    ); 

    public static ObjectsToDraw house2_door = new ObjectsToDraw(
        new double[][] {
            {0.7,0,-5.1}, {1.3,0,-5.1}, {0.7,1,-5.1}, {1.3,1,-5.1},
            {1.3,0,-5}, {0.7,0,-5}, {0.7,1,-5}, {1.3,1,-5}    
        }, 
        new int[][] {
            {0,1,2},{3,2,1},{1,4,3},{7,3,4},{4,5,7},{6,7,5},{5,0,6},{2,6,0},{2,3,6},{7,6,3},{1,0,4},{5,4,0}
        }
    ); 



    // gate to community 
    public static ObjectsToDraw gate_bottom = new ObjectsToDraw(
        new double[][]{
            {2,5,2},{0,5,2},{0,5,0},{2,5,0}, 
            {2,0,2},{0,0,2},{0,0,0},{2,0,0}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7}
        }
    ); 

    public static ObjectsToDraw gate_top = new ObjectsToDraw(
        new double[][]{
            {7,8,2},{0,8,2},{0,8,0},{7,8,0},
            {7,5,2},{0,5,2},{0,5,0},{7,5,0}
        }, 
        new int[][] {
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7}
        }
    ); 

    public static ObjectsToDraw gate_side1 = new ObjectsToDraw(
        new double[][]{
            {0,8,0},{-1.5,6.5,0},{-3,5,0},{0,5,0},
            {0,8,2},{-1.5,6.5,2},{-3,5,2},{0,5,2}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 

    public static ObjectsToDraw gate_side2 = new ObjectsToDraw(
        new double[][]{
            {8.5,6.5,0},{7,8,0},{7,5,0},{10,5,0},
            {8.5,6.5,2},{7,8,2},{7,5,2},{10,5,2}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 



    public static ObjectsToDraw floor1 = new ObjectsToDraw(
        new double[][] {
            {3.1,0,3.1},{-3.1,0,3.1},{-3.1,0,-3.1},{3.1,0,-3.1},
            {3.1,-0.1,3.1},{-3.1,-0.1,3.1},{-3.1,-0.1,-3.1},{3.1,-0.1,-3.1}
        }, 
        new int[][]  {
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7}
        }
    ); 


    public static ObjectsToDraw tabletop = new ObjectsToDraw(
        new double[][] {
            {1.5,1.0,0.8},{-1.5,1.0,0.8},{-1.5,1.0,-0.8},{1.5,1.0,-0.8},
            {1.5,0.9,0.8},{-1.5,0.9,0.8},{-1.5,0.9,-0.8},{1.5,0.9,-0.8}
        },
        new int[][] {
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    );

    public static ObjectsToDraw leg1 = new ObjectsToDraw(
        new double[][]{
            {-1.3,0.9,-0.6},{-1.5,0.9,-0.6},{-1.5,0.9,-0.8},{-1.3,0.9,-0.8},
            {-1.3,0,-0.6},{-1.5,0,-0.6},{-1.5,0,-0.8},{-1.3,0,-0.8}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 

    public static ObjectsToDraw leg2 = new ObjectsToDraw(
        new double[][]{
            {-1.3,0.9,0.8},{-1.5,0.9,0.8},{-1.5,0.9,0.6},{-1.3,0.9,0.6},
            {-1.3,0,0.8},{-1.5,0,0.8},{-1.5,0,0.6},{-1.3,0,0.6}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 

    public static ObjectsToDraw leg3 = new ObjectsToDraw(
        new double[][]{
            {1.5,0.9,-0.6},{1.3,0.9,-0.6},{1.3,0.9,-0.8},{1.5,0.9,-0.8},
            {1.5,0,-0.6},{1.3,0,-0.6},{1.3,0,-0.8},{1.5,0,-0.8}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 

    public static ObjectsToDraw leg4 = new ObjectsToDraw(
        new double[][]{
            {1.5,0.9,0.8},{1.3,0.9,0.8},{1.3,0.9,0.6},{1.5,0.9,0.6},
            {1.5,0,0.8},{1.3,0,0.8},{1.3,0,0.6},{1.5,0,0.6}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 


    public static ObjectsToDraw wall1 = new ObjectsToDraw(
        new double[][] {
            {-1.8,3,2.9},{-2.9,3,2.9},{-2.9,3,2.7},{-1.8,3,2.7},
            {-1.8,0,2.9},{-2.9,0,2.9},{-2.9,0,2.7},{-1.8,0,2.7}
        }, 
        new int[][] {
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 

    public static ObjectsToDraw wall2 = new ObjectsToDraw(
        new double[][] {
            {2.9,3,2.9},{1.8,3,2.9},{1.8,3,2.7},{2.9,3,2.7},
            {2.9,0,2.9},{1.8,0,2.9},{1.8,0,2.7},{2.9,0,2.7}
        }, 
        new int[][] {
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 

    public static ObjectsToDraw wall3 = new ObjectsToDraw(
        new double[][]{
            {1.8,0.7,2.9},{-1.8,0.7,2.9},{-1.8,0.7,2.7},{1.8,0.7,2.7},
            {1.8,0,2.9},{-1.8,0,2.9},{-1.8,0,2.7},{1.8,0,2.7}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7}
        }
    ); 

    public static ObjectsToDraw wall4 = new ObjectsToDraw(
        new double[][]{
            {1.8,3,2.9},{-1.8,3,2.9},{-1.8,3,2.7},{1.8,3,2.7},
            {1.8,2.3,2.9},{-1.8,2.3,2.9},{-1.8,2.3,2.7},{1.8,2.3,2.7}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7}
        }
    ); 


    public static ObjectsToDraw wall5 = new ObjectsToDraw(
        new double[][]{
            {0.5,2.3,2.9},{-0.5,2.3,2.9},{-0.5,2.3,2.7},{0.5,2.3,2.7}, 
            {0.5,0.7,2.9},{-0.5,0.7,2.9},{-0.5,0.7,2.7},{0.5,0.7,2.7}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 


    public static ObjectsToDraw sidewall = new ObjectsToDraw(
        new double[][]{
            {-2.9,3,2.7},{-2.9,3,-2.7},{-2.7,3,-2.7},{-2.7,3,2.7},
            {-2.9,0,2.7},{-2.9,0,-2.7},{-2.7,0,-2.7},{-2.7,0,2.7}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 

    public static ObjectsToDraw sidedoor = new ObjectsToDraw(
        new double[][]{
            {-3,1.5,0.6},{-3,1.5,-0.6},{-2.9,1.5,-0.6},{-2.9,1.5,0.6},
            {-3,0,0.6},{-3,0,-0.6},{-2.9,0,-0.6},{-2.9,0,0.6}
        }, 
        new int[][]{
            {0,1,4},{5,4,1},{2,3,6},{7,6,3},{3,2,0},{1,0,2},
            {2,6,1},{5,1,6},{7,3,4},{0,4,3},{6,7,5},{4,5,7} 
        }
    ); 
}