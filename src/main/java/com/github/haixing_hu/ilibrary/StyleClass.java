/*
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
 */package com.github.haixing_hu.ilibrary;

import javafx.css.PseudoClass;

/**
 * Defines the constants of style classes.
 *
 * @author Haixing Hu
 */
public interface StyleClass {

  public static final String HEADER = "header";

  public static final String FOOTER = "footer";

  public static final String TOOLBAR = "toolbar";

  public static final String ALIGN_CENTER_LEFT = "align-center-left";

  public static final String ALIGN_CENTER = "align-center";

  public static final String ALIGN_CENTER_RIGHT = "align-center-right";

  public static final String TITLE = "title";

  public static final String CONTENT = "content";

  public static final String PAGE_TITLE = "page-title";

  public static final String TREE_VIEW = "tree-view";

  public static final String TAB_PAGE = "tab-page";

  public static final PseudoClass ACTIVE = PseudoClass.getPseudoClass("active");
}
