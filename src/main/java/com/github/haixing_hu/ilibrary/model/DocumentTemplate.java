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

import javax.annotation.concurrent.Immutable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.csl.Type;

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

  @XmlElement(name = "csl-type", required = true)
  private final Type cslType;

  @XmlElement(name = "default-kind", required = true)
  private final String defaultKind;

  @XmlElementWrapper(name = "kinds")
  @XmlElement(name = "kind")
  private final List<String> kinds;

  @XmlElementWrapper(name = "fields")
  @XmlElement(name = "group")
  private final List<FieldGroupTemplate> fieldGroups;

  @XmlJavaTypeAdapter(VariableMappingXmlAdapter.class)
  @XmlElement(name = "variable-mapping")
  private final VariableMapping variableMapping;

  /**
   * Default constructor.
   * <p>
   * This default constructor is presented for JAXB.
   */
  DocumentTemplate() {
    name = StringUtils.EMPTY;
    type = DocumentType.ARTICLE;
    cslType = Type.ARTICLE;
    defaultKind = null;
    kinds = null;
    fieldGroups = null;
    variableMapping = null;
  }

  /**
   * Constructs a {@link DocumentTemplate}.
   *
   * @param name
   *          the name of the document template.
   * @param type
   *          the type of the documents created by the document template.
   * @param cslType
   *          the CSL type of the documents created by the document template.
   * @param defaultKind
   *          the default kind of the documents created by the document
   * @param kinds
   *          the list of kinds of the documents created by the document
   *          template. template.
   * @param fieldGroups
   *          the list of templates of field groups for the documents created by
   *          the document template.
   * @param variableMapping
   *          the mapping from CSL standard variables to property values of a
   *          document.
   */
  public DocumentTemplate(final String name, final DocumentType type,
      final Type cslType, final String defaultKind, final List<String> kinds,
      final List<FieldGroupTemplate> fieldGroups,
      final VariableMapping variableMapping) {
    this.name = requireNonNull("name", name);
    this.type = requireNonNull("type", type);
    this.cslType = requireNonNull("cslType", cslType);
    this.defaultKind = requireNonNull("defaultKind", defaultKind);
    this.kinds = requireNonNull("kinds", kinds);
    this.fieldGroups = requireNonNull("fieldGroups", fieldGroups);
    this.variableMapping = requireNonNull("variableMapping", variableMapping);
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
   * Gets the the list of templates of field groups for the documents created
   * from this document template.
   *
   * @return the list of templates of field groups for the documents created
   *         from this document template, which will never be {@code null}.
   */
  public List<FieldGroupTemplate> getFieldGroups() {
    return fieldGroups;
  }

  /**
   * Gets the mapping from CSL standard variables to property values of a
   * document.
   *
   * @return the mapping from CSL standard variables to property values of a
   *         document.
   */
  public VariableMapping getVariableMapping() {
    return variableMapping;
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
