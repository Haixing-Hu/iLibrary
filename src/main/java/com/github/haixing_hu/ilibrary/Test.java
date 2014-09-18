/**
 *
 */
package com.github.haixing_hu.ilibrary;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class Test extends ApplicationWindow {

  StatusLineManager slm = new StatusLineManager();
  Ch4_StatusAction status_action = new Ch4_StatusAction(slm);

  public Test() {
    super(null);
    addStatusLine();
    addMenuBar();
    addToolBar(SWT.FLAT | SWT.WRAP);
  }

  @Override
  protected Control createContents(Composite parent) {
    getShell().setText("ActionEx/Contribution Example");
    parent.setSize(290, 150);
    return parent;
  }

  public static void main(String[] args) {
    Test swin = new Test();
    swin.setBlockOnOpen(true);
    swin.open();
    Display.getCurrent().dispose();
  }

  @Override
  protected MenuManager createMenuManager() {
    MenuManager main_menu = new MenuManager(null);
    MenuManager action_menu = new MenuManager("Menu");
    main_menu.add(action_menu);
    action_menu.add(status_action);
    return main_menu;
  }

  @Override
  protected ToolBarManager createToolBarManager(int style) {
    ToolBarManager tool_bar_manager = new ToolBarManager(style);
    tool_bar_manager.add(status_action);
    return tool_bar_manager;
  }

  @Override
  protected StatusLineManager createStatusLineManager() {
    return slm;
  }
}

class Ch4_StatusAction extends Action {
  StatusLineManager statman;
  short triggercount = 0;

  public Ch4_StatusAction(StatusLineManager sm) {
    super("&Trigger@Ctrl+T", AS_PUSH_BUTTON);
    statman = sm;
    setToolTipText("Trigger the ActionEx");
  }

  @Override
  public void run() {
    triggercount++;
    statman.setMessage("The status action has fired. Count: " + triggercount);
  }
}
