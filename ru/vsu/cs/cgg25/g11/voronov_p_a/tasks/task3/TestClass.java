package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

import org.junit.jupiter.api.Test;

import javax.vecmath.Vector3f;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {
    @Test
    public void testScale() {
        Model model = new Model();
        model.vertices.add(new Vector3f(2, 3, 5));
        model.vertices.add(new Vector3f(1, 0, 1));
        affineTransformerOptimusPrime ato = new affineTransformerOptimusPrime();
        ato.scaleX(model, 2);
        assertEquals(new Vector3f(4, 3, 5), model.vertices.get(0));
        assertEquals(new Vector3f(2, 0, 1), model.vertices.get(1));
        ato.scale(model, 2, -1, -2);
        assertEquals(new Vector3f(8, -3, -10), model.vertices.get(0));
        assertEquals(new Vector3f(4, 0, -2), model.vertices.get(1));
    }

    @Test
    public void testRotate() {
        Model model = new Model();
        model.vertices.add(new Vector3f(1, 1, 1));
        model.vertices.add(new Vector3f(2, 5, 4));
        affineTransformerOptimusPrime atop = new affineTransformerOptimusPrime();
        atop.rotateByX(model, 90, false);
        assertEquals(new Vector3f(1, 1, -1), model.vertices.get(0));
        assertEquals(new Vector3f(2, 4, -5), model.vertices.get(1));
        atop.rotateByY(model, Math.PI / 2, true);
        assertEquals(new Vector3f(-1, 1, -1), model.vertices.get(0));
        assertEquals(new Vector3f(-5, 4, -2), model.vertices.get(1));
    }

    @Test
    public void testTransport() {
        Model model = new Model();
        model.vertices.add(new Vector3f(4, 3,3));
        model.vertices.add(new Vector3f(3, 5, 7));
        affineTransformerOptimusPrime op = new affineTransformerOptimusPrime();
        op.transportX(model, 3);
        assertEquals(new Vector3f(7, 3, 3), model.vertices.get(0));
        assertEquals(new Vector3f(6, 5, 7), model.vertices.get(1));
        op.transportY(model, 0.5F);
        assertEquals(new Vector3f(7, 3.5F, 3), model.vertices.get(0));
        assertEquals(new Vector3f(6, 5.5F, 7), model.vertices.get(1));
        op.transport(model, -4, 2.2F, 0);
        assertEquals(new Vector3f(3, 5.7F, 3), model.vertices.get(0));
        assertEquals(new Vector3f(2, 7.7F, 7), model.vertices.get(1));
    }
}