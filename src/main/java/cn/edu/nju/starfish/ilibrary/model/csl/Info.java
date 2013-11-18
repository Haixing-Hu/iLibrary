/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model.csl;

import java.util.List;

/**
 * The model of meta information of a CSL.
 *
 * @author Haixing Hu
 */
public class Info {

  private String id;
  private String title;
  private List<Author> authors;
  private List<Author> contributors;
  private List<Category> categories;
  private List<String> ISSNs;
  private List<String> EISSNs;
  private List<String> ISSNLs;

}
