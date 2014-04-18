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

package com.github.haixing_hu.ilibrary.gui.library;

import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusHasFileAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFileStatusNoFileAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterFlagStatusFlaggedAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusHasReadAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusReadingAction;
import com.github.haixing_hu.ilibrary.action.view.FilterReadStatusUnreadAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeAllAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeArticleAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeBookAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeLawAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeMediaAction;
import com.github.haixing_hu.ilibrary.action.view.FilterTypeReferenceAction;
import com.github.haixing_hu.ilibrary.gui.MainPanelHeader;

/**
 * The header in the library panel.
 *
 * @author Haixing Hu
 */
public final class LibraryPanelHeader extends MainPanelHeader {

  private static final String ACTIONS[] = {
    FilterFlagStatusAllAction.KEY,
    FilterFlagStatusFlaggedAction.KEY,
    //FlagFilterUnflaggedAction.KEY,
    Separator.class.getName(),
    FilterReadStatusAllAction.KEY,
    FilterReadStatusUnreadAction.KEY,
    FilterReadStatusReadingAction.KEY,
    FilterReadStatusHasReadAction.KEY,
    Separator.class.getName(),
    FilterTypeAllAction.KEY,
    FilterTypeArticleAction.KEY,
    FilterTypeBookAction.KEY,
    FilterTypeReferenceAction.KEY,
    FilterTypeLawAction.KEY,
    FilterTypeMediaAction.KEY,
    Separator.class.getName(),
    FilterFileStatusAllAction.KEY,
    FilterFileStatusHasFileAction.KEY,
    FilterFileStatusNoFileAction.KEY,
  };

  public LibraryPanelHeader(Application application, Composite parent) {
    super(application, parent, ACTIONS);
  }
}
