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

package com.github.haixing_hu.ilibrary.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test of the {@link FieldTemplate} class.
 *
 * @author Haixing Hu
 */
public class FieldTemplateTest extends XmlSerializationTest<FieldTemplate> {

  private static final Map<FieldTemplate, String> MARSHAL_TEST_DATA;
  private static final Map<String, FieldTemplate> UNMARSHAL_TEST_DATA;

  static {
    MARSHAL_TEST_DATA = new HashMap<FieldTemplate, String>();
    UNMARSHAL_TEST_DATA = new HashMap<String, FieldTemplate>();

    final FieldTemplate title = new FieldTemplate();
    title.setName("title");
    title.setType(FieldDataType.STRING);
    title.setRequired(true);
    MARSHAL_TEST_DATA.put(title,
                 "<field required='true' list='false'>"
                 + "<name>title</name>"
                 + "<type>string</type>"
                 + "</field>");

    UNMARSHAL_TEST_DATA.put("<field required='true'>"
        + "<name>title</name>"
        + "<type>string</type>"
        + "</field>",
        title);

    final FieldTemplate authors = new FieldTemplate();
    authors.setName("authors");
    authors.setType(FieldDataType.RESPONSIBILITY);
    authors.setRequired(true);
    authors.setList(true);
    MARSHAL_TEST_DATA.put(authors,
        "<field required='true' list='true'>"
        + "<name>authors</name>"
        + "<type>responsibility</type>"
        + "</field>");

    UNMARSHAL_TEST_DATA.put("<field required='true' list='true'>"
        + "<name>authors</name>"
        + "<type>responsibility</type>"
        + "</field>",
        authors);

    final FieldTemplate submittedDate = new FieldTemplate();
    submittedDate.setName("submitted-date");
    submittedDate.setType(FieldDataType.DAY);

    MARSHAL_TEST_DATA.put(submittedDate,
        "<field required='false' list='false'>"
        + "<name>submitted-date</name>"
        + "<type>day</type>"
        + "</field>");

    UNMARSHAL_TEST_DATA.put("<field>"
        + "<name>submitted-date</name>"
        + "<type>day</type>"
        + "</field>",
        submittedDate);
  }

  public FieldTemplateTest() {
    super(FieldTemplate.class, MARSHAL_TEST_DATA, UNMARSHAL_TEST_DATA);
  }

}
