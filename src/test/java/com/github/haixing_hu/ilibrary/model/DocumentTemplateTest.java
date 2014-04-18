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
 * Unit test of the {@link DocumentTemplate} class.
 *
 * @author Haixing Hu
 */
public class DocumentTemplateTest extends XmlSerializationTest<DocumentTemplate> {

  private static final Map<DocumentTemplate, String> MARSHAL_TEST_DATA;
  private static final Map<String, DocumentTemplate> UNMARSHAL_TEST_DATA;

  static {
    MARSHAL_TEST_DATA = new HashMap<DocumentTemplate, String>();
    UNMARSHAL_TEST_DATA = new HashMap<String, DocumentTemplate>();

    final DocumentTemplate journalArticle = new DocumentTemplate();
    journalArticle.setName("journal-article");
    journalArticle.setType(DocumentType.ARTICLE);
    journalArticle.setDefaultKind("article");
    final List<String> journalArticleKinds = new ArrayList<String>();
    journalArticleKinds.add("abstract");
    journalArticleKinds.add("article");
    journalArticleKinds.add("commentary");
    journalArticleKinds.add("editorial");
    journalArticleKinds.add("electronic-article");
    journalArticleKinds.add("erratum");
    journalArticleKinds.add("extended-abstract");
    journalArticleKinds.add("letter");
    journalArticleKinds.add("news-and-views");
    journalArticleKinds.add("rebuttal");
    journalArticleKinds.add("retraction");
    journalArticleKinds.add("review");
    journalArticle.setKinds(journalArticleKinds);
    final List<String> journalArticleFields = new ArrayList<String>();
    journalArticleFields.add("title");
    journalArticleFields.add("subtitle");
    journalArticleFields.add("authors");
    journalArticleFields.add("translators");
    journalArticleFields.add("abstract");
    journalArticleFields.add("journal");
    journalArticleFields.add("number");
    journalArticleFields.add("volume");
    journalArticleFields.add("issue");
    journalArticleFields.add("pages");
    journalArticleFields.add("submitted-date");
    journalArticleFields.add("revised-date");
    journalArticleFields.add("accepted-date");
    journalArticleFields.add("published-date");
    journalArticle.setFields(journalArticleFields);

    final String journalArticleXml =
          "<document>"
        + "<name>journal-article</name>"
        + "<type>article</type>"
        + "<default-kind>article</default-kind>"
        + "<kinds>"
        + "<kind>abstract</kind>"
        + "<kind>article</kind>"
        + "<kind>commentary</kind>"
        + "<kind>editorial</kind>"
        + "<kind>electronic-article</kind>"
        + "<kind>erratum</kind>"
        + "<kind>extended-abstract</kind>"
        + "<kind>letter</kind>"
        + "<kind>news-and-views</kind>"
        + "<kind>rebuttal</kind>"
        + "<kind>retraction</kind>"
        + "<kind>review</kind>"
        + "</kinds>"
        + "<fields>"
        + "<field>title</field>"
        + "<field>subtitle</field>"
        + "<field>authors</field>"
        + "<field>translators</field>"
        + "<field>abstract</field>"
        + "<field>journal</field>"
        + "<field>number</field>"
        + "<field>volume</field>"
        + "<field>issue</field>"
        + "<field>pages</field>"
        + "<field>submitted-date</field>"
        + "<field>revised-date</field>"
        + "<field>accepted-date</field>"
        + "<field>published-date</field>"
        + "</fields>"
        + "</document>";

    MARSHAL_TEST_DATA.put(journalArticle, journalArticleXml);
    UNMARSHAL_TEST_DATA.put(journalArticleXml,journalArticle);
  }

  public DocumentTemplateTest() {
    super(DocumentTemplate.class, MARSHAL_TEST_DATA, UNMARSHAL_TEST_DATA);
  }

}
