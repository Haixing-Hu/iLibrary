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
public class TagUtils {

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
   * Gets the list of names of the tags in the specified scope from a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code>.
   * @return the list of names of the tags in the specified scope, or
   *         <code>null</code> if no such tag.
   */
  public static List<String> getTagNamesInScope(String scope, @Nullable List<Tag> tags) {
    Argument.requireNonEmpty("scope", scope);
    if (tags == null) {
      return null;
    }
    final List<String> result = new LinkedList<String>();
    for (final Tag tag : tags) {
      if (scope.equals(tag.getScope())) {
        result.add(tag.getName());
      }
    }
    return result;
  }

  /**
   * Gets the name of the first tag in the specified scope from a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code>.
   * @return the name of the first tag in the specified scope, or
   *         <code>null</code> if no such tag.
   */
  public static String getFirstTagNameInScope(String scope, @Nullable List<Tag> tags) {
    Argument.requireNonEmpty("scope", scope);
    if (tags == null) {
      return null;
    }
    for (final Tag tag : tags) {
      if (scope.equals(tag.getScope())) {
        return tag.getName();
      }
    }
    return null;
  }

  /**
   * Adds a tag in the specified scope to a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code> or empty. If it
   *          is <code>null</code> or empty, this function will create a new tag
   *          list, add the new tag to the list, and return the new tag list.
   * @param name
   *          the name of new tag in the specified scope to be added to the tag
   *          list.
   * @return the tag list after update, which cannot be <code>null</code>.
   */
  public static List<Tag> addTagInScope(String scope,
      @Nullable List<Tag> tags, String name) {
    Argument.requireNonEmpty("scope", scope);
    Argument.requireNonNull("name", name);
    if (tags == null) {
      tags = new LinkedList<Tag>();
    }
    tags.add(new Tag(scope, name));
    return tags;
  }

  /**
   * Adds the tags in the specified scope to a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code> or empty. If it
   *          is <code>null</code> or empty, this function will create a new tag
   *          list, add the new tags to the list, and return the new tag list.
   * @param names
   *          the names of new tags in the specified scope to be added to the tag
   *          list.
   * @return the tag list after update, which may be <code>null</code>.
   */
  public static List<Tag> addTagsInScope(String scope,
      @Nullable List<Tag> tags, List<String> names) {
    Argument.requireNonEmpty("scope", scope);
    Argument.requireNonNull("names", names);
    if (names.isEmpty()) {
      return tags;
    }
    if (tags == null) {
      tags = new LinkedList<Tag>();
    }
    for (final String name : names) {
      tags.add(new Tag(scope, name));
    }
    return tags;
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
   * @param name
   *          the name of new tag in the specified scope to be updated to the tag
   *          list.
   * @return the tag list after update, which cannot be <code>null</code>.
   */
  public static List<Tag> updateTagInScope(String scope,
      @Nullable List<Tag> tags, String name) {
    Argument.requireNonEmpty("scope", scope);
    Argument.requireNonNull("name", name);
    if (tags == null) {
      tags = new LinkedList<Tag>();
    } else {
      removeTagsInScope(scope, tags);
    }
    tags.add(new Tag(scope, name));
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
   * @param names
   *          the names of new tags in the specified scope to be updated to the tag
   *          list.
   * @return the tag list after update, which may be <code>null</code>.
   */
  public static List<Tag> updateTagsInScope(String scope,
      @Nullable List<Tag> tags, List<String> names) {
    Argument.requireNonEmpty("scope", scope);
    Argument.requireNonNull("names", names);
    if (tags == null) {
      if (names.isEmpty()) {
        return null;
      }
      tags = new LinkedList<Tag>();
    } else {
      removeTagsInScope(scope, tags);
    }
    for (final String name : names) {
      tags.add(new Tag(scope, name));
    }
    return tags;
  }

  /**
   * Removes a tag in the specified scope from a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code> or empty. If it
   *          is <code>null</code> or empty, this function will create a new tag
   *          list, add the new tag to the list, and return the new tag list.
   * @param name
   *          the name of tag in the specified scope to be removed from the tag
   *          list.
   */
  public static void removeTagInScope(String scope, @Nullable List<Tag> tags,
      String name) {
    Argument.requireNonEmpty("scope", scope);
    Argument.requireNonNull("name", name);
    if (tags == null) {
      return;
    }
    final ListIterator<Tag> iter = tags.listIterator();
    while (iter.hasNext()) {
      final Tag tag = iter.next();
      if (scope.equals(tag.getScope()) && name.equals(tag.getName())) {
        iter.remove();
      }
    }
  }

  /**
   * Removes tags in the specified scope from a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which could be <code>null</code> or empty. If it
   *          is <code>null</code> or empty, this function will create a new tag
   *          list, add the new tag to the list, and return the new tag list.
   * @param names
   *          the names of tags in the specified scope to be removed from the tag
   *          list.
   */
  public static void removeTagsInScope(String scope, @Nullable List<Tag> tags,
      List<String> names) {
    Argument.requireNonEmpty("scope", scope);
    Argument.requireNonNull("names", names);
    if ((tags == null) || (names.isEmpty())) {
      return;
    }
    final ListIterator<Tag> iter = tags.listIterator();
    while (iter.hasNext()) {
      final Tag tag = iter.next();
      if (scope.equals(tag.getScope())) {
        if (names.contains(tag.getName())) {
          iter.remove();
        }
      }
    }
  }

  /**
   * Removes all the tags in the specified scope from a tag list.
   *
   * @param scope
   *          the scope of tags, which cannot be <code>null</code> nor empty.
   * @param tags
   *          the list of tags, which may be <code>null</code>.
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
}
