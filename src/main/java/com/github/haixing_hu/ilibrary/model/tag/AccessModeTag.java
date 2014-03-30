/******************************************************************************
 *
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
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.model.tag;

import java.util.List;

import javax.annotation.Nullable;

import com.github.haixing_hu.ilibrary.model.AccessMode;
import com.github.haixing_hu.ilibrary.utils.Argument;

/**
 * The tag representing an access mode.
 * <p>
 * A tag representing an access mode have the scope equals to the name of the
 * {@link TagScope#ACCESS_MODE}.
 *
 * @author Haixing Hu
 */
public class AccessModeTag extends Tag {

  /**
   * This tag represents the access mode {@link AccessMode#OPEN}.
   */
  public static final AccessModeTag OPEN = new AccessModeTag(
      AccessMode.OPEN.name());

  /**
   * This tag represents the access mode {@link AccessMode#FREE}.
   */
  public static final AccessModeTag FREE = new AccessModeTag(
      AccessMode.FREE.name());

  /**
   * This tag represents the access mode {@link AccessMode#NONE}.
   */
  public static final AccessModeTag NONE = new AccessModeTag(
      AccessMode.NONE.name());

  /**
   * Gets the access mode from a list of tags.
   * <p>
   * This function will check the tags in the tag list, and returns the name of
   * the first tag in the scope {@link TagScope#ACCESS_MODE}. If there is no
   * such tag, this function will return the name of {@link AccessMode#NONE}.
   *
   * @param tags
   *          a list of tags, which could be null or empty.
   * @return the name of the access mode get from the tag list, or the name of
   *         {@link AccessMode#NONE} if not found.
   */
  public static String getAccessMode(@Nullable List<Tag> tags) {
    if (tags == null) {
      return AccessMode.NONE.name();
    }
    final String scope = TagScope.ACCESS_MODE.name();
    final Tag tag = TagUtils.getFirstTagInScope(scope, tags);
    if (tag == null) {
      return AccessMode.NONE.name();
    } else {
      return tag.getName();
    }
  }

  /**
   * Sets the access mode to a tag list.
   * <p>
   * After calling this function, the old tag or tags representing an access
   * mode will be removed, and a new tag representing the specified access mode
   * will be added to the tag list.
   *
   * @param tags
   *          the list of tags, where to update the access mode. It could be
   *          null. If it is <code>null</code>, this function will create a new
   *          tag list, put the tag of access mode to the new tag list, and
   *          return the new tag list.
   * @param accessMode
   *          the name of the access mode to be set, which cannot be null nor
   *          empty.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is <code>null</code>.
   */
  public static List<Tag> setAccessMode(@Nullable List<Tag> tags,
      String accessMode) {
    Argument.requireNonEmpty("accessMode", accessMode);
    return TagUtils.updateTagInScope(TagScope.ACCESS_MODE.name(), tags,
        accessMode);
  }

  /**
   * Constructs a tag representing an access mode.
   *
   * @param mode
   *          the name of an access mode.
   */
  public AccessModeTag(String mode) {
    super(TagScope.ACCESS_MODE.name(), mode);
  }
}
