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

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * The dynamic class for {@link Document} instances.
 *
 * @author Haixing Hu
 */
public class DocumentClass extends BasicDynaClass {

  private static final long serialVersionUID = 5061481935062484280L;

  private final DocumentTemplate template;

  public DocumentClass(final DocumentTemplate template) {
    super(template.getName(), Document.class);
    this.template = requireNonNull("template", template);
    final DynaProperty[] properties = constructProperties(template);
    super.setProperties(properties);
  }

  private DynaProperty[] constructProperties(final DocumentTemplate template) {
    final List<DynaProperty> properties = new ArrayList<DynaProperty>();
    properties.add(new DynaProperty("id", Long.class));


    //  adds all the fields as descriptors.
    for (final FieldGroupTemplate group : template.getFieldGroups()) {
      for (final FieldTemplate field : group.getFields()) {
        final DynaProperty property = new DynaProperty(field.getName(),
            field.getType().toClass());
        properties.add(property);
      }
    }
    return properties.toArray(new DynaProperty[0]);
  }

  /**
   * Gets the document template.
   *
   * @return the document template.
   */
  public DocumentTemplate getTemplate() {
    return template;
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
