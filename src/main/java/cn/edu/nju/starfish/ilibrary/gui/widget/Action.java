/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.widget;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * An extension to {@link org.eclipse.jface.action.Action} which adds the
 * visibility of actions.
 *
 * @author Haixing Hu
 */
public abstract class Action extends org.eclipse.jface.action.Action {

  private boolean visible = true;

  /**
   * Creates a new action with no text and no image.
   * <p>
   * Configure the action later using the set methods.
   * </p>
   */
  protected Action() {
    super();
  }

  /**
   * Creates a new action with the given text and no image. Calls the zero-arg
   * constructor, then <code>setText</code>.
   *
   * @param text
   *          the string used as the text for the action, or <code>null</code>
   *          if there is no text
   * @see #setText
   */
  protected Action(String text) {
    super(text);
  }

  /**
   * Creates a new action with the given text and image. Calls the zero-arg
   * constructor, then <code>setText</code> and <code>setImageDescriptor</code>.
   *
   * @param text
   *          the action's text, or <code>null</code> if there is no text
   * @param image
   *          the action's image, or <code>null</code> if there is no image
   * @see #setText
   * @see #setImageDescriptor
   */
  protected Action(String text, ImageDescriptor image) {
    super(text, image);
  }

  /**
   * Creates a new action with the given text and style.
   *
   * @param text
   *          the action's text, or <code>null</code> if there is no text
   * @param style
   *          one of <code>AS_PUSH_BUTTON</code>, <code>AS_CHECK_BOX</code>,
   *          <code>AS_DROP_DOWN_MENU</code>, <code>AS_RADIO_BUTTON</code>, and
   *          <code>AS_UNSPECIFIED</code>.
   */
  protected Action(String text, int style) {
    super(text, style);
  }

  /**
   * Tests whether this action is visible.
   *
   * @return <code>true</code> if this action is visible; <code>false</code>
   *         otherwise.
   */
  public boolean isVisible() {
    return visible;
  }

  /**
   * Sets whether this action's visibility.
   *
   * @param visible
   *          <code>true</code> if this action should be visible;
   *          <code>false</code> otherwise.
   */
  public void setVisible(boolean visible) {
    this.visible = visible;
  }
}
