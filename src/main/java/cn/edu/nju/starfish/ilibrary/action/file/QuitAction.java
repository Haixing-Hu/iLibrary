/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.file;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.IActionManager;

/**
 * The action to quit the application.
 *
 * @author Haixing Hu
 */
public class QuitAction extends BaseAction implements Listener {

  public static final String KEY = FileAction.KEY + ".quit";

  public QuitAction(Application application, IActionManager actionManager) {
    super(KEY, application, actionManager);
  }

  @Override
  public void run() {
    application.getMainWindow().close();
  }

  @Override
  public void handleEvent(Event event) {
    this.run();
  }
}
