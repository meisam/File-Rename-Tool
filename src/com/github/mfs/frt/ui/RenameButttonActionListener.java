  /**
   * File-Rename-Tool is a simple tool for renaming significant number of files.
   * Copyright (C) 2010  Meisam Fathi Salmi <meisam.fathi[at]gmail.com>
   * 
   * This program is free software: you can redistribute it and/or modify
   * it under the terms of the GNU General Public License as published by
   * the Free Software Foundation, either version 3 of the License, or
   * (at your option) any later version.
   * 
   * This program is distributed in the hope that it will be useful,
   * but WITHOUT ANY WARRANTY; without even the implied warranty of
   * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   * GNU General Public License for more details.
   * 
   * You should have received a copy of the GNU General Public License
   * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
