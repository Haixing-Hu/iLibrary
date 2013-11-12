/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model.tag;

import java.util.List;

import javax.annotation.Nullable;

import cn.edu.nju.starfish.ilibrary.model.AccessMode;
import cn.edu.nju.starfish.ilibrary.model.Conference;
import cn.edu.nju.starfish.ilibrary.utils.Argument;
import cn.edu.nju.starfish.ilibrary.utils.TagListUtils;

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
  public static final AccessModeTag OPEN = new AccessModeTag(AccessMode.OPEN.name());

  /**
   * This tag represents the access mode {@link AccessMode#FREE}.
   */
  public static final AccessModeTag FREE = new AccessModeTag(AccessMode.FREE.name());

  /**
   * This tag represents the access mode {@link AccessMode#NONE}.
   */
  public static final AccessModeTag NONE = new AccessModeTag(AccessMode.NONE.name());

  /**
   * Gets the access mode from a list of tags.
   * <p>
   * This function will check the tags of this {@link Conference} object, and
   * returns the name of the first tag whose scope is
   * {@link TagScope#ACCESS_MODE}. If there is no such tag, this function will
   * return the name of {@link AccessMode#NONE}.
   *
   * @param tags
   *          a list of tags, which could be null or empty.
   * @return the name of the access mode get from the tag list, or {@link AccessMode#NONE}
   *         if not found.
   */
  public static String getAccessMode(@Nullable List<Tag> tags) {
    if (tags == null) {
      return AccessMode.NONE.name();
    }
    final String scope = TagScope.ACCESS_MODE.name();
    final Tag tag = TagListUtils.getFirstTagInScope(scope, tags);
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
   * @param accessMode
   *          the name of the access mode to be set, which cannot be null nor
   *          empty.
   * @param tags
   *          the list of tags, where to update the access mode. It could be
   *          null. If it is <code>null</code>, this function will create a new
   *          tag list, put the tag of access mode to the new tag list, and
   *          return the new tag list.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is <code>null</code>.
   */
  public static List<Tag> setAccessMode(String accessMode, @Nullable List<Tag> tags) {
    Argument.requireNonEmpty("accessMode", accessMode);
    return TagListUtils.updateTagInScope(TagScope.ACCESS_MODE.name(), tags, accessMode);
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
