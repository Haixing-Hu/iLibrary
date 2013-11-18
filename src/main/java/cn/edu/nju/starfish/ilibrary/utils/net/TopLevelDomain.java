/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.net;

import javax.annotation.concurrent.Immutable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * A top-level domain (TLD) is the last part of an Internet domain name; that
 * is, the letters which follow the final dot of any domain name. For example,
 * in the domain name <code>www.website.com</code>, the top-level domain is
 * <code>com</code>.
 *
 * @author Haixing Hu
 * @see http://www.iana.org/
 * @see http://en.wikipedia.org/wiki/Top-level_domain
 */
@Immutable
public final class TopLevelDomain extends DomainSuffix {

  private static final long serialVersionUID = - 3880755857023154643L;

  public enum Type {
    INFRASTRUCTURE, GENERIC, COUNTRY
  };

  Type type;
  String country;

  TopLevelDomain() {
    super();
    type = Type.GENERIC;
    country = "";
  }

  TopLevelDomain(final String domain, final Status status,
      final String description, final Type type, final String country) {
    super(domain, status, description);
    this.type = type;
    this.country = country;
  }

  public Type getType() {
    return type;
  }

  @Override
  public boolean isTopLevel() {
    return true;
  }

  /**
   * Returns the country name if this TLD is Country Code TLD.
   *
   * @return country name or null
   */
  public String getCountry() {
    return country;
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
