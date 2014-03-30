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

import com.github.haixing_hu.ilibrary.model.Publisher;

/**
 * The interface of the service for managing {@link Publisher} objects.
 *
 * @author Haixing Hu
 */
public interface PublisherService {

  /**
   * Gets the publisher by its ID.
   *
   * @param id
   *          The ID of a publisher.
   * @return The publisher with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Publisher get(int id) throws DataAccessException;

  /**
   * Gets all the publishers.
   *
   * @return The list of all the publishers.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Publisher> getAll() throws DataAccessException;

  /**
   * Adds a new publisher.
   *
   * @param publisher
   *          The new publisher to add. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new publisher.
   * @return The automatically generated ID of the new publisher.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Publisher publisher) throws DataAccessException;

  /**
   * Updates an existing publisher.
   *
   * @param publisher
   *          The publisher to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Publisher publisher) throws DataAccessException;

  /**
   * Deletes the specified publisher.
   *
   * @param id
   *          The ID of the publisher to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified publishers.
   *
   * @param ids
   *          The array of IDs of the publishers to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;

  /**
   * Merges a list of old publishers to a new publisher.
   *
   * @param oldPublishers
   *          The list of old publishers to be merged.
   * @param newPublisher
   *          The new publisher after merging. After calling this function, the
   *          ID of this argument will be set to the automatically generated ID
   *          of the new publisher.
   * @return The automatically generated ID of the new publisher.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int merge(List<Publisher> oldPublishers, Publisher newPublisher)
      throws DataAccessException;

}
