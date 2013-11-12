/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model.tag;

import java.util.List;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nju.starfish.ilibrary.model.Label;
import cn.edu.nju.starfish.ilibrary.utils.Argument;
import cn.edu.nju.starfish.ilibrary.utils.TagUtils;

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
   *          it is <code>null</code>, this function will create a new tag list,
   *          put the tag of the label to the new tag list, and return the new tag
   *          list.
   * @param label
   *          the label to be set, which cannot be <code>null</code>.
   * @return the tag list after updating, or a new tag list if the tag list
   *         passed to the argument is <code>null</code>.
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
   *          the label to be represented, which cannot be <code>null</code>.
   */
  public LabelTag(Label label) {
    super(TagScope.LABEL.name(), label.name());
  }
}
