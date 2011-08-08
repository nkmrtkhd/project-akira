package tools.DelaunayTriangle.voxel;

/**
 * Voxel
 * <pre>
 * Voxel�̃C���^�[�t�F�C�X
 * </pre>
 * @author t.matsuoka
 * @version 0.1
 */
public interface Voxel {
  /**
   * �{�N�Z���i�q�f�[�^���擾
   *
   * @return
   */
  public double[][][] getVoxel();

  /**
   * �{�N�Z���W�J�����̃x�N�g�����擾
   *
   * @return
   */
  public double[] getVoxelVector();

  /**
   * �{�N�Z���i�q�̊�_���擾
   *
   * @return
   */
  public double[] getVoxelOrigin();
}
