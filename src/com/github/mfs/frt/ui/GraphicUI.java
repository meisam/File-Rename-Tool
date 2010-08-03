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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.github.mfs.frt.Application;

/**
 * @author Meisam Fathi
 * @version 0.1, July 26, 2010
 */
public class GraphicUI extends JFrame implements IApplicationUI {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  private final Application application;

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
  private JLabel prefixLabel;

  /**
   * 
   */
  private JTextField prefixField;

  /**
   * 
   */
  private JLabel postfixLabel;

  /**
   * 
   */
  private JTextField postfixField;

  /**
   * 
   */
  private JButton exportButtton;

  /**
	 * 
	 */
  private JButton renameButtton;

  /**
   * 
   */
  private JLabel fileNameLabel;

  /**
   * 
   */
  private JScrollPane scrollPane;

  /**
   * 
   */
  private JList filesList;

  /**
   * 
   */
  private DefaultListModel filesListDataModel;

  /**
   * 
   */
  private JFileChooser fileChooser;

  /**
   * 
   */
  private BrowseButttonActionListener browseButttonActionListener;

  /**
   * 
   */
  private RenameButttonActionListener renameButttonActionListener;

  /**
   * 
   */
  private ExportButttonActionListener exportButttonActionListener;

  /**
   * 
   */
  private File workingDirectory;

  /**
   * @throws HeadlessException
   */
  public GraphicUI(final Application application) throws HeadlessException {
    super();
    this.application = application;
    this.setLayout(new BorderLayout());
    this.getContentPane().add(this.getBrowsePanel(), BorderLayout.NORTH);
    this.getContentPane().add(this.getFilesListPanel(), BorderLayout.CENTER);
    this.getContentPane().add(this.getActionsPanel(), BorderLayout.SOUTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
      this.browseButtton.addActionListener(this.getBrownButtonActionListener());
    }
    return this.browseButtton;
  }

  private ActionListener getBrownButtonActionListener() {
    if (this.browseButttonActionListener == null) {
      this.browseButttonActionListener =
          new BrowseButttonActionListener(GraphicUI.this);
    }
    return this.browseButttonActionListener;
  }

  /**
   * @return
   */
  private JPanel getFilesListPanel() {
    if (this.filesListPanel == null) {
      this.filesListPanel = new JPanel();
      this.filesListPanel.setLayout(new BorderLayout());
      this.filesListPanel.add(this.getScrollPane(), BorderLayout.CENTER);
    }
    return this.filesListPanel;
  }

  private JScrollPane getScrollPane() {
    if (this.scrollPane == null) {
      this.scrollPane = new JScrollPane();
      this.scrollPane.setPreferredSize(new Dimension(600, 500));
      this.scrollPane.getViewport().add(this.getFilesList());
    }
    return this.scrollPane;
  }

  private JList getFilesList() {
    if (this.filesList == null) {
      this.filesList = new JList(this.getFilesListDataModel());
    }
    return this.filesList;
  }

  private DefaultListModel getFilesListDataModel() {
    if (this.filesListDataModel == null) {
      this.filesListDataModel = new DefaultListModel();
      this.filesListDataModel.add(0, "Hello");
      this.filesListDataModel.add(0, "Hello");
      this.filesListDataModel.add(0, "Hello");
      this.filesListDataModel.add(0, "Hello");
    }
    return this.filesListDataModel;
  }

  /**
   * @return
   */
  private JPanel getActionsPanel() {
    if (this.actionsPanel == null) {
      this.actionsPanel = new JPanel();
      this.actionsPanel.add(this.getExportButton());
      this.actionsPanel.add(this.getPrefixField());
      this.actionsPanel.add(this.getPrefixLabel());
      this.actionsPanel.add(this.getFileNameLabel());
      this.actionsPanel.add(this.getPostLabel());
      this.actionsPanel.add(this.getPostfixField());
      this.actionsPanel.add(this.getRenameButton());
    }
    return this.actionsPanel;
  }

