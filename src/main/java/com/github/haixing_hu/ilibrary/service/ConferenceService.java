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

import com.github.haixing_hu.ilibrary.model.Event;

/**
 * The interface of the service for managing {@link Event} objects.
 *
 * @author Haixing Hu
 */
public interface ConferenceService {

  /**
   * Gets the conference by its ID.
   *
   * @param id
   *          The ID of a conference.
   * @return The conference with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Event get(int id) throws DataAccessException;

  /**
   * Gets all the conferences.
   *
   * @return The list of all the conferences.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Event> getAll() throws DataAccessException;

  /**
   * Adds a new conference.
   *
   * @param conference
   *          The new conference to add. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new conference.
   * @return The automatically generated ID of the new conference.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Event conference) throws DataAccessException;

  /**
   * Updates an existing conference.
   *
   * @param conference
   *          The conference to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Event conference) throws DataAccessException;

  /**
   * Deletes the specified conference.
   *
   * @param id
   *          The ID of the conference to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified conferences.
   *
   * @param ids
   *          The array of IDs of the conferences to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;

  /**
   * Merges a list of old conferences to a new conference.
   *
   * @param oldConferences
   *          The list of old conferences to be merged.
   * @param newConference
   *          The new conference after merging. After calling this function, the
   *          ID of this argument will be set to the automatically generated ID
   *          of the new conference.
   * @return The automatically generated ID of the new conference.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int merge(List<Event> oldConferences, Event newConference)
      throws DataAccessException;

}
