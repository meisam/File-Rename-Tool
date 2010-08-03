/**
 * File Rename Tool
 * Copyright (C) 2010, Meisam Fathi <meisam.fathi[at]gmail.com>
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library;
 * if not, write to the Free Software Foundation, Inc., 
 * 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307 USA
 */

package com.github.mfs.frt.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * {@link ActionListener} for <code>export Button</code>
 * 
 * @author Meisam Fathi
 * @version 0.1, Agust 03, 2010
 */
public class RenameButttonActionListener implements ActionListener {

  private final IApplicationUI ui;

  public RenameButttonActionListener(final IApplicationUI uiModel) {
    this.ui = uiModel;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    this.ui.renameFiles();
  }

}
