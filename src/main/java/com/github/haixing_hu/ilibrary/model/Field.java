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
package com.github.haixing_hu.ilibrary.model;

import javax.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The field of a document.
 *
 * @author Haixing Hu
 */
public final class Field {

  private int id;
  private FieldTemplate template;
  private Object value;
  private String rawValue;

  /**
   * Default constructs a {@link Field}.
   */
  public Field() {
    id = - 1;
    template = null;
    value = null;
    rawValue = null;
  }

  /**
   * Constructs a {@link Field}.
   *
   * @param name
   *          the name of the new filed.
   * @param template
   *          the template of the new field.
   */
  public Field(final String name, final FieldTemplate template) {
    id = - 1;
    this.template = requireNonNull("template", template);
    value = null;
  }

  /**
   * Constructs a {@link Field}.
   *
   * @param name
   *          the name of the new filed.
   * @param template
   *          the template of the new field.
   * @param value
   *          the value of the new field, or {@code null} if the new field has
   *          no value.
   */
  public Field(final String name, final FieldTemplate template, @Nullable final Object value) {
    id = - 1;
    this.template = requireNonNull("template", template);
    this.value = value;
    rawValue = null;
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
   * Gets the template of this field.
   *
   * @return the template of this field.
   */
  public FieldTemplate getTemplate() {
    return template;
  }

  /**
   * Sets the template of this field.
   *
   * @param template
   *          the new template to set, which cannot be {@code null}.
   */
  public void setTemplate(final FieldTemplate template) {
    this.template = requireNonNull("template", template);
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
   *          the new value to set, which can be {@code null}.
   */
  public void setValue(@Nullable final Object value) {
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
  public void setRawValue(@Nullable final String rawValue) {
    this.rawValue = rawValue;
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
