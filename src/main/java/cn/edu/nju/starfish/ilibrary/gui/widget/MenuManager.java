/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.gui.widget;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.ContributionManager;
import org.eclipse.jface.action.ExternalActionManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IContributionManagerOverrides;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuListener2;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;

/**
 * A menu manager is a contribution manager which realizes itself and its items
 * in a menu control; either as a menu bar, a sub-menu, or a context menu.
 * <p>
 * This class may be instantiated; it may also be subclassed.
 * </p>
 * <p>
 * This class is a modified version of the {@link org.eclipse.jface.action.MenuManager},
 * and it provides a function to create a sub-menu for a parent menu.
 * </p>
 *
 * @author Haixing Hu
 */
public class MenuManager extends ContributionManager implements IMenuManager {

  private static final String MANAGER_KEY = "org.eclipse.jface.action.MenuManager.managerKey"; //$NON-NLS-1$

  /**
   * The menu id.
   */
  private final String id;

  /**
   * List of registered menu listeners (element type: <code>IMenuListener</code>
   * ).
   */
  private final ListenerList listeners = new ListenerList();

  /**
   * The menu control; <code>null</code> before creation and after disposal.
   */
  private Menu menu = null;

  /**
   * The menu item widget; <code>null</code> before creation and after disposal.
   * This field is used when this menu manager is a sub-menu.
   */
  private MenuItem menuItem;

  /**
   * The text for a sub-menu.
   */
  private final String menuText;

  /**
   * The image for a sub-menu.
   */
  private final ImageDescriptor image;

  /**
   * A resource manager to remember all of the images that have been used by
   * this menu.
   */
  private LocalResourceManager imageManager;

  /**
   * The overrides for items of this manager
   */
  private IContributionManagerOverrides overrides;

  /**
   * The parent contribution manager.
   */
  private IContributionManager parent;

  /**
   * Indicates whether <code>removeAll</code> should be called just before the
   * menu is displayed.
   */
  private boolean removeAllWhenShown = false;

  /**
   * Indicates this item is visible in its manager; <code>true</code> by
   * default.
   *
   * @since 3.3
   */
  protected boolean visible = true;

  /**
   * allows a submenu to display a shortcut key. This is often used with the
   * QuickMenu command or action which can pop up a menu using the shortcut.
   */
  private String definitionId = null;

  /**
   * Sets whether to show the image of the action. The default value of this
   * attribute is <code>true</code>.
   *
   * @author Haixing Hu
   */
  private boolean showImage = true;

  /**
   * Creates a menu manager. The text and id are <code>null</code>. Typically
   * used for creating a context menu, where it doesn't need to be referred to
   * by id.
   */
  public MenuManager() {
    this(null, null, null);
  }

  /**
   * Creates a menu manager. The text and id are <code>null</code>. Typically
   * used for creating a context menu, where it doesn't need to be referred to
   * by id.
   *
   * @param showImage
   *          indicates whether the new manager manager should display images on
   *          its children menu items.
   */
  public MenuManager(boolean showImage) {
    this(null, null, null);
    this.showImage = showImage;
  }

  /**
   * Creates a menu manager with the given text. The id of the menu is
   * <code>null</code>. Typically used for creating a sub-menu, where it doesn't
   * need to be referred to by id.
   *
   * @param text
   *          the text for the menu, or <code>null</code> if none
   */
  public MenuManager(String text) {
    this(text, null, null);
  }

  /**
   * Creates a menu manager with the given text and id. Typically used for
   * creating a sub-menu, where it needs to be referred to by id.
   *
   * @param text
   *          the text for the menu, or <code>null</code> if none
   * @param id
   *          the menu id, or <code>null</code> if it is to have no id
   */
  public MenuManager(String text, String id) {
    this(text, null, id);
  }

