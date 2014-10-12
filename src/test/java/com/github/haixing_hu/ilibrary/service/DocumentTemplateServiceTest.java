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
package com.github.haixing_hu.ilibrary.service;

import java.util.Collection;

import org.junit.Test;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.model.DocumentTemplate;
import com.github.haixing_hu.ilibrary.model.DocumentType;

import static org.junit.Assert.*;

/**
 * The unit test of the implementation of the {@link DocumentTemplateService}
 * interface.
 *
 * @author Haixing Hu
 */
public class DocumentTemplateServiceTest {

  @Test
  public void testGetAll() {
    final AppConfig config = new AppConfig(Application.CONTEXT_FILE);
    final DocumentTemplateService service = config.getBean(DocumentTemplateService.class);
    final Collection<DocumentTemplate> templates = service.getAll();
    assertTrue(templates.size() > 0);
    for (final DocumentTemplate template : templates) {
      System.out.println(template);
    }
  }

  @Test
  public void testGetAllType() {
    final AppConfig config = new AppConfig(Application.CONTEXT_FILE);
    final DocumentTemplateService service = config.getBean(DocumentTemplateService.class);

    final Collection<DocumentTemplate> articles = service.getAll(DocumentType.ARTICLE);
    assertTrue(articles.size() > 0);
    for (final DocumentTemplate t : articles) {
      assertEquals(DocumentType.ARTICLE, t.getType());
      System.out.println(t);
    }

    final Collection<DocumentTemplate> books = service.getAll(DocumentType.BOOK);
    assertTrue(books.size() > 0);
    for (final DocumentTemplate t : books) {
      assertEquals(DocumentType.BOOK, t.getType());
      System.out.println(t);
    }

    final Collection<DocumentTemplate> legals = service.getAll(DocumentType.LEGAL);
    assertTrue(legals.size() > 0);
    for (final DocumentTemplate t : legals) {
      assertEquals(DocumentType.LEGAL, t.getType());
      System.out.println(t);
    }

    final Collection<DocumentTemplate> references = service.getAll(DocumentType.REFERENCE);
    assertTrue(references.size() > 0);
    for (final DocumentTemplate t : references) {
      assertEquals(DocumentType.REFERENCE, t.getType());
      System.out.println(t);
    }

    final Collection<DocumentTemplate> media = service.getAll(DocumentType.MEDIA);
    assertTrue(media.size() > 0);
    for (final DocumentTemplate t : media) {
      assertEquals(DocumentType.MEDIA, t.getType());
      System.out.println(t);
    }
  }

  @Test
  public void testGet() {
    final AppConfig config = new AppConfig(Application.CONTEXT_FILE);
    final DocumentTemplateService service = config.getBean(DocumentTemplateService.class);

    final DocumentTemplate journalArticle = service.get("journal-article");
    assertNotNull(journalArticle);
    assertEquals("journal-article", journalArticle.getName());
    assertEquals(DocumentType.ARTICLE, journalArticle.getType());

    final DocumentTemplate book = service.get("book");
    assertNotNull(book);
    assertEquals("book", book.getName());
    assertEquals(DocumentType.BOOK, book.getType());
  }
}
