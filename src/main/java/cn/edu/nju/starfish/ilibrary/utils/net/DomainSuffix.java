/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils.net;

import java.io.Serializable;

import javax.annotation.concurrent.Immutable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * This class represents the last part of the host name, which is operated by
 * authorities, not individuals. This information is needed to find the domain
 * name of a host. The domain name of a host is defined to be the last part
 * before the domain suffix, without sub-domain names. As an example the domain
 * name of <code> http://www.sina.com.cn/</code> is <code>sina.com.cn</code>.
 * <p>
 * This class holds two fields, <strong>domain</strong> field represents the
 * suffix (such as "co.uk"), <strong>status</strong> field represents domain's
 * status.
 *
 * @author Haixing Hu
 */
@Immutable
public class DomainSuffix implements Serializable {

  private static final long serialVersionUID = - 891087570899663847L;

  /**
   * Enumeration of the status of the top level domain.
   *
   * @see domain-suffixes.xml
   */
  public enum Status {
    INFRASTRUCTURE,
    SPONSORED,
    UNSPONSORED,
    STARTUP,
    PROPOSED,
    DELETED,
    PSEUDO_DOMAIN,
    DEPRECATED,
    IN_USE,
    NOT_IN_USE,
    REJECTED,
  };

  public static final Status DEFAULT_STATUS = Status.IN_USE;

  String domain;
  Status status;
  String description;

  DomainSuffix() {
    domain = "";
    status = DEFAULT_STATUS;
    description = "";
  }

  DomainSuffix(final String domain, final Status status,
      final String description) {
    this.domain = domain;
    this.status = status;
    this.description = description;
  }

  public String getDomain() {
    return domain;
  }

  public Status getStatus() {
    return status;
  }

  public String getDescription() {
    return description;
  }

  public boolean isTopLevel() {
    return false;
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
