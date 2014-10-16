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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The model of templates of field groups.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "group")
public final class FieldGroupTemplate {

  @XmlAttribute(name = "name", required = true)
  private final FieldGroup group;

  @XmlElement(name = "field")
  private final List<FieldTemplate> fields;

  /**
   * Default constructor for JAXB.
   */
  FieldGroupTemplate() {
    group = null;
    fields = null;
  }

  /**
   * Constructs a {@link FieldGroupTemplate}.
   *
   * @param group
   *          the field group.
   * @param fields
   *          the list of fields in this grou.
   */
  public FieldGroupTemplate(final FieldGroup group,
      final List<FieldTemplate> fields) {
    this.group = requireNonNull("group", group);
    this.fields = requireNonNull("fields", fields);
  }

  /**
   * Gets the field group.
   *
   * @return the field group.
   */
  public FieldGroup getGroup() {
    return group;
  }

  /**
   * Gets the fields in this field group.
   *
   * @return the fields in this field group.
   */
  public List<FieldTemplate> getFields() {
    return fields;
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
