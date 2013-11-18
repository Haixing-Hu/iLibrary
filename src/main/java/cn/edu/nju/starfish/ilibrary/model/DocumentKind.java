/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

import java.util.Locale;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The model of kinds of a document type.
 *
 * @author Haixing Hu
 */
public class DocumentKind {

  private int id;
  private String name;
  private Map<Locale, String> displayNames;

  /**
   * Default constructs a document kind.
   */
  public DocumentKind() {
    id = - 1;
    name = null;
    displayNames = null;
  }

  /**
   * Constructs a document kind.
   *
   * @param name
   *          the name of the new document kind.
   */
  public DocumentKind(@Nullable String name) {
    this.id = - 1;
    this.name = name;
    this.displayNames = null;
  }

  /**
   * Constructs a document kind.
   *
   * @param name
   *          the name of the new document kind.
   * @param displayNames
   *          the display names of the new document kind, represented as a map
   *          from the locale to the corresponding display name.
   */
  public DocumentKind(@Nullable String name,
      @Nullable Map<Locale, String> displayNames) {
    this.id = - 1;
    this.name = name;
    this.displayNames = displayNames;
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
   * Gets the display names of the new document kind, represented as a map from
   * the locale to the corresponding display name.
   *
   * @return the display names of the new document kind, represented as a map
   *         from the locale to the corresponding display name.
   */
  public Map<Locale, String> getDisplayNames() {
    return displayNames;
  }

  /**
   * Sets the display names of the new document kind, represented as a map from
   * the locale to the corresponding display name..
   *
   * @param displayNames
   *          the new display names to set.
   */
  public void setDisplayNames(Map<Locale, String> displayNames) {
    this.displayNames = displayNames;
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
