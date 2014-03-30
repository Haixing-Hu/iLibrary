/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.utils.tree;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * An implementation of tree using a array list to store the children.
 *
 * @author Haixing Hu
 */
@NotThreadSafe
public class ArrayListTree<KEY, VALUE> extends AbstractListTree<KEY, VALUE> {

  @Override
  protected List<Tree<KEY, VALUE>> makeTreeList() {
    return new ArrayList<Tree<KEY, VALUE>>();
  }

  public ArrayListTree(KEY key, VALUE value) {
    super(key, value);
  }

}
