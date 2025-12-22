package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

public class AffineMatrices {
  
  public static Matrix4f getScaleMatrix(float x, float y, float z) {
    Matrix4f m4f = new Matrix4f(x, 0, 0, 0,
                                0, y, 0, 0,
                                0, 0, z, 0,
                                0, 0, 0, 1);
    return m4f;
  }

  public Matrix4d getXRotateMatrix(double a, double b, double g, boolean isRadians) {
    Matrix4d m4d = new Matrix4d(1, 0, 0, 0,
                                0, Math.cos(a), Math.sin(a), 0,
                                0, -Math.sin(a), Math.cos(a), 0,
                                0, 0, 0, 1);
    return m4d;
  }

  public Matrix4d getYRotateMatrix(double a, double b, double g, boolean isRad) {
    Matrix4d m4d = new Matrix4d(Math.cos(b), 0, Math.sin(b), 0,
                                          0, 1, 0, 0,
                               -Math.sin(b), 0, Math.cos(b), 0,
                                          0, 0, 0, 1);
    return m4d;
  }

  public Matrix4d getZRotateMatrix(double a, double b, double g, boolean isRad) {
    Matrix4d m4d = new Matrix4d(Math.cos(g), Math.sin(g), 0, 0,
                               -Math.sin(g), Math.cos(g), 0, 0,
                                                    0, 0, 1, 0,
                                                    0, 0, 0, 1);
    return m4d;
  }

  public static Matrix4d getRotateMatrix(double alfa, double beta, double gamma, boolean isRad) {
    double a;
    double b;
    double g;
    if (!isRad) {
      a = Math.toRadians(alfa);
      b = Math.toRadians(beta);
      g = Math.toRadians(gamma);
    } else {
      a = alfa;
      b = beta;
      g = gamma;
    }
    Matrix4d m4d = (Matrix4d) getXRotateMatrix(a, b, g, isRad).clone();
    m4d.mul(getYRotateMatrix(a, b, g, isRad);
    m4d.mul(getXRotateMatrix(a, b, g, isRad);
    return m4d;
  }

  public static Matrix4f getTransportMatrix(float x, float y, float z) {
    Matrix4f m4f = new Matrix4f(1, 0, 0, x,
                                0, 1, 0, y,
                                0, 0, 1, z,
                                0, 0, 0, 1);
    return m4f;
  }

  public static Matrix4d getAllMatrix(float sx, float sy, float sz,
                               double alfa, double beta, double gamma,
                               boolean isRadians, float tx, float ty, float tz) {
    Matrix4d m4d = (Matrix4d) getTransportMatrix(tx, ty, tz).clone();
    m4d.mul(getRotateMatrix(alfa, beta, gamma, isRadians));
    m4d.mul(getScaleMatrix(sx, sy, sz);
    return m4d;
  }
}
