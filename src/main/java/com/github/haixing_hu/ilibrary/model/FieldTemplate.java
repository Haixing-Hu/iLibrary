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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The model of templates of fields.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="field")
public final class FieldTemplate {

  @XmlElement(required=true)
  private String name;

  @XmlElement(required=true)
  private FieldDataType type;

  @XmlAttribute
  private boolean required;

  @XmlAttribute
  private boolean list;

  /**
   * Default Constructs a {@link FieldTemplate}.
   */
  public FieldTemplate() {
    name = null;
    type = FieldDataType.STRING;
    required = false;
    list = false;
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
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the type of the value of this field.
   *
   * @return the type of the value of this field, which will never be
   *         <code>null</code>.
   */
  public FieldDataType getType() {
    return type;
  }

  /**
   * Sets the type of the value of this field.
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
   * Gets the required.
   *
   * @return the required.
   */
  public boolean isRequired() {
    return required;
  }

  /**
   * Sets the required.
   *
   * @param required
   *          the new required to set.
   */
  public void setRequired(boolean required) {
    this.required = required;
  }

  /**
   * Creates a new field from this field template.
   *
   * @return a new field from this field template, whose value is kept
   *         <code>null</code>.
   */
  public Field newField() {
    return new Field(name, type, list);
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