# checkstyle-checks-android

[![GitHubActions](https://github.com/fartem/checkstyle-checks-android/workflows/Build/badge.svg)](https://github.com/fartem/checkstyle-checks-android/actions?query=workflow%3ABuild)

## About

Custom Checkstyle checks for Android projects.

## Checks

| Check | Description |
| --- | --- | --- |
| `AndroidViewFieldNameCheck` | Check Android view field name (example: for `TextView` variable's name must be starts with `tv`) |
| `ContextFirstParameterCheck` | Check Context as first parameter in a class constructor or in an arguments list |
| `MethodObjectReturnAnnotationCheck` | Check annotation for a method with return values (by default it is `@NonNull` and `@Nullable`) |
| `MethodParametersAnnotationCheck` | Check annotation for an argument in a class constructor or a method (by default it is `@NonNull` and `@Nullable`) |

## Installation

### Gradle

If you are using [Checkstyle plugin](https://docs.gradle.org/current/userguide/checkstyle_plugin.html) for Gradle, add
checks project as dependency in the `dependencies` section in the `build.gradle`:

```groovy
checkstyle 'com.github.fartem:checkstyle-checks-android:master'
```

## How to use

Add to `TreeWalker` module:

```xml
<module name="com.smlnskgmail.jaman.checkstyle.checks.AndroidViewFieldNameCheck">
    <property name="id" value="AndroidViewFieldNameCheck" />
</module>
<module name="com.smlnskgmail.jaman.checkstyle.checks.ContextFirstParameterCheck">
    <property name="id" value="ContextFirstParameterCheck" />
</module>
<module name="com.smlnskgmail.jaman.checkstyle.checks.MethodObjectReturnAnnotationCheck">
    <property name="id" value="MethodObjectReturnAnnotationCheck" />
</module>
<module name="com.smlnskgmail.jaman.checkstyle.checks.MethodParametersAnnotationCheck">
    <property name="id" value="MethodParametersAnnotationCheck" />
</module>
```

## How to contribute

Read [Commit Convention](https://github.com/fartem/repository-rules/blob/master/commit-convention/COMMIT_CONVENTION.md).
Make sure your build is green before you contribute your pull request. Then:

```shell
./gradlew clean
./gradlew build
```

If you don't see any error messages, submit your pull request.

## Contributors

- [@fartem](https://github.com/fartem) as Artem Fomchenkov

