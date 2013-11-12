/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

import static cn.edu.nju.starfish.ilibrary.utils.Argument.requireNonNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * The model of responsibilities.
 * <p>
 * A responsibility is either a person, or an institute.
 *
 * @author Haixing Hu
 */
public class Responsibility {

  public enum Type {
    PERSON,
    INSTITUTE,
  }

  private Person person;
  private Institute institute;

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
  public Responsibility(Institute institute) {
    this.person = null;
    this.institute = requireNonNull("institute", institute);
  }

  /**
   * Gets the type of this responsibility.
   * <p>
   * If the <code>institute</code> field of this {@link Responsibility} object
   * is <code>null</code>, the type of this {@link Responsibility} object is
   * {@link Type#PERSON}; otherwise, the type of this {@link Responsibility}
   * object is {@link Type#INSTITUTE}.
   *
   * @return the type of the responsibility.
   */
  public Type getType() {
    return (institute == null ? Type.PERSON : Type.INSTITUTE);
  }

  /**
   * Gets the person represented by this responsibility.
   *
   * @return the person represented by this responsibility. If this
   *         responsibility represents a institute, this function will returns
   *         <code>null</code>.
   */
  public Person getPerson() {
    return person;
  }

  /**
   * Sets the person represented by this responsibility.
   * <p>
   * <b>NOTE:</b> This function will clear the <code>institute</code> field of
   * this {@link Responsibility} object.
   *
   * @param person
   *          the new person represented by this responsibility.
   */
  public void setPerson(Person person) {
    this.person = requireNonNull("person", person);
  }

  /**
   * Gets the institute represented by this responsibility.
   *
   * @return the institute represented by this responsibility. If this
   *         responsibility represents a person, this function will returns
   *         <code>null</code>.
   */
  public Institute getInstitute() {
    return institute;
  }

  /**
   * Sets the institute represented by this responsibility.
   * <p>
   * <b>NOTE:</b> This function will clear the <code>person</code> field of this
   * {@link Responsibility} object.
   *
   * @param institute
   *          the new institute represented by this responsibility.
   */
  public void setInstitute(Institute institute) {
    this.institute = requireNonNull("institute", institute);
    this.person = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
