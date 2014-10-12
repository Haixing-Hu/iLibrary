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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.csl.Variable;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The model of templates of fields.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "field")
public final class FieldTemplate {

  @XmlElement(required = true)
  private final String name;

  @XmlElement(required = true)
  private final FieldDataType type;

  @XmlElement(required = false)
  private final boolean multiple;

  @XmlElement(required = false)
  private final Variable variable;

  /**
   * Default Constructs a {@link FieldTemplate}.
   * <p>
   * This default constructor is presented for JAXB.
   */
  FieldTemplate() {
    name = StringUtils.EMPTY;
    type = FieldDataType.STRING;
    multiple = false;
    variable = null;
  }

  /**
   * Constructs a {@link FieldTemplate}.
   *
   * @param name
   *          the name of the field.
   * @param type
   *          the data type of the field.
   * @param multiple
   *          indicates whether the field can have multiple values.
   * @param variable
   *          the CSL standard variable corresponds to the field, or
   *          {@code null} if it has none.
   */
  public FieldTemplate(final String name, final FieldDataType type,
      final boolean multiple, @Nullable final Variable variable) {
    this.name = requireNonNull("name", name);
    this.type = requireNonNull("type", type);
    this.multiple = multiple;
    this.variable = variable;
  }

  /**
   * Gets the name of the field.
   *
   * @return the name of the field, which will never be {@code null}.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the data type of values of the field.
   *
   * @return the data type of values of the field, which will never be
   *         {@code null}.
   */
  public FieldDataType getType() {
    return type;
  }

  /**
   * Tests whether this field can have multiple values.
   * <p>
   * The default value of this property is {@code false}.
   *
   * @return {@code true} if this field can have multiple values; {@code false}
   *         otherwise.
   */
  public boolean isMultiple() {
    return multiple;
  }

  /**
   * Gets the CSL standard variable corresponds to the field.
   * <p>
   * The default value of this property is {@code null}.
   *
   * @return the CSL standard variable corresponds to the field, or {@code null}
   *         if it has none.
   */
  public Variable getVariable() {
    return variable;
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
