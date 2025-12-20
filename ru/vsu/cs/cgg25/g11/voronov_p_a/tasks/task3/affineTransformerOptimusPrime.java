package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

import javax.vecmath.Matrix3f;
import javax.vecmath.Vector3f;

public class affineTransformerOptimusPrime {
    //

    public void scaleX(Model model, float x) {
        scale(model, x, 1, 1);
    }

    public void scaleY(Model model, float y) {
        scale(model, 1, y, 1);
    }

    public void scaleZ(Model model, float z) {
        scale(model, 1, 1, z);
    }

    public void scale(Model model, float x, float y, float z) {
        Matrix3f m3f = new Matrix3f(x, 0, 0, 0, y, 0, 0, 0, z);
        for (Vector3f v3f : model.vertices) {
            Matrix3f v3fMatrix = new Matrix3f(v3f.x, 0, 0, v3f.y, 0, 0, v3f.z, 0, 0);
            m3f.mul(v3fMatrix);
            v3fMatrix = m3f;
            v3f.set(v3fMatrix.m00, v3fMatrix.m10, v3fMatrix.m20);
        }
    }

    public void transport(Model model, float x, float y, float z) {
        //
    }

    public void rotate(Model model, float x, float y, float z) {
        //
    }
}
