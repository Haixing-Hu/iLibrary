/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.navigator;

import org.apache.commons.configuration.Configuration;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.KeySuffix;
import cn.edu.nju.starfish.ilibrary.utils.SWTUtils;
import cn.edu.nju.starfish.ilibrary.utils.XmlUtils;

/**
 * The navigator tree panel.
 *
 * @author Haixing Hu
 */
public class NavigatorTree extends TreeViewer {

  public static final String KEY = NavigatorPanel.KEY + ".tree"; // window.navigator.tree

  private static final Logger LOGGER = LoggerFactory.getLogger(NavigatorTree.class);

  private final Application application;

  public NavigatorTree(Application application, Composite parent) {
    super(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
    this.application = application;
    createContents();
    //fixNodeIndent();
  }

  private void createContents() {
    final Configuration config = application.getConfig();
    final String input = config.getString(KEY + KeySuffix.INPUT);
    final Document doc = XmlUtils.getDocument(input);
    if (doc != null) {
      this.setContentProvider(new NavigatorTreeContentProvider());
      this.setLabelProvider(new NavigatorTreeLabelProvider(application));
      this.setInput(doc);
    }
    //  set the background color
    final String bgcolor = config.getString(KEY + KeySuffix.BACKGROUND_COLOR);
    final Color color = SWTUtils.parseRGB(bgcolor);
    if (color != null) {
      this.getControl().setBackground(color);
    }
  }

//  /**
//   * Fixes the indent of some nodes.
//   * <p>
//   * See the line 32-44 of the codes in the "Example 5: Enhancing the native content"
//   * of the article
//   * <a href="http://www.eclipse.org/articles/article.php?file=Article-CustomDrawingTableAndTreeItems/index.html">"Custom
//   * Drawing Table and Tree Items"</a>.
//   */
//  private void fixNodeIndent() {
//    final Tree tree = (Tree) this.getControl();
//    final int offset = -40;
//    tree.addListener(SWT.PaintItem, new Listener() {
//      @Override
//      public void handleEvent(Event event) {
//        final TreeItem item = (TreeItem)event.item;
//        final NavigatorTreeNode node = (NavigatorTreeNode) item.getData();
//        LOGGER.debug("handle PaintItem event for node: {}", node.getKey());
//        LOGGER.debug("The event object for the node is: {}", event);
//        event.x -= 40;
//      }
//    });
//  }

}
