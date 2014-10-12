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

import com.github.haixing_hu.ilibrary.model.PeriodicalType;
import com.github.haixing_hu.lang.Argument;

/**
 * The tag representing a type of periodicals.
 * <p>
 * A tag representing a type of periodicals have the scope equals to the name of
 * the {@link TagScope#PERIODICAL_TYPE}.
 *
 * @author Haixing Hu
 */
public class PeriodicalTypeTag extends Tag {

  /**
   * This tag represents the predefined periodical type
   * {@link PeriodicalType#JOURNAL}.
   */
  public static final PeriodicalTypeTag JOURNAL = new PeriodicalTypeTag(
      PeriodicalType.JOURNAL.name());

  /**
   * This tag represents the predefined periodical type
   * {@link PeriodicalType#LAW_REPORT}.
   */
  public static final PeriodicalTypeTag LAW_REPORT = new PeriodicalTypeTag(
      PeriodicalType.LAW_REPORT.name());

  /**
   * This tag represents the predefined periodical type
   * {@link PeriodicalType#MAGAZINE}.
   */
  public static final PeriodicalTypeTag MAGAZINE = new PeriodicalTypeTag(
      PeriodicalType.MAGAZINE.name());

  /**
   * This tag represents the predefined periodical type
   * {@link PeriodicalType#NEWSPAPER}.
   */
  public static final PeriodicalTypeTag NEWSPAPER = new PeriodicalTypeTag(
      PeriodicalType.NEWSPAPER.name());

  /**
   * Gets the periodical type from a list of tags.
   * <p>
   * This function will check the tags in the tag list, and returns the name of
   * the first tag in the scope {@link TagScope#PERIODICAL_TYPE}. If there is no
   * such tag, this function will return the {@code null}.
   *
   * @param tags
   *          a list of tags, which could be null or empty.
   * @return the name of the periodical type get from the tag list, or
   *         {@code null} if not found.
   */
  public static String getPeriodicalType(@Nullable List<Tag> tags) {
    if (tags == null) {
      return null;
    }
    final String scope = TagScope.PERIODICAL_TYPE.name();
    final Tag tag = TagUtils.getFirstTagInScope(scope, tags);
    if (tag == null) {
      return null;
    } else {
      return tag.getName();
    }
  }

  /**
   * Sets the periodical type to a tag list.
   * <p>
   * After calling this function, the old tag or tags representing a periodical
   * type will be removed, and a new tag representing the specified periodical
   * type will be added to the tag list.
   *
   * @param tags
   *          the list of tags, where to update the periodical type. It could be
   *          null. If it is {@code null}, this function will create a new
   *          tag list, put the tag of periodical type to the new tag list, and
   *          return the new tag list.
   * @param periodicalType
   *          the name of the periodical type to be set, which cannot be null
   *          nor empty.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is {@code null}.
   */
  public static List<Tag> setPeriodicalType(@Nullable List<Tag> tags,
      String periodicalType) {
    Argument.requireNonEmpty("periodicalType", periodicalType);
    return TagUtils.updateTagInScope(TagScope.PERIODICAL_TYPE.name(), tags,
        periodicalType);
  }

  /**
   * Constructs a tag representing a type of periodicals.
   *
   * @param typeName
   *          the name of the type.
   */
  public PeriodicalTypeTag(String typeName) {
    super(TagScope.PERIODICAL_TYPE.name(), typeName);
  }

}
