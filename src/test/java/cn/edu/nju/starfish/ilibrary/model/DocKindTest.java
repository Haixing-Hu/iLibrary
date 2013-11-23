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

package cn.edu.nju.starfish.ilibrary.model;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import static org.junit.Assert.assertEquals;

/**
 * Unit test of the {@link DocKind} class.
 *
 * @author Haixing Hu
 */
public class DocKindTest {

  private List<DocKind> generateTestData() {
    final List<DocKind> data = new ArrayList<DocKind>();

    DocKind kind = new DocKind();
    Map<String, String> displayNames = new HashMap<String, String>();
    kind.setName("kind1");
    displayNames.put("zh_CN", "第一个类型");
    displayNames.put("en_US", "The first kind");
    kind.setDisplayNames(displayNames);
    data.add(kind);

    kind = new DocKind();
    displayNames = new HashMap<String, String>();
    kind.setName("kind2");
    displayNames.put("zh_CN", "第二个类型");
    kind.setDisplayNames(displayNames);
    data.add(kind);

    kind = new DocKind();
    displayNames = new HashMap<String, String>();
    kind.setName("kind3");
    kind.setDisplayNames(displayNames);
    data.add(kind);

    kind = new DocKind();
    displayNames = new HashMap<String, String>();
    kind.setName("kind4");
    data.add(kind);

    kind = new DocKind();
    data.add(kind);

    return data;
  }

  @Test
  public void testXmlSerializeDeserialize() throws Exception {
    final List<DocKind> data = generateTestData();
    final Serializer sr = new Persister();
    for (final DocKind kind : data) {
      final StringWriter writer = new StringWriter();
      sr.write(kind, writer);
      final String xml = writer.toString();
      System.out.println(xml);
      final StringReader reader = new StringReader(xml);
      final DocKind k = sr.read(DocKind.class, reader);
      assertEquals(kind, k);
    }
  }
}
