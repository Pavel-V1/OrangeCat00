package ru.vsu.cs.cgg25.g11.voronov_p_a.tasks.task3;

public class AffineMatrices {
  
  public Matrix4f getScaleMatrix() {
    Matrix4f m4f = new Matrix4f(x, 0, 0, 0,
                                0, y, 0, 0,
                                0, 0, z, 0,
                                0, 0, 0, 1);
    return m4f;
  }

  public Matrix4d getXRotateMatrix() {
    Matrix4d m4d = new Matrix4d(1, 0, 0, 0,
                                0, Math.cos(a), Math.sin(a), 0,
                                0, -Math.sin(a), Math.cos(a), 0,
                                0, 0, 0, 1);
    return m4d;
  }

  public Matrix4d getYRotateMatrix() {
    Matrix4d m4d = new Matrix4d(Math.cos(b), 0, Math.sin(b), 0,
                                          0, 1, 0, 0,
                               -Math.sin(b), 0, Math.cos(b), 0,
                                          0, 0, 0, 1);
    return m4d;
  }

  public Matrix4d getZRotateMatrix() {
    Matrix4d m4d = new Matrix4d(Math.cos(g), Math.sin(g), 0, 0,
                               -Math.sin(g), Math.cos(g), 0, 0,
                                                    0, 0, 1, 0,
                                                    0, 0, 0, 1);
    return m4d;
  }

  public Matrix4f getTransportMatrix() {
    Matrix4f m4f = new Matrix4f(1, 0, 0, x,
                                0, 1, 0, y,
                                0, 0, 1, z,
                                0, 0, 0, 1);
    return m4f;
  }
}
