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

package com.github.haixing_hu.ilibrary.action;

import javafx.event.ActionEvent;
import javafx.scene.input.KeyCombination;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.MessageKey;
import com.github.haixing_hu.javafx.action.Action;
import com.github.haixing_hu.javafx.action.ActionOption;
import com.github.haixing_hu.lang.StringUtils;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The base class for all actions used in this application.
 *
 * @author Haixing Hu
 */
public class BaseAction extends Action {

  public static final int DEFAULT = ActionOption.DEFAULT
                                  | ActionOption.HIDE_MENU_ITEM_GRAPHIC
                                  | ActionOption.HIDE_BUTTON_TEXT;

  public static final int DIALOG = ActionOption.DEFAULT
                                 | ActionOption.HIDE_MENU_ITEM_GRAPHIC
                                 | ActionOption.HIDE_BUTTON_TEXT
                                 | ActionOption.SHOW_DIALOG;

  public static final int CHECK = ActionOption.TOGGLE_BUTTON
                                | ActionOption.CHECK_MENU_ITEM
                                | ActionOption.HIDE_MENU_ITEM_GRAPHIC
                                | ActionOption.HIDE_BUTTON_TEXT;

  protected final Application application;
  protected final Logger logger;

  /**
   * Constructs an action.
   *
   * @param id
   *          the ID of the new action.
   * @param application
   *          the application the new action belongs to.
   */
  public BaseAction(String id, Application application) {
    this(id, null, application, DEFAULT);
  }

  /**
   * Constructs an action.
   *
   * @param id
   *          the ID of the new action.
   * @param application
   *          the application the new action belongs to.
   * @param options
   *          the options of the new action.
   */
  public BaseAction(String id, Application application, int options) {
    this(id, null, application, options);
  }

  /**
   * Constructs an action.
   *
   * @param id
   *          the ID of the new action.
   * @param title
   *          the title of the new action, or null if none.
   * @param application
   *          the application the new action belongs to.
   * @param options
   *          the options of the new action.
   */
  protected BaseAction(String id, @Nullable String title,
      Application application, int options) {
    super(id, options);
    this.application = requireNonNull("application", application);
    logger = LoggerFactory.getLogger(this.getClass());

    logger.trace("Creating the action: {}", id);
    final AppConfig config = application.getConfig();
    if (title == null) {
      title = config.getTitle(id);
    }
    if (StringUtils.isEmpty(title)) {
      logger.error("Cannot get the title for action: {}", id);
      title = config.getMessage(MessageKey.ERROR_NO_TITLE);
    }
    logger.trace("Set title to {}.", title);
    setText(title);

    final String shortcut = config.getShortcut(id);
    if (! StringUtils.isEmpty(shortcut)) {
      logger.trace("Set shortcut to {}.", shortcut);
      final KeyCombination accelerator = KeyCombination.valueOf(shortcut);
      setAccelerator(accelerator);
    }

    String description = config.getDescription(id);
    if (StringUtils.isEmpty(description)) {
      description = title;
    }
    logger.trace("Set description to {}.", description);
    setDescription(description);
  }

  @Override
  public void handle(ActionEvent event) {
    //  default implementation is to display an error message.
    application.displayUnimplementedError(getId());
  }
}
