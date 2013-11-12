/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model.tag;

import cn.edu.nju.starfish.ilibrary.model.PeriodicalType;

/**
 * The tag representing a type of periodicals.
 * <p>
 * A tag representing a type of periodicals have the scope equals to the
 * name of the {@link TagScope#PERIODICAL_TYPE}.
 *
 * @author Haixing Hu
 */
public class PeriodicalTypeTag extends Tag {

  /**
   * This tag represents the predefined periodical type {@link PeriodicalType#JOURNAL}.
   */
  public static final PeriodicalTypeTag JOURNAL =
      new PeriodicalTypeTag(PeriodicalType.JOURNAL.name());

  /**
   * This tag represents the predefined periodical type {@link PeriodicalType#LAW_REPORT}.
   */
  public static final PeriodicalTypeTag LAW_REPORT =
      new PeriodicalTypeTag(PeriodicalType.LAW_REPORT.name());

  /**
   * This tag represents the predefined periodical type {@link PeriodicalType#MAGAZINE}.
   */
  public static final PeriodicalTypeTag MAGAZINE =
      new PeriodicalTypeTag(PeriodicalType.MAGAZINE.name());

  /**
   * This tag represents the predefined periodical type {@link PeriodicalType#NEWSPAPER}.
   */
  public static final PeriodicalTypeTag NEWSPAPER =
      new PeriodicalTypeTag(PeriodicalType.NEWSPAPER.name());

  /**
   * Constructs a tag representing a type of periodicals.
   *
   * @param typeName
   *    the name of the type.
   */
  public PeriodicalTypeTag(String typeName) {
    super(TagScope.PERIODICAL_TYPE.name(), typeName);
  }

}
