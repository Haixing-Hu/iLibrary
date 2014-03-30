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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

import static com.github.haixing_hu.ilibrary.utils.Argument.requireNonNull;

/**
 * The model of kinds of a document type.
 *
 * @author Haixing Hu
 */
@Root(name = "kind")
public class DocKind {

  @Element(name = "name",
           required = false)
  private String name;

  @ElementMap(entry = "display-name",
              key = "locale",
              attribute = true,
              inline = true,
              required = false)
  private Map<String, String> displayNames;

  /**
   * Default constructs a document kind.
   */
  public DocKind() {
    name = StringUtils.EMPTY;
    displayNames = new HashMap<String, String>();
  }

  /**
   * Constructs a document kind.
   *
   * @param name
   *          the name of the new document kind.
   */
  public DocKind(String name) {
    this.name = requireNonNull("name", name);
    this.displayNames = new HashMap<String, String>();
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
  public DocKind(String name, Map<String, String> displayNames) {
    this.name = requireNonNull("name", name);
    this.displayNames = requireNonNull("displayNames", displayNames);
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
    this.name = requireNonNull("name", name);
  }

  /**
   * Gets the display names of the new document kind, represented as a map from
   * the locale to the corresponding display name.
   *
   * @return the display names of the new document kind, represented as a map
   *         from the locale to the corresponding display name.
   */
  public Map<String, String> getDisplayNames() {
    return displayNames;
  }

  /**
   * Sets the display names of the new document kind, represented as a map from
   * the locale to the corresponding display name..
   *
   * @param displayNames
   *          the new display names to set.
   */
  public void setDisplayNames(Map<String, String> displayNames) {
    this.displayNames = requireNonNull("displayNames", displayNames);
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
