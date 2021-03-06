/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2014 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.maven.plugins.nodejs.installation;

import io.wcm.maven.plugins.nodejs.mojo.Task;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * Task to for extracting gzipped tar archives
 */
public class NodeUnarchiveTask extends Task {

  protected String nodeJsDirectory;

  /**
   * public constructor
   * @param nodeJsDirectory
   */
  public NodeUnarchiveTask(String nodeJsDirectory) {
    this.nodeJsDirectory = nodeJsDirectory;
  }


  @Override
  public void execute(NodeInstallationInformation information) throws MojoExecutionException {
    TarUnArchiver unArchiver = new TarUnArchiver(information.getArchive());
    unArchiver.unarchive(nodeJsDirectory);
  }

}
