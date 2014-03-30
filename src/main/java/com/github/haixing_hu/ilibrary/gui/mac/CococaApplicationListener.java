/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui.mac;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.edit.PreferencesAction;
import com.github.haixing_hu.ilibrary.action.file.QuitAction;
import com.github.haixing_hu.ilibrary.action.help.AboutAction;

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
    about = new AboutAction(application, application.getActionManager());
    preferences = new PreferencesAction(application, application.getActionManager());
    quit = new QuitAction(application, application.getActionManager());
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
