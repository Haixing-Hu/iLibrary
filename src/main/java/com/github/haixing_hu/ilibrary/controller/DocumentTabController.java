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

package com.github.haixing_hu.ilibrary.controller;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.ActionManager;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateHighlightAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateSelectionAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateStrikethroughAction;
import com.github.haixing_hu.ilibrary.action.edit.AnnotateUnderlineAction;
import com.github.haixing_hu.swt.action.ActionEx;
import com.github.haixing_hu.ilibrary.state.AnnotateMode;
import com.github.haixing_hu.ilibrary.state.ApplicationState;

/**
 * The controller of the document tab.
 *
 * @author Haixing Hu
 */
public class DocumentTabController  extends BaseController {

  /**
   * Constructs a {@link DocumentTabController}.
   *
   * @param application
   *          the application.
   */
  public DocumentTabController(Application application) {
    super(application);
  }

  /**
   * Sets the annotate mode.
   *
   * @param mode
   *          the new annotate mode.
   */
  public void setAnnotateMode(AnnotateMode mode) {
    logger.info("Set the annotate mode to: {}", mode);
    //  TODO: set the annotate mode
    final ActionManager am = application.getActionManager();
    final ActionEx annotate = am.get(AnnotateAction.KEY);
    final ActionEx selection = am.get(AnnotateSelectionAction.KEY);
    final ActionEx highlight = am.get(AnnotateHighlightAction.KEY);
    final ActionEx underline = am.get(AnnotateUnderlineAction.KEY);
    final ActionEx strikethrough = am.get(AnnotateStrikethroughAction.KEY);
    switch (mode) {
    case SELECTION:
      //  update action's checking status
      selection.setChecked(true);
      highlight.setChecked(false);
      underline.setChecked(false);
      strikethrough.setChecked(false);
      //  change the icon of the AnnotateAction
      annotate.setImageDescriptor(selection.getImageDescriptor());
      break;
    case HIGHLIGHT:
      //  update action's checking status
      selection.setChecked(false);
      highlight.setChecked(true);
      underline.setChecked(false);
      strikethrough.setChecked(false);
      //  change the icon of the AnnotateAction
      annotate.setImageDescriptor(highlight.getImageDescriptor());
      break;
    case UNDERLINE:
      //  update action's checking status
      selection.setChecked(false);
      highlight.setChecked(false);
      underline.setChecked(true);
      strikethrough.setChecked(false);
      //  change the icon of the AnnotateAction
      annotate.setImageDescriptor(underline.getImageDescriptor());
      break;
    case STRIKETHORUGH:
      selection.setChecked(false);
      highlight.setChecked(false);
      underline.setChecked(false);
      strikethrough.setChecked(true);
      //  change the icon of the AnnotateAction
      annotate.setImageDescriptor(strikethrough.getImageDescriptor());
      break;
    default:
      logger.error("Unknown annotate mode: ", mode);
      return;
    }
    //  set the state
    final ApplicationState state = application.getState();
    state.setAnnotateMode(mode);
  }
}
