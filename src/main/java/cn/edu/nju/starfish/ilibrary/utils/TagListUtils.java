/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Nullable;

import cn.edu.nju.starfish.ilibrary.model.tag.Tag;

/**
 * Provides functions to manipulate the tag lists.
 *
 * @author Haixing Hu
 */
public class TagListUtils {

  /**
   * Gets the list of tags in the specified scope from a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code>.
   * @return the list of tags in the specified scope, or <code>null</code> if no such
   *         tag.
   */
  public static List<Tag> getTagsInScope(String scope, @Nullable List<Tag> tags) {
    Argument.requireNonEmpty("scope", scope);
    if (tags == null) {
      return null;
    }
    final List<Tag> result = new LinkedList<Tag>();
    for (final Tag tag : tags) {
      if (scope.equals(tag.getScope())) {
        result.add(tag);
      }
    }
    return result;
  }

  /**
   * Gets the first tag in the specified scope from a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code>.
   * @return the first tag in the specified scope, or <code>null</code> if no such
   *         tag.
   */
  public static Tag getFirstTagInScope(String scope, @Nullable List<Tag> tags) {
    Argument.requireNonEmpty("scope", scope);
    if (tags == null) {
      return null;
    }
    for (final Tag tag : tags) {
      if (scope.equals(tag.getScope())) {
        return tag;
      }
    }
    return null;
  }

  /**
   * Removes all the tags in the specified scope from a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code>.
   */
  public static void removeTagsInScope(String scope, @Nullable List<Tag> tags) {
    if (tags == null) {
      return;
    }
    final ListIterator<Tag> iter = tags.listIterator();
    while (iter.hasNext()) {
      final Tag tag = iter.next();
      if (scope.equals(tag.getScope())) {
        iter.remove();
      }
    }
  }

  /**
   * Updates a tag in the specified scope from a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code> or empty. If it
   *          is <code>null</code> or empty, this function will create a new tag
   *          list, add the new tag to the list, and return the new tag list.
   * @param newName
   *          the name of new tag in the specified scope to be added to the tag
   *          list.
   * @return the tag list after update.
   */
  public static List<Tag> updateTagInScope(String scope,
      @Nullable List<Tag> tags, String newName) {
    Argument.requireNonEmpty("scope", scope);
    Argument.requireNonNull("newNames", newName);
    if (tags == null) {
      tags = new LinkedList<Tag>();
    } else {
      removeTagsInScope(scope, tags);
    }
    tags.add(new Tag(scope, newName));
    return tags;
  }

  /**
   * Updates the tags in the specified scope from a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code> or empty. If it
   *          is <code>null</code> or empty, this function will create a new tag
   *          list, add the new tags to the list, and return the new tag list.
   * @param newNames
   *          the names of new tags in the specified scope to be added to the tag
   *          list.
   * @return the tag list after update.
   */
  public static List<Tag> updateTagsInScope(String scope,
      @Nullable List<Tag> tags, String... newNames) {
    Argument.requireNonEmpty("scope", scope);
    Argument.requireNonNull("newNames", newNames);
    if (tags == null) {
      tags = new LinkedList<Tag>();
    } else {
      removeTagsInScope(scope, tags);
    }
    for (final String name : newNames) {
      tags.add(new Tag(scope, name));
    }
    return tags;
  }
}
