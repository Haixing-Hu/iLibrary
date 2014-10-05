/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.gui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.StyleClass;

/**
 * The base class for panels with a header and a footer.
 *
 * @author Haixing Hu
 */
public abstract class BasicPanel extends VBoxBase {

  protected final HBox header;
  protected final Region content;
  protected final HBox footer;

  public BasicPanel(Application application) {
    super(application);
    header = createHeader();
    content = createContent();
    footer = createFooter();
    VBox.setVgrow(header, Priority.NEVER);
    VBox.setVgrow(content, Priority.ALWAYS);
    VBox.setVgrow(footer, Priority.NEVER);
    getChildren().addAll(header, content, footer);
  }

  /**
   * This function <b>MUST</b> be called at the end of the constructor of the
   * sub-classes.
   */
  protected final void init() {
    configHeader();
    configContent();
    configFooter();
  }

  /**
   * Creates the header.
   *
   * @return the header.
   */
  protected final HBox createHeader() {
    final HBox header = new HBox();
    header.getStyleClass().addAll(StyleClass.HEADER, StyleClass.TOOLBAR,
        StyleClass.ALIGN_CENTER_LEFT);
    return header;
  }

  /**
   * Creates the content.
   *
   * @return the content.
   */
  protected abstract Region createContent();

  /**
   * Creates the footer.
   *
   * @return the footer.
   */
  protected final HBox createFooter() {
    final HBox footer = new HBox();
    footer.getStyleClass().addAll(StyleClass.FOOTER, StyleClass.TOOLBAR,
        StyleClass.ALIGN_CENTER_LEFT);
    return footer;
  }

  /**
   * Configures the header.
   * <p>
   * This function <b>must</b> be called at the constructor of the sub-class,
   * after initialization all its internal fields.
   */
  protected abstract void configHeader();

  /**
   * Configures the content.
   * <p>
   * This function <b>must</b> be called at the constructor of the sub-class,
   * after initialization all its internal fields.
   */
  protected abstract void configContent();

  /**
   * Configures the footer.
   * <p>
   * This function <b>must</b> be called at the constructor of the sub-class,
   * after initialization all its internal fields.
   */
  protected abstract void configFooter();

  /**
   * Gets the header.
   *
   * @return the header.
   */
  public final HBox getHeader() {
    return header;
  }

  /**
   * Gets the content.
   *
   * @return the content.
   */
  public Region getContent() {
    return content;
  }

  /**
   * Gets the footer.
   *
   * @return the footer.
   */
  public final HBox getFooter() {
    return footer;
  }
}
