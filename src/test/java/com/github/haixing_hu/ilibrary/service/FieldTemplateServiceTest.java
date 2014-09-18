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

package com.github.haixing_hu.ilibrary.service;

import java.util.Collection;

import org.junit.Test;

import com.github.haixing_hu.ilibrary.AppConfig;
import com.github.haixing_hu.ilibrary.Application;
import com.github.haixing_hu.ilibrary.model.FieldDataType;
import com.github.haixing_hu.ilibrary.model.FieldTemplate;

import static org.junit.Assert.*;

/**
 * The unit test of the implementation of the {@link FieldTemplateService}
 * interface.
 *
 * @author Haixing Hu
 */
public class FieldTemplateServiceTest {

  @Test
  public void testGetAll() {
    final AppConfig config = new AppConfig(Application.CONTEXT_FILE);
    final FieldTemplateService service = config.getBean(FieldTemplateService.class);
    final Collection<FieldTemplate> templates = service.getAll();
    assertTrue(templates.size() > 0);
    for (final FieldTemplate template : templates) {
      System.out.println(template);
    }
  }


  @Test
  public void testGet() {
    final AppConfig config = new AppConfig(Application.CONTEXT_FILE);
    final FieldTemplateService service = config.getBean(FieldTemplateService.class);

    final FieldTemplate title = service.get("title");
    assertNotNull(title);
    assertEquals("title", title.getName());
    assertEquals(FieldDataType.STRING, title.getType());
    assertEquals(false, title.isList());

    final FieldTemplate authors = service.get("authors");
    assertNotNull(authors);
    assertEquals("authors", authors.getName());
    assertEquals(FieldDataType.RESPONSIBILITY, authors.getType());
    assertEquals(true, authors.isList());
  }
}
