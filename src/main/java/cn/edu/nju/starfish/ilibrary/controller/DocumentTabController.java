/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.controller;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateAction;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateHighlightAction;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateSelectionAction;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateStrikethroughAction;
import cn.edu.nju.starfish.ilibrary.action.edit.AnnotateUnderlineAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.Action;
import cn.edu.nju.starfish.ilibrary.state.AnnotateMode;
import cn.edu.nju.starfish.ilibrary.state.ApplicationState;

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
    final Action annotate = am.get(AnnotateAction.KEY);
    final Action selection = am.get(AnnotateSelectionAction.KEY);
    final Action highlight = am.get(AnnotateHighlightAction.KEY);
    final Action underline = am.get(AnnotateUnderlineAction.KEY);
    final Action strikethrough = am.get(AnnotateStrikethroughAction.KEY);
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
