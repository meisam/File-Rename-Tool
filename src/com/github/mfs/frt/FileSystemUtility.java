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

package com.github.mfs.frt;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * utility Class For working with files
 * 
 * @author Meisam Fathi
 * @version 0.1, July 26, 2010
 */
public class FileSystemUtility {

  private static final String FileExtensionSeperator = ".";

  private static final String EMPTY_STRING = "";

  public static Collection<File> renameAll(final Collection<File> files,
      final String prefix, final String postFix) {

    final Collection<File> newFiles = new Vector<File>(files.size());
    for (final Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
      final File file = iterator.next();
      final String filePath = file.getParentFile().getPath();
      final String oldName = file.getName();

      // file name without file extension
      final String pureFileName = extractPureFileName(oldName);
      final String fileExtension = extractFileExtension(oldName);

      final String newName = prefix + pureFileName + postFix + fileExtension;
      final File newFile = new File(filePath + File.separatorChar + newName);
      newFiles.add(newFile);
      final boolean succeeded = file.renameTo(newFile);
      if (!succeeded)
        throw new FileRenameException("Cannot rename '" + file + "' to '"
            + newFile + "'");
    }
    return newFiles;
  }

  private static String extractFileExtension(String fileName) {
    int extensionIndex = fileName.lastIndexOf(FileExtensionSeperator);
    if (extensionIndex == -1) {
      return "";
    } else {
      return fileName.substring(extensionIndex, fileName.length());
    }
  }

  private static String extractPureFileName(String fileName) {
    int extensionIndex = fileName.lastIndexOf(FileExtensionSeperator);
    if (extensionIndex == -1) {
      return fileName;
    } else {
      return fileName.substring(0, extensionIndex);
    }
  }

  public static Collection<File> listAllFile(final File directory) {
    final Collection<File> visitedFiles = new Vector<File>(1000);
    final Queue<File> dirsToVisit = new LinkedList<File>();
    if (FileSystemUtility.isValidDirectory(directory)) {
      dirsToVisit.add(directory);
    }
    while (!dirsToVisit.isEmpty()) {
      final File currentDir = dirsToVisit.poll();
      final File[] files = currentDir.listFiles();
      for (int i = 0; i < files.length; i++) {
        if (FileSystemUtility.isValidDirectory(files[i])) {
          dirsToVisit.add(files[i]);
        } else if (FileSystemUtility.isValidFile(files[i])) {
          visitedFiles.add(files[i]);
        }
      }
    }
    return visitedFiles;
  }

  private static boolean isValidDirectory(final File dir) {
    return (dir != null) && dir.isDirectory() && dir.canRead();
  }

  private static boolean isValidFile(final File file) {
    return (file != null) && file.isFile() && file.canRead();
  }
}
