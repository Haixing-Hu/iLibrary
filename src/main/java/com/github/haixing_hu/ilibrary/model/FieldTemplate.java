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

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The model of templates of fields.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "field")
public final class FieldTemplate {

  @XmlAttribute(name = "name", required = true)
  private final String name;

  @XmlAttribute(name = "type", required = true)
  private final DataType type;

  @XmlAttribute(name = "multiple", required = false)
  private final boolean multiple;

  /**
   * Default Constructs a {@link FieldTemplate}.
   * <p>
   * This default constructor is presented for JAXB.
   */
  FieldTemplate() {
    name = StringUtils.EMPTY;
    type = DataType.STRING;
    multiple = false;
  }

  /**
   * Constructs a {@link FieldTemplate}.
   *
   * @param name
   *          the name of the fieldType.
   * @param type
   *          the data type of the field.
   * @param multiple
   *          indicates whether the fieldType can have multiple values.
   */
  public FieldTemplate(final String name, final DataType type,
      final boolean multiple) {
    this.name = requireNonNull("name", name);
    this.type = requireNonNull("type", type);
    this.multiple = multiple;
  }

  /**
   * Gets the name of the fieldType.
   *
   * @return the name of the fieldType, which will never be {@code null}.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the data type of values of the fieldType.
   *
   * @return the data type of values of the fieldType, which will never be
   *         {@code null}.
   */
  public DataType getType() {
    return type;
  }

  /**
   * Tests whether this fieldType can have multiple values.
   * <p>
   * The default value of this property is {@code false}.
   *
   * @return {@code true} if this fieldType can have multiple values;
   *         {@code false} otherwise.
   */
  public boolean isMultiple() {
    return multiple;
  }

  /**
   * Gets the dynamic property for the fields defined by this template.
   *
   * @return the dynamic property for the fields defined by this template.
   */
  public DynaProperty toDynaProperty() {
    if (multiple) {
      return new DynaProperty(name, List.class, type.toClass());
    } else {
      return new DynaProperty(name, type.toClass());
    }
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
