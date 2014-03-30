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

package com.github.haixing_hu.ilibrary.model.csl;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * The model of links of a CSL.
 *
 * @author Haixing Hu
 */
@Root
public class Link {

  @Element
  private String href;

  @Element
  private String rel;

  /**
   * Default constructs a {@link Link}.
   */
  public Link() {
    href = null;
    rel = null;
  }

  /**
   * Gets the href.
   *
   * @return the href.
   */
  public String getHref() {
    return href;
  }

  /**
   * Sets the href.
   *
   * @param href
   *          the new href to set.
   */
  public void setHref(String href) {
    this.href = href;
  }

  /**
   * Gets the rel.
   *
   * @return the rel.
   */
  public String getRel() {
    return rel;
  }

  /**
   * Sets the rel.
   *
   * @param rel
   *          the new rel to set.
   */
  public void setRel(String rel) {
    this.rel = rel;
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
