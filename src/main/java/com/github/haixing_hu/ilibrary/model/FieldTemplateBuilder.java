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

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.github.haixing_hu.csl.Variable;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A builder used to build {@link FieldTemplate} objects.
 *
 * @author Haixing Hu
 */
public final class FieldTemplateBuilder {

  private String name;
  private FieldDataType type;
  private boolean multiple;
  private Variable variable;

  public FieldTemplateBuilder() {
    name = StringUtils.EMPTY;
    type = FieldDataType.STRING;
    multiple = false;
    variable = null;
  }

  public FieldTemplateBuilder setName(final String name) {
    this.name = requireNonNull("name", name);
    return this;
  }

  public FieldTemplateBuilder setType(final FieldDataType type) {
    this.type = requireNonNull("type", type);
    return this;
  }

  public FieldTemplateBuilder setMultiple(final boolean multiple) {
    this.multiple = multiple;
    return this;
  }

  public FieldTemplateBuilder setVariable(@Nullable final Variable variable) {
    this.variable = variable;
    return this;
  }

  public FieldTemplate build() {
    return new FieldTemplate(name, type, multiple, variable);
  }
}
