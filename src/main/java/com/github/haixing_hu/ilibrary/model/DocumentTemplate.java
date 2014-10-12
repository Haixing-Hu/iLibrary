/*
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
 */
package com.github.haixing_hu.ilibrary.model;

import java.util.List;
import java.util.Map;

import javax.annotation.concurrent.Immutable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.csl.Variable;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The model of templates of documents.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "document")
@Immutable
public final class DocumentTemplate {

  @XmlElement(name = "name", required = true)
  private final String name;

  @XmlElement(name = "type", required = true)
  private final DocumentType type;

  @XmlElement(name = "default-kind", required = true)
  private final String defaultKind;

  @XmlElementWrapper(name = "kinds")
  @XmlElement(name = "kind")
  private final List<String> kinds;

  @XmlElementWrapper(name = "fields")
  @XmlElement(name = "field")
  private final List<String> fields;

  @XmlElementWrapper(name = "csl-mapping")
  @XmlElement(name = "rule")
  private final Map<Variable, String> cslMapping;

  /**
   * Default constructor.
   * <p>
   * This default constructor is presented for JAXB.
   */
  DocumentTemplate() {
    name = StringUtils.EMPTY;
    type = DocumentType.ARTICLE;
    defaultKind = null;
    kinds = null;
    fields = null;
    cslMapping = null;
  }

  /**
   * Constructs a {@link DocumentTemplate}.
   *
   * @param name
   *          the name of the document template.
   * @param type
   *          the type of the documents created by the document template.
   * @param defaultKind
   *          the default kind of the documents created by the document
   * @param kinds
   *          the list of kinds of the documents created by the document
   *          template. template.
   * @param fields
   *          the list of names of fields for the documents created by the
   *          document template.
   * @param cslMapping
   *          a mapping from CSL standard variables to property expressions.
   */
  public DocumentTemplate(final String name, final DocumentType type,
      final String defaultKind, final List<String> kinds,
      final List<String> fields, final Map<Variable, String> cslMapping) {
    this.name = requireNonNull("name", name);
    this.type = requireNonNull("type", type);
    this.defaultKind = requireNonNull("defaultKind", defaultKind);
    this.kinds = requireNonNull("kinds", kinds);
    this.fields = requireNonNull("fields", fields);
    this.cslMapping = requireNonNull("cslMapping", cslMapping);
  }

  /**
   * Gets the name of this document template.
   *
   * @return the name of this document template, which will never be
   *         {@code null}.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the type of documents created from this document template.
   *
   * @return the type of documents created from this document template, which
   *         will never be {@code null}.
   */
  public DocumentType getType() {
    return type;
  }

  /**
   * Gets the default kind of documents created from this document template.
   *
   * @return the default kind of documents created from this document
   *         template,which will never be {@code null}.
   */
  public String getDefaultKind() {
    return defaultKind;
  }

  /**
   * Gets the list of kinds of documents created from this document template.
   *
   * @return the list of kinds of documents created from this document template,
   *         which will never be {@code null}.
   */
  public List<String> getKinds() {
    return kinds;
  }

  /**
   * Gets the the list of names of fields for the documents created from this
   * document template.
   *
   * @return the list of names of fields for the documents created from this
   *         document template, which will never be {@code null}.
   */
  public List<String> getFields() {
    return fields;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(final Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
