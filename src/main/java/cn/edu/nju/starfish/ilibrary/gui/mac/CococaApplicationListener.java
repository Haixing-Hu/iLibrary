/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.mac;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.edit.PreferencesAction;
import cn.edu.nju.starfish.ilibrary.action.file.QuitAction;
import cn.edu.nju.starfish.ilibrary.action.help.AboutAction;

/**
 * Default implementation of {@link NsApplicationListener} interface.
 *
 * @author Haixing Hu
 */
public class CococaApplicationListener implements NsApplicationListener {

  private final AboutAction about;
  private final PreferencesAction preferences;
  private final QuitAction quit;

  public CococaApplicationListener(Application application) {
    about = new AboutAction(application);
    preferences = new PreferencesAction(application);
    quit = new QuitAction(application);
  }

  @Override
  public void handleAbout(NsApplicationEvent event) {
    about.run();
    event.setHandled(true);
  }

  @Override
  public void handleOpenApplication(NsApplicationEvent event) {
    // TODO Auto-generated method stub
    event.setHandled(false);
  }

  @Override
  public void handleOpenFile(NsApplicationEvent event) {
    // TODO Auto-generated method stub
    event.setHandled(false);
  }

  @Override
  public void handlePreferences(NsApplicationEvent event) {
    preferences.run();
    event.setHandled(true);
  }

  @Override
  public void handlePrintFile(NsApplicationEvent event) {
    // TODO Auto-generated method stub
    event.setHandled(false);
  }

  @Override
  public void handleQuit(NsApplicationEvent event) {
    quit.run();
    event.setHandled(true);
  }

  @Override
  public void handleReOpenApplication(NsApplicationEvent event) {
    // TODO Auto-generated method stub
  }

}
