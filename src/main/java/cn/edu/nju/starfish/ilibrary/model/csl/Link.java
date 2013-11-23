/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model.csl;

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
