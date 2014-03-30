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

package com.github.haixing_hu.ilibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;

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
