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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * The model of a mapping entry from the name of a locale to the corresponding
 * display name.
 *
 * @author Haixing Hu
 */
@XmlType(name="display-name")
public final class DisplayName {

  @XmlAttribute(name="locale")
  private String locale;

  @XmlValue
  private String name;


  public DisplayName() {
    locale = null;
    name = null;
  }

  public DisplayName(String locale, String name) {
    this.locale = locale;
    this.name = name;
  }

  /**
   * Gets the locale.
   *
   * @return the locale.
   */
  public String getLocale() {
    return locale;
  }

  /**
   * Sets the locale.
   *
   * @param locale
   *          the new locale to set.
   */
  public void setLocale(String locale) {
    this.locale = locale;
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

}
