/******************************************************************************
 *
 * Copyright (c) 2013  Haixing Hu
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The model of list of display names.
 *
 * @author Haixing Hu
 */
@XmlRootElement(name="display-names")
@XmlAccessorType(XmlAccessType.FIELD)
public final class DisplayNames implements Iterable<DisplayName> {

  @XmlElement(name="display-name")
  private final List<DisplayName> names;


  public DisplayNames() {
    names = new ArrayList<DisplayName>();
  }

  public DisplayNames(int initialCapacity) {
    names = new ArrayList<DisplayName>(initialCapacity);
  }

  public int size() {
    return names.size();
  }

  public boolean isEmpty() {
    return names.isEmpty();
  }

  @Override
  public Iterator<DisplayName> iterator() {
    return names.iterator();
  }

  public void add(DisplayName name) {
    names.add(name);
  }

  public String get(Locale locale) {
    //  TODO
    return null;
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
