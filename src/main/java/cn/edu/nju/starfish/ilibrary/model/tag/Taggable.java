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
import cn.edu.nju.starfish.ilibrary.model.Label;
import cn.edu.nju.starfish.ilibrary.utils.TagListUtils;

/**
 * The base class for all objects with a tag list.
 *
 * @author Haixing Hu
 */
public class Taggable {

  protected List<Tag> tags;

  /**
   * Default constructs a {@link Taggable} object.
   */
  public Taggable() {
    tags = null;
  }

  /**
   * Gets the tags.
   *
   * @return the tags.
   */
  public final List<Tag> getTags() {
    return tags;
  }

  /**
   * Sets the tags.
   *
   * @param tags
   *          the new tags to set.
   */
  public final void setTags(@Nullable List<Tag> tags) {
    this.tags = tags;
  }

  /**
   * Gets the list of tags in the specified scope from the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @return the list of tags in the specified scope, or <code>null</code> if no such
   *         tag.
   */
  public final List<Tag> getTagsInScope(String scope) {
    return TagListUtils.getTagsInScope(scope, tags);
  }

  /**
   * Gets the first tag in the specified scope from the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @return the first tag in the specified scope, or <code>null</code> if no such
   *         tag.
   */
  public final Tag getFirstTagInScope(String scope) {
    return TagListUtils.getFirstTagInScope(scope, tags);
  }

  /**
   * Removes all the tags in the specified scope from the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   */
  public final void removeTagsInScope(String scope) {
    TagListUtils.removeTagsInScope(scope, tags);
  }

  /**
   * Updates a tag in the specified scope from the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param newName
   *          the name of new tag in the specified scope to be added to the tag
   *          list.
   */
  public final void updateTagInScope(String scope, String newName) {
    tags = TagListUtils.updateTagInScope(scope, tags, newName);
  }

  /**
   * Updates the tags in the specified scope from the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param newNames
   *          the names of new tags in the specified scope to be added to the tag
   *          list.
   */
  public final void updateTagsInScope(String scope, String ... newNames) {
    tags = TagListUtils.updateTagsInScope(scope, tags, newNames);
  }

  /**
   * Gets the access mode of this object.
   * <p>
   * This function will check the tags of this object, and returns the name of
   * the first tag whose scope is {@link TagScope#ACCESS_MODE}. If there is no
   * such tag, this function will return the name of {@link AccessMode#NONE}.
   *
   * @return the name of the access mode of this object.
   */
  public final String getAccessMode() {
    return AccessModeTag.getAccessMode(tags);
  }

  /**
   * Sets the access mode to this object.
   * <p>
   * After calling this function, the old tag or tags representing an access
   * mode will be removed, and a new tag representing the specified access mode
   * will be added to the tag list.
   *
   * @param accessMode
   *          the name of the new access mode to be set to this object.
   */
  public final void setAccessMode(String accessMode) {
    tags = AccessModeTag.setAccessMode(accessMode, tags);
  }

  /**
   * Gets the label of this object.
   * <p>
   * This function will check the tags of this {@link Conference} object, and
   * returns the name of the first tag whose scope is {@link TagScope#LABEL}. If
   * there is no such tag, this function will return the name of
   * {@link Label#NONE}.
   *
   * @return the enumeration of the label of this object.
   */
  public final Label getLabel() {
    return LabelTag.getLabel(tags);
  }

  /**
   * Sets the label to this object.
   * <p>
   * After calling this function, the old tag or tags representing a label will
   * be removed, and a new tag representing the specified label will be added to
   * the tag list.
   *
   * @param label
   *          the new label to be set to this object.
   */
  public final void setLabel(Label label) {
    tags = LabelTag.setLabel(label, tags);
  }

  /**
   * Gets the category of this object.
   * <p>
   * This function will check the tags of this object, and returns the name of
   * the first tag whose scope is {@link TagScope#CATEGORY}. If there is no such
   * tag, this function will return <code>null</code>.
   *
   * @return the name of the category of this object, or <code>null</code> if
   *         the category is not set for this object.
   */
  public final String getCategory() {
    return CategoryTag.getCategory(tags);
  }

  /**
   * Sets the category to this object.
   * <p>
   * After calling this function, the old tag or tags representing an access
   * mode will be removed, and a new tag representing the specified category
   * will be added to the tag list.
   *
   * @param category
   *          the name of the new category to be set to this object.
   */
  public final void setCategory(String category) {
    tags = CategoryTag.setCategory(category, tags);
  }
}
