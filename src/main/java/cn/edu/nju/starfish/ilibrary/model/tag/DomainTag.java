/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model.tag;

import java.util.List;

import javax.annotation.Nullable;

import cn.edu.nju.starfish.ilibrary.utils.Argument;
import cn.edu.nju.starfish.ilibrary.utils.TagUtils;

/**
 * The tag representing a domain.
 * <p>
 * A tag representing a domain have the scope equals to the name of the
 * {@link TagScope#DOMAIN}.
 *
 * @author Haixing Hu
 */
public class DomainTag extends Tag {

  /**
   * Gets the domain from a list of tags.
   * <p>
   * This function will check the tags in the tag list, and returns the name of
   * the first tag in the scope {@link TagScope#DOMAIN}. If there is no such
   * tag, this function will return <code>null</code>.
   *
   * @param tags
   *          a list of tags, which could be null or empty.
   * @return the name of the domain get from the tag list, or <code>null</code>
   *         if not found.
   */
  public static String getDomain(@Nullable List<Tag> tags) {
    if (tags == null) {
      return null;
    }
    final String scope = TagScope.DOMAIN.name();
    final Tag tag = TagUtils.getFirstTagInScope(scope, tags);
    if (tag == null) {
      return null;
    } else {
      return tag.getName();
    }
  }

  /**
   * Sets the domain to a tag list.
   * <p>
   * After calling this function, the old tag or tags representing a domain will
   * be removed, and a new tag representing the specified domain will be added
   * to the tag list.
   *
   * @param tags
   *          the list of tags, where to update the domain. It could be null. If
   *          it is <code>null</code>, this function will create a new tag list,
   *          put the tag of the domain to the new tag list, and return the new
   *          tag list.
   * @param domain
   *          the name of the domain to be set, which cannot be null nor empty.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is <code>null</code>.
   */
  public static List<Tag> setDomain(@Nullable List<Tag> tags, String domain) {
    Argument.requireNonEmpty("domain", domain);
    return TagUtils.updateTagInScope(TagScope.DOMAIN.name(), tags, domain);
  }

  /**
   * Constructs a tag representing a domain.
   *
   * @param domain
   *          the name of a domain.
   */
  public DomainTag(String domain) {
    super(TagScope.DOMAIN.name(), domain);
  }
}
