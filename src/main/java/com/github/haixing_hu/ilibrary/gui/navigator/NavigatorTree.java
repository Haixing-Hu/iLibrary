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

package com.github.haixing_hu.ilibrary.gui.navigator;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.ApplicationConfig;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.controller.NavigatorController;
import com.github.haixing_hu.swt.utils.SWTUtils;
import com.github.haixing_hu.text.xml.XmlUtils;

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
    final ApplicationConfig config = ApplicationConfig.getInstance();
    final String input = config.getString(KEY + KeySuffix.INPUT);
    final Document doc = XmlUtils.getDocument(input);
    if (doc != null) {
      this.setContentProvider(new NavigatorTreeContentProvider());
      this.setLabelProvider(new NavigatorTreeLabelProvider(application));
      this.setInput(doc);
    }
    final Tree tree = this.getTree();
    //  set the background color
    final String bgcolor = config.getString(KEY + KeySuffix.BACKGROUND_COLOR);
    final Color color = SWTUtils.parseRGB(bgcolor);
    if (color != null) {
      tree.setBackground(color);
    }
    //  set the selection event handle
    final NavigatorController controller = application.getNavigatorController();
    tree.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        controller.onSelectNode(event);
      }
      @Override
      public void widgetDefaultSelected(SelectionEvent event) {
        controller.onSelectNode(event);
      }
    });
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
