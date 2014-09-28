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

/**
 * The base class for the headers.
 * <p>
 * <b>NOTE:</b> Because the abstract function should not be called in the
 * constructor, the subclass <b>must</b> call the {@link #initialize()}
 * after calling the super's constructor and initialing its fields.
 *
 * @author Haixing Hu
 */
public abstract class BasicHeader extends Composite {

  /**
   * The default style of the header.
   */
  public static final int DEFAULT_STYLE = SWT.LEFT | SWT.SEPARATOR;

  protected final Application application;
  protected final int style;
  protected final int height;
  protected final int marginWidth;
  protected final Color backgroundColor;
  protected final Image backgroundImage;
  protected final Color controlBackgroundColor;
  protected final Image controlBackgroundImage;
  protected Control control;
  protected Label separator;

  /**
   * Constructs a header with the default style.
   *
   * @param application
   *          the application.
   * @param parent
   *          the parent of the header.
   * @param id
   *          the ID of the header.
   * @see {@link #DEFAULT_STYLE}
   */
  public BasicHeader(Application application, Composite parent,
      String id) {
    this(application, parent, id, DEFAULT_STYLE);
  }

  /**
   * Constructs a header.
   *
   * @param application
   *          the application.
   * @param parent
   *          the parent of the header.
   * @param id
   *          the ID of the header.
   * @param style
   *          the style of the control, specifying the alignment of the control
   *          in the footer, which should be the combination of the following
   *          values:
   *          <ul>
   *          <li>SWT.LEFT: indicates that the control will be left aligned.</li>
   *          <li>SWT.CENTER: indicates that the control will be center aligned.</li>
   *          <li>SWT.RIGHT: indicates that the control will be right aligned.</li>
   *          <li>SWT.SEPARATOR: indicates that the header will have a horizontal
   *          separator at the bottom.</li>
   *          </ul>
   */
  public BasicHeader(Application application, Composite parent,
      String id, int style) {
    super(parent, SWT.FLAT);
    this.application = application;
    this.style = style;
    final AppConfig config = application.getConfig();
    height = config.getInt(id + KeySuffix.HEIGHT);
    marginWidth = config.getInt(id + KeySuffix.MARGIN_WIDTH);
    backgroundColor = config.getColor(id + KeySuffix.BACKGROUND_COLOR);
    backgroundImage = config.getImage(this.getClass(), id + KeySuffix.BACKGROUND_IMAGE);
    controlBackgroundColor = config.getColor(id + KeySuffix.CONTROL
        + KeySuffix.BACKGROUND_COLOR);
    controlBackgroundImage = config.getImage(this.getClass(),
        id + KeySuffix.CONTROL + KeySuffix.BACKGROUND_IMAGE);
  }

  protected void initialize() {
    control = createControl();
    if ((style & SWT.SEPARATOR) != 0) {
      separator = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    } else {
      separator = null;
    }
    configContents();
  }

  private final void configContents() {
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
      control.setBackground(controlBackgroundColor);
    }
    if (controlBackgroundImage != null) {
      control.setBackgroundImage(controlBackgroundImage);
    }
  }

  private void doGridLayout(final int alignment) {
    final GridLayout layout = new GridLayout(1, true);
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    setLayout(layout);
    final GridData gd_control = new GridData(alignment, SWT.CENTER, true, true);
    control.setLayoutData(gd_control);
    if (separator != null) {
      final GridData gd_separator = new GridData(GridData.FILL_HORIZONTAL);
      separator.setLayoutData(gd_separator);
    }
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
    }
    control.pack();
    final Point controlSize = control.getSize();
    final int marginHeight = (height - separatorHeight - controlSize.y) / 2;
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
    fd_control.top = new FormAttachment(0, marginHeight);
    fd_control.bottom = new FormAttachment(0, height - separatorHeight - marginHeight);
    control.setLayoutData(fd_control);
    if (separator != null) {
      final FormData fd_separator = new FormData();
      fd_separator.left = new FormAttachment(0);
      fd_separator.right = new FormAttachment(100);
      fd_separator.top = new FormAttachment(0, height - separatorHeight);
      fd_separator.bottom = new FormAttachment(0, height);
      separator.setLayoutData(fd_separator);
    }
  }

  /**
   * Creating the control placed on this footer.
   *
   * @return
   *    the created control placed on this footer.
   */
  protected abstract Control createControl();

  /**
   * Gets the control on this header.
   *
   * @return the control on this header.
   */
  public Control getControl() {
    return control;
  }

  /**
   * Gets the height of this header.
   *
   * @return the height of this header.
   */
  public final int getHeight() {
    return height;
  }
}
