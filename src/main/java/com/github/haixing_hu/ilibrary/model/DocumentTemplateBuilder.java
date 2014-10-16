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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.haixing_hu.csl.Type;
import com.github.haixing_hu.csl.Variable;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The builder used to build {@link DocumentTemplate} objects.
 *
 * @author Haixing Hu
 */
public final class DocumentTemplateBuilder {

  private String name;
  private DocumentType type;
  private Type cslType;
  private final List<String> kinds;
  private String defaultKind;
  private final List<FieldGroupTemplate> fieldGroups;
  private final VariableMapping variableMapping;

  public DocumentTemplateBuilder() {
    name = StringUtils.EMPTY;
    type = DocumentType.ARTICLE;
    cslType = Type.ARTICLE;
    kinds = new ArrayList<>();
    defaultKind = StringUtils.EMPTY;
    fieldGroups = new ArrayList<>();
    variableMapping = new VariableMapping();
  }

  public DocumentTemplateBuilder setName(final String name) {
    this.name = requireNonNull("name", name);
    return this;
  }

  public DocumentTemplateBuilder setType(final DocumentType type) {
    this.type = requireNonNull("type", type);
    return this;
  }

  public DocumentTemplateBuilder setCslType(final Type cslType) {
    this.cslType = requireNonNull("cslType", cslType);
    return this;
  }

  public DocumentTemplateBuilder setDefaultKind(final String defaultKind) {
    this.defaultKind = requireNonNull("defaultKind", defaultKind);
    return this;
  }

  public DocumentTemplateBuilder addKind(final String kind) {
    kinds.add(requireNonNull("kind", kind));
    return this;
  }

  public DocumentTemplateBuilder addFieldGroup(final FieldGroupTemplate group) {
    fieldGroups.add(requireNonNull("group", group));
    return this;
  }

  public DocumentTemplateBuilder addVariableMapping(final Variable variable,
      final String field) {
    variableMapping.put(variable, field);
    return this;
  }

  public DocumentTemplateBuilder reset() {
    name = StringUtils.EMPTY;
    type = DocumentType.ARTICLE;
    kinds.clear();
    defaultKind = StringUtils.EMPTY;
    fieldGroups.clear();
    variableMapping.clear();
    return this;
  }

  public DocumentTemplate build() {
    return new DocumentTemplate(name, type, cslType, defaultKind, kinds,
        fieldGroups, variableMapping);
  }
}
