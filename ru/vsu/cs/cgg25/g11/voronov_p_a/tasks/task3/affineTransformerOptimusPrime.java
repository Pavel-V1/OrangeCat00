package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

import javax.vecmath.Matrix3d;
import javax.vecmath.Matrix3f;
import javax.vecmath.Matrix4f;
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

    public void scale(Model model, Vector3f v3f) {
        scale(model, v3f.x, v3f.y, v3f.z);
    }

    public void scale(Model model, float x, float y, float z) {
        Matrix3f m3f = new Matrix3f(x, 0, 0,
                                    0, y, 0,
                                    0, 0, z);
        for (Vector3f v3f : model.vertices) {
            Matrix3f copyM = (Matrix3f) m3f.clone();
            Matrix3f v3fMatrix = new Matrix3f(v3f.x, 0, 0,
                                              v3f.y, 0, 0,
                                              v3f.z, 0, 0);
            copyM.mul(v3fMatrix);
            v3f.set(copyM.m00, copyM.m10, copyM.m20);
        }
    }

    public void rotateByX(Model model, double alfa, boolean isRadians) {
        rotate(model, alfa, 0, 0, isRadians);
    }

    public void rotateByY(Model model, double beta, boolean isRadians) {
        rotate(model, 0, beta, 0, isRadians);
    }

    public void rotateByZ(Model model, double gamma, boolean isRadians) {
        rotate(model, 0, 0, gamma, isRadians);
    }

    public void rotate(Model model, Vector3f v3f, boolean isRadians) {
        double alfa = v3f.x;
        double beta = v3f.y;
        double gamma = v3f.z;
        rotate(model, alfa, beta, gamma, isRadians);
    }

    public void rotate(Model model, double alfa, double beta, double gamma, boolean isRadians) {
        double a;
        double b;
        double g;
        if (!isRadians) {
            a = Math.toRadians(alfa);
            b = Math.toRadians(beta);
            g = Math.toRadians(gamma);
        } else {
            a = alfa;
            b = beta;
            g = gamma;
        }
        Matrix3d rotMatrix = new Matrix3d(1, 0, 0,
                                          0, Math.cos(a), Math.sin(a),
                                          0, -Math.sin(a), Math.cos(a));

        Matrix3d yRotMatrix = new Matrix3d(Math.cos(b), 0, Math.sin(b),
                                                0, 1, 0,
                                           -Math.sin(b), 0, Math.cos(b));

        Matrix3d zRotMatrix = new Matrix3d(Math.cos(g), Math.sin(g), 0,
                                           -Math.sin(g), Math.cos(g), 0,
                                                      0, 0, 1);
        rotMatrix.mul(yRotMatrix);
        rotMatrix.mul(zRotMatrix);
        for (Vector3f v3f : model.vertices) {
            Matrix3d v3fM = new Matrix3d(v3f.x, 0, 0,
                                         v3f.y, 0, 0,
                                         v3f.z, 0, 0);
            Matrix3d copyM = (Matrix3d) rotMatrix.clone();
            copyM.mul(v3fM);
            v3f.set((float) copyM.m00, (float) copyM.m10, (float) copyM.m20);
        }
    }

    public void transportX(Model model, float x) {
        transport(model, x, 0, 0);
    }

    public void transportY(Model model, float y) {
        transport(model, 0, y, 0);
    }

    public void transportZ(Model model, float z) {
        transport(model, 0, 0, z);
    }

    public void transport(Model model, Vector3f v3f) {
        transport(model, v3f.x, v3f.y, v3f.z);
    }

    public void transport(Model model, float x, float y, float z) {
        Matrix4f m4f = new Matrix4f(1, 0, 0, x,
                                    0, 1, 0, y,
                                    0, 0, 1, z,
                                    0, 0, 0, 1);
        for (Vector3f v3f : model.vertices) {
            Matrix4f vm4f = new Matrix4f(v3f.x, 0, 0, 0,
                                         v3f.y, 0, 0, 0,
                                         v3f.z, 0, 0, 0,
                                        1, 0, 0, 0);
            Matrix4f copyM = (Matrix4f) m4f.clone();
            copyM.mul(vm4f);
            v3f.set(copyM.m00, copyM.m10, copyM.m20);
        }
    }
}
