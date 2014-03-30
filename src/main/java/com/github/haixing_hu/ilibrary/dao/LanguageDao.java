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

package com.github.haixing_hu.ilibrary.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.ilibrary.model.Language;

/**
 * The interface for the DAO of {@link Language}.
 *
 * @author Haixing Hu
 */
public interface LanguageDao {

  /**
   * Gets the language by its ID.
   *
   * @param id
   *          The ID of a language.
   * @return The language with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Language get(int id) throws DataAccessException;

  /**
   * Gets the language by its code.
   *
   * @param code
   *          The code of a language.
   * @return The language with the specified code.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Language getByCode(String code) throws DataAccessException;

  /**
   * Gets the language by its name.
   *
   * @param name
   *          The name of a language.
   * @return The language with the specified name.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Language getByName(String name) throws DataAccessException;

  /**
   * Gets all the languages.
   *
   * @return The list of all the languages.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Language> getAll() throws DataAccessException;

  /**
   * Adds a new language.
   *
   * @param language
   *          The new language to add. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new language.
   * @return The automatically generated ID of the new language.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Language language) throws DataAccessException;

  /**
   * Updates an existing language.
   *
   * @param language
   *          The language to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Language language) throws DataAccessException;

  /**
   * Deletes the specified language.
   *
   * @param id
   *          The ID of the language to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified languages.
   *
   * @param ids
   *          The array of IDs of the languages to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;
}
