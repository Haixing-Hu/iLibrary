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

import com.github.haixing_hu.ilibrary.model.DocumentTemplate;
import com.github.haixing_hu.ilibrary.model.DocumentType;

/**
 * The interface of the service for managing {@link DocumentTemplate} objects.
 *
 * @author Haixing Hu
 */
public interface DocumentTemplateService {

  /**
   * Gets all the document templates.
   *
   * @return The collection of all the document templates, or an empty
   *         collection if no document template.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Collection<DocumentTemplate> getAll() throws DataAccessException;

  /**
   * Gets all the document templates of a specified document type.
   *
   * @param type
   *          A type of documents.
   * @return The collection of all the document templates of the specified
   *         document type, or an empty collection if no such document template.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Collection<DocumentTemplate> getAll(DocumentType type)
      throws DataAccessException;

  /**
   * Gets the document template with a specified name.
   *
   * @param name
   *          The name of a document template.
   * @return The document template with the specified name, or null if no such
   *         document template.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public DocumentTemplate get(String name) throws DataAccessException;

}
