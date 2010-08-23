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
      String fileNameExtension = ".tmp";
      String fileNamePrefix = "file-rename-tool-test";
      for (int i = 0; i < 5; i++) {
        final File tempFile =
            File.createTempFile(fileNamePrefix, fileNameExtension);
        tempFile.deleteOnExit();
        files.add(tempFile);
      }
      final String prefix = "zzzzzzzzzzzzzzzzz";
      final String postFix = "xxxxxxxxxxxxxxxxx";
      final Collection<File> renamedFiles =
          this.application.renameAll(files, prefix, postFix);
      for (final Iterator<File> iterator = renamedFiles.iterator(); iterator
          .hasNext();) {
        final File file = iterator.next();
        Assert.assertTrue(file.getName().startsWith(prefix + fileNamePrefix));
        Assert.assertTrue(file.getName() + " doesn't end with " + postFix
            + fileNameExtension,
            file.getName().endsWith(postFix + fileNameExtension));
      }
    } catch (final Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void testRenameAllNoExtension() {
    final Collection<File> files = new Vector<File>(5);
    try {
      String fileNameExtension = "tmp";
      String fileNamePrefix = "file-rename-tool-test";
      for (int i = 0; i < 5; i++) {
        final File tempFile =
            File.createTempFile(fileNamePrefix, fileNameExtension);
        tempFile.deleteOnExit();
        files.add(tempFile);
      }
      final String prefix = "zzzzzzzzzzzzzzzzz";
      final String postFix = "xxxxxxxxxxxxxxxxx";
      final Collection<File> renamedFiles =
          this.application.renameAll(files, prefix, postFix);
      for (final Iterator<File> iterator = renamedFiles.iterator(); iterator
          .hasNext();) {
        final File file = iterator.next();
        Assert.assertTrue(file.getName().startsWith(prefix + fileNamePrefix));
        Assert.assertTrue(file.getName() + " doesn't end with "
            + fileNameExtension + postFix,
            file.getName().endsWith(fileNameExtension + postFix));
      }
    } catch (final Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void testRenameAllTwoExtension() {
    final Collection<File> files = new Vector<File>(5);
    try {
      String virtualExtension = ".ephemral";
      String realExtension = ".tmp";
      String fileNamePrefix = "file-rename-tool-test";
      for (int i = 0; i < 5; i++) {
        final File tempFile =
            File.createTempFile(fileNamePrefix, virtualExtension
                + realExtension);
        tempFile.deleteOnExit();
        files.add(tempFile);
      }
      final String prefix = "zzzzzzzzzzzzzzzzz";
      final String postFix = "xxxxxxxxxxxxxxxxx";
      final Collection<File> renamedFiles =
          this.application.renameAll(files, prefix, postFix);
      for (final Iterator<File> iterator = renamedFiles.iterator(); iterator
          .hasNext();) {
        final File file = iterator.next();
        Assert.assertTrue(file.getName().startsWith(prefix + fileNamePrefix));
        Assert
            .assertTrue(
                file.getName() + " doesn't end with " + postFix + realExtension,
                file.getName().endsWith(
                    virtualExtension + postFix + realExtension));
      }
    } catch (final Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void testListAllFiles() {
    try {
      final File tempFile =
          File.createTempFile("file-rename-tool-test", "tmps");

      final File directory = tempFile.getParentFile();

      final Collection<File> allFiles =
          FileSystemUtility.listAllFile(directory);

      Assert.assertTrue(allFiles.contains(tempFile));
    } catch (final Exception e) {
      Assert.fail(e.getMessage());
    }
  }
}
