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

import com.github.haixing_hu.ilibrary.model.tag.Tag;

/**
 * The interface of DAO of {@link Tag}.
 *
 * @author Haixing Hu
 */
public interface TagDao {

  /**
   * Gets the tag by its ID.
   *
   * @param id
   *          The ID of a tag.
   * @return The tag with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Tag get(int id) throws DataAccessException;

  /**
   * Gets the tag by its scope and name.
   *
   * @param scope
   *          The scope of the specified tag.
   * @param name
   *          The name of the specified tag.
   * @return The tag with the specified scope and name.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Tag getByScopeName(String scope, String name) throws DataAccessException;

  /**
   * Gets all the tags of a specified scope.
   *
   * @param scope
   *          The scope of the specified tags.
   * @return The list of tags with the specified scope.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Tag> getByScope(String scope) throws DataAccessException;

  /**
   * Gets all the tags.
   *
   * @return The list of all the tags.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Tag> getAll() throws DataAccessException;

  /**
   * Adds a new tag.
   *
   * @param tag
   *          The new tag to add. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new website.
   * @return The automatically generated ID of the new tag.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Tag tag) throws DataAccessException;

  /**
   * Updates an existing tag.
   *
   * @param tag
   *          The tag to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Tag tag) throws DataAccessException;

  /**
   * Deletes the specified tag.
   *
   * @param id
   *          The ID of the tag to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified tags.
   *
   * @param ids
   *          The array of IDs of the tags to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;
}
