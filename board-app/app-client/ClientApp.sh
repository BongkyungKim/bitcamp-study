#!/bin/zsh

# comments
# $ which zsh
# $ chmod 755 ClientApp.sh
# $ ./ClientApp.sh

java -Dfile.encoding=UTF-8 -classpath /Users/bebeco/git/bitcamp-study/board-app/app-client/bin/main:/Users/bebeco/.gradle/caches/modules-2/files-2.1/com.google.guava/guava/30.1.1-jre/87e0fd1df874ea3cbe577702fe6f17068b790fd8/guava-30.1.1-jre.jar:/Users/bebeco/.gradle/caches/modules-2/files-2.1/com.google.code.gson/gson/2.9.1/2cc2131b98ebfb04e2b2c7dfb84431f4045096b/gson-2.9.1.jar:/Users/bebeco/.gradle/caches/modules-2/files-2.1/com.google.guava/failureaccess/1.0.1/1dcf1de382a0bf95a3d8b0849546c88bac1292c9/failureaccess-1.0.1.jar:/Users/bebeco/.gradle/caches/modules-2/files-2.1/com.google.guava/listenablefuture/9999.0-empty-to-avoid-conflict-with-guava/b421526c5f297295adef1c886e5246c39d4ac629/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar:/Users/bebeco/.gradle/caches/modules-2/files-2.1/com.google.code.findbugs/jsr305/3.0.2/25ea2e8b0c338a877313bd4672d3fe056ea78f0d/jsr305-3.0.2.jar:/Users/bebeco/.gradle/caches/modules-2/files-2.1/org.checkerframework/checker-qual/3.8.0/6b83e4a33220272c3a08991498ba9dc09519f190/checker-qual-3.8.0.jar:/Users/bebeco/.gradle/caches/modules-2/files-2.1/com.google.errorprone/error_prone_annotations/2.5.1/562d366678b89ce5d6b6b82c1a073880341e3fba/error_prone_annotations-2.5.1.jar:/Users/bebeco/.gradle/caches/modules-2/files-2.1/com.google.j2objc/j2objc-annotations/1.3/ba035118bc8bac37d7eff77700720999acd9986d/j2objc-annotations-1.3.jar -XX:+ShowCodeDetailsInExceptionMessages com.bitcamp.board.ClientApp