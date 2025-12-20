package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

import org.junit.jupiter.api.Test;

import javax.vecmath.Vector3f;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {
    @Test
    public void testScale() {
        Model model = new Model();
        model.vertices.add(new Vector3f(2, 3, 5));
        affineTransformerOptimusPrime ato = new affineTransformerOptimusPrime();
        ato.scaleX(model, 2);
        assertEquals(new Vector3f(4, 3, 5), model.vertices.get(0));
    }
}
