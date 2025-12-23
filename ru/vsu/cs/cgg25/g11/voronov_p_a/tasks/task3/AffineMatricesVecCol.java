package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

import javax.vecmath.Matrix4f;

public class AffineMatricesVecCol {
  
    public static Matrix4f getScaleMatrix(float x, float y, float z) {
        return new Matrix4f(x, 0, 0, 0,
                            0, y, 0, 0,
                            0, 0, z, 0,
                            0, 0, 0, 1
        );
    }

    public static Matrix4f getRotateMatrixDegrees(double alfa, double beta, double gamma) {
        return getRotateMatrixRadians(Math.toRadians(alfa), Math.toRadians(beta), Math.toRadians(gamma));
    }

    public static Matrix4f getRotateMatrixRadians(double alfa, double beta, double gamma) {
        // правая система координат
        return new Matrix4f((float) (Math.cos(beta) * Math.cos(gamma)),
                            (float) (-Math.sin(gamma) * Math.cos(beta)),
                            (float) (Math.sin(beta)),
                            0,

                            (float) (Math.sin(alfa) * Math.sin(beta) * Math.cos(gamma) + Math.sin(gamma) * Math.cos(alfa)),
                            (float) (-Math.sin(alfa) * Math.sin(beta) * Math.sin(gamma) + Math.cos(alfa) * Math.cos(gamma)),
                            (float) (-Math.sin(alfa) * Math.cos(beta)),
                            0,

                            (float) (Math.sin(alfa) * Math.sin(gamma) - Math.sin(beta) * Math.cos(alfa) * Math.cos(gamma)),
                            (float) (Math.sin(alfa) * Math.cos(gamma) + Math.sin(beta) * Math.sin(gamma) * Math.cos(alfa)),
                            (float) (Math.cos(alfa) * Math.cos(beta)),
                            0,

                            0, 0, 0, 1
        );
    }

    public static Matrix4f getTransportMatrix(float x, float y, float z) {
        return new Matrix4f(1, 0, 0, x,
                            0, 1, 0, y,
                            0, 0, 1, z,
                            0, 0, 0, 1
        );
    }

    public static Matrix4f getAllMatrix(float sx, float sy, float sz,
                                        double alfa, double beta, double gamma,
                                        boolean isRadians, float tx, float ty, float tz) {

        Matrix4f m4f = (Matrix4f) getTransportMatrix(tx, ty, tz).clone();
        if (isRadians) {
            m4f.mul(getRotateMatrixRadians(alfa, beta, gamma));
        } else {
            m4f.mul(getRotateMatrixDegrees(alfa, beta, gamma));
        }
        m4f.mul(getScaleMatrix(sx, sy, sz));
        return m4f;
    }
}