  private JButton getExportButton() {
    if (this.exportButtton == null) {
      this.exportButtton = new JButton();
      this.exportButtton.setText("Export...");
      this.exportButtton
          .addActionListener(this.getExportButtonActionListener());
    }
    return this.exportButtton;
  }

  private ActionListener getExportButtonActionListener() {
    if (this.exportButttonActionListener == null) {
      this.exportButttonActionListener =
          new ExportButttonActionListener(GraphicUI.this);
    }
    return this.exportButttonActionListener;
  }

  /**
   * @return
   */
  private JLabel getPrefixLabel() {
    if (this.prefixLabel == null) {
      this.prefixLabel = new JLabel(" + ");
    }
    return this.prefixLabel;
  }

  /**
   * @return
   */
  private JLabel getFileNameLabel() {
    if (this.fileNameLabel == null) {
      this.fileNameLabel = new JLabel(" file ");
    }
    return this.fileNameLabel;
  }

  /**
   * @return
   */
  private JTextField getPrefixField() {
    if (this.prefixField == null) {
      this.prefixField = new JTextField(30);
    }
    return this.prefixField;
  }

  /**
   * @return
   */
  private JLabel getPostLabel() {
    if (this.postfixLabel == null) {
      this.postfixLabel = new JLabel(" + ");
    }
    return this.postfixLabel;
  }

  /**
   * @return
   */
  private JTextField getPostfixField() {
    if (this.postfixField == null) {
      this.postfixField = new JTextField(30);
    }
    return this.postfixField;
  }

  private JButton getRenameButton() {
    if (this.renameButtton == null) {
      this.renameButtton = new JButton();
      this.renameButtton.setText("Rename...");
      this.renameButtton
          .addActionListener(this.getRenameButtonActionListener());
    }
    return this.renameButtton;
  }

  private ActionListener getRenameButtonActionListener() {
    if (this.renameButttonActionListener == null) {
      this.renameButttonActionListener =
          new RenameButttonActionListener(GraphicUI.this);
    }
    return this.renameButttonActionListener;
  }

  @Override
  public void showFileChooser() {
    final int popDownStatus =
        this.getFileChooser().showOpenDialog(GraphicUI.this);
    switch (popDownStatus) {
    case JFileChooser.CANCEL_OPTION:
      break;
    case JFileChooser.ERROR_OPTION:
      throw new ShowDirectoryChooserException();
      // break; // no break needed
    case JFileChooser.APPROVE_OPTION:
      final File selectedFile = this.getFileChooser().getSelectedFile();
      this.changeDirectory(selectedFile);
      break;
    default:
      throw new UnknownFileChooseOption();
    }

  }

  private void changeDirectory(final File directory) {
    this.workingDirectory = directory;
    final Collection<File> listAllFiles =
        this.application.listAllFiles(directory);
    this.getFilesListDataModel().removeAllElements();
    for (final File file : listAllFiles) {
      this.getFilesListDataModel().addElement(file);
    }
  }

  private JFileChooser getFileChooser() {
    if (this.fileChooser == null) {
      this.fileChooser = new JFileChooser();
      this.fileChooser.setMultiSelectionEnabled(false);
      this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }
    return this.fileChooser;
  }

  @Override
  public File getWorkingDirectory() {
    return this.workingDirectory;
  }

  @Override
  public void exportFiles() {
    final Collection<File> allFiles =
        this.application.listAllFiles(this.workingDirectory);
    this.application.exportFiles(allFiles);
  }

  @Override
  public void renameFiles() {
    final Collection<File> allFiles =
        this.application.listAllFiles(this.workingDirectory);
    final String prefix = this.getPrefixField().getText();
    final String postfix = this.getPostfixField().getText();
    this.application.renameAll(allFiles, prefix, postfix);
  }

}
