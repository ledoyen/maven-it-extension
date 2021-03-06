package org.apache.maven.jupiter.extension.maven;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import static org.apiguardian.api.API.Status.EXPERIMENTAL;

import java.util.stream.Stream;
import org.apiguardian.api.API;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.StringUtils;

/**
 * @author Karl Heinz Marbaise
 */
@API(status = EXPERIMENTAL, since = "0.1.0")
public enum MavenVersion {
  UNKNOWN("UNKOWN"), //TODO: Need to reconsider?
  M3_0_5("3.0.5"),
  M3_1_1("3.1.1"),
  M3_2_5("3.2.5"),
  M3_3_1("3.3.1"),
  M3_3_9("3.3.9"),
  M3_5_0("3.5.0"),
  M3_5_2("3.5.2"),
  M3_5_3("3.5.3"),
  M3_5_4("3.5.4"),
  M3_6_0("3.6.0"),
  M3_6_1("3.6.1"),
  M3_6_2("3.6.2"),
  M3_6_3("3.6.3");

  private static final Logger logger = LoggerFactory.getLogger(MavenVersion.class);

  private static final MavenVersion CURRENT_MAVEN_VERSION = determineCurrentVersion();

  private final String versionString;

  MavenVersion(String versionString) {
    this.versionString = versionString;
  }

  private static MavenVersion determineCurrentVersion() {
    String currentVersion = System.getProperty("maven.version");
    //FIXME: Think about usage of interal API?
    if (StringUtils.isBlank(currentVersion)) {
      logger.error(
          () -> "JVM system property 'maven.version' is undefined. It is therefore not possible to detect Maven version.");
    }
    return Stream.of(values())
        .filter(mavenVersion -> mavenVersion.getVersionString().equals(currentVersion))
        .findFirst()
        .orElseGet(() -> MavenVersion.UNKNOWN);
  }

  /**
   * @return {@code true} if <em>this</em> {@link MavenVersion} is known to be the Maven version for the currently being
   * executed Maven version.
   */
  public boolean isCurrentVersion() {
    return this == CURRENT_MAVEN_VERSION;
  }

  public String getVersionString() {
    return versionString;
  }
}
