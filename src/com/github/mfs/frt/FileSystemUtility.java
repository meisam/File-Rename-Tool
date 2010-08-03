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

  public static Collection<File> renameAll(final Collection<File> files,
      final String prefix, final String postFix) {

    final Collection<File> newFiles = new Vector<File>(files.size());
    for (final Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
      final File file = iterator.next();
      final String filePath = file.getParentFile().getPath();
      final String oldName = file.getName();

      final String newName = prefix + oldName + postFix;
      final File newFile = new File(filePath + File.separatorChar + newName);
      final boolean succeeded = file.renameTo(newFile);
      if (!succeeded)
        throw new FileRenameException("Cannot rename '" + file + "' to '"
            + newFile + "'");
    }
    return newFiles;
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
