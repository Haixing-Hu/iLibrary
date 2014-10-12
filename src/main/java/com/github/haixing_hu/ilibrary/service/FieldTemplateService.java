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

import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.ilibrary.model.FieldTemplate;

/**
 * The interface of the service for managing {@link FieldTemplate} objects.
 *
 * @author Haixing Hu
 */
public interface FieldTemplateService {

  /**
   * Gets all the field templates.
   *
   * @return The collection of all the field templates, or an empty collection
   *         if no field template.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Collection<FieldTemplate> getAll() throws DataAccessException;

  /**
   * Gets the field template with a specified name.
   *
   * @param name
   *          The name of a field template.
   * @return The field template with the specified name, or null if no such
   *         field template.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public FieldTemplate get(String name) throws DataAccessException;
}
