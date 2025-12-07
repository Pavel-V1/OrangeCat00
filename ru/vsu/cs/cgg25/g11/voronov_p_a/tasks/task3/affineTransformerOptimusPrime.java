package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

import javax.vecmath.Matrix3f;
import javax.vecmath.Vector3f;

public class affineTransformerOptimusPrime {
    //

    public void scale(Model model, float x, float y, float z) {
        Matrix3f m3f = new Matrix3f(x, 0, 0, 0, y, 0, 0, 0, z);
        for (Vector3f v3f : model.vertices) {
            v3f = v3f.;
        }
    }

    public void transport(Model model, float x, float y, float z) {
        //
    }

    public void rotate(Model model, float x, float y, float z) {
        //
    }
}
