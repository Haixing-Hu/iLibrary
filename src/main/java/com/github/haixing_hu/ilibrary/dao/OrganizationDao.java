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

import com.github.haixing_hu.ilibrary.model.Organization;

/**
 * The interface for the DAO of {@link Organization}.
 *
 * @author Haixing Hu
 */
public interface OrganizationDao {

  /**
   * Gets the organization by its ID.
   *
   * @param id
   *          The ID of a organization.
   * @return The organization with the specified ID.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Organization get(int id) throws DataAccessException;

  /**
   * Gets the organization by its name.
   *
   * @param name
   *          The name of a organization.
   * @return The organization with the specified name.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public Organization getByName(String name) throws DataAccessException;

  /**
   * Gets all the organizations.
   *
   * @return The list of all the organizations.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public List<Organization> getAll() throws DataAccessException;

  /**
   * Adds a new organization.
   *
   * @param organization
   *          The new organization to add. After calling this function, the ID of
   *          this argument will be set to the automatically generated ID of the
   *          new organization.
   * @return The automatically generated ID of the new organization.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public int add(Organization organization) throws DataAccessException;

  /**
   * Updates an existing organization.
   *
   * @param organization
   *          The organization to be updated.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void update(Organization organization) throws DataAccessException;

  /**
   * Deletes the specified organization.
   *
   * @param id
   *          The ID of the organization to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int id) throws DataAccessException;

  /**
   * Deletes the specified organizations.
   *
   * @param ids
   *          The array of IDs of the organizations to be deleted.
   * @throws DataAccessException
   *           If any error occurs.
   */
  public void delete(int[] ids) throws DataAccessException;
}
