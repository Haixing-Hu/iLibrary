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

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The builder used to build {@link DocumentTemplate} objects.
 *
 * @author Haixing Hu
 */
public final class DocumentTemplateBuilder {

  private String name;
  private DocumentType type;
  private final List<String> kinds;
  private String defaultKind;
  private final List<String> fields;

  public DocumentTemplateBuilder() {
    name = StringUtils.EMPTY;
    type = DocumentType.ARTICLE;
    kinds = new ArrayList<String>();
    defaultKind = StringUtils.EMPTY;
    fields = new ArrayList<String>();
  }

  public DocumentTemplateBuilder setName(final String name) {
    this.name = requireNonNull("name", name);
    return this;
  }

  public DocumentTemplateBuilder setType(final DocumentType type) {
    this.type = requireNonNull("type", type);
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

  public DocumentTemplateBuilder addField(final String field) {
    fields.add(requireNonNull("field", field));
    return this;
  }

  public DocumentTemplate build() {
    //return new DocumentTemplate(name, type, defaultKind, kinds, fields);
    //  FIXME:
    return null;
  }
}