  /**
   * Creates a menu manager with the given text, image, and id. Typically used
   * for creating a sub-menu, where it needs to be referred to by id.
   *
   * @param text
   *          the text for the menu, or <code>null</code> if none
   * @param image
   *          the image for the menu, or <code>null</code> if none
   * @param id
   *          the menu id, or <code>null</code> if it is to have no id
   * @since 3.4
   */
  public MenuManager(String text, ImageDescriptor image, String id) {
    this.menuText = text;
    this.image = image;
    this.id = id;
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.eclipse.jface.action.IMenuManager#addMenuListener(org.eclipse.jface
   * .action.IMenuListener)
   */
  @Override
  public void addMenuListener(IMenuListener listener) {
    listeners.add(listener);
  }

  /**
   * Creates and returns an SWT context menu control for this menu, and installs
   * all registered contributions. Does not create a new control if one already
   * exists.
   * <p>
   * Note that the menu is not expected to be dynamic.
   * </p>
   *
   * @param parent
   *          the parent control
   * @return the menu control
   */
  public Menu createContextMenu(Control parent) {
    if (! menuExist()) {
      menu = new Menu(parent);
      menu.setData(MANAGER_KEY, this);
      initializeMenu();
    }
    return menu;
  }

  /**
   * Creates and returns an SWT context menu control for this menu, and installs
   * all registered contributions. Does not create a new control if one already
   * exists.
   * <p>
   * Note that the menu is not expected to be dynamic.
   * </p>
   *
   * @param parent
   *          the parent menu.
   * @return the menu control
   * @author Haixing Hu
   */
  public Menu createSubMenu(Menu parent) {
    if (! menuExist()) {
      menu = new Menu(parent);
      menu.setData(MANAGER_KEY, this);
      initializeMenu();
    }
    return menu;
  }

  /**
   * Creates and returns an SWT menu bar control for this menu, for use in the
   * given <code>Decorations</code>, and installs all registered contributions.
   * Does not create a new control if one already exists.
   *
   * @param parent
   *          the parent decorations
   * @return the menu control
   * @since 2.1
   */
  public Menu createMenuBar(Decorations parent) {
    if (! menuExist()) {
      menu = new Menu(parent, SWT.BAR);
      menu.setData(MANAGER_KEY, this);
      update(false);
    }
    return menu;
  }

