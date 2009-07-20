/*
 * Copyright 2007 Alin Dreghiciu.
 *
 * Licensed  under the  Apache License,  Version 2.0  (the "License");
 * you may not use  this file  except in  compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed  under the  License is distributed on an "AS IS" BASIS,
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.url.maven.commons;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import static org.junit.Assert.*;
import org.junit.Test;
import org.ops4j.io.FileUtils;

public class SettingsImplTest
{

    @Test
    public void constructorWithNullURL()
    {
        new MavenSettingsImpl( null );
    }

    @Test
    public void validSettingsFile()
        throws MalformedURLException, FileNotFoundException
    {
        new MavenSettingsImpl( FileUtils.getFileFromClasspath( "settings/settingsWithLocalRepository.xml" ).toURL() );
    }

    @Test
    public void getExistingLocalRepository()
        throws MalformedURLException, FileNotFoundException
    {
        MavenSettingsImpl settings =
            new MavenSettingsImpl( FileUtils.getFileFromClasspath( "settings/settingsWithLocalRepository.xml" ).toURL() );
        assertEquals( "Local repository", "repository", settings.getLocalRepository() );
    }

    @Test
    public void getInexistingLocalRepository()
        throws MalformedURLException, FileNotFoundException
    {
        MavenSettingsImpl settings =
            new MavenSettingsImpl( FileUtils.getFileFromClasspath( "settings/settingsEmpty.xml" ).toURL() );
        assertEquals( "Local repository",
                      System.getProperty( "user.home" ) + "/.m2/repository",
                      settings.getLocalRepository()
        );
    }

    @Test
    public void getEmptyTagLocalRepository()
        throws MalformedURLException, FileNotFoundException
    {
        MavenSettingsImpl settings =
            new MavenSettingsImpl( FileUtils.getFileFromClasspath( "settings/settingsEmptyTags.xml" ).toURL() );
        assertEquals( "Local repository",
                      System.getProperty( "user.home" ) + "/.m2/repository",
                      settings.getLocalRepository()
        );
    }

    @Test
    public void getInexistingRepositories()
        throws MalformedURLException, FileNotFoundException
    {
        MavenSettingsImpl settings =
            new MavenSettingsImpl( FileUtils.getFileFromClasspath( "settings/settingsEmpty.xml" ).toURL() );
        assertEquals( "Repositories",
                      "http://osgi.sonatype.org/content/groups/pax-runner",
                      settings.getRepositories()
        );
    }

    @Test
    public void getInexistingRepositoriesWithFallback()
        throws MalformedURLException, FileNotFoundException
    {
        MavenSettingsImpl settings =
            new MavenSettingsImpl( FileUtils.getFileFromClasspath( "settings/settingsEmpty.xml" ).toURL(), true );
        assertEquals( "Repositories",
                      "http://repo1.maven.org/maven2,"
                      + "http://repository.ops4j.org/maven2,"
                      + "http://repository.springsource.com/maven/bundles/release,"
                      + "http://repository.springsource.com/maven/bundles/external",
                      settings.getRepositories()
        );
    }

    @Test
    public void getExistingRepositories()
        throws MalformedURLException, FileNotFoundException
    {
        MavenSettingsImpl settings =
            new MavenSettingsImpl(
                FileUtils.getFileFromClasspath( "settings/settingsWithRepositories.xml" ).toURL()
            );
        String repositories = settings.getRepositories();
        assertNotNull( "Repositories", repositories );
        String[] segments = repositories.split( "," );
        assertEquals( "Number of repositories", 6, segments.length );

        assertEquals( "Repository 1",
                      "http://repository1",
                      segments[ 0 ]
        );
        assertEquals( "Repository 2",
                      "http://user@repository2@snapshots",
                      segments[ 1 ]
        );
        assertEquals( "Repository 3",
                      "http://user:password@repository3@noreleases",
                      segments[ 2 ]
        );
        assertEquals( "Repository 5",
                      "jar:http://user:password@repository5/jar!@noreleases",
                      segments[ 3 ]
        );
        assertEquals( "Repository 6",
                      "http://user:password@repository6@snapshots@noreleases",
                      segments[ 4 ]
        );
        assertEquals( "Repository 7",
                      "http://osgi.sonatype.org/content/groups/pax-runner",
                      segments[ 5 ]
        );
    }

    @Test
    public void getExistingRepositoriesWithFallback()
        throws MalformedURLException, FileNotFoundException
    {
        MavenSettingsImpl settings =
            new MavenSettingsImpl(
                FileUtils.getFileFromClasspath( "settings/settingsWithRepositories.xml" ).toURL(), true
            );
        String repositories = settings.getRepositories();
        assertNotNull( "Repositories", repositories );
        String[] segments = repositories.split( "," );
        assertEquals( "Number of repositories", 9, segments.length );

        assertEquals( "Repository 1",
                      "http://repository1",
                      segments[ 0 ]
        );
        assertEquals( "Repository 2",
                      "http://user@repository2@snapshots",
                      segments[ 1 ]
        );
        assertEquals( "Repository 3",
                      "http://user:password@repository3@noreleases",
                      segments[ 2 ]
        );
        assertEquals( "Repository 5",
                      "jar:http://user:password@repository5/jar!@noreleases",
                      segments[ 3 ]
        );
        assertEquals( "Repository 6",
                      "http://user:password@repository6@snapshots@noreleases",
                      segments[ 4 ]
        );
        assertEquals( "Repository 7",
                      "http://repo1.maven.org/maven2",
                      segments[ 5 ]
        );
        assertEquals( "Repository 8",
                      "http://repository.ops4j.org/maven2",
                      segments[ 6 ]
        );
    }


}
