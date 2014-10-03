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

package com.github.haixing_hu.ilibrary.state;

import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorInfoTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorNotesTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorOverviewTabAction;
import com.github.haixing_hu.ilibrary.action.view.inspector.InspectorActivityTabAction;


/**
 * The enumeration of panels of the inspector panel.
 *
 * @author Haixing Hu
 */
public enum InspectorTab {

  OVERVIEW(InspectorOverviewTabAction.ID),

  INFO(InspectorInfoTabAction.ID),

  NOTES(InspectorNotesTabAction.ID),

  ACTIVITY(InspectorActivityTabAction.ID);

  private String actionId;

  private InspectorTab(String actionId) {
    this.actionId = actionId;
  }

  public String actionId() {
    return actionId;
  }
}
