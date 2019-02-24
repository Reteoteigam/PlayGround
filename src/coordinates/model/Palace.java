package coordinates.model;

public class Palace {

  private static final String DEFAULT_ID = "DEFAULT_ID";
  private static final int DEFAULT_X = 0;
  private static final int DEFAULT_Y = 0;
  private static final int DEFAULT_Z = 0;
  private String id;
  private int x;
  private int y;
  private int z;

  public Palace() {
    id = DEFAULT_ID;
    x = DEFAULT_X;
    y = DEFAULT_Y;
    z = DEFAULT_Z;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getZ() {
    return z;
  }

  public void setZ(int z) {
    this.z = z;
  }

}