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
 * The model of contributors of a CSL.
 *
 * @author Haixing Hu
 */
@Root
public class Contributor {

  @Element
  private String name;

  @Element(required=false)
  private String email;

  @Element(required=false)
  private String uri;

  /**
   * Default constructs an {@link Contributor}.
   */
  public Contributor() {
    name = "anonymous";
    email = null;
    uri = null;
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
   * Gets the email.
   *
   * @return the email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email
   *          the new email to set.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the uri.
   *
   * @return the uri.
   */
  public String getUri() {
    return uri;
  }

  /**
   * Sets the uri.
   *
   * @param uri
   *          the new uri to set.
   */
  public void setUri(String uri) {
    this.uri = uri;
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
