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
 */package com.github.haixing_hu.ilibrary.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.criteria.Criterion;

/**
 * The class representing the collection of documents.
 *
 * @author Haixing Hu
 */
public final class DocumentCollection {

  private int id;
  private int parentId;
  private String name;
  private String description;
  private boolean smart;
  private Criterion criterion;

  public DocumentCollection() {
    id = - 1;
    parentId = - 1;
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
   * @param id
   *          the new id to set.
   */
  public void setId(final int id) {
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
   * @param parentId
   *          the new parentId to set.
   */
  public void setParentId(final int parentId) {
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
   * @param name
   *          the new name to set.
   */
  public void setName(final String name) {
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
   * @param description
   *          the new description to set.
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Tests whether this collection is a smart collection.
   *
   * @return {@code true} if this collection is a smart collection;
   *         {@code false} otherwise.
   */
  public boolean isSmart() {
    return smart;
  }

  /**
   * Sets whether this collection is a smart collection.
   *
   * @param smart
   *          {@code true} to set this collection to be a smart collection;
   *          {@code false} otherwise.
   */
  public void setSmart(final boolean smart) {
    this.smart = smart;
  }

  /**
   * Gets the criterion used to filter documents in this smart collection.
   *
   * @return the criterion used to filter documents in this smart collection
   */
  public Criterion getCriterion() {
    return criterion;
  }

  /**
   * Sets the criterion used to filter documents in this smart collection.
   *
   * @param criterion
   *          the new criterion to set.
   */
  public void setCriterion(final Criterion criterion) {
    this.criterion = criterion;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(final Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
