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
 * See the License for the specific country governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.ilibrary.model.Country;

/**
 * The interface for the DAO of {@link Country}.
 *
 * @author Haixing Hu
 */
public interface CountryDao {

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
   * Gets the country by its code.
   *
   * @param code
   *          The code of a country.
   * @return The country with the specified code.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Country getByCode(String code) throws DataAccessException;

  /**
   * Gets the country by its name.
   *
   * @param name
   *          The name of a country.
   * @return The country with the specified name.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Country getByName(String name) throws DataAccessException;

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
}
