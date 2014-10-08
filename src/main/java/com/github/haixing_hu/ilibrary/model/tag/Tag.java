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

package com.github.haixing_hu.ilibrary.model.tag;

import com.github.haixing_hu.lang.Equality;
import com.github.haixing_hu.lang.Hash;
import com.github.haixing_hu.text.tostring.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonEmpty;

/**
 * The model of tag, which store the information of a tag.
 *
 * @author Haixing Hu
 */
public class Tag {

  protected int id;
  protected String scope;
  protected String name;
  protected int parentId;

  /**
   * Default constructs a {@link Tag}, whose scope and name
   * are both the {@link TagScope#UNKNOWN.name()}.
   */
  public Tag() {
    id = - 1;
    scope = TagScope.UNKNOWN.name();
    name = TagScope.UNKNOWN.name();
    parentId = - 1;
  }

  /**
   * Constructs a {@link Tag}.
   *
   * @param scope
   *          the scope of the new tag, which cannot be <code>null</code> nor
   *          empty.
   * @param name
   *          the name of the new tag, which cannot be <code>null</code> nor
   *          empty.
   */
  public Tag(String scope, String name) {
    id = - 1;
    this.scope = requireNonEmpty("scope", scope);
    this.name = requireNonEmpty("name", name);
    parentId = - 1;
  }

  /**
   * Constructs a {@link Tag}.
   *
   * @param scope
   *          the scope of the new tag, which cannot be <code>null</code> nor
   *          empty.
   * @param name
   *          the name of the new tag, which cannot be <code>null</code> nor
   *          empty.
   * @param parentId
   *          the ID of the parent of the new tag.
   */
  public Tag(String scope, String name, int parentId) {
    id = - 1;
    this.scope = requireNonEmpty("scope", scope);
    this.name = requireNonEmpty("name", name);
    this.parentId = parentId;
  }

  /**
   * Gets the ID.
   *
   * @return the ID.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the ID.
   *
   * @param id
   *          the new ID to set.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the scope.
   *
   * @return the scope.
   */
  public String getScope() {
    return scope;
  }

  /**
   * Sets the scope.
   *
   * @param scope
   *          the new scope to set, which cannot be <code>null</code> nor empty.
   */
  public void setScope(String scope) {
    this.scope = requireNonEmpty("scope", scope);
  }

  /**
   * Gets the name.
   *
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name
   *          the new name to set, which cannot be <code>null</code> nor empty.
   */
  public void setName(String name) {
    this.name = requireNonEmpty("name", name);
  }

  /**
   * Gets the parent ID.
   *
   * @return the parent ID.
   */
  public int getParentId() {
    return parentId;
  }

  /**
   * Sets the parent ID.
   *
   * @param parentId
   *          the new parent ID to set.
   */
  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  @Override
  public int hashCode() {
    int code = 7;
    final int multiplier = 3;
    code = Hash.combine(code, multiplier, id);
    code = Hash.combine(code, multiplier, scope);
    code = Hash.combine(code, multiplier, name);
    code = Hash.combine(code, multiplier, parentId);
    return code;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (! (obj instanceof Tag)) {
      return false;
    }
    final Tag other = (Tag) obj;
    return (id == other.id)
        && (parentId == other.parentId)
        && Equality.equals(scope, other.scope)
        && Equality.equals(name, other.name);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
                .append("id", id)
                .append("scope", scope)
                .append("name", name)
                .append("parentId", parentId)
                .toString();
  }
}
