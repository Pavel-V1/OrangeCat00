package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

import javax.vecmath.*;
import ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3.AffineMatricesVecCol.*;

public class affineTransformerOptimusPrime {

    public void scaleX(Model model, float x) {
        scale(model, x, 1, 1, 1);
    }

    public void scaleY(Model model, float y) {
        scale(model, 1, y, 1, 1);
    }

    public void scaleZ(Model model, float z) {
        scale(model, 1, 1, z, 1);
    }

    public void scale(Model model, Vector4f v4f) {
        scale(model, v4f.x, v4f.y, v4f.z, v4f.w);
    }

    public void scale(Model model, float x, float y, float z, float w) {
        Matrix4f m4f = AffineMatricesVecCol.getScaleMatrix(x, y, z);
        for (Vector3f v3f : model.vertices) {
            Matrix4f copyM = (Matrix4f) m4f.clone();
            Matrix4f v4fMatrix = new Matrix4f(v3f.x, 0, 0, 0,
                                              v3f.y, 0, 0, 0,
                                              v3f.z, 0, 0, 0,
                                                  w, 0, 0, 0);
            copyM.mul(v4fMatrix);
            v3f.set(copyM.m00, copyM.m10, copyM.m20);
        }
    }

    public void rotateByX(Model model, double alfa, boolean isRadians) {
        rotate(model, alfa, 0, 0, 1, isRadians);
    }

    public void rotateByY(Model model, double beta, boolean isRadians) {
        rotate(model, 0, beta, 0, 1, isRadians);
    }

    public void rotateByZ(Model model, double gamma, boolean isRadians) {
        rotate(model, 0, 0, gamma, 1, isRadians);
    }

    public void rotate(Model model, Vector4f v4f, boolean isRadians) {
        rotate(model, v4f.x, v4f.y, v4f.z, v4f.w, isRadians);
    }

    public void rotate(Model model, double alfa, double beta, double gamma, float w, boolean isRadians) {
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
        Matrix4d rotMatrix = AffineMatricesVecCol.getRotateMatrix(a, b, g, isRadians);
        for (Vector3f v3f : model.vertices) {
            Matrix4d v4fM = new Matrix4d(v3f.x, 0, 0, 0,
                                         v3f.y, 0, 0, 0,
                                         v3f.z, 0, 0, 0,
                                             w, 0, 0, 0);
            Matrix4d copyM = (Matrix4d) rotMatrix.clone();
            copyM.mul(v4fM);
            v3f.set((float) copyM.m00, (float) copyM.m10, (float) copyM.m20);
        }
    }

    public void transportX(Model model, float x) {
        transport(model, x, 0, 0, 1);
    }

    public void transportY(Model model, float y) {
        transport(model, 0, y, 0, 1);
    }

    public void transportZ(Model model, float z) {
        transport(model, 0, 0, z, 1);
    }

    public void transport(Model model, Vector4f v4f) {
        transport(model, v4f.x, v4f.y, v4f.z, v4f.w);
    }

    public void transport(Model model, float x, float y, float z, float w) {
        Matrix4f m4f = AffineMatricesVecCol.getTransportMatrix(x, y, z);
        for (Vector3f v3f : model.vertices) {
            Matrix4f vm4f = new Matrix4f(v3f.x, 0, 0, 0,
                                         v3f.y, 0, 0, 0,
                                         v3f.z, 0, 0, 0,
                                             w, 0, 0, 0);
            Matrix4f copyM = (Matrix4f) m4f.clone();
            copyM.mul(vm4f);
            v3f.set(copyM.m00, copyM.m10, copyM.m20);
        }
    }

    public void conveyor(Model model, float sx, float sy, float sz,
                         float alfa, float beta, float gamma, boolean isRadians,
                         float tx, float ty, float tz, float w) {
        Matrix4d allMatrix = AffineMatricesVecCol.getAllMatrix(sx, sy, sz,
                                                               alfa, beta, gamma,
                                                               isRadians, tx, ty, tz);
        for (Vector3f v3f : model.vertices) {
            Matrix4d copyM = (Matrix4d) allMatrix.clone();
            Matrix4d m4d = new Matrix4d(v3f.x, 0, 0, 0,
                                        v3f.y, 0, 0, 0,
                                        v3f.z, 0, 0, 0,
                                            w, 0, 0, 0);
            copyM.mul(m4d);
            v3f.set(copyM.m00, copyM.m10, copyM.m20);
    }
}
