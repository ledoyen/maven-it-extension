package org.apache.maven.jupiter.extension;

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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test to check the annotation defined defaults of {@link MavenTest}.
 *
 * @author Karl Heinz Marbaise
 */
class MavenTestTest {

  private MavenTest mavenTestAnnotation;

  @BeforeEach
  void beforeEach() throws NoSuchMethodException {
    XYZ xyz = new XYZ();
    this.mavenTestAnnotation = xyz.getClass().getDeclaredMethod("name").getAnnotation(MavenTest.class);
  }

  @Test
  void debug_default_should_be_false() {
    assertThat(mavenTestAnnotation.debug()).isFalse();
  }

  @Test
  void default_goals_should_be_empty() {
    assertThat(mavenTestAnnotation.goals()).isEmpty();
  }

  @Test
  void default_project_should_be_empty() {
    assertThat(mavenTestAnnotation.goals()).isEmpty();
    assertThat(mavenTestAnnotation.project()).isEmpty();
    assertThat(mavenTestAnnotation.activeProfiles()).isEmpty();
  }

  @Test
  void default_active_profiles_should_be_empty() {
    assertThat(mavenTestAnnotation.activeProfiles()).isEmpty();
  }

  class XYZ {

    @MavenTest
    void name() {

    }
  }
}
