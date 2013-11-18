/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

import javax.annotation.Nullable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import static cn.edu.nju.starfish.ilibrary.utils.Argument.requireNonNull;

/**
 * The field of a document.
 *
 * @author Haixing Hu
 */
public class Field {

  private int id;
  private String name;
  private DataType type;
  private boolean list;
  private Object value;

  /**
   * Default constructs a {@link Field}.
   */
  public Field() {
    this.id = - 1;
    this.name = "";
    this.type = DataType.STRING;
    this.list = false;
    this.value = null;
  }

  /**
   * Constructs a {@link Field}.
   *
   * @param name
   *          the name of the new filed.
   * @param type
   *          the type of the new field.
   */
  public Field(String name, DataType type) {
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
  public Field(String name, DataType type, boolean list) {
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
  public DataType getType() {
    return type;
  }

  /**
   * Sets the type.
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
