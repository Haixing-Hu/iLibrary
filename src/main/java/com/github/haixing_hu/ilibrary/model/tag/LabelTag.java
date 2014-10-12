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
package com.github.haixing_hu.ilibrary.model.tag;

import java.util.List;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.model.Label;
import com.github.haixing_hu.lang.Argument;

/**
 * The tag representing a label.
 * <p>
 * A tag representing a label have the scope equals to the name of the
 * {@link TagScope#LABEL}.
 *
 * @author Haixing Hu
 */
public class LabelTag extends Tag {

  /**
   * This tag represents the label {@link Label#RED}.
   */
  public static final LabelTag RED = new LabelTag(Label.RED);

  /**
   * This tag represents the label {@link Label#ORANGE}.
   */
  public static final LabelTag ORANGE = new LabelTag(Label.ORANGE);

  /**
   * This tag represents the label {@link Label#YELLOW}.
   */
  public static final LabelTag YELLOW = new LabelTag(Label.YELLOW);

  /**
   * This tag represents the label {@link Label#GREEN}.
   */
  public static final LabelTag GREEN = new LabelTag(Label.GREEN);

  /**
   * This tag represents the label {@link Label#BLUE}.
   */
  public static final LabelTag BLUE = new LabelTag(Label.BLUE);

  /**
   * This tag represents the label {@link Label#PURPLE}.
   */
  public static final LabelTag PURPLE = new LabelTag(Label.PURPLE);

  /**
   * This tag represents the label {@link Label#BLACK}.
   */
  public static final LabelTag BLACK = new LabelTag(Label.BLACK);

  /**
   * Gets the label from a list of tags.
   * <p>
   * This function will check the tags in the tag list, and returns the name of
   * the first tag in the scope {@link TagScope#LABEL}. If there is no such
   * tag, this function will return the name of {@link Label#NONE}.
   *
   * @param tags
   *          a list of tags, which could be null or empty.
   * @return the label get from the tag list, or {@link Label#NONE} if not
   *         found.
   */
  public static Label getLabel(@Nullable List<Tag> tags) {
    if (tags == null) {
      return Label.NONE;
    }
    final String scope = TagScope.ACCESS_MODE.name();
    final Tag tag = TagUtils.getFirstTagInScope(scope, tags);
    if (tag == null) {
      return Label.NONE;
    } else {
      final String name = tag.getName();
      try {
        return Label.valueOf(name);
      } catch (final Exception e) {
        final Logger logger = LoggerFactory.getLogger(LabelTag.class);
        logger.error("Invalid label name: {}", name);
        return Label.NONE;
      }
    }
  }

  /**
   * Sets the label to a tag list.
   * <p>
   * After calling this function, the old tag or tags representing a label will
   * be removed, and a new tag representing the specified label will be added to
   * the tag list.
   *
   * @param tags
   *          the list of tags, where to update the label. It could be null. If
   *          it is {@code null}, this function will create a new tag list,
   *          put the tag of the label to the new tag list, and return the new tag
   *          list.
   * @param label
   *          the label to be set, which cannot be {@code null}.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is {@code null}.
   */
  public static List<Tag> setLabel(@Nullable List<Tag> tags, Label label) {
    Argument.requireNonNull("label", label);
    return TagUtils.updateTagInScope(TagScope.LABEL.name(), tags,
        label.name());
  }

  /**
   * Constructs a tag representing a label.
   *
   * @param label
   *          the label to be represented, which cannot be {@code null}.
   */
  public LabelTag(Label label) {
    super(TagScope.LABEL.name(), label.name());
  }
}
