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

package com.github.haixing_hu.ilibrary.service.impl;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.ilibrary.model.FieldTemplate;
import com.github.haixing_hu.ilibrary.service.FieldTemplateService;

/**
 * Implements the {@link FieldTemplateService} interface.
 *
 * @author Haixing Hu
 */
public final class FieldTemplateServiceImpl implements FieldTemplateService {

  private final Logger logger;
  private final Map<String, FieldTemplate> templates;

  public FieldTemplateServiceImpl(String resourcePattern) {
    logger = LoggerFactory.getLogger(FieldTemplateServiceImpl.class);
    templates = new HashMap<String, FieldTemplate>();
    //  load all the field templates
    final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    try {
      final JAXBContext jaxbContext = JAXBContext.newInstance(FieldTemplate.class);
      final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      final Resource[] resources = resolver.getResources(resourcePattern);
      for (final Resource resource : resources) {
        final InputStream is = resource.getInputStream();
        final FieldTemplate field = (FieldTemplate) unmarshaller.unmarshal(is);
        templates.put(field.getName(), field);
      }
    } catch (final Exception e) {
      logger.error("Failed to load the fild templates from: {}", resourcePattern, e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public Collection<FieldTemplate> getAll() throws DataAccessException {
    return templates.values();
  }

  @Override
  public FieldTemplate get(String name) throws DataAccessException {
    return templates.get(name);
  }

}
