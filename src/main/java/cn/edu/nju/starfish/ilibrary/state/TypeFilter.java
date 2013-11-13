/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.ActionManager;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterAllAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterArticleAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterBookAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterMediaAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterPatentAction;
import cn.edu.nju.starfish.ilibrary.action.view.TypeFilterReportAction;
import cn.edu.nju.starfish.ilibrary.gui.widget.Action;

/**
 * The enumeration of type filters.
 *
 * @author Haixing Hu
 */
public enum TypeFilter {

  ARTICLE,

  BOOK,

  REPORT,

  PATENT,

  MEDIA,

  ALL;


  private static final Logger LOGGER = LoggerFactory.getLogger(TypeFilter.class);

  /**
   * Updates the type filter.
   *
   * @param application the application.
   * @param filter the new type filter.
   */
  public static void update(Application application, TypeFilter filter) {
    //  TODO: set the filter in the document list table
    final ActionManager am = application.getActionManager();
    final Action all = am.get(TypeFilterAllAction.KEY);
    final Action article = am.get(TypeFilterArticleAction.KEY);
    final Action book = am.get(TypeFilterBookAction.KEY);
    final Action report = am.get(TypeFilterReportAction.KEY);
    final Action patent = am.get(TypeFilterPatentAction.KEY);
    final Action media = am.get(TypeFilterMediaAction.KEY);
    switch (filter) {
    case ALL:
      all.setChecked(true);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case ARTICLE:
      all.setChecked(false);
      article.setChecked(true);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case BOOK:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(true);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case REPORT:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(true);
      patent.setChecked(false);
      media.setChecked(false);
      break;
    case PATENT:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(true);
      media.setChecked(false);
      break;
    case MEDIA:
      all.setChecked(false);
      article.setChecked(false);
      book.setChecked(false);
      report.setChecked(false);
      patent.setChecked(false);
      media.setChecked(true);
      break;
    default:
      LOGGER.error("Unknown type filter: {}", filter);
      return;
    }
    //  set the state
    final ApplicationState state = application.getState();
    state.setTypeFilter(filter);
  }
}
