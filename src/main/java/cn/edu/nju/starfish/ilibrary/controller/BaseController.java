/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.Application;

/**
 * The base class for all controllers.
 *
 * @author Haixing Hu
 */
public class BaseController {

  protected final Application application;
  protected final Logger logger;

  /**
   * Constructs a {@link BaseController}.
   *
   * @param application
   *          the application.
   */
  public BaseController(Application application) {
    this.application = application;
    this.logger = LoggerFactory.getLogger(this.getClass());
  }

}
