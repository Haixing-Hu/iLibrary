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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.gui.widget.ForceTextToolBarManager;
import com.github.haixing_hu.swt.utils.SWTUtils;

/**
 * The base class for the tool bars in the tabs of the main panel.
 *
 * @author Haixing Hu
 */
public class MainPanelToolBar extends Composite {

  public static final String KEY = "toolbar";

  protected final Application application;
  protected final String[] actionKeys;
  protected final int height;
  protected final String background;
  protected ForceTextToolBarManager toolBarManager;

  /**
   * Constructs a main panel tool bar.
   *
   * @param application
   *          the application.
   * @param parent
   *          the parent of the tool bar.
   * @param actionKeys
   *          the array of keys of actions to be added to the tool bar. If the
   *          key is the class name of the {@link Separator} class (i.e.,
   *          <code>Separator.class.getName()</code>), a {@link Separator()}
   *          will be added at that position.
   */
  public MainPanelToolBar(Application application, Composite parent, String[] actionKeys) {
    super(parent, SWT.NONE);
    this.application = application;
    this.actionKeys = actionKeys;
    final ApplicationConfig config = ApplicationConfig.getInstance();
    this.height = config.getInt(KEY + KeySuffix.HEIGHT);
    this.background = config.getString(KEY + KeySuffix.BACKGROUND_IMAGE);
    createContents();
    layoutContents();
  }

  /**
   * Creates the contents of this tool bar.
   */
  private final void createContents() {
    toolBarManager = new ForceTextToolBarManager(SWT.FLAT);
    if (actionKeys != null) {
      final ActionManager am = application.getActionManager();
      for (final String key : actionKeys) {
        if (key.equals(Separator.class.getName())) {
          toolBarManager.add(new Separator());
        } else {
          final IAction action = am.get(key);
          toolBarManager.add(action);
        }
      }
    }
    toolBarManager.createControl(this);
  }

  private final void layoutContents() {
    final GridLayout layout = new GridLayout(1, true);
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    layout.marginLeft = 0;
    layout.marginTop = 0;
    layout.marginRight = 0;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    this.setLayout(layout);

    final ToolBar toolBar = toolBarManager.getControl();
    final GridData gd_toolBar = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
    toolBar.setLayoutData(gd_toolBar);

    final Image img = SWTUtils.getImage(background);
    this.setBackgroundImage(img);
    //  in order to be compatible on multi-platforms, we must set the
    //  background image on both this composite and the tool bar.
    toolBar.setBackgroundImage(img);
  }

  /**
   * Gets the height of this status line.
   *
   * @return the height of this status line.
   */
  public final int getHeight() {
    return height;
  }
}
