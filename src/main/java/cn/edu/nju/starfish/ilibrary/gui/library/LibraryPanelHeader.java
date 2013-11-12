/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.library;

import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterHasFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.AttachmentFilterNoFileAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.FlagFilterFlaggedAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterHasReadAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterReadingAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFilterUnreadAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterArticleAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterBookAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterMediaAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterPatentAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterReportAction;
import cn.edu.nju.starfish.ilibrary.gui.MainPanelHeader;

/**
 * The tool bar used to filter the documents.
 *
 * @author Haixing Hu
 */
public final class LibraryPanelHeader extends MainPanelHeader {

  private static final String ACTIONS[] = {
    FlagFilterAllAction.KEY,
    FlagFilterFlaggedAction.KEY,
    //FlagFilterUnflaggedAction.KEY,
    Separator.class.getName(),
    ReadFilterAllAction.KEY,
    ReadFilterUnreadAction.KEY,
    ReadFilterReadingAction.KEY,
    ReadFilterHasReadAction.KEY,
    Separator.class.getName(),
    TypeFilterAllAction.KEY,
    TypeFilterArticleAction.KEY,
    TypeFilterBookAction.KEY,
    TypeFilterReportAction.KEY,
    TypeFilterPatentAction.KEY,
    TypeFilterMediaAction.KEY,
    Separator.class.getName(),
    AttachmentFilterAllAction.KEY,
    AttachmentFilterHasFileAction.KEY,
    AttachmentFilterNoFileAction.KEY,
  };

  public LibraryPanelHeader(Application application, Composite parent) {
    super(application, parent, ACTIONS);
  }
}
