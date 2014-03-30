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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

import static com.github.haixing_hu.ilibrary.utils.Argument.requireNonNull;

/**
 * The template of a field.
 *
 * @author Haixing Hu
 */
@Root(name="field")
public class FieldTemplate {

  @Attribute(required = false)
  private int id;

  @Element
  private String name;

  @Element
  private DataType type;

  @Attribute
  private boolean list;

  @Attribute
  private boolean required;

  @ElementMap(entry = "display-name",
              key = "locale",
              attribute = true,
              inline = true,
              required = false)
  private Map<String, String> displayNames;

  /**
   * Default Constructs a {@link FieldTemplate}.
   */
  public FieldTemplate() {
    id = - 1;
    name = null;
    type = DataType.STRING;
    list = false;
    required = false;
    displayNames = new HashMap<String, String>();
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
  public DataType getType() {
    return type;
  }

  /**
   * Sets the type of the value of this field.
   *
   * @param type
   *          the new type to set, which cannot be <code>null</code>.
   */
  public void setType(DataType type) {
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
   * Gets the map from the locale to the corresponding display name.
   *
   * @return the map from the locale to the corresponding display name, which
   *         will never be <code>null</code>.
   */
  public Map<String, String> getDisplayNames() {
    return displayNames;
  }

  /**
   * Sets the map from the locale to the corresponding display name.
   *
   * @param displayNames
   *          the new map from the locale to the corresponding display name to
   *          set, which cannot be <code>null</code>.
   */
  public void setDisplayNames(Map<String, String> displayNames) {
    this.displayNames = requireNonNull("displayNames", displayNames);
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
