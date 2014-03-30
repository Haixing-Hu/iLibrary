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

import com.github.haixing_hu.ilibrary.model.Periodical;

/**
 * The interface for the DAO of {@link Periodical}.
 *
 * @author Haixing Hu
 */
public interface PeriodicalDao {

  /**
   * Gets the periodical by its ID.
   *
   * @param id
   *          The ID of a periodical.
   * @return The periodical with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Periodical get(int id) throws DataAccessException;

  /**
   * Gets the periodical by its name.
   *
   * @param name
   *          The name of a periodical.
   * @return The periodical with the specified name.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Periodical getByName(String name) throws DataAccessException;

  /**
   * Gets all the periodicals.
   *
   * @return The list of all the periodicals.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Periodical> getAll() throws DataAccessException;

  /**
   * Adds a new periodical.
   *
   * @param periodical
   *          The new periodical to add. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new periodical.
   * @return The automatically generated ID of the new periodical.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Periodical periodical) throws DataAccessException;

  /**
   * Updates an existing periodical.
   *
   * @param periodical
   *          The periodical to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Periodical periodical) throws DataAccessException;

  /**
   * Deletes the specified periodical.
   *
   * @param id
   *          The ID of the periodical to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified periodicals.
   *
   * @param ids
   *          The array of IDs of the periodicals to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;
}
