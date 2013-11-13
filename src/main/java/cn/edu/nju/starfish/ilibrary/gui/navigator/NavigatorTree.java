/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.navigator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.configuration.Configuration;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The navigator tree panel.
 *
 * @author Haixing Hu
 */
public class NavigatorTree extends TreeViewer {

  public static final String KEY = NavigatorPanel.KEY + ".tree"; // window.navigator.tree

  private static final Logger LOGGER =
      LoggerFactory.getLogger(NavigatorTree.class);

  private final Application application;

  public NavigatorTree(Application application, Composite parent) {
    super(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
    this.application = application;
    createContents();
    //fixNodeIndent();
  }

  private void createContents() {
    final Configuration config = application.getConfig();
    final String inputFile = config.getString(KEY + ".input");
    final URL inputUrl = this.getClass().getResource(inputFile);
    if (inputUrl == null) {
      LOGGER.error("Failed to load the resource: {}", inputFile);
      return;
    }
    InputStream stream = null;
    try {
      final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
      final DocumentBuilder builder = builderFactory.newDocumentBuilder();
      stream = inputUrl.openStream();
      final Document doc = builder.parse(stream);
      this.setContentProvider(new NavigatorTreeContentProvider());
      this.setLabelProvider(new NavigatorTreeLabelProvider(application));
      this.setInput(doc);
    } catch (final Exception e) {
      LOGGER.error("Failed to load the navigator tree definition file: {}", inputFile, e);
      return;
    } finally {
      if (stream != null) {
        try {
          stream.close();
        } catch (final IOException e) {
          LOGGER.error("Closing stream filed: {}", e);
        }
      }
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
