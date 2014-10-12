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
package com.github.haixing_hu.ilibrary.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.ilibrary.model.Country;

/**
 * The interface of the service for managing {@link Country} objects.
 *
 * @author Haixing Hu
 */
public interface CountryService {

  /**
   * Gets the country by its ID.
   *
   * @param id
   *          The ID of a country.
   * @return The country with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Country get(int id) throws DataAccessException;

  /**
   * Gets all the countries.
   *
   * @return The list of all the countries.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Country> getAll() throws DataAccessException;

  /**
   * Adds a new country.
   *
   * @param country
   *          The new country to add. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new country.
   * @return The automatically generated ID of the new country.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Country country) throws DataAccessException;

  /**
   * Updates an existing country.
   *
   * @param country
   *          The country to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Country country) throws DataAccessException;

  /**
   * Deletes the specified country.
   *
   * @param id
   *          The ID of the country to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified countries.
   *
   * @param ids
   *          The array of IDs of the countries to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;

  /**
   * Merges a list of old countries to a new country.
   *
   * @param oldCountrys
   *          The list of old countries to be merged.
   * @param newCountry
   *          The new country after merging. After calling this function, the ID
   *          of this argument will be set to the automatically generated ID of
   *          the new country.
   * @return The automatically generated ID of the new country.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int merge(List<Country> oldCountrys, Country newCountry)
      throws DataAccessException;

}
