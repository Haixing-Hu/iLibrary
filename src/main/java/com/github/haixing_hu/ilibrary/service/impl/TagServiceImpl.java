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

package com.github.haixing_hu.ilibrary.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.github.haixing_hu.collection.tree.Tree;
import com.github.haixing_hu.ilibrary.model.tag.Tag;
import com.github.haixing_hu.ilibrary.service.TagService;

/**
 * The implementation of the {@link TagService}.
 *
 * @author Haixing Hu
 */
public class TagServiceImpl implements TagService {

  @Override
  public Tag get(int id) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Tag> get(int[] ids) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Tag get(String scope, String name) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Tag> get(String scope, String[] names) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Tag> getAll(String scope) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Tag> getAll() throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Tag> getRoots(String scope) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Tree<Long, Tag>> getForest(String scope)
      throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Tag> getChildren(Tag parent) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Tree<Long, Tag> getSubTree(Tag root) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void add(Tag tag) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void add(Collection<Tag> tags) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Tag tag) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Collection<Tag> tags) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Tag tag) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Collection<Tag> tags) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteDescendants(Tag tag) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteDecendants(Collection<Tag> roots)
      throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteAll(String scope) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteAll() throws DataAccessException {
    // TODO Auto-generated method stub

  }

}
