package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

import ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3.AffineMatricesVecCol.*;

import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class AffineTransformerOptimusPrime {

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
                                              w, 0, 0, 0
            );
            copyM.mul(v4fMatrix);
            v3f.set(copyM.m00, copyM.m10, copyM.m20);
        }
    }

    public void rotateByX(Model model, double alfa, boolean isRadians) {
        rotate(model, alfa, 0, 0, isRadians, 1);
    }

    public void rotateByY(Model model, double beta, boolean isRadians) {
        rotate(model, 0, beta, 0, isRadians, 1);
    }

    public void rotateByZ(Model model, double gamma, boolean isRadians) {
        rotate(model, 0, 0, gamma, isRadians, 1);
    }

    public void rotate(Model model, Vector4f v4f, boolean isRadians) {
        rotate(model, v4f.x, v4f.y, v4f.z, isRadians, v4f.w);
    }

    public void rotate(Model model, double alfa, double beta, double gamma, boolean isRadians, float w) {
        Matrix4f rotMatrix = isRadians ? AffineMatricesVecCol.getRotateMatrixRadians(alfa, beta, gamma)
                                        : AffineMatricesVecCol.getRotateMatrixDegrees(alfa, beta, gamma);
        for (Vector3f v3f : model.vertices) {
            Matrix4f m4f = new Matrix4f(v3f.x, 0, 0, 0,
                                        v3f.y, 0, 0, 0,
                                        v3f.z, 0, 0, 0,
                                        w, 0, 0, 0
            );
            Matrix4f copyM = (Matrix4f) rotMatrix.clone();
            copyM.mul(m4f);
            v3f.set(copyM.m00, copyM.m10, copyM.m20);
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
            Matrix4f mv4f = new Matrix4f(v3f.x, 0, 0, 0,
                                         v3f.y, 0, 0, 0,
                                         v3f.z, 0, 0, 0,
                                         w, 0, 0, 0
            );
            Matrix4f copyM = (Matrix4f) m4f.clone();
            copyM.mul(mv4f);
            v3f.set(copyM.m00, copyM.m10, copyM.m20);
        }
    }

    public void conveyor(Model model, float sx, float sy, float sz,
                         float alfa, float beta, float gamma, boolean isRadians,
                         float tx, float ty, float tz, float w) {
        Matrix4f allMatrix = AffineMatricesVecCol.getAllMatrix(sx, sy, sz,
                                                               alfa, beta, gamma,
                                                               isRadians, tx, ty, tz);
        for (Vector3f v3f : model.vertices) {
            Matrix4f copyM = (Matrix4f) allMatrix.clone();
            Matrix4f m4f = new Matrix4f(v3f.x, 0, 0, 0,
                                        v3f.y, 0, 0, 0,
                                        v3f.z, 0, 0, 0,
                                        w, 0, 0, 0
            );
            copyM.mul(m4f);
            v3f.set(copyM.m00, copyM.m10, copyM.m20);
        }
    }
}
