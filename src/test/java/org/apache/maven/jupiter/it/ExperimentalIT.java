package org.apache.maven.jupiter.it;

import org.apache.maven.jupiter.extension.MavenIT;
import org.apache.maven.jupiter.extension.MavenTest;
import org.apache.maven.jupiter.extension.maven.MavenExecutionResult;
import org.junit.jupiter.api.Disabled;

import static org.apache.maven.jupiter.assertj.MavenExecutionResultAssert.assertThat;

@MavenIT
@Disabled
class ExperimentalIT {

  @MavenTest
  void first(MavenExecutionResult result) {
    assertThat(result).isSuccessful().log();
    assertThat(result).isSuccessful().project().hasTarget();
    assertThat(result).isSuccessful().cache();
  }

  @MavenTest
  void second(MavenExecutionResult result) {
    assertThat(result).log();
    assertThat(result).project().hasTarget().withEarFile();
    assertThat(result).project().hasTarget().withJarFile();
    assertThat(result).project().hasTarget().withWarFile();
    assertThat(result).cache();
  }
}
