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
 * See the License for the specific event governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.ilibrary.model.Event;

/**
 * The interface for the DAO of {@link Event}.
 *
 * @author Haixing Hu
 */
public interface EventDao {

  /**
   * Gets the event by its ID.
   *
   * @param id
   *          The ID of a event.
   * @return The event with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Event get(int id) throws DataAccessException;

  /**
   * Gets all the events.
   *
   * @return The list of all the events.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Event> getAll() throws DataAccessException;

  /**
   * Adds a new event.
   *
   * @param event
   *          The new event to add. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new event.
   * @return The automatically generated ID of the new event.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Event event) throws DataAccessException;

  /**
   * Updates an existing event.
   *
   * @param event
   *          The event to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Event event) throws DataAccessException;

  /**
   * Deletes the specified event.
   *
   * @param id
   *          The ID of the event to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified events.
   *
   * @param ids
   *          The array of IDs of the events to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;
}
