/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The model of types of documents.
 *
 * @author Haixing Hu
 */
public class DocType {

  private int id;
  private String name;
  private String version;
  private Date createTime;
  private Date updatedTime;
  private Person author;
  private Locale defaultLocale;
  private Map<Locale, String> displayNames;
  private List<DocKind> kinds;
  private List<FieldTemplate> fields;

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
