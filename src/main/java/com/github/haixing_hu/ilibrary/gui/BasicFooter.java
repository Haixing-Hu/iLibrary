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

package com.github.haixing_hu.ilibrary.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.KeySuffix;
import com.github.haixing_hu.ilibrary.gui.util.ControlCreator;

/**
 * The base class for the footers.
 *
 * @author Haixing Hu
 */
public class BasicFooter extends Composite {

  /**
   * The default style of the footer.
   */
  public static final int DEFAULT_STYLE = SWT.LEFT | SWT.SEPARATOR;

  protected final Application application;
  protected final int style;
  protected final Label separator;
  protected final Label leftPadding;
  protected final Control control;
  protected final Label rightPadding;
  protected final int height;
  protected final int marginWidth;
  protected final Color backgroundColor;
  protected final Image backgroundImage;
  protected final Color controlBackgroundColor;
  protected final Image controlBackgroundImage;

  /**
   * Creates a footer with the default style.
   *
   * @param application
   *    the application.
   * @param parent
   *    the parent of the footer.
   * @param key
   *    the key of the footer.
   * @param creator
   *    the creator of a control.
   * @see {@link #DEFAULT_STYLE}
   */
  public BasicFooter(Application application, Composite parent,
      String key, ControlCreator creator) {
    this(application, parent, key, creator, DEFAULT_STYLE);
  }

  /**
   * Creates a footer.
   *
   * @param application
   *          the application.
   * @param parent
   *          the parent of the footer.
   * @param key
   *          the key of the footer.
   * @param creator
   *          the creator of a control.
   * @param style
   *          the style of the control, specifying the alignment of the control
   *          in the footer, which should be the combination of the following
   *          values:
   *          <ul>
   *          <li>SWT.LEFT: indicates that the control will be left aligned.</li>
   *          <li>SWT.CENTER: indicates that the control will be center aligned.</li>
   *          <li>SWT.RIGHT: indicates that the control will be right aligned.</li>
   *          <li>SWT.SEPARATOR: indicates that the header will have a horizontal
   *          separator at the top.</li>
   *          </ul>
   */
  public BasicFooter(Application application, Composite parent,
      String key, ControlCreator creator, int style) {
    super(parent, SWT.NONE);
    this.application = application;
    this.style = style;
    if ((style & SWT.SEPARATOR) != 0) {
      separator = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    } else {
      separator = null;
    }
    final AppConfig config = application.getConfig();
    height = config.getInt(key + KeySuffix.HEIGHT);
    marginWidth = config.getInt(key + KeySuffix.MARGIN_WIDTH);
    backgroundColor = config.getColor(key + KeySuffix.BACKGROUND_COLOR);
    backgroundImage = config.getImage(this.getClass(), key + KeySuffix.BACKGROUND_IMAGE);
    controlBackgroundColor = config.getColor(key + KeySuffix.CONTROL
        + KeySuffix.BACKGROUND_COLOR);
    controlBackgroundImage = config.getImage(this.getClass(),
        key + KeySuffix.CONTROL + KeySuffix.BACKGROUND_IMAGE);
    if (((style & SWT.CENTER) != 0) || (marginWidth <= 0)) {
      leftPadding = null;
      control = creator.create(this);
      rightPadding = null;
    } else {
      leftPadding = new Label(this, SWT.NONE);
      control = creator.create(this);
      rightPadding = new Label(this, SWT.NONE);
    }
    layoutContents();
  }

  protected void layoutContents() {
    final int alignment = (style & (SWT.LEFT | SWT.CENTER | SWT.RIGHT));
    if ((alignment == SWT.CENTER) || (marginWidth <= 0)) {
      doGridLayout(alignment);
    } else {
      doFormLayout(alignment);
    }
    if (backgroundColor != null) {
      setBackground(backgroundColor);
    }
    if (backgroundImage != null) {
      setBackgroundImage(backgroundImage);
    }
    if (controlBackgroundColor != null) {
      control.setBackground(backgroundColor);
    }
    if (controlBackgroundImage != null) {
      control.setBackgroundImage(backgroundImage);
    }
  }

  private void doGridLayout(final int alignment) {
    final GridLayout layout = new GridLayout(1, true);
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    setLayout(layout);
    if (separator != null) {
      final GridData gd_separator = new GridData(GridData.FILL_HORIZONTAL);
      separator.setLayoutData(gd_separator);
    }
    final GridData gd_control = new GridData(alignment, GridData.FILL, true, true);
    control.setLayoutData(gd_control);
  }

  private void doFormLayout(final int alignment) {
    final FormLayout layout = new FormLayout();
    layout.spacing = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    setLayout(layout);

    final int separatorHeight;
    if (separator == null) {
      separatorHeight = 0;
    } else {
      separator.pack();
      separatorHeight = separator.getSize().y;
      final FormData fd_separator = new FormData();
      fd_separator.left = new FormAttachment(0);
      fd_separator.right = new FormAttachment(100);
      fd_separator.top = new FormAttachment(0);
      fd_separator.bottom = new FormAttachment(0, separatorHeight);
      separator.setLayoutData(fd_separator);
    }
    control.pack();
    final Point controlSize = control.getSize();
    final FormData fd_control = new FormData();
    switch (alignment) {
    case SWT.RIGHT:
      fd_control.left = new FormAttachment(100, - controlSize.x - marginWidth);
      fd_control.right = new FormAttachment(100, - marginWidth);
      break;
    case SWT.LEFT:
    default:
      fd_control.left = new FormAttachment(0, marginWidth);
      fd_control.right = new FormAttachment(100, - marginWidth);
      break;
    }
    final int marginHeight = (height - separatorHeight - controlSize.y) / 2;
    fd_control.top = new FormAttachment(0, separatorHeight + marginHeight);
    fd_control.bottom = new FormAttachment(0, height - marginHeight);
    control.setLayoutData(fd_control);
  }


  /**
   * Gets the control on this footer.
   *
   * @return the control on this footer.
   */
  public Control getControl() {
    return control;
  }

  /**
   * Gets the height of this footer.
   *
   * @return the height of this footer.
   */
  public final int getHeight() {
    return height;
  }
}
