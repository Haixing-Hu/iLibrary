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

import org.apache.commons.lang3.StringUtils;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A builder used to build {@link FieldTemplate} objects.
 *
 * @author Haixing Hu
 */
public final class FieldTemplateBuilder {

  private String name;
  private DataType type;
  private boolean multiple;

  public FieldTemplateBuilder() {
    name = StringUtils.EMPTY;
    type = DataType.STRING;
    multiple = false;
  }

  public FieldTemplateBuilder setName(final String name) {
    this.name = requireNonNull("name", name);
    return this;
  }

  public FieldTemplateBuilder setType(final DataType type) {
    this.type = requireNonNull("type", type);
    return this;
  }

  public FieldTemplateBuilder setMultiple(final boolean multiple) {
    this.multiple = multiple;
    return this;
  }

  public FieldTemplateBuilder reset() {
    name = StringUtils.EMPTY;
    type = DataType.STRING;
    multiple = false;
    return this;
  }

  public FieldTemplate build() {
    return new FieldTemplate(name, type, multiple);
  }
}
