/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model.tag;

import java.util.List;

import javax.annotation.Nullable;

import cn.edu.nju.starfish.ilibrary.model.Conference;
import cn.edu.nju.starfish.ilibrary.utils.Argument;
import cn.edu.nju.starfish.ilibrary.utils.TagListUtils;

/**
 * The tag representing a category
 * <p>
 * A tag representing a category have the scope equals to the name of the
 * {@link TagScope#CATEGORY}.
 *
 * @author Haixing Hu
 */
public class CategoryTag extends Tag {

  /**
   * Gets the category from a list of tags.
   * <p>
   * This function will check the tags of this {@link Conference} object, and
   * returns the name of the first tag whose scope is
   * {@link TagScope#CATEGORY}. If there is no such tag, this function will
   * return <code>null</code>.
   *
   * @param tags
   *          a list of tags, which could be null or empty.
   * @return the name of the category get from the tag list, or
   *         <code>null</code> if not found.
   */
  public static String getCategory(@Nullable List<Tag> tags) {
    if (tags == null) {
      return null;
    }
    final String scope = TagScope.CATEGORY.name();
    final Tag tag = TagListUtils.getFirstTagInScope(scope, tags);
    if (tag == null) {
      return null;
    } else {
      return tag.getName();
    }
  }

  /**
   * Sets the category to a tag list.
   * <p>
   * After calling this function, the old tag or tags representing a category
   * will be removed, and a new tag representing the specified category will be
   * added to the tag list.
   *
   * @param category
   *          the name of the category to be set, which cannot be null nor
   *          empty.
   * @param tags
   *          the list of tags, where to update the category. It could be null.
   *          If it is <code>null</code>, this function will create a new tag
   *          list, put the tag of access mode to the new tag list, and
   *          return the new tag list.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is <code>null</code>.
   */
  public static List<Tag> setCategory(String category,
      @Nullable List<Tag> tags) {
    Argument.requireNonEmpty("category", category);
    return TagListUtils.updateTagInScope(TagScope.CATEGORY.name(), tags, category);
  }

  /**
   * Constructs a tag representing a category.
   *
   * @param category
   *          the name of a category.
   */
  public CategoryTag(String category) {
    super(TagScope.CATEGORY.name(), category);
  }
}
