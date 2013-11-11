/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.main;

import org.apache.commons.configuration.Configuration;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.file.PrintAction;
import cn.edu.nju.starfish.ilibrary.action.library.AddReviewAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditKeywordsAction;
import cn.edu.nju.starfish.ilibrary.action.library.EditNotesAction;
import cn.edu.nju.starfish.ilibrary.action.library.OpenFileAction;
import cn.edu.nju.starfish.ilibrary.action.library.OpenUrlAction;
import cn.edu.nju.starfish.ilibrary.action.share.ShareAction;
import cn.edu.nju.starfish.ilibrary.action.view.ReadFullScreenAction;
import cn.edu.nju.starfish.ilibrary.action.view.ViewModeAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.ForceTextToolBarManager;

/**
 * The main tool bar.
 *
 * @author Haixing Hu
 */
public final class MainToolBar extends Composite {

  public static final String KEY = "toolbar";

  private final Application application;
  private final int height;
  private ForceTextToolBarManager toolBarManager;

  public MainToolBar(Application application, Composite parent) {
    super(parent, SWT.FLAT);
    this.application = application;
    final Configuration config = application.getConfig();
    this.height = config.getInt(KEY + ".height");
    createContents();
  }

  /**
   * Creates the contents of this tool bar.
   */
  private void createContents() {
    final RowLayout layout = new RowLayout(SWT.VERTICAL);
    layout.justify = true;
    layout.marginLeft = 0;
    layout.marginTop = 0;
    layout.marginRight = 0;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    this.setLayout(layout);

    toolBarManager = new ForceTextToolBarManager(SWT.FLAT);
    final ActionManager am = application.getActionManager();
    toolBarManager.add(am.getAction(ReadFullScreenAction.KEY));
    toolBarManager.add(am.getAction(OpenFileAction.KEY));
    toolBarManager.add(am.getAction(OpenUrlAction.KEY));
    toolBarManager.add(am.getAction(ShareAction.KEY));
    toolBarManager.add(am.getAction(PrintAction.KEY));
    toolBarManager.add(new Separator());
    toolBarManager.add(am.getAction(EditKeywordsAction.KEY));
    toolBarManager.add(am.getAction(EditNotesAction.KEY));
    toolBarManager.add(am.getAction(AddReviewAction.KEY));
    toolBarManager.add(new Separator());
    toolBarManager.add(am.getAction(ViewModeAction.KEY));

    toolBarManager.createControl(this);
  }

  /**
   * Gets the height of this status line.
   *
   * @return the height of this status line.
   */
  public int getHeight() {
    return height;
  }
}
