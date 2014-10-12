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
package com.github.haixing_hu.ilibrary.model;

import com.github.haixing_hu.csl.Variable;

/**
 * Unit test of the {@link FieldTemplate} class.
 *
 * @author Haixing Hu
 */
public class FieldTemplateTest extends XmlSerializationTest<FieldTemplate> {

  public FieldTemplateTest() {
    super(FieldTemplate.class);
    addAbstract();
    addAcceptedData();
    addAuthors();
  }

  private void addAbstract() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    final FieldTemplate template = builder.setName("abstract")
                                          .setType(FieldDataType.STRING)
                                          .setMultiple(false)
                                          .setVariable(Variable.ABSTRACT)
                                          .build();
    final String xml = "<field>"
               + "<name>abstract</name>"
               + "<type>string</type>"
               + "<multiple>false</multiple>"
               + "<variable>abstract</variable>"
               + "</field>";
    marshalTestData.put(template, xml);
    unmarshalTestData.put(xml, template);
  }

  private void addAcceptedData() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    final FieldTemplate template = builder.setName("accepted-data")
                                          .setType(FieldDataType.DATE)
                                          .setMultiple(false)
                                          .setVariable(null)
                                          .build();
    final String xml = "<field>"
               + "<name>accepted-data</name>"
               + "<type>date</type>"
               + "<multiple>false</multiple>"
               + "</field>";
    marshalTestData.put(template, xml);
    unmarshalTestData.put(xml, template);
  }

  private void addAuthors() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    final FieldTemplate template = builder.setName("authors")
                                          .setType(FieldDataType.RESPONSIBILITY)
                                          .setMultiple(true)
                                          .setVariable(Variable.AUTHOR)
                                          .build();
    final String xml = "<field>"
               + "<name>authors</name>"
               + "<type>responsibility</type>"
               + "<multiple>true</multiple>"
               + "<variable>author</variable>"
               + "</field>";
    marshalTestData.put(template, xml);
    unmarshalTestData.put(xml, template);
  }

}
