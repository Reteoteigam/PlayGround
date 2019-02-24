package coordinates.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

  private static final String DEFAULT_NAME = "DEFAULT_NAME";

  private static final String DEFAULT_ID = "DEFAULT_ID";

  private String id;
  private String name;
  private List<Palace> ownPalace;

  public Player() {
    id = DEFAULT_ID;
    name = DEFAULT_NAME;
    ownPalace = new ArrayList<Palace>();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Palace> getOwnPalace() {
    return ownPalace;
  }

  public void setOwnPalace(List<Palace> ownPalace) {
    this.ownPalace = ownPalace;
  }

}