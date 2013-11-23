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

package cn.edu.nju.starfish.ilibrary.model.csl;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Specifies the license under which the style file is released.
 *
 * @author Haixing Hu
 */
@Root
public class Right {

  @Attribute(required = false)
  private String license;

  @Element
  private String content;

  /**
   * Gets the license.
   *
   * @return the license.
   */
  public String getLicense() {
    return license;
  }

  /**
   * Sets the license.
   *
   * @param license
   *          the new license to set.
   */
  public void setLicense(String license) {
    this.license = license;
  }

  /**
   * Gets the content.
   *
   * @return the content.
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets the content.
   *
   * @param content
   *          the new content to set.
   */
  public void setContent(String content) {
    this.content = content;
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
