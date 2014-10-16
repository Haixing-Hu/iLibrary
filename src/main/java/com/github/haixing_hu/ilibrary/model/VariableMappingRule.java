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

import javax.annotation.concurrent.Immutable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.csl.Variable;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A {@link VariableMappingRule} represents a mapping from a CSL standard
 * variable to a field.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "expression")
@Immutable
public class VariableMappingRule {

  @XmlElement(required = true)
  private final Variable variable;

  @XmlElement(required = true)
  private final String field;

  /**
   * Default constructor.
   * <p>
   * This default constructor is presented for the JAXB.
   */
  VariableMappingRule() {
    variable = null;
    field = null;
  }

  /**
   * Constructs a {@link VariableMappingRule}.
   *
   * @param variable
   *          a CSL standard variable.
   * @param field
   *          the field corresponds to the CSL standard variable.
   */
  public VariableMappingRule(final Variable variable, final String field) {
    this.variable = requireNonNull("variable", variable);
    this.field = requireNonNull("field", field);
  }

  /**
   * Gets the CSL standard variable.
   *
   * @return the CSL standard variable.
   */
  public Variable getVariable() {
    return variable;
  }

  /**
   * Gets the field corresponds to the CSL standard variable.
   *
   * @return the field corresponds to the CSL standard variable.
   */
  public String getField() {
    return field;
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
