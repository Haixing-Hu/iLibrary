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
package com.github.haixing_hu.ilibrary.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.ilibrary.model.Website;

/**
 * The interface for the DAO of {@link Website}.
 *
 * @author Haixing Hu
 */
public interface WebsiteDao {

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
   * Gets the website by its URL.
   *
   * @param url
   *          The URL of a website.
   * @return The website with the specified URL.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Website getByUrl(String url) throws DataAccessException;

  /**
   * Gets the website by its name.
   *
   * @param name
   *          The name of a website.
   * @return The website with the specified name.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Website getByName(String name) throws DataAccessException;

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
}
