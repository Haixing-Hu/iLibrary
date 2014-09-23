/******************************************************************************
 *
 * Copyright (c) 2013  Haixing Hu
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

package com.github.haixing_hu.ilibrary.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test of the {@link DisplayName} class.
 *
 * @author Haixing Hu
 */
public class DisplayNameTest  extends XmlSerializationTest<DisplayName>{

  private static final Map<DisplayName, String> TEST_DATA;
  private static final List<DisplayName> FAIL_OBJECT;
  private static final List<String> FAIL_XML;

  static {
    TEST_DATA = new HashMap<DisplayName, String>();
    FAIL_OBJECT = new ArrayList<DisplayName>();
    FAIL_XML = new ArrayList<String>();

    TEST_DATA.put(new DisplayName("zh_CN", "Chinese"),
                  "<display-name locale='zh_CN'>Chinese</display-name>");
    TEST_DATA.put(new DisplayName("en_US", "English"),
                  "<display-name locale='en_US'>English</display-name>");

    FAIL_OBJECT.add(new DisplayName());
    FAIL_OBJECT.add(new DisplayName(null, "name"));

    FAIL_XML.add("<display-name>name</display-name>");
    FAIL_XML.add("<display-name-1>name</display-name-1>");
    FAIL_XML.add("<display-name>name<display-name>");
  }

  public DisplayNameTest() {
    super(DisplayName.class, TEST_DATA, FAIL_OBJECT, FAIL_XML);
  }
}
