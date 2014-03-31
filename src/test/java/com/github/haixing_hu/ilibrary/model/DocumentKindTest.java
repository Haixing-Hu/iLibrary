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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The unit test of the {@link DocumentKind} class.
 *
 * @author Haixing Hu
 */
public class DocumentKindTest extends XmlSerializationTest<DocumentKind> {

  private static final Map<DocumentKind, String> TEST_DATA;
  private static final List<DocumentKind> FAIL_OBJECT;
  private static final List<String> FAIL_XML;

  static {
    TEST_DATA = new HashMap<DocumentKind, String>();
    FAIL_OBJECT = new ArrayList<DocumentKind>();
    FAIL_XML = new ArrayList<String>();

    final DocumentKind kind1 = new DocumentKind("abstract");
    final HashMap<String, String> displayNames1 = new HashMap<String, String>();
    displayNames1.put("en_US", "Abstract");
    displayNames1.put("zh_CN", "摘要");
    kind1.setDisplayNames(displayNames1);
    final String xml1 = "<kind name='abstract'>\n"
                      + "  <display-names>\n"
                      + "    <display-name locale='en_US'>Abstract</display-name>\n"
                      + "    <display-name locale='zh_CN'>摘要</display-name>\n"
                      + "  </display-names>\n"
                      + "</kind>";
    TEST_DATA.put(kind1, xml1);

    final DocumentKind kind2 = new DocumentKind("article");
    final HashMap<String, String> displayNames2 = new HashMap<String, String>();
    displayNames2.put("zh_CN", "论文");
    kind2.setDisplayNames(displayNames2);
    final String xml2 = "<kind name='article'>\n"
                      + "  <display-names>\n"
                      + "    <display-name locale='zh_CN'>论文</display-name>\n"
                      + "  </display-names>\n"
                      + "</kind>";
    TEST_DATA.put(kind2, xml2);

    final DocumentKind kind3 = new DocumentKind("commentary");
    final String xml3 = "<kind name='commentary'>"
                      + "</kind>";
    TEST_DATA.put(kind3, xml3);

  }

  public DocumentKindTest() {
    super(DocumentKind.class, TEST_DATA, FAIL_OBJECT, FAIL_XML);
  }
}
