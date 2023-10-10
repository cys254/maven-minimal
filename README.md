Maven version: 3.6.3
JDK version: 11.0.20

Reference
- https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
- https://reflectoring.io/junit5/


Error:

[ERROR] Source option 5 is no longer supported. Use 6 or later.
[ERROR] Target option 1.5 is no longer supported. Use 1.6 or later.

Solution:
add to pom.xml

<properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
</properties>
