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
import com.github.haixing_hu.ilibrary.action.library.edit.AddReviewAction;
import com.github.haixing_hu.ilibrary.action.library.edit.EditKeywordsAction;
import com.github.haixing_hu.ilibrary.action.library.edit.EditNotesAction;
import com.github.haixing_hu.ilibrary.action.library.open.OpenFileAction;
import com.github.haixing_hu.ilibrary.action.library.open.OpenUrlAction;
import com.github.haixing_hu.ilibrary.action.share.ShareAction;
import com.github.haixing_hu.ilibrary.action.view.layout.LayoutModeAction;
import com.github.haixing_hu.ilibrary.gui.BasicToolBar;

/**
 * The tool bar in the library panel.
 *
 * @author Haixing Hu
 */
public final class ExplorerToolBar extends BasicToolBar {

  public static final String ID = ExplorerPanel.ID + ".toolbar";

  private static final String ACTIONS[] = {
    OpenFileAction.ID,
    OpenUrlAction.ID,
    ShareAction.ID,
    PrintAction.ID,
    Separator.class.getName(),
    EditKeywordsAction.ID,
    EditNotesAction.ID,
    AddReviewAction.ID,
    Separator.class.getName(),
    LayoutModeAction.ID,
  };

  public ExplorerToolBar(Application application, Composite parent) {
    super(application, parent, ACTIONS);
  }
}
