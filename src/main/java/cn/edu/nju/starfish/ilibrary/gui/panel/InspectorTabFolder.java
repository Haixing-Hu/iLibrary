/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.panel;

import org.eclipse.swt.widgets.Composite;

import cn.edu.nju.starfish.ilibrary.Application;
import cn.edu.nju.starfish.ilibrary.gui.widget.BaseTabFolder;

/**
 * The inspector tab folder.
 *
 * @author Haixing Hu
 */
public class InspectorTabFolder extends BaseTabFolder {

  public static final String KEY = InspectorPanel.KEY + ".tab";

  private InfoTab infoTab;
  private NotesTab notesTab;
  private ReviewTab reviewTab;
  private FilesTab filesTab;

  public InspectorTabFolder(Application application, Composite parent) {
    super(application, KEY, parent);
  }

  @Override
  protected void createContents() {
    this.infoTab = new InfoTab(application, this);
    this.notesTab = new NotesTab(application, this);
    this.reviewTab = new ReviewTab(application, this);
    this.filesTab = new FilesTab(application, this);
    this.setSelection(infoTab);
  }

  /**
   * Gets the information tab.
   *
   * @return the information tab.
   */
  public InfoTab getInfoTab() {
    return infoTab;
  }

  /**
   * Gets the notes tab.
   *
   * @return the notes tab.
   */
  public NotesTab getNotesTab() {
    return notesTab;
  }

  /**
   * Gets the review tab.
   *
   * @return the review tab.
   */
  public ReviewTab getReviewTab() {
    return reviewTab;
  }

  /**
   * Gets the files tab.
   *
   * @return the files tab.
   */
  public FilesTab getFilesTab() {
    return filesTab;
  }

}
