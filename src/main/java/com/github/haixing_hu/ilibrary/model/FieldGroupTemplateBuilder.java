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

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A builder used to build {@link FieldGroupTemplate} objects.
 *
 * @author Haixing Hu
 */
public final class FieldGroupTemplateBuilder {

  private FieldGroup group;
  private final List<FieldTemplate> fields;

  public FieldGroupTemplateBuilder() {
    group = FieldGroup.TITLE;
    fields = new ArrayList<FieldTemplate>();
  }

  public FieldGroupTemplateBuilder setGroup(final FieldGroup group) {
    this.group = requireNonNull("group", group);
    return this;
  }

  public FieldGroupTemplateBuilder addField(final FieldTemplate field) {
    fields.add(field);
    return this;
  }

  public FieldGroupTemplateBuilder reset() {
    group = FieldGroup.TITLE;
    fields.clear();
    return this;
  }

  public FieldGroupTemplate build() {
    return new FieldGroupTemplate(group, fields);
  }
}
