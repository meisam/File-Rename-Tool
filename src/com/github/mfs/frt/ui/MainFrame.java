/**
 * File Rename Tool
 * Copyright (C) 2010, Meisam Fathi <meisam.fathi[at]gmail.com>
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.github.mfs.frt.ui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Meisam Fathi
 * @version 0.1, July 26, 2010
 * 
 */
public class MainFrame extends JFrame {

	/**
   * 
   */
	private JPanel browsePanel;
	/**
   * 
   */
	private JPanel filesListPanel;
	/**
   * 
   */
	private JPanel actionsPanel;
	private JTextField fileNameField;
	private JButton browseButtton;

	/**
	 * @throws HeadlessException
	 */
	public MainFrame() throws HeadlessException {
		super();
		setLayout(new BorderLayout());
		getContentPane().add(getBrowsePanel(), BorderLayout.NORTH);
		getContentPane().add(getFilesListPanel(), BorderLayout.CENTER);
		getContentPane().add(getActionsPanel(), BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * @return
	 */
	private JPanel getBrowsePanel() {
		if (this.browsePanel == null) {
			this.browsePanel = new JPanel();
			this.browsePanel.add(getFileNameField());
			this.browsePanel.add(getBrowseButtton());
		}
		return this.browsePanel;
	}

	/**
	 * @return
	 */
	private JTextField getFileNameField() {
		if (this.fileNameField == null) {
			this.fileNameField = new JTextField(50);
		}
		return this.fileNameField;
	}

	/**
	 * @return
	 */
	private JButton getBrowseButtton() {
		if (this.browseButtton == null) {
			this.browseButtton = new JButton();
			this.browseButtton.setText("Browse...");
		}
		return this.browseButtton;
	}

	/**
	 * @return
	 */
	private JPanel getFilesListPanel() {
		if (this.filesListPanel == null) {
			this.filesListPanel = new JPanel();
		}
		return this.filesListPanel;
	}

	/**
	 * @return
	 */
	private JPanel getActionsPanel() {
		if (this.actionsPanel == null) {
			this.actionsPanel = new JPanel();
		}
		return this.actionsPanel;
	}

}
