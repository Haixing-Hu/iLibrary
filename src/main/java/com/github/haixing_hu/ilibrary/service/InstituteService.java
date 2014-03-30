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

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.ilibrary.model.Institute;

/**
 * The interface of the service for managing {@link Institute} objects.
 *
 * @author Haixing Hu
 */
public interface InstituteService {

  /**
   * Gets the institute by its ID.
   *
   * @param id
   *          The ID of a institute.
   * @return The institute with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Institute get(int id) throws DataAccessException;

  /**
   * Gets all the institutes.
   *
   * @return The list of all the institutes.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Institute> getAll() throws DataAccessException;

  /**
   * Adds a new institute.
   *
   * @param institute
   *          The new institute to add. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new institute.
   * @return The automatically generated ID of the new institute.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Institute institute) throws DataAccessException;

  /**
   * Updates an existing institute.
   *
   * @param institute
   *          The institute to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Institute institute) throws DataAccessException;

  /**
   * Deletes the specified institute.
   *
   * @param id
   *          The ID of the institute to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified institutes.
   *
   * @param ids
   *          The array of IDs of the institutes to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;

  /**
   * Merges a list of old institutes to a new institute.
   *
   * @param oldInstitutes
   *          The list of old institutes to be merged.
   * @param newInstitute
   *          The new institute after merging. After calling this function, the
   *          ID of this argument will be set to the automatically generated ID
   *          of the new institute.
   * @return The automatically generated ID of the new institute.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int merge(List<Institute> oldInstitutes, Institute newInstitute)
      throws DataAccessException;

}
