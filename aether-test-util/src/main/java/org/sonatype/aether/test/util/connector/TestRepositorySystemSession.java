package org.sonatype.aether.test.util.connector;

/*
 * Copyright (c) 2010 Sonatype, Inc. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0, 
 * and you may not use this file except in compliance with the Apache License Version 2.0. 
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the Apache License Version 2.0 is distributed on an 
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */

import java.util.Collections;
import java.util.Map;

import org.sonatype.aether.ArtifactTypeRegistry;
import org.sonatype.aether.AuthenticationSelector;
import org.sonatype.aether.DependencyGraphTransformer;
import org.sonatype.aether.DependencyManager;
import org.sonatype.aether.DependencySelector;
import org.sonatype.aether.DependencyTraverser;
import org.sonatype.aether.LocalRepository;
import org.sonatype.aether.LocalRepositoryManager;
import org.sonatype.aether.MirrorSelector;
import org.sonatype.aether.ProxySelector;
import org.sonatype.aether.RepositoryCache;
import org.sonatype.aether.RepositoryListener;
import org.sonatype.aether.RepositorySystemSession;
import org.sonatype.aether.TransferListener;
import org.sonatype.aether.WorkspaceReader;
import org.sonatype.aether.test.util.selectors.DefaultAuthenticationSelector;
import org.sonatype.aether.test.util.selectors.DefaultProxySelector;

public class TestRepositorySystemSession
    implements RepositorySystemSession
{

    private TransferListener listener = new RecordingTransferListener();
    private AuthenticationSelector authenticator = new DefaultAuthenticationSelector();
    private ProxySelector proxySelector = new DefaultProxySelector();

    public String getUserAgent()
    {
        return "Aether";
    }

    public int getConnectTimeout()
    {
        return 60;
    }

    public int getRequestTimeout()
    {
        return 60;
    }

    public TransferListener getTransferListener()
    {
        return listener;
    }

    public Map<String, Object> getConfigProperties()
    {
        return Collections.emptyMap();
    }

    public boolean isOffline()
    {
        throw new UnsupportedOperationException( "isOffline()" );
    }

    public boolean isTransferErrorCachingEnabled()
    {
        throw new UnsupportedOperationException( "isTransferErrorCachingEnabled()" );
    }

    public boolean isNotFoundCachingEnabled()
    {
        throw new UnsupportedOperationException( "isNotFoundCachingEnabled()" );
    }

    public boolean isIgnoreMissingArtifactDescriptor()
    {
        throw new UnsupportedOperationException( "isIgnoreMissingArtifactDescriptor()" );
    }

    public boolean isIgnoreInvalidArtifactDescriptor()
    {
        throw new UnsupportedOperationException( "isIgnoreInvalidArtifactDescriptor()" );
    }

    public String getChecksumPolicy()
    {
        throw new UnsupportedOperationException( "getChecksumPolicy()" );
    }

    public String getUpdatePolicy()
    {
        throw new UnsupportedOperationException( "getUpdatePolicy()" );
    }

    public LocalRepository getLocalRepository()
    {
        throw new UnsupportedOperationException( "getLocalRepository()" );
    }

    public LocalRepositoryManager getLocalRepositoryManager()
    {
        throw new UnsupportedOperationException( "getLocalRepositoryManager()" );
    }

    public WorkspaceReader getWorkspaceReader()
    {
        throw new UnsupportedOperationException( "getWorkspaceReader()" );
    }

    public RepositoryListener getRepositoryListener()
    {
        throw new UnsupportedOperationException( "getRepositoryListener()" );
    }

    public Map<String, String> getSystemProperties()
    {
        throw new UnsupportedOperationException( "String>" );
    }

    public Map<String, String> getUserProperties()
    {
        throw new UnsupportedOperationException( "String>" );
    }

    public MirrorSelector getMirrorSelector()
    {
        throw new UnsupportedOperationException( "getMirrorSelector()" );
    }

    public ProxySelector getProxySelector()
    {
        return proxySelector;
    }

    public AuthenticationSelector getAuthenticationSelector()
    {
        return authenticator ;
    }

    public ArtifactTypeRegistry getArtifactTypeRegistry()
    {
        throw new UnsupportedOperationException( "getArtifactTypeRegistry()" );
    }

    public DependencyTraverser getDependencyTraverser()
    {
        throw new UnsupportedOperationException( "getDependencyTraverser()" );
    }

    public DependencyManager getDependencyManager()
    {
        throw new UnsupportedOperationException( "getDependencyManager()" );
    }

    public DependencySelector getDependencySelector()
    {
        throw new UnsupportedOperationException( "getDependencySelector()" );
    }

    public DependencyGraphTransformer getDependencyGraphTransformer()
    {
        throw new UnsupportedOperationException( "getDependencyGraphTransformer()" );
    }

    public RepositoryCache getCache()
    {
        throw new UnsupportedOperationException( "getCache()" );
    }
}