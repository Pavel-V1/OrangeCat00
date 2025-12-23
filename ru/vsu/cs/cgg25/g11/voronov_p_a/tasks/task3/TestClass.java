package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

import org.junit.jupiter.api.Test;

import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {
    @Test
    public void testScale() {
        Model model = new Model();
        model.vertices.add(new Vector3f(2, 3, 5));
        model.vertices.add(new Vector3f(1, 0, 1));
        AffineTransformerOptimusPrime ato = new AffineTransformerOptimusPrime();
        ato.scaleX(model, 2);
        assertEquals(new Vector3f(4, 3, 5), model.vertices.get(0));
        assertEquals(new Vector3f(2, 0, 1), model.vertices.get(1));
        ato.scale(model, 2, -1, -2, 1);
        assertEquals(new Vector3f(8, -3, -10), model.vertices.get(0));
        assertEquals(new Vector3f(4, 0, -2), model.vertices.get(1));
    }

    @Test
    public void testRotate() {
        Model model = new Model();
        model.vertices.add(new Vector3f(1, 1, 1));
        model.vertices.add(new Vector3f(2, 5, 4));
        AffineTransformerOptimusPrime atop = new AffineTransformerOptimusPrime();
        atop.rotateByX(model, 90, false);
        assertEquals(new Vector3f(1, -1, 1), model.vertices.get(0));
        assertEquals(new Vector3f(2, -4, 5), model.vertices.get(1));
        atop.rotateByY(model, Math.PI / 2, true);
        assertEquals(new Vector3f(1, -1, -1), model.vertices.get(0));
        assertEquals(new Vector3f(5, -4, -2), model.vertices.get(1));
        atop.rotate(model, new Vector4f(90, 90, 0, 1), false);
    }

    @Test
    public void testTransport() {
        Model model = new Model();
        model.vertices.add(new Vector3f(4, 3,3));
        model.vertices.add(new Vector3f(3, 5, 7));
        AffineTransformerOptimusPrime op = new AffineTransformerOptimusPrime();
        op.transportX(model, 3);
        assertEquals(new Vector3f(7, 3, 3), model.vertices.get(0));
        assertEquals(new Vector3f(6, 5, 7), model.vertices.get(1));
        op.transportY(model, 0.5F);
        assertEquals(new Vector3f(7, 3.5F, 3), model.vertices.get(0));
        assertEquals(new Vector3f(6, 5.5F, 7), model.vertices.get(1));
        op.transport(model, -4, 2.2F, 0, 1);
        assertEquals(new Vector3f(3, 5.7F, 3), model.vertices.get(0));
        assertEquals(new Vector3f(2, 7.7F, 7), model.vertices.get(1));
    }

    @Test
    public void testConveyor() {
        Model model = new Model();
        model.vertices.add(new Vector3f(1, 1, 1));
        model.vertices.add(new Vector3f(-1, 0, 3));
        AffineTransformerOptimusPrime trs = new AffineTransformerOptimusPrime();
        trs.conveyor(model, 3, 0, -1, 90, 0, 90, false, 0, 3, 7, 1);
        Model model2 = new Model();
        model2.vertices.add(model.vertices.get(0));
        model2.vertices.add(model.vertices.get(1));
        trs.scale(model2, 3, 0, -1, 1);
        trs.rotate(model2, 90, 0, 90, false, 1);
        trs.transport(model2, 0, 3, 7, 1);
        assertEquals(model.vertices.get(0), model2.vertices.get(0));
        assertEquals(model.vertices.get(1), model2.vertices.get(1));
//        System.out.println(model.vertices.get(0));
//        System.out.println(model.vertices.get(1));
//        System.out.println(Math.sin(Math.toRadians(90)));
//        System.out.println(Math.cos(Math.toRadians(90)));
//        System.out.println(Math.sin(Math.toRadians(0)));
//        System.out.println(Math.cos(Math.toRadians(0)));
    }
}