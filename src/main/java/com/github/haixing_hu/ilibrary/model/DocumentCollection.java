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
package com.github.haixing_hu.ilibrary.model;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.github.haixing_hu.criteria.Criterion;

/**
 * The class representing the collection of documents.
 *
 * @author Haixing Hu
 */
public class DocumentCollection {

  private int id;
  private int parentId;
  private String name;
  private String description;
  private boolean smart;
  private Criterion criterion;

  public DocumentCollection() {
    id = -1;
    parentId = -1;
    name = StringUtils.EMPTY;
    description = StringUtils.EMPTY;
    smart = false;
    criterion = null;
  }

  /**
   * Gets the id.
   *
   * @return the id.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id to set.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the parentId.
   *
   * @return the parentId.
   */
  public int getParentId() {
    return parentId;
  }

  /**
   * Sets the parentId.
   *
   * @param parentId the new parentId to set.
   */
  public void setParentId(int parentId) {
    this.parentId = parentId;
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
   * @param name the new name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the description.
   *
   * @return the description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description the new description to set.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets the smart.
   *
   * @return the smart.
   */
  public boolean isSmart() {
    return smart;
  }

  /**
   * Sets the smart.
   *
   * @param smart the new smart to set.
   */
  public void setSmart(boolean smart) {
    this.smart = smart;
  }

  /**
   * Gets the criterion.
   *
   * @return the criterion.
   */
  public Criterion getCriterion() {
    return criterion;
  }

  /**
   * Sets the criterion.
   *
   * @param criterion the new criterion to set.
   */
  public void setCriterion(Criterion criterion) {
    this.criterion = criterion;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
