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

import com.github.haixing_hu.ilibrary.model.City;

/**
 * The interface of the service for managing {@link City} objects.
 *
 * @author Haixing Hu
 */
public interface CityService {

  /**
   * Gets the city by its ID.
   *
   * @param id
   *          The ID of a city.
   * @return The city with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public City get(int id) throws DataAccessException;

  /**
   * Gets all the cities.
   *
   * @return The list of all the cities.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<City> getAll() throws DataAccessException;

  /**
   * Adds a new city.
   *
   * @param city
   *          The new city to add. After calling this function, the ID of this
   *          argument will be set to the automatically generated ID of the new
   *          city.
   * @return The automatically generated ID of the new city.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(City city) throws DataAccessException;

  /**
   * Updates an existing city.
   *
   * @param city
   *          The city to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(City city) throws DataAccessException;

  /**
   * Deletes the specified city.
   *
   * @param id
   *          The ID of the city to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified cities.
   *
   * @param ids
   *          The array of IDs of the cities to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;

  /**
   * Merges a list of old cities to a new city.
   *
   * @param oldCitys
   *          The list of old cities to be merged.
   * @param newCity
   *          The new city after merging. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new city.
   * @return The automatically generated ID of the new city.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int merge(List<City> oldCitys, City newCity)
      throws DataAccessException;

}
