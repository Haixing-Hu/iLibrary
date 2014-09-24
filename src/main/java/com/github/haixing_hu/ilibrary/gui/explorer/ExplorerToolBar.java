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

package com.github.haixing_hu.ilibrary.gui.explorer;

import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.file.PrintAction;
import com.github.haixing_hu.ilibrary.action.library.AddReviewAction;
import com.github.haixing_hu.ilibrary.action.library.EditKeywordsAction;
import com.github.haixing_hu.ilibrary.action.library.EditNotesAction;
import com.github.haixing_hu.ilibrary.action.library.OpenFileAction;
import com.github.haixing_hu.ilibrary.action.library.OpenUrlAction;
import com.github.haixing_hu.ilibrary.action.share.ShareAction;
import com.github.haixing_hu.ilibrary.action.view.ReadFullScreenAction;
import com.github.haixing_hu.ilibrary.action.view.ViewModeAction;
import com.github.haixing_hu.ilibrary.gui.BasicToolBar;

/**
 * The tool bar in the library panel.
 *
 * @author Haixing Hu
 */
public final class ExplorerToolBar extends BasicToolBar {

  public static final String KEY = ExplorerPanel.KEY + ".toolbar";

  private static final String ACTIONS[] = {
    ReadFullScreenAction.KEY,
    OpenFileAction.KEY,
    OpenUrlAction.KEY,
    ShareAction.KEY,
    PrintAction.KEY,
    Separator.class.getName(),
    EditKeywordsAction.KEY,
    EditNotesAction.KEY,
    AddReviewAction.KEY,
    Separator.class.getName(),
    ViewModeAction.KEY,
  };

  public ExplorerToolBar(Application application, Composite parent) {
    super(application, parent, ACTIONS);
  }
}
