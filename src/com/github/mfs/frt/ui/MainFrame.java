/**
 * File Rename Tool Copyright (C) 2010, Meisam Fathi <meisam.fathi[at]gmail.com>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version. This library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details. You should have received a copy of
 * the GNU Lesser General Public License along with this library; if not, write
 * to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307 USA
 */

package com.github.mfs.frt.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Meisam Fathi
 * @version 0.1, July 26, 2010
 */
public class MainFrame extends JFrame {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;

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

  /**
	 * 
	 */
  private JTextField fileNameField;

  /**
	 * 
	 */
  private JButton browseButtton;

  /**
   * 
   */
  private JTextField prefixField;

  /**
   * 
   */
  private JTextField postfixField;

  /**
	 * 
	 */
  private JButton exportButtton;

  /**
   * @throws HeadlessException
   */
  public MainFrame() throws HeadlessException {
    super();
    this.setLayout(new BorderLayout());
    this.getContentPane().add(this.getBrowsePanel(), BorderLayout.NORTH);
    this.getContentPane().add(this.getFilesListPanel(), BorderLayout.CENTER);
    this.getContentPane().add(this.getActionsPanel(), BorderLayout.SOUTH);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  /**
   * @return
   */
  private JPanel getBrowsePanel() {
    if (this.browsePanel == null) {
      this.browsePanel = new JPanel();
      this.browsePanel.add(this.getFileNameField());
      this.browsePanel.add(this.getBrowseButtton());
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
      this.actionsPanel.add(getExportButton());
      this.actionsPanel.add(getPrefixField());
      this.actionsPanel.add(getPostfixField());
    }
    return this.actionsPanel;
  }

  /**
   * @return
   */
  private JTextField getPrefixField() {
    if (this.prefixField == null) {
      this.prefixField = new JTextField(50);
    }
    return this.prefixField;
  }

  /**
   * @return
   */
  private JTextField getPostfixField() {
    if (this.postfixField == null) {
      this.postfixField = new JTextField(50);
    }
    return this.postfixField;
  }

  private JButton getExportButton() {
    if (this.exportButtton == null) {
      this.exportButtton = new JButton();
      this.exportButtton.setText("Export...");
    }
    return this.exportButtton;
  }

}
