/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.navigator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The content provider for the navigator tree viewer.
 *
 * @author Haixing Hu
 */
public class NavigatorTreeContentProvider implements ITreeContentProvider {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(NavigatorTreeContentProvider.class);

  @Override
  public void dispose() {
    // do nothing
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    // do nothing
  }

  @Override
  public Object[] getElements(Object inputElement) {
    LOGGER.info("Building the navigator tree ...");
    final Document doc = (Document) inputElement;
    final Element root = doc.getDocumentElement();
    if (! NavigatorTreeNode.ROOT_NAME.equals(root.getNodeName())) {
      LOGGER.error("Invalid XML structure, the root element must be <{}>.",
          NavigatorTreeNode.ROOT_NAME);
      return ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    final NodeList children = root.getChildNodes();
    final int n = children.getLength();
    final List<Object> result = new ArrayList<Object>();
    for (int i = 0; i < n; ++i) {
      final Node child = children.item(i);
      if (child instanceof Element) {
        result.add(new NavigatorTreeNode((Element) child, null));
      }
    }
    return result.toArray();
  }

  @Override
  public Object[] getChildren(Object parentElement) {
    final NavigatorTreeNode parent = (NavigatorTreeNode) parentElement;
    final Element element = parent.getDomElement();
    final NodeList children = element.getChildNodes();
    final int n = children.getLength();
    final List<Object> result = new ArrayList<Object>();
    for (int i = 0; i < n; ++i) {
      final Node child = children.item(i);
      if (child instanceof Element) {
        result.add(new NavigatorTreeNode((Element) child, parent));
      }
    }
    return result.toArray();
  }

  @Override
  public Object getParent(Object element) {
    final NavigatorTreeNode node = (NavigatorTreeNode) element;
    return node.getParent();
  }

  @Override
  public boolean hasChildren(Object element) {
    final NavigatorTreeNode node = (NavigatorTreeNode) element;
    return node.getChildren().size() > 0;
  }

}
