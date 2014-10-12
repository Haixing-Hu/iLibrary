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

import com.github.haixing_hu.text.xml.XmlException;
import com.github.haixing_hu.text.xml.XmlUtils;

/**
 * Unit test of the {@link DocumentTemplate} class.
 *
 * @author Haixing Hu
 */
public class DocumentTemplateTest extends XmlSerializationTest<DocumentTemplate> {

  public DocumentTemplateTest() {
    super(DocumentTemplate.class);
    addJournalArticle();
    addArticleManuscript();
  }

  private void addJournalArticle() {
    final DocumentTemplateBuilder builder = new DocumentTemplateBuilder();

    final DocumentTemplate template =
        builder.setName("journal-article")
              .setType(DocumentType.ARTICLE)
              .setDefaultKind("article")
              .addKind("article")
              .addKind("abstract")
              .addKind("commentary")
              .addKind("editorial")
              .addKind("electronic-article")
              .addKind("erratum")
              .addKind("extended-abstract")
              .addKind("letter")
              .addKind("news-and-views")
              .addKind("rebuttal")
              .addKind("retraction")
              .addKind("review")
              .addField("title")
              .addField("subtitle")
              .addField("authors")
              .addField("translators")
              .addField("abstract")
              .addField("journal")
              .addField("volume")
              .addField("number")
              .addField("issue")
              .addField("pages")
              .addField("submitted-date")
              .addField("revised-date")
              .addField("accepted-date")
              .addField("published-date")
              .build();

    String xml;
    try {
      final org.w3c.dom.Document doc =
          XmlUtils.parse("document/article/journal-article.xml");
      xml = XmlUtils.toString(doc);
    } catch (final XmlException e) {
      throw new RuntimeException(e);
    }

    marshalTestData.put(template, xml);
    unmarshalTestData.put(xml,template);
  }

  private void addArticleManuscript() {
    final DocumentTemplateBuilder builder = new DocumentTemplateBuilder();

    final DocumentTemplate template =
        builder.setName("article-manuscript")
              .setType(DocumentType.ARTICLE)
              .setDefaultKind("article")
              .addKind("article")
              .addKind("abstract")
              .addKind("commentary")
              .addKind("editorial")
              .addKind("electronic-article")
              .addKind("erratum")
              .addKind("letter")
              .addKind("news-and-views")
              .addKind("rebuttal")
              .addKind("retraction")
              .addKind("review")
              .addField("title")
              .addField("subtitle")
              .addField("authors")
              .addField("abstract")
              .addField("version")
              .addField("created-date")
              .addField("updated-date")
              .addField("accessed-date")
              .build();

    String xml;
    try {
      final org.w3c.dom.Document doc =
          XmlUtils.parse("document/article/article-manuscript.xml");
      xml = XmlUtils.toString(doc);
    } catch (final XmlException e) {
      throw new RuntimeException(e);
    }

    marshalTestData.put(template, xml);
    unmarshalTestData.put(xml,template);
  }
}
