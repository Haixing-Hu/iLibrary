/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model.tag;

import java.util.List;

import javax.annotation.Nullable;

import cn.edu.nju.starfish.ilibrary.utils.Argument;

/**
 * The tag representing a keyword.
 * <p>
 * A tag representing a keyword have the scope equals to the name of the
 * {@link TagScope#KEYWORD}.
 *
 * @author Haixing Hu
 */
public class KeywordTag extends Tag {

  /**
   * Gets the keywords from a list of tags.
   * <p>
   * This function will check the tags of the tag list, and returns the names of
   * the tags in the scope {@link TagScope#KEYWORD}. If there is no such tag,
   * this function will return <code>null</code>.
   *
   * @param tags
   *          a list of tags, which could be null or empty.
   * @return the list of keywords get from the tag list, or <code>null</code> if
   *         not found.
   */
  public static List<String> getKeywords(@Nullable List<Tag> tags) {
    final String scope = TagScope.KEYWORD.name();
    return TagUtils.getTagNamesInScope(scope, tags);
  }

  /**
   * Sets the keywords to a tag list.
   * <p>
   * After calling this function, the old tag or tags representing a keyword
   * will be removed, and new tags representing the specified keywords will be
   * added to the tag list.
   *
   * @param tags
   *          the list of tags, where to update the keywords. It could be null.
   *          If it is <code>null</code>, this function will create a new tag
   *          list, put the tags of keywords to the new tag list, and return
   *          the new tag list.
   * @param keywords
   *          the list of keywords to be set, which cannot be <code>null</code>,
   *          and every elements in the array cannot be <code>null</code> nor empty.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is <code>null</code>.
   */
  public static List<Tag> setKeywords(@Nullable List<Tag> tags, List<String> keywords) {
    Argument.requireNonEmpty("keywords", keywords);
    return TagUtils.updateTagsInScope(TagScope.KEYWORD.name(), tags, keywords);
  }

  /**
   * Adds a keyword to a tag list.
   *
   * @param tags
   *          the list of tags, where to update the keywords. It could be null.
   *          If it is <code>null</code>, this function will create a new tag
   *          list, put the tag of the keyword to the new tag list, and return
   *          the new tag list.
   * @param keyword
   *          the keywords to be added, which cannot be <code>null</code>, and
   *          every elements in the array cannot be <code>null</code> nor empty.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is <code>null</code>.
   */
  public static List<Tag> addKeyword(@Nullable List<Tag> tags, String keyword) {
    Argument.requireNonEmpty("keyword", keyword);
    return TagUtils.addTagInScope(TagScope.KEYWORD.name(), tags, keyword);
  }

  /**
   * Adds keywords to a tag list.
   *
   * @param tags
   *          the list of tags, where to update the keywords. It could be null.
   *          If it is <code>null</code>, this function will create a new tag
   *          list, put the tags of keywords to the new tag list, and return
   *          the new tag list.
   * @param keywords
   *          the list of keywords to be added, which cannot be <code>null</code>,
   *          and every elements in the array cannot be <code>null</code> nor empty.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is <code>null</code>.
   */
  public static List<Tag> addKeywords(@Nullable List<Tag> tags, List<String> keywords) {
    Argument.requireNonEmpty("keywords", keywords);
    return TagUtils.addTagsInScope(TagScope.KEYWORD.name(), tags, keywords);
  }

  /**
   * Removes a keyword from a tag list.
   *
   * @param tags
   *          the list of tags, where to update the keywords, which could be null.
   * @param keyword
   *          the keywords to be removed, which cannot be <code>null</code> nor empty.
   */
  public static void removeKeyword(@Nullable List<Tag> tags, String keyword) {
    Argument.requireNonEmpty("keyword", keyword);
    TagUtils.removeTagInScope(TagScope.KEYWORD.name(), tags, keyword);
  }

  /**
   * Removes keywords from a tag list.
   *
   * @param tags
   *          the list of tags, where to update the keywords, which could be null.
   * @param keywords
   *          the keywords to be removed, which cannot be <code>null</code>, and
   *          every elements in the array cannot be <code>null</code> nor empty.
   */
  public static void removeKeywords(@Nullable List<Tag> tags, List<String> keywords) {
    Argument.requireNonEmpty("keywords", keywords);
    TagUtils.removeTagsInScope(TagScope.KEYWORD.name(), tags, keywords);
  }

  /**
   * Constructs a tag representing a keyword.
   *
   * @param keyword
   *          a keyword.
   */
  public KeywordTag(String keyword) {
    super(TagScope.KEYWORD.name(), keyword);
  }
}
