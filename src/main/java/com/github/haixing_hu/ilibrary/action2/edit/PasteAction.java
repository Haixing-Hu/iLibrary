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

package com.github.haixing_hu.ilibrary.action2.edit;

import com.github.haixing_hu.ilibrary.Application2;
import com.github.haixing_hu.ilibrary.action2.BaseAction;

/**
 * The action to paste the text in the clip board.
 *
 * @author Haixing Hu
 */
public class PasteAction extends BaseAction {

  public static final String ID = EditAction.ID + ".paste";

  public PasteAction(Application2 application) {
    super(ID, application);
  }
}
