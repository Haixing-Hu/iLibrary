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

import com.github.haixing_hu.ilibrary.model.Website;

/**
 * The interface of the service for managing {@link Website} objects.
 *
 * @author Haixing Hu
 */
public interface WebsiteService {

  /**
   * Gets the website by its ID.
   *
   * @param id
   *          The ID of a website.
   * @return The website with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Website get(int id) throws DataAccessException;

  /**
   * Gets all the websites.
   *
   * @return The list of all the websites.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Website> getAll() throws DataAccessException;

  /**
   * Adds a new website.
   *
   * @param website
   *          The new website to add. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new website.
   * @return The automatically generated ID of the new website.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Website website) throws DataAccessException;

  /**
   * Updates an existing website.
   *
   * @param website
   *          The website to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Website website) throws DataAccessException;

  /**
   * Deletes the specified website.
   *
   * @param id
   *          The ID of the website to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified websites.
   *
   * @param ids
   *          The array of IDs of the websites to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;

  /**
   * Merges a list of old websites to a new website.
   *
   * @param oldWebsites
   *          The list of old websites to be merged.
   * @param newWebsite
   *          The new website after merging. After calling this function, the
   *          ID of this argument will be set to the automatically generated ID
   *          of the new website.
   * @return The automatically generated ID of the new website.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int merge(List<Website> oldWebsites, Website newWebsite)
      throws DataAccessException;

}
