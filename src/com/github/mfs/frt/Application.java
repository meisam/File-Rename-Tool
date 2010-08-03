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

package com.github.mfs.frt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import com.github.mfs.frt.ui.GraphicUI;
import com.github.mfs.frt.ui.IApplicationUI;

/**
 * The start point of the application
 * 
 * @author Meisam Fathi
 * @version 0.1, July 26, 2010
 */
public class Application {

  private IApplicationUI ui;

  private void setUi(final IApplicationUI ui) {
    this.ui = ui;
  }

  public Collection<File> renameAll(final Collection<File> files, final String prefix,
      final String postFix) {
    return FileSystemUtility.renameAll(files, prefix, postFix);
  }

  public Collection<File> listAllFiles(final File directory) {
    return FileSystemUtility.listAllFile(directory);
  }

  public void exportFiles(final Collection<File> allFiles) {
    try {
      final String fileName =
          this.ui.getWorkingDirectory() + File.separator
              + "all-files-in-subdirs.csv";
      final File file = new File(fileName);
      PrintWriter writer;
      writer = new PrintWriter(file);
      final Iterator<File> filesIterator = allFiles.iterator();
      int count = 1;
      while (filesIterator.hasNext()) {
        final File currentFile = filesIterator.next();
        writer.print(count);
        writer.print(",");
        writer.print(currentFile.getName());
        writer.print(", ");
        writer.print(currentFile.getAbsolutePath());
        writer.println();

        count++;
      }

      writer.flush();
      writer.close();

    } catch (final FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  // ======================== MAIN =============================

  /**
   * @param args
   */
  public static void main(final String[] args) {
    final Application application = new Application();
    final GraphicUI ui = new GraphicUI(application);
    application.setUi(ui);
  }

}
