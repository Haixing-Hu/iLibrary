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
package com.github.haixing_hu.ilibrary.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.ilibrary.model.DocumentTemplate;
import com.github.haixing_hu.ilibrary.model.DocumentType;
import com.github.haixing_hu.ilibrary.service.DocumentTemplateService;

/**
 * Implements the {@link DocumentTemplateService} interface.
 *
 * @author Haixing Hu
 */
public final class DocumentTemplateServiceImpl implements DocumentTemplateService {

  private final Logger logger;
  private final Map<String, DocumentTemplate> templates;

  public DocumentTemplateServiceImpl(final String resourcePattern) {
    logger = LoggerFactory.getLogger(DocumentTemplateServiceImpl.class);
    templates = new HashMap<String, DocumentTemplate>();
    //  load all the field templates
    final PathMatchingResourcePatternResolver resolver =
        new PathMatchingResourcePatternResolver();
    try {
      final JAXBContext context =
          JAXBContext.newInstance(DocumentTemplate.class);
      final Unmarshaller unmarshaller = context.createUnmarshaller();
      final Resource[] resources = resolver.getResources(resourcePattern);
      for (final Resource resource : resources) {
        final InputStream is = resource.getInputStream();
        final DocumentTemplate document =
            (DocumentTemplate) unmarshaller.unmarshal(is);
        templates.put(document.getName(), document);
      }
    } catch (final Exception e) {
      logger.error("Failed to load the document templates from: {}",
          resourcePattern, e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public Collection<DocumentTemplate> getAll() throws DataAccessException {
    return templates.values();
  }

  @Override
  public Collection<DocumentTemplate> getAll(final DocumentType type)
      throws DataAccessException {
    final List<DocumentTemplate> result = new ArrayList<DocumentTemplate>();
    for (final DocumentTemplate template : templates.values()) {
      if (template.getType() == type) {
        result.add(template);
      }
    }
    return result;
  }

  @Override
  public DocumentTemplate get(final String name) throws DataAccessException {
    return templates.get(name);
  }

}
