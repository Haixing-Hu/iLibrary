/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.library;

import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.view.FilterFileStatusAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterFileStatusHasFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterFileStatusNoFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterFlagStatusAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterFlagStatusFlaggedAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterReadStatusAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterReadStatusHasReadAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterReadStatusReadingAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterReadStatusUnreadAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterTypeAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterTypeArticleAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterTypeBookAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterTypeMediaAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterTypePatentAction;
import cn.edu.nju.starfish.ilibrary.action.view.FilterTypeReportAction;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelHeader;

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
    FilterTypeReportAction.KEY,
    FilterTypePatentAction.KEY,
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
