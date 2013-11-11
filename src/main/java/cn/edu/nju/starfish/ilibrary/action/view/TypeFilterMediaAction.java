/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.action.view;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.action.BaseCheckBoxAction;
import cn.edu.nju.starfish.ilibrary.state.TypeFilter;

/**
 * The action to filter media documents.
 *
 * @author Haixing Hu
 */
public class TypeFilterMediaAction extends BaseCheckBoxAction {

  public static final String KEY = TypeFilterAction.KEY + ".media";

  public TypeFilterMediaAction(Application application) {
    super(application, KEY);
  }

  @Override
  public void run() {
    TypeFilter.update(application, TypeFilter.MEDIA);
  }
}
