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

package com.github.haixing_hu.ilibrary.utils.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * The customized JAXB data type adaptor for the enumeration types.
 * <p>
 * This adaptor will automatically change the style of the name of an
 * enumerator, in the following way:
 * <ul>
 * <li>Lower case the name of the enumerator.</li>
 * <li>Replace the '_' with '-'.</li>
 * </ul>
 * For example, suppose we have an enumeration class as follows:
 * <code>
 * <pre>
 * package com.github.haixinghu.csl;
 * public enum MyEnum {
 *  FIRST,
 *  SECOND_ITEM,
 *  THE_THIRD_ITEM,
 * }
 * </pre>
 * </code>
 * We should create an adaptor class extending the {@link EnumXmlAdaptor} as
 * follows:
 * <code>
 * <pre>
 *  package com.github.haixinghu.csl;
 *  public final class MyEnumXmlAdaptor extends EnumXmlAdaptor<MyEnum> {
 *    public MyEnumXmlAdaptor() {
 *      super(MyEnum.class);
 *    }
 *  }
 * </pre>
 * </code>
 * Then we should use a
 * <a href="http://www.onjava.com/pub/a/onjava/2004/04/21/declarative.html?page=3">
 * package level annotation</a> in the <code>package-info.java</code> as follows:
 * <code>
 * <pre>
 *  &#64;XmlJavaTypeAdapters({
 *    &#64;XmlJavaTypeAdapter(type=MyEnum.class, value=MyEnumXmlAdaptor.class)
 *  })
 *  package com.github.haixinghu.csl;
 *  import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
 *  import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
 * </pre>
 * </code>
 * This will make the JAXB automatically converts the names of enumerators in
 * the <code>MyEnum</code> enumeration class as follows:
 * <code>
 * <pre>
 *  FIRST <==> "first"
 *  SECOND_ITEM <==> "second-item"
 *  THE_THIRD_ITEM <==> "third-item"
 * </pre>
 * </code>
 *
 * @author Haixing Hu
 */
public class EnumXmlAdaptor<T extends Enum<T>> extends XmlAdapter<String, T> {

  private final Class<T> cls;

  protected EnumXmlAdaptor(Class<T> cls) {
    this.cls = cls;
  }

  @Override
  public T unmarshal(String v) throws Exception {
    if (v == null) {
      return null;
    } else {
      return Enum.valueOf(cls, v.toUpperCase().replace('-', '_'));
    }
  }

  @Override
  public String marshal(T v) throws Exception {
    if (v == null) {
      return null;
    } else {
      return v.name().toLowerCase().replace('_', '-');
    }
  }
}
