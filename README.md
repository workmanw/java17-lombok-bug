# Proving out Lombok Compiler bug

This repo demonstrates a bug we've found with the OpenJDK 17.0.1 compiler.

```
$ mvn -version

Apache Maven 3.8.3 (ff8e977a158738155dc465c6a97ffaf31982d739)
Maven home: /usr/local/Cellar/maven/3.8.3/libexec
Java version: 17.0.1, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk-17.0.1.jdk/Contents/Home
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "11.6", arch: "x86_64", family: "mac"
```

```
$ mvn clean compile

[INFO] Scanning for projects...
[INFO]
[INFO] -----< com.workmanw.java17.lombok.bug:workmanw-java17-lombok-bug >------
[INFO] Building workmanw-java17-lombok-bug 0.0.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ workmanw-java17-lombok-bug ---
[INFO] Deleting /Users/wesleyw/Code/workmanw-java17-lombok-bug/target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ workmanw-java17-lombok-bug ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/wesleyw/Code/workmanw-java17-lombok-bug/src/main/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ workmanw-java17-lombok-bug ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /Users/wesleyw/Code/workmanw-java17-lombok-bug/target/classes
An exception has occurred in the compiler (17.0.1). Please file a bug against the Java compiler via the Java bug reporting page (http://bugreport.java.com) after checking the Bug Database (http://bugs.java.com) for duplicates. Include your program, the following diagnostic, and the parameters passed to the Java compiler in your report. Thank you.
java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
	at jdk.compiler/com.sun.tools.javac.jvm.ClassWriter.writePosition(ClassWriter.java:672)
	at jdk.compiler/com.sun.tools.javac.jvm.ClassWriter.writeTypeAnnotation(ClassWriter.java:649)
	at jdk.compiler/com.sun.tools.javac.jvm.ClassWriter.writeTypeAnnotations(ClassWriter.java:553)
	at jdk.compiler/com.sun.tools.javac.jvm.ClassWriter.writeCode(ClassWriter.java:1120)
	at jdk.compiler/com.sun.tools.javac.jvm.ClassWriter.writeMethod(ClassWriter.java:988)
	at jdk.compiler/com.sun.tools.javac.jvm.ClassWriter.writeMethods(ClassWriter.java:1479)
	at jdk.compiler/com.sun.tools.javac.jvm.ClassWriter.writeClassFile(ClassWriter.java:1584)
	at jdk.compiler/com.sun.tools.javac.jvm.ClassWriter.writeClass(ClassWriter.java:1505)
	at jdk.compiler/com.sun.tools.javac.main.JavaCompiler.genCode(JavaCompiler.java:738)
	at jdk.compiler/com.sun.tools.javac.main.JavaCompiler.generate(JavaCompiler.java:1617)
	at jdk.compiler/com.sun.tools.javac.main.JavaCompiler.generate(JavaCompiler.java:1585)
	at jdk.compiler/com.sun.tools.javac.main.JavaCompiler.compile(JavaCompiler.java:946)
	at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.lambda$doCall$0(JavacTaskImpl.java:104)
	at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.invocationHelper(JavacTaskImpl.java:152)
	at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.doCall(JavacTaskImpl.java:100)
	at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.call(JavacTaskImpl.java:94)
	at org.codehaus.plexus.compiler.javac.JavaxToolsCompiler.compileInProcess(JavaxToolsCompiler.java:126)
	at org.codehaus.plexus.compiler.javac.JavacCompiler.performCompile(JavacCompiler.java:174)
	at org.apache.maven.plugin.compiler.AbstractCompilerMojo.execute(AbstractCompilerMojo.java:1134)
	at org.apache.maven.plugin.compiler.CompilerMojo.execute(CompilerMojo.java:187)
	at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:137)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:210)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:156)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:148)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:117)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:81)
	at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:56)
	at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:305)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:192)
	at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:105)
	at org.apache.maven.cli.MavenCli.execute(MavenCli.java:972)
	at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:293)
	at org.apache.maven.cli.MavenCli.main(MavenCli.java:196)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:282)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:225)
	at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:406)
	at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:347)
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR :
[INFO] -------------------------------------------------------------
[ERROR] An unknown compilation problem occurred
[INFO] 1 error
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.571 s
[INFO] Finished at: 2021-12-10T16:03:18-05:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (default-compile) on project workmanw-java17-lombok-bug: Compilation failure
[ERROR] An unknown compilation problem occurred
[ERROR]
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```