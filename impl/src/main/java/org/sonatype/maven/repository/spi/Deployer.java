package org.sonatype.maven.repository.spi;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.sonatype.maven.repository.DeployRequest;
import org.sonatype.maven.repository.DeployResult;
import org.sonatype.maven.repository.DeploymentException;
import org.sonatype.maven.repository.RepositorySystemSession;

/**
 * @author Benjamin Bentmann
 */
public interface Deployer
{

    /**
     * Uploads a collection of artifacts and their accompanying metadata to a remote repository.
     * 
     * @param session The repository session, must not be {@code null}.
     * @param request The deployment request, must not be {@code null}.
     * @return The deployment result, never {@code null}.
     * @throws DeploymentException If any artifact/metadata from the request could not be deployed.
     */
    DeployResult deploy( RepositorySystemSession session, DeployRequest request )
        throws DeploymentException;

}
