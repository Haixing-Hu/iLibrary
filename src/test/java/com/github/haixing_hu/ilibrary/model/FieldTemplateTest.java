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

import java.util.List;

import org.apache.commons.beanutils.DynaProperty;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static com.github.haixing_hu.ilibrary.model.JournalArticle.getAuthorsField;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getAuthorsFieldXml;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getJournalField;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getJournalFieldXml;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getPublishedDateField;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getPublishedDateFieldXml;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getTitleField;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getTitleFieldXml;

/**
 * Unit test of the {@link FieldTemplate} class.
 *
 * @author Haixing Hu
 */
public class FieldTemplateTest extends XmlSerializationTest<FieldTemplate> {

  public FieldTemplateTest() {
    super(FieldTemplate.class);

    final FieldTemplate title = getTitleField();
    final String titleXml = getTitleFieldXml();
    marshalTestData.put(title, titleXml);
    unmarshalTestData.put(titleXml, title);

    final FieldTemplate authors = getAuthorsField();
    final String authorsXml = getAuthorsFieldXml();
    marshalTestData.put(authors, authorsXml);
    unmarshalTestData.put(authorsXml, authors);

    final FieldTemplate journal = getJournalField();
    final String journalXml = getJournalFieldXml();
    marshalTestData.put(journal, journalXml);
    unmarshalTestData.put(journalXml, journal);

    final FieldTemplate publishedDate = getPublishedDateField();
    final String publishedDateXml = getPublishedDateFieldXml();
    marshalTestData.put(publishedDate, publishedDateXml);
    unmarshalTestData.put(publishedDateXml, publishedDate);
  }

  @Test
  public void testToDynaProperty() {
    final FieldTemplate title = getTitleField();
    final DynaProperty titleProp = title.toDynaProperty();
    assertEquals("title", titleProp.getName());
    assertEquals(String.class, titleProp.getType());

    final FieldTemplate authors = getAuthorsField();
    final DynaProperty authorsProp = authors.toDynaProperty();
    assertEquals("authors", authorsProp.getName());
    assertEquals(List.class, authorsProp.getType());
    assertEquals(Responsibility.class, authorsProp.getContentType());
  }

}
