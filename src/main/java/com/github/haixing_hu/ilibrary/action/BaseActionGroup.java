/*
 * Copyright (C) 2014 Haixing Hu
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.github.haixing_hu.ilibrary.action;

import javafx.scene.input.KeyCombination;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.MessageKey;
import com.github.haixing_hu.javafx.action.ActionGroup;
import com.github.haixing_hu.javafx.action.ActionManager;
import com.github.haixing_hu.javafx.action.ActionOption;
import com.github.haixing_hu.javafx.action.IAction;
import com.github.haixing_hu.javafx.action.SeparatorAction;
import com.github.haixing_hu.lang.StringUtils;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The base class for all action groups used in this application.
 *
 * @author Haixing Hu
 */
public class BaseActionGroup extends ActionGroup {

  protected final Application application;
  protected final Logger logger;

  /**
   * Constructs an action.
   *
   * @param id
   *          the id of the new action group.
   * @param application
   *          the application the new action group belongs to.
   */
  public BaseActionGroup(String id, Application application) {
    this(id, null, application, ActionOption.DEFAULT);
  }

  /**
   * Constructs an action.
   *
   * @param id
   *          the id of the new action group.
   * @param application
   *          the application the new action group belongs to.
   * @param options
   *          the options of the new action group.
   */
  public BaseActionGroup(String id, Application application, int options) {
    this(id, null, application, options);
  }

  /**
   * Constructs an action.
   *
   * @param id
   *          the id of the new action group.
   * @param title
   *          the title of the new action. If this value is null, the title will
   *          be get from the resource bundles.
   * @param application
   *          the application the new action belongs to.
   * @param options
   *          the options of the new action group.
   */
  public BaseActionGroup(String id, @Nullable String title,
      Application application, int options) {
    super(id, options);
    this.application = requireNonNull("application", application);
    logger = LoggerFactory.getLogger(this.getClass());

    logger.trace("Creating the action group: {}", id);
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

  protected void addSubAction(ActionManager am, IAction action) {
    actions.add(action);
    if (! (action instanceof SeparatorAction)) {
      am.add(action);
    }
  }
}