  /**
   * Disposes of this menu manager and frees all allocated SWT resources.
   * Notifies all contribution items of the dispose. Note that this method does
   * not clean up references between this menu manager and its associated
   * contribution items. Use <code>removeAll</code> for that purpose.
   */
  @Override
  public void dispose() {
    if (menuExist()) {
      menu.dispose();
    }
    menu = null;

    if (menuItem != null) {
      menuItem.dispose();
      menuItem = null;
    }

    disposeOldImages();

    final IContributionItem[] items = getItems();
    for (final IContributionItem item : items) {
      item.dispose();
    }

    markDirty();
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets
   * .Composite)
   */
  @Override
  public void fill(Composite parent) {
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets
   * .CoolBar, int)
   */
  @Override
  public void fill(CoolBar parent, int index) {
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets
   * .Menu, int)
   */
  @Override
  public void fill(Menu parent, int index) {
    if ((menuItem == null) || menuItem.isDisposed()) {
      if (index >= 0) {
        menuItem = new MenuItem(parent, SWT.CASCADE, index);
      } else {
        menuItem = new MenuItem(parent, SWT.CASCADE);
      }

      final String text = getMenuText();
      if (text != null) {
        menuItem.setText(text);
      }

      if (image != null) {
        final LocalResourceManager localManager = new LocalResourceManager(
            JFaceResources.getResources());
        menuItem.setImage(localManager.createImage(image));
        disposeOldImages();
        imageManager = localManager;
      }

      if (! menuExist()) {
        menu = new Menu(parent);
        menu.setData(MANAGER_KEY, this);
      }

      menuItem.setMenu(menu);

      initializeMenu();

      setDirty(true);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets
   * .ToolBar, int)
   */
  @Override
  public void fill(ToolBar parent, int index) {
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.eclipse.jface.action.IMenuManager#findMenuUsingPath(java.lang.String)
   */
  @Override
  public IMenuManager findMenuUsingPath(String path) {
    final IContributionItem item = findUsingPath(path);
    if (item instanceof IMenuManager) {
      return (IMenuManager) item;
    }
    return null;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IMenuManager#findUsingPath(java.lang.String)
   */
  @Override
  public IContributionItem findUsingPath(String path) {
    String id = path;
    String rest = null;
    final int separator = path.indexOf('/');
    if (separator != - 1) {
      id = path.substring(0, separator);
      rest = path.substring(separator + 1);
    } else {
      return super.find(path);
    }

    final IContributionItem item = super.find(id);
    if (item instanceof IMenuManager) {
      final IMenuManager manager = (IMenuManager) item;
      return manager.findUsingPath(rest);
    }
    return null;
  }

  /**
   * Notifies any menu listeners that a menu is about to show. Only listeners
   * registered at the time this method is called are notified.
   *
   * @param manager
   *          the menu manager
   *
   * @see IMenuListener#menuAboutToShow
   */
  private void fireAboutToShow(IMenuManager manager) {
    final Object[] listeners = this.listeners.getListeners();
    for (final Object listener : listeners) {
      ((IMenuListener) listener).menuAboutToShow(manager);
    }
  }

  /**
   * Notifies any menu listeners that a menu is about to hide. Only listeners
   * registered at the time this method is called are notified.
   *
   * @param manager
   *          the menu manager
   *
   */
  private void fireAboutToHide(IMenuManager manager) {
    final Object[] listeners = this.listeners.getListeners();
    for (final Object listener : listeners) {
      if (listener instanceof IMenuListener2) {
        final IMenuListener2 listener2 = (IMenuListener2) listener;
        listener2.menuAboutToHide(manager);
      }
    }
  }

  /**
   * Returns the menu id. The menu id is used when creating a contribution item
   * for adding this menu as a sub menu of another.
   *
   * @return the menu id
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * Returns the SWT menu control for this menu manager.
   *
   * @return the menu control
   */
  public Menu getMenu() {
    return menu;
  }

  /**
   * Returns the text shown in the menu, potentially with a shortcut appended.
   *
   * @return the menu text
   */
  public String getMenuText() {
    if (definitionId == null) {
      return menuText;
    }
    final ExternalActionManager.ICallback callback = ExternalActionManager
        .getInstance().getCallback();
    if (callback != null) {
      final String shortCut = callback.getAcceleratorText(definitionId);
      if (shortCut == null) {
        return menuText;
      }
      return menuText + "\t" + shortCut; //$NON-NLS-1$
    }
    return menuText;
  }

  /**
   * Returns the image for this menu as an image descriptor.
   *
   * @return the image, or <code>null</code> if this menu has no image
   * @since 3.4
   */
  public ImageDescriptor getImageDescriptor() {
    return image;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IContributionManager#getOverrides()
   */
  @Override
  public IContributionManagerOverrides getOverrides() {
    if (overrides == null) {
      if (parent == null) {
        overrides = new IContributionManagerOverrides() {
          @Override
          public Integer getAccelerator(IContributionItem item) {
            return null;
          }

          @Override
          public String getAcceleratorText(IContributionItem item) {
            return null;
          }

          @Override
          public Boolean getEnabled(IContributionItem item) {
            return null;
          }

          @Override
          public String getText(IContributionItem item) {
            return null;
          }

          @Override
          public Boolean getVisible(IContributionItem item) {
            return null;
          }
        };
      } else {
        overrides = parent.getOverrides();
      }
      super.setOverrides(overrides);
    }
    return overrides;
  }

  /**
   * Returns the parent contribution manager of this manger.
   *
   * @return the parent contribution manager
   * @since 2.0
   */
  public IContributionManager getParent() {
    return parent;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IMenuManager#getRemoveAllWhenShown()
   */
  @Override
  public boolean getRemoveAllWhenShown() {
    return removeAllWhenShown;
  }

  /**
   * Notifies all listeners that this menu is about to appear.
   */
  private void handleAboutToShow() {
    if (removeAllWhenShown) {
      removeAll();
    }
    fireAboutToShow(this);
    update(false, false);
  }

  /**
   * Notifies all listeners that this menu is about to disappear.
   */
  private void handleAboutToHide() {
    fireAboutToHide(this);
  }

  /**
   * Initializes the menu control.
   */
  private void initializeMenu() {
    menu.addMenuListener(new MenuAdapter() {
      @Override
      public void menuHidden(MenuEvent e) {
        // ApplicationWindow.resetDescription(e.widget);
        handleAboutToHide();
      }

      @Override
      public void menuShown(MenuEvent e) {
        handleAboutToShow();
      }
    });
    // Don't do an update(true) here, in case menu is never opened.
    // Always do it lazily in handleAboutToShow().
  }

  /**
   * Tests whether this menu manager will show the image on the children menu
   * item.
   *
   * @return <code>true</code> if this menu manager will show the image on the
   *         children menu item; <code>false</code> otherwise.
   * @author Haixing Hu
   */
  public boolean isShowImage() {
    return showImage;
  }

  /**
   * Sets whether this menu manager will show the image on the children menu
   * item.
   *
   * @param showImage
   *          <code>true</code> if this menu manager should show the image on the
   *          children menu item; <code>false</code> otherwise.
   * @author Haixing Hu
   */
  public void setShowImage(boolean showImage) {
    this.showImage = showImage;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IContributionItem#isDynamic()
   */
  @Override
  public boolean isDynamic() {
    return false;
  }

  /**
   * Returns whether this menu should be enabled or not. Used to enable the menu
   * item containing this menu when it is realized as a sub-menu.
   * <p>
   * The default implementation of this framework method returns
   * <code>true</code>. Subclasses may reimplement.
   * </p>
   *
   * @return <code>true</code> if enabled, and <code>false</code> if disabled
   */
  @Override
  public boolean isEnabled() {
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IContributionItem#isGroupMarker()
   */
  @Override
  public boolean isGroupMarker() {
    return false;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IContributionItem#isSeparator()
   */
  @Override
  public boolean isSeparator() {
    return false;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IContributionItem#isVisible()
   */
  @Override
  public boolean isVisible() {
    if (! visible) {
      return false; // short circuit calculations in this case
    }

    if (removeAllWhenShown) {
      // we have no way of knowing if the menu has children
      return true;
    }

    // menus aren't visible if all of its children are invisible (or only
    // contains visible separators).
    final IContributionItem[] childItems = getItems();
    boolean visibleChildren = false;
    for (int j = 0; j < childItems.length; j++) {
      if (isChildVisible(childItems[j]) && ! childItems[j].isSeparator()) {
        visibleChildren = true;
        break;
      }
    }

    return visibleChildren;
  }

  /**
   * The <code>MenuManager</code> implementation of this
   * <code>ContributionManager</code> method also propagates the dirty flag up
   * the parent chain.
   *
   * @since 3.1
   */
  @Override
  public void markDirty() {
    super.markDirty();
    // Can't optimize by short-circuiting when the first dirty manager is
    // encountered,
    // since non-visible children are not even processed.
    // That is, it's possible to have a dirty sub-menu under a non-dirty parent
    // menu
    // even after the parent menu has been updated.
    // If items are added/removed in the sub-menu, we still need to propagate
    // the dirty flag up,
    // even if the sub-menu is already dirty, since the result of isVisible()
    // may change
    // due to the added/removed items.
    final IContributionManager parent = getParent();
    if (parent != null) {
      parent.markDirty();
    }
  }

  /**
   * Returns whether the menu control is created and not disposed.
   *
   * @return <code>true</code> if the control is created and not disposed,
   *         <code>false</code> otherwise
   * @since 3.4 protected, was added in 3.1 as private method
   */
  protected boolean menuExist() {
    return (menu != null) && ! menu.isDisposed();
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.eclipse.jface.action.IMenuManager#removeMenuListener(org.eclipse.jface
   * .action.IMenuListener)
   */
  @Override
  public void removeMenuListener(IMenuListener listener) {
    listeners.remove(listener);
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IContributionItem#saveWidgetState()
   */
  @Override
  public void saveWidgetState() {
  }

  /**
   * Sets the overrides for this contribution manager
   *
   * @param newOverrides
   *          the overrides for the items of this manager
   * @since 2.0
   */
  @Override
  public void setOverrides(IContributionManagerOverrides newOverrides) {
    overrides = newOverrides;
    super.setOverrides(overrides);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.eclipse.jface.action.IContributionItem#setParent(org.eclipse.jface.
   * action.IContributionManager)
   */
  @Override
  public void setParent(IContributionManager manager) {
    parent = manager;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IMenuManager#setRemoveAllWhenShown(boolean)
   */
  @Override
  public void setRemoveAllWhenShown(boolean removeAll) {
    this.removeAllWhenShown = removeAll;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IContributionItem#setVisible(boolean)
   */
  @Override
  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  /**
   * Sets the action definition id of this action. This simply allows the menu
   * item text to include a short cut if available. It can be used to notify a
   * user of a key combination that will open a quick menu.
   *
   * @param definitionId
   *          the command definition id
   * @since 3.4
   */
  public void setActionDefinitionId(String definitionId) {
    this.definitionId = definitionId;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IContributionItem#update()
   */
  @Override
  public void update() {
    updateMenuItem();
  }

  /**
   * The <code>MenuManager</code> implementation of this
   * <code>IContributionManager</code> updates this menu, but not any of its
   * submenus.
   *
   * @see #updateAll
   */
  @Override
  public void update(boolean force) {
    update(force, false);
  }

  /**
   * Get all the items from the implementation's widget.
   *
   * @return the menu items
   * @since 3.4
   */
  protected Item[] getMenuItems() {
    if (menu != null) {
      return menu.getItems();
    }
    return null;
  }

  /**
   * Get an item from the implementation's widget.
   *
   * @param index
   *          of the item
   * @return the menu item
   * @since 3.4
   */
  protected Item getMenuItem(int index) {
    if (menu != null) {
      return menu.getItem(index);
    }
    return null;
  }

  /**
   * Get the menu item count for the implementation's widget.
   *
   * @return the number of items
   * @since 3.4
   */
  protected int getMenuItemCount() {
    if (menu != null) {
      return menu.getItemCount();
    }
    return 0;
  }

  /**
   * Call an <code>IContributionItem</code>'s fill method with the
   * implementation's widget. The default is to use the <code>Menu</code>
   * widget.<br>
   * <code>fill(Menu menu, int index)</code>
   *
   * @param ci
   *          An <code>IContributionItem</code> whose <code>fill()</code> method
   *          should be called.
   * @param index
   *          The position the <code>fill()</code> method should start inserting
   *          at.
   * @since 3.4
   */
  protected void doItemFill(IContributionItem ci, int index) {
    ci.fill(menu, index);
  }

  /**
   * Incrementally builds the menu from the contribution items. This method
   * leaves out double separators and separators in the first or last position.
   *
   * @param force
   *          <code>true</code> means update even if not dirty, and
   *          <code>false</code> for normal incremental updating
   * @param recursive
   *          <code>true</code> means recursively update all submenus, and
   *          <code>false</code> means just this menu
   */
  protected void update(boolean force, boolean recursive) {
    if (isDirty() || force) {
      if (menuExist()) {
        // clean contains all active items without double separators
        final IContributionItem[] items = getItems();
        final List<IContributionItem> clean = new ArrayList<IContributionItem>(items.length);
        IContributionItem separator = null;
        for (final IContributionItem item : items) {
          final IContributionItem ci = item;
          if (! isChildVisible(ci)) {
            continue;
          }
          if (ci.isSeparator()) {
            // delay creation until necessary
            // (handles both adjacent separators, and separator at end)
            separator = ci;
          } else {
            if (separator != null) {
              if (clean.size() > 0) {
                clean.add(separator);
              }
              separator = null;
            }
            clean.add(ci);
          }
        }

        // remove obsolete (removed or non active)
        Item[] mi = getMenuItems();

        for (final Item element : mi) {
          final Object data = element.getData();

          if ((data == null) || ! clean.contains(data)) {
            element.dispose();
          } else if ((data instanceof IContributionItem)
              && ((IContributionItem) data).isDynamic()
              && ((IContributionItem) data).isDirty()) {
            element.dispose();
          }
        }

        // add new
        mi = getMenuItems();
        int srcIx = 0;
        int destIx = 0;

        for (final Object element : clean) {
          final IContributionItem src = (IContributionItem) element;
          IContributionItem dest;

          // get corresponding item in SWT widget
          if (srcIx < mi.length) {
            dest = (IContributionItem) mi[srcIx].getData();
          } else {
            dest = null;
          }

          if ((dest != null) && src.equals(dest)) {
            srcIx++;
            destIx++;
          } else if ((dest != null) && dest.isSeparator() && src.isSeparator()) {
            mi[srcIx].setData(src);
            srcIx++;
            destIx++;
          } else {
            final int start = getMenuItemCount();
            doItemFill(src, destIx);
            final int newItems = getMenuItemCount() - start;
            for (int i = 0; i < newItems; i++) {
              final Item item = getMenuItem(destIx++);
              item.setData(src);
            }
          }

          // May be we can optimize this call. If the menu has just
          // been created via the call src.fill(fMenuBar, destIx) then
          // the menu has already been updated with update(true)
          // (see MenuManager). So if force is true we do it again. But
          // we can't set force to false since then information for the
          // sub sub menus is lost.
          if (recursive) {
            IContributionItem item = src;
            if (item instanceof SubContributionItem) {
              item = ((SubContributionItem) item).getInnerItem();
            }
            if (item instanceof IMenuManager) {
              ((IMenuManager) item).updateAll(force);
            }
          }

        }

        // remove any old menu items not accounted for
        for (; srcIx < mi.length; srcIx++) {
          mi[srcIx].dispose();
        }

        setDirty(false);
      }
    } else {
      // I am not dirty. Check if I must recursivly walk down the hierarchy.
      if (recursive) {
        final IContributionItem[] items = getItems();
        for (final IContributionItem ci : items) {
          if (ci instanceof IMenuManager) {
            final IMenuManager mm = (IMenuManager) ci;
            if (isChildVisible(mm)) {
              mm.updateAll(force);
            }
          }
        }
      }
    }
    updateMenuItem();
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IContributionItem#update(java.lang.String)
   */
  @Override
  public void update(String property) {
    final IContributionItem items[] = getItems();

    for (final IContributionItem item : items) {
      item.update(property);
    }

    if ((menu != null) && ! menu.isDisposed() && (menu.getParentItem() != null)) {
      if (IAction.TEXT.equals(property)) {
        String text = getOverrides().getText(this);

        if (text == null) {
          text = getMenuText();
        }

        if (text != null) {
          final ExternalActionManager.ICallback callback = ExternalActionManager
              .getInstance().getCallback();

          if (callback != null) {
            final int index = text.indexOf('&');

            if ((index >= 0) && (index < (text.length() - 1))) {
              final char character = Character.toUpperCase(text
                  .charAt(index + 1));

              if (callback.isAcceleratorInUse(SWT.ALT | character)
                  && isTopLevelMenu()) {
                if (index == 0) {
                  text = text.substring(1);
                } else {
                  text = text.substring(0, index) + text.substring(index + 1);
                }
              }
            }
          }

          menu.getParentItem().setText(text);
        }
      } else if (IAction.IMAGE.equals(property) && (image != null)) {
        final LocalResourceManager localManager = new LocalResourceManager(
            JFaceResources.getResources());
        menu.getParentItem().setImage(localManager.createImage(image));
        disposeOldImages();
        imageManager = localManager;
      }
    }
  }

  private boolean isTopLevelMenu() {
    if ((menu != null) && ! menu.isDisposed() && (menuItem != null)
        && ! menuItem.isDisposed()) {
      final Menu parentMenu = menuItem.getParent();
      return (parentMenu != null)
          && ((parentMenu.getStyle() & SWT.BAR) == SWT.BAR);
    }
    return false;
  }

  /**
   * Dispose any images allocated for this menu
   */
  private void disposeOldImages() {
    if (imageManager != null) {
      imageManager.dispose();
      imageManager = null;
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.jface.action.IMenuManager#updateAll(boolean)
   */
  @Override
  public void updateAll(boolean force) {
    update(force, true);
  }

  /**
   * Updates the menu item for this sub menu. The menu item is disabled if this
   * sub menu is empty. Does nothing if this menu is not a submenu.
   */
  private void updateMenuItem() {
    /*
     * Commented out until proper solution to enablement of menu item for a
     * sub-menu is found. See bug 30833 for more details.
     *
     * if (menuItem != null && !menuItem.isDisposed() && menuExist()) {
     * IContributionItem items[] = getItems(); boolean enabled = false; for (int
     * i = 0; i < items.length; i++) { IContributionItem item = items[i];
     * enabled = item.isEnabled(); if(enabled) break; } // Workaround for
     * 1GDDCN2: SWT:Linux - MenuItem.setEnabled() always causes a redraw if
     * (menuItem.getEnabled() != enabled) menuItem.setEnabled(enabled); }
     */
    // Partial fix for bug #34969 - diable the menu item if no
    // items in sub-menu (for context menus).
    if ((menuItem != null) && ! menuItem.isDisposed() && menuExist()) {
      final boolean enabled = removeAllWhenShown || (menu.getItemCount() > 0);
      // Workaround for 1GDDCN2: SWT:Linux - MenuItem.setEnabled() always causes
      // a redraw
      if (menuItem.getEnabled() != enabled) {
        // We only do this for context menus (for bug #34969)
        Menu topMenu = menu;
        while (topMenu.getParentMenu() != null) {
          topMenu = topMenu.getParentMenu();
        }
        if ((topMenu.getStyle() & SWT.BAR) == 0) {
          menuItem.setEnabled(enabled);
        }
      }
    }
  }

  private boolean isChildVisible(IContributionItem item) {
    final Boolean v = getOverrides().getVisible(item);
    if (v != null) {
      return v.booleanValue();
    }
    return item.isVisible();
  }

  /**
   * Adds an action to this menu.
   * <p>
   * <b>NOTE:</b> We override this method in order to enable or disable the
   * image on the children menu item according to the <code>showImage</code>
   * property of this menu manager.
   *
   * @param action
   *          the action to be added.
   * @see #isShowImage()
   * @see #setShowImage(boolean)
   * @author Haixing Hu
   */
  public void add(Action action) {
    Assert.isNotNull(action, "Action must not be null"); //$NON-NLS-1$
    final IContributionItem item;
    if (showImage) {
      item = new ActionContributionItem(action);
    } else {
      item = new ActionContributionItem(action) {
        @Override
        public void update(String propertyName) {
          if (propertyName == null) {
            // we must split the updating requests and ignore the IMAGE
            super.update(IAction.TEXT);
            // super.update(IAction.IMAGE); // ignore the IMAGE
            super.update(IAction.TOOL_TIP_TEXT);
            super.update(IAction.ENABLED);
            super.update(IAction.CHECKED);
          } else if (propertyName.equals(IAction.IMAGE)) {
            // ignore the update of IMAGE
            return;
          } else {
            super.update(propertyName);
          }
        }
      };
    }
    //  set the visibility of the item according to the visibility of the action.
    if (! action.isVisible()) {
      item.setVisible(false);
    }
    add(item);
  }
}