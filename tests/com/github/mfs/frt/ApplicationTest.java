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
import java.util.Vector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Application}
 * 
 * @author Meisam Fathi
 * @version 0.1, Agust 03, 2010
 */
public class ApplicationTest {

  private Application application;
  @Before
  public void before() {
    this.application = new Application();
  }
  
  @Test
  public void testRenameAll() {
    final Collection<File> files = new Vector<File>(5);
    try {
      for (int i = 0; i < 5; i++) {
        final File tempFile =
            File.createTempFile("file-rename-tool-test", "tmps");
        tempFile.deleteOnExit();
        files.add(tempFile);
      }
      final String prefix = "zzzzzzzzzzzzzzzzz";
      final String postFix = "xxxxxxxxxxxxxxxxx";
      final Collection<File> renamedFiles =
        application.renameAll(files, prefix, postFix);
      for (final Iterator<File> iterator = renamedFiles.iterator(); iterator
          .hasNext();) {
        final File file = iterator.next();
        Assert.assertTrue(file.getName().endsWith(postFix));
        Assert.assertTrue(file.getName().startsWith(prefix));
      }
    } catch (final Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void testListAllFiles() {
    final Collection<File> files = new Vector<File>(5);
    try {
      final File tempFile = File.createTempFile("file-rename-tool-test", "tmps");

      final File directory = tempFile.getParentFile();

      final Collection<File> allFiles = FileSystemUtility.listAllFile(directory);

      Assert.assertTrue(allFiles.contains(tempFile));
    } catch (final Exception e) {
      Assert.fail(e.getMessage());
    }
  }
}
