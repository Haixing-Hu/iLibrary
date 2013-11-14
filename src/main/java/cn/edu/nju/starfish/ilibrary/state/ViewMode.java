/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.state;


/**
 * The enumeration of view mode states.
 *
 * @author Haixing Hu
 */
public final class ViewMode {

  public static final int NONE = 0;

  public static final int INSPECTOR = 0x01;

  public static final int PREVIEW = 0x02;

  public static final int ALL = INSPECTOR | PREVIEW;

}
