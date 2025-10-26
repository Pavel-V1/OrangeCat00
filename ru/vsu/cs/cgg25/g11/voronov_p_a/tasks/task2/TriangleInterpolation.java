package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task2;

import java.awt.*;

public class TriangleInterpolation {
    public void Interpolation(Point p1, Point p2, Point p3) {
        double x_1 = p1.x;
        double y_1 = p1.y;
        double x_2 = p2.x;
        double y_2 = p2.y;
        double x_3 = p3.x;
        double y_3 = p3.y;


//        sort triangle vertices by y :
//        ( x_0 , y_0 ) // - top vertex
//        ( x_1 , y_1 ) // - middle vertex
//        ( x_2 , y_2 ) // - bottom vertex
//
//        calculate line equations
//
//        for ( y from y_0 to y_1 )
//        calculate x_left , x_right with y from line equations
//        for ( x from x_left to x_right )
//        put_pixel (x , y) ;
//
//        for ( y from y_1 to y_2 )
//        calculate x_left , x_right with y from line equations
//        for ( x from x_left to x_right )
//        put_pixel (x , y) ;
    }
}