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

import com.github.haixing_hu.ilibrary.model.Person;

/**
 * The interface of the service for managing {@link Person} objects.
 *
 * @author Haixing Hu
 */
public interface PersonService {

  /**
   * Gets the person by its ID.
   *
   * @param id
   *          The ID of a person.
   * @return The person with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Person get(int id) throws DataAccessException;

  /**
   * Gets all the persons.
   *
   * @return The list of all the persons.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Person> getAll() throws DataAccessException;

  /**
   * Adds a new person.
   *
   * @param person
   *          The new person to add. After calling this function, the ID of this
   *          argument will be set to the automatically generated ID of the new
   *          person.
   * @return The automatically generated ID of the new person.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Person person) throws DataAccessException;

  /**
   * Updates an existing person.
   *
   * @param person
   *          The person to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Person person) throws DataAccessException;

  /**
   * Deletes the specified person.
   *
   * @param id
   *          The ID of the person to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified persons.
   *
   * @param ids
   *          The array of IDs of the persons to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;

  /**
   * Merges a list of old persons to a new person.
   *
   * @param oldPersons
   *          The list of old persons to be merged.
   * @param newPerson
   *          The new person after merging. After calling this function, the ID
   *          of this argument will be set to the automatically generated ID of
   *          the new person.
   * @return The automatically generated ID of the new person.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int merge(List<Person> oldPersons, Person newPerson)
      throws DataAccessException;

}
