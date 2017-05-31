package persona.moderatore;

import persona.moderatore.model.Moderatore;
import persona.moderatore.model.Moderatore;
// import persona.moderatore.controller.ModeratoreController;
import persona.moderatore.controller.JDBCModeratoreController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class ModeratoreView {

  public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public ModeratoreView() {}

  public void show() throws IOException {
    System.out.println("This is the moderator view");
    String moderator = reader.readLine();
  }

}
