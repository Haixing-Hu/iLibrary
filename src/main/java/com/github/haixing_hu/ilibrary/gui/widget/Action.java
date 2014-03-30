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

package com.github.haixing_hu.ilibrary.gui.widget;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * An extension to {@link org.eclipse.jface.action.Action}, providing the
 * following enhancements:
 * <ul>
 * <li>add the visibility control</li>
 * <li>add a property which indicate whether this action will display a dialog.</li>
 * </ul>
 *
 * @author Haixing Hu
 */
public abstract class Action extends org.eclipse.jface.action.Action {

  private boolean visible = true;
  private final boolean showImage = true;
  private boolean showDialog = false;

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

  /**
   * Tests whether this action will show a dialog.
   *
   * @return <code>true</code> if this action will show a dialog;
   *         <code>false</code> otherwise.
   */
  public boolean isShowDialog() {
    return showDialog;
  }

  /**
   * Sets whether this action will show a dialog.
   *
   * @return <code>true</code> if this action will show a dialog;
   *         <code>false</code> otherwise.
   */
  public void setShowDialog(boolean showDialog) {
    this.showDialog = showDialog;
  }

}
