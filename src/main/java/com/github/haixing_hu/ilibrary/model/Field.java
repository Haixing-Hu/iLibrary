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

import javax.annotation.Nullable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The field of a document.
 *
 * @author Haixing Hu
 */
public final class Field {

  private int id;
  private String name;
  private FieldDataType type;
  private boolean list;
  private Object value;
  private String rawValue;

  /**
   * Default constructs a {@link Field}.
   */
  public Field() {
    this.id = - 1;
    this.name = "";
    this.type = FieldDataType.STRING;
    this.list = false;
    this.value = null;
    this.rawValue = null;
  }

  /**
   * Constructs a {@link Field}.
   *
   * @param name
   *          the name of the new filed.
   * @param type
   *          the type of the new field.
   */
  public Field(String name, FieldDataType type) {
    this.id = - 1;
    this.name = requireNonNull("name", name);
    this.type = requireNonNull("type", type);
    this.value = null;
  }

  /**
   * Constructs a {@link Field}.
   *
   * @param name
   *          the name of the new filed.
   * @param type
   *          the type of the new field.
   * @param list
   *          indicates whether this field has a list of values.
   */
  public Field(String name, FieldDataType type, boolean list) {
    this.id = - 1;
    this.name = requireNonNull("name", name);
    this.type = requireNonNull("type", type);
    this.value = null;
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
  public void setId(int id) {
    this.id = id;
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
   *          the new name to set, which cannot be <code>null</code>.
   */
  public void setName(String name) {
    this.name = requireNonNull("name", name);
  }

  /**
   * Gets the type.
   *
   * @return the type.
   */
  public FieldDataType getType() {
    return type;
  }

  /**
   * Sets the type.
   *
   * @param type
   *          the new type to set, which cannot be <code>null</code>.
   */
  public void setType(FieldDataType type) {
    this.type = requireNonNull("type", type);
  }

  /**
   * Tests whether this field has a list of values.
   *
   * @return <code>true</code> if this field has a list of values;
   *         <code>false</code> otherwise.
   */
  public boolean isList() {
    return list;
  }

  /**
   * Sets whether this field has a list of values.
   *
   * @param list
   *          <code>true</code> if this field has a list of values;
   *          <code>false</code> otherwise.
   */
  public void setList(boolean list) {
    this.list = list;
  }

  /**
   * Gets the value.
   *
   * @return the value.
   */
  public Object getValue() {
    return value;
  }

  /**
   * Sets the value.
   *
   * @param value
   *          the new value to set, which can be <code>null</code>.
   */
  public void setValue(@Nullable Object value) {
    this.value = value;
  }


  /**
   * Gets the rawValue.
   *
   * @return the rawValue.
   */
  public String getRawValue() {
    return rawValue;
  }

  /**
   * Sets the rawValue.
   *
   * @param rawValue the new rawValue to set.
   */
  public void setRawValue(@Nullable String rawValue) {
    this.rawValue = rawValue;
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
