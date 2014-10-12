/*
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
 */
package com.github.haixing_hu.ilibrary.action.view.zoom;

import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.action.BaseAction;
import com.github.haixing_hu.ilibrary.action.view.ViewAction;

/**
 * The action to zoom the current document to fit the size of the current window.
 *
 * @author Haixing Hu
 */
public class ZoomToFitAction extends BaseAction {

  public static final String ID = ViewAction.ID + ".zoom-to-fit";

  public ZoomToFitAction(Application application) {
    super(ID, application);
  }
}
