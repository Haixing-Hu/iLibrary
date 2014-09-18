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

package com.github.haixing_hu.ilibrary.gui;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.edit.EditAction;
import com.github.haixing_hu.ilibrary.action.file.FileAction;
import com.github.haixing_hu.ilibrary.action.help.HelpAction;
import com.github.haixing_hu.ilibrary.action.library.LibraryAction;
import com.github.haixing_hu.ilibrary.action.share.ShareAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;
import com.github.haixing_hu.ilibrary.action.window.WindowAction;
import com.github.haixing_hu.swt.menu.MenuManagerEx;

/**
 * The main menu bar of the application.
 *
 * @author Haixing Hu
 */
public final class MainMenuBar extends MenuManagerEx {

  private final Application application;

  /**
   * Constructs a menu bar.
   *
   * @param application
   *    the application the new menu bar belongs.
   */
  public MainMenuBar(Application application) {
    super(false);
    this.application = application;
    final ActionManager am = application.getActionManager();
    this.add(am.get(FileAction.KEY));
    this.add(am.get(EditAction.KEY));
    this.add(am.get(ViewAction.KEY));
    this.add(am.get(LibraryAction.KEY));
    this.add(am.get(ShareAction.KEY));
    this.add(am.get(WindowAction.KEY));
    this.add(am.get(HelpAction.KEY));
  }

  /**
   * Gets the application this menu belongs to.
   *
   * @return the application this menu belongs to.
   */
  public Application getApplication() {
    return application;
  }
}
