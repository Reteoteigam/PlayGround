package coordinates.model;

import java.util.ArrayList;
import java.util.List;

public class Guild {
  private static final String DEFAULT_ID = "DEFAULT_ID";

  private static final String DEFAULT_NAME = "DEFAULT_NAME";

  private static final String DEFAULT_TAG = "DEFAULT_TAG";

  private String id;
  private String name;
  private String tag;
  private List<Player> ownPlayers;

  public Guild() {
    id = DEFAULT_ID;
    name = DEFAULT_NAME;
    tag = DEFAULT_TAG;
    ownPlayers = new ArrayList<Player>();
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

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public List<Player> getOwnPlayers() {
    return ownPlayers;
  }

  public void setOwnPlayers(List<Player> ownPlayers) {
    this.ownPlayers = ownPlayers;
  }

}
