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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The model of responsibilities.
 * <p>
 * A responsibility is either a person, or an institute.
 *
 * @author Haixing Hu
 */
public final class Responsibility {

  private Person person;
  private Organization institute;

  /**
   * Default constructs a {@link Responsibility} representing a person.
   */
  public Responsibility() {
    person = new Person();
    institute = null;
  }

  /**
   * Constructs a {@link Responsibility} representing a person.
   *
   * @param person
   *    the person to be represented.
   */
  public Responsibility(Person person) {
    this.person = requireNonNull("person", person);
    this.institute = null;
  }

  /**
   * Constructs a {@link Responsibility} representing an institute.
   *
   * @param institute
   *    the institute to be represented.
   */
  public Responsibility(Organization institute) {
    this.person = null;
    this.institute = requireNonNull("institute", institute);
  }

  /**
   * Tests whether this responsibility is a person.
   *
   * @return {@code true} if this responsibility is a person;
   *         {@code false} otherwise.
   */
  public boolean isPerson() {
    return (person != null);
  }

  /**
   * Tests whether this responsibility is an institute.
   *
   * @return {@code true} if this responsibility is an institute;
   *         {@code false} otherwise.
   */
  public boolean isInstitute() {
    return (institute != null);
  }

  /**
   * Gets the person represented by this responsibility.
   *
   * @return the person represented by this responsibility. If this
   *         responsibility represents a institute, this function will returns
   *         {@code null}.
   */
  public Person getPerson() {
    return person;
  }

  /**
   * Sets the person represented by this responsibility.
   * <p>
   * <b>NOTE:</b> This function will clear the {@code institute} field of
   * this {@link Responsibility} object.
   *
   * @param person
   *          the new person represented by this responsibility.
   */
  public void setPerson(Person person) {
    this.person = requireNonNull("person", person);
    this.institute = null;
  }

  /**
   * Gets the institute represented by this responsibility.
   *
   * @return the institute represented by this responsibility. If this
   *         responsibility represents a person, this function will returns
   *         {@code null}.
   */
  public Organization getInstitute() {
    return institute;
  }

  /**
   * Sets the institute represented by this responsibility.
   * <p>
   * <b>NOTE:</b> This function will clear the {@code person} field of this
   * {@link Responsibility} object.
   *
   * @param institute
   *          the new institute represented by this responsibility.
   */
  public void setInstitute(Organization institute) {
    this.institute = requireNonNull("institute", institute);
    this.person = null;
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
    return ReflectionToStringBuilder.toString(this);
  }
}
