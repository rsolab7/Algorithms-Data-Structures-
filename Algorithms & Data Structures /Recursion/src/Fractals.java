
public class Fractals {

    // Draw a square, centered at (x, y), of the given side length
    public static void drawSquare(double x, double y, double size) {

        //draw the square
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledSquare(x, y, size/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, size/2);

    }

    // Draw a triangle, centered at (x, y), of the given side length
    public static void drawTriangle(double x, double y, double size) {

        // compute the coordinates of the 3 tips of the triangle
        double x0 = x;
        double x1=x-size;
        double x2=x+size;
        double y0=y + size;
        double y1 = y - size;
        double y2 = y - size;

        //create arrays for the x and y points
        double xArray[]={x0,x1,x2};
        double yArray[]={y0,y1,y2};

        //draw one triangle
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledPolygon(xArray, yArray);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.polygon(xArray, yArray);

    }

    // plot an order n recursive square, centered on (x, y), of the given side length
    public static void drawRecursiveSquare(int n, double x, double y, double size) {
        if (n == 0) return;
        drawSquare(x, y, size);

        // compute x- and y-coordinates of the 4 half-size squares
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;
        // recursively draw 4 half-size recursive squares of order n-1
        drawRecursiveSquare(n-1, x0, y0, size/2);    // lower left square
        drawRecursiveSquare(n-1, x0, y1, size/2);    // upper left square
        drawRecursiveSquare(n-1, x1, y0, size/2);    // lower right square
        drawRecursiveSquare(n-1, x1, y1, size/2);    // upper right square
    }

    // FIXME
    public static void drawRecursiveTriangle (int n, double x, double y, double size){
        if (n==0){
            return;
        }
        drawTriangle(x, y, size);

        // compute x- and y-coordinates of the 4 half-size squares
        double x0 = x - size/2; // left
        double x1 = x + size/2; //  right
        double y0 = y - size/2;   // down
        double y1 = y + size/2;   // Up


        drawRecursiveTriangle(n-1, x, y1, size/2);    // Upper right
        drawRecursiveTriangle(n-1, x0, y0, size/2);    // upper left
        drawRecursiveTriangle(n-1, x1, y0, size/2);    // lower center

    }


    public static void main(String[] args) {

        int N = 8;
        double x = 0.5, y = 0.5;   // center of the square
        double size = 0.5;         // side length of square
        //drawRecursiveSquare(N, x, y, size);
        drawRecursiveTriangle(N,x,y,size);
    }
}

