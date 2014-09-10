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

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.collection.tree.Tree;
import com.github.haixing_hu.ilibrary.model.tag.Tag;

/**
 * The interface of the service for managing the {@link Tag} objects.
 *
 * @author Haixing Hu
 */
public interface TagService {

  /**
   * Gets the {@link Tag} object with the specified ID.
   *
   * @param id
   *          The ID of the tag to be get.
   * @return The {@link Tag} object with the specified ID, or null if no such
   *         object.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public Tag get(int id) throws DataAccessException;

  /**
   * Gets the list of {@link Tag} objects with the specified list of IDs.
   *
   * @param ids
   *          The array of IDs of the tags to be get.
   * @return The list of {@link Tag} objects with the specified IDs; if any ID
   *         has no corresponding {@link Tag} object, the corresponding object
   *         in the returned list is null.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public List<Tag> get(int[] ids) throws DataAccessException;

  /**
   * Gets the {@link Tag} object in the specified scope and with the specified
   * name.
   *
   * @param scope
   *          The scope of the {@link Tag} object to be get.
   * @param name
   *          The name of the {@link Tag} object to be get.
   * @return The {@link Tag} object in the specified scope and with the
   *         specified name, or null if no such object.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public Tag get(String scope, String name) throws DataAccessException;

  /**
   * Gets the list of {@link Tag} objects in the specified scope and with the
   * specified list of names.
   *
   * @param scope
   *          The scope of the {@link Tag} objects to be get.
   * @param names
   *          The array of names of the {@link Tag} objects to be get.
   * @return The list of {@link Tag} objects in the specified scope and with the
   *         specified names; if any name has no corresponding {@link Tag}
   *         object, the corresponding object in the returned list is null.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public List<Tag> get(String scope, String[] names)
      throws DataAccessException;

  /**
   * Gets all {@link Tag} objects in the specified scope.
   *
   * @param scope
   *          The scope of the {@link Tag} objects to be get.
   * @return The list of all {@link Tag} objects in the specified scope; returns
   *         an empty list if no {@link Tag} object in the specified scope.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public List<Tag> getAll(String scope) throws DataAccessException;

  /**
   * Gets all {@link Tag} objects.
   *
   * @return The list of all {@link Tag} objects; returns an empty list if no
   *         {@link Tag} object.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public List<Tag> getAll() throws DataAccessException;

  /**
   * Gets all root {@link Tag} objects in the specified scope.
   *
   * @param scope
   *          The scope of the {@link Tag} objects to be get.
   * @return The list of all root {@link Tag} objects in the specified scope.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public List<Tag> getRoots(String scope) throws DataAccessException;

  /**
   * Gets all {@link Tag} forests in the specified scope.
   *
   * @param scope
   *          The scope of the {@link Tag} objects to be get.
   * @return The list of all {@link Tag} forests in the specified scope.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public List<Tree<Long, Tag>> getForest(String scope)
      throws DataAccessException;

  /**
   * Gets the list of all children {@link Tag} objects of a specified parent
   * {@link Tag} object.
   *
   * @param parent
   *          The parent {@link Tag} object.
   * @return The list of all children {@link Tag} objects of the specified
   *         parent {@link Tag} object; returns an empty list if the specified
   *         parent {@link Tag} object does not exists or if it exists but has
   *         no child.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public List<Tag> getChildren(Tag parent) throws DataAccessException;

  /**
   * Gets the subtree of all descendants {@link Tag} objects of a specified root
   * {@link Tag} object.
   *
   * @param root
   *          The root {@link Tag} object.
   * @return The subtree of all descendants {@link Tag} objects of the specified
   *         root {@link Tag} object; returns null if the specified parent
   *         {@link Tag} object does not exists or if it exists but has no
   *         descendant.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public Tree<Long, Tag> getSubTree(Tag root) throws DataAccessException;

  /**
   * Adds a new {@link Tag} object.
   *
   * @param tag
   *          The {@link Tag} object to be add. After calling this function, the
   *          ID of this argument will be set to a system allocated unique ID.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public void add(Tag tag) throws DataAccessException;

  /**
   * Adds a collection of new {@link Tag} objects.
   *
   * @param tags
   *          The collection of {@link Tag} objects to be add. After calling
   *          this function, the ID of every element of this argument will be
   *          set to a system allocated unique ID.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public void add(Collection<Tag> tags) throws DataAccessException;

  /**
   * Updates a {@link Tag} object.
   *
   * @param tag
   *          The {@link Tag} object to be updated. Its ID must be set correctly
   *          before calling this function, and the function will use its ID to
   *          identify the old {@link Tag} object to be updated.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public void update(Tag tag) throws DataAccessException;

  /**
   * Updates a collection of {@link Tag} object.
   *
   * @param tags
   *          The collection of {@link Tag} objects to be updated. Their IDs
   *          must be set correctly before calling this function, and the
   *          function will use their IDs to identify the old {@link Tag} object
   *          to be updated.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public void update(Collection<Tag> tags) throws DataAccessException;

  /**
   * Deletes a {@link Tag} object.
   *
   * @param tag
   *          The I{@link Tag} object to be deleted.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public void delete(Tag tag) throws DataAccessException;

  /**
   * Deletes a collection of {@link Tag} objects.
   *
   * @param tags
   *          The collection of the {@link Tag} objects to be deleted.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public void delete(Collection<Tag> tags) throws DataAccessException;

  /**
   * Deletes all descendants {@link Tag} object of a root {@link Tag} object.
   * <p>
   * Note that after calling this function, the root {@link Tag} object itself
   * will NOT be deleted, instead, all its descendants {@link Tag} objects will
   * be deleted.
   * </p>
   *
   * @param tag
   *          The root {@link Tag} object.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public void deleteDescendants(Tag tag) throws DataAccessException;

  /**
   * Deletes all descendants {@link Tag} object of a collection of root
   * {@link Tag} object.
   * <p>
   * Note that after calling this function, the root {@link Tag} object itself
   * will NOT be deleted, instead, all its descendants {@link Tag} objects will
   * be deleted.
   * </p>
   *
   * @param roots
   *          The collection of the root {@link Tag} objects.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public void deleteDecendants(Collection<Tag> roots)
      throws DataAccessException;

  /**
   * Deletes all {@link Tag} objects in a specified scope.
   *
   * @param scope
   *          The scope of the {@link Tag} objects to be deleted.
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public void deleteAll(String scope) throws DataAccessException;

  /**
   * Deletes all {@link Tag} objects.
   *
   * @throws DataAccessException
   *           If any data access error occurred.
   */
  public void deleteAll() throws DataAccessException;
}
