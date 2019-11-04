Issue: Nashorn15x Slower With openj9-0.17.0 Java11_vs openj9-0.17.0 Java8

Instructions:
1. Compile JavascriptTest.java with any JDK8 compiler
2. Run the following test with AdoptOpenJDK 8u232 with OpenJ9 and with AdoptOpenJDK 11.0.5 with OpenJ9:
     java -cp . JavascriptTest test.js
	 
	 
Sample results on an Amazon m3.large instance (2 Core of a Intel(R) Xeon(R) CPU E5-2670 v2 @ 2.50GHz) running CentOS 7.6:

With AdoptOpenJDK 8u232 with OpenJ9:

[root@ip-172-31-32-163 mnt]# ./Java8u232-OpenJ9/bin/java -version
openjdk version "1.8.0_232"
OpenJDK Runtime Environment (build 1.8.0_232-b09)
Eclipse OpenJ9 VM (build openj9-0.17.0, JRE 1.8.0 Linux amd64-64-Bit Compressed References 20191017_442 (JIT enabled, AOT enabled)
OpenJ9   - 77c1cf708
OMR      - 20db4fbc
JCL      - 97b5ec8f383 based on jdk8u232-b09)

[root@ip-172-31-32-163 mnt]# ./Java8u232-OpenJ9/bin/java -cp . JavascriptTest test.js
5610
[root@ip-172-31-32-163 mnt]# ./Java8u232-OpenJ9/bin/java -cp . JavascriptTest test.js
5705
[root@ip-172-31-32-163 mnt]# ./Java8u232-OpenJ9/bin/java -cp . JavascriptTest test.js
6038
[root@ip-172-31-32-163 mnt]# ./Java8u232-OpenJ9/bin/java -cp . JavascriptTest test.js
5618
[root@ip-172-31-32-163 mnt]# ./Java8u232-OpenJ9/bin/java -cp . JavascriptTest test.js
5689

=> Average 5732 ms with openj9-0.17.0 java 8

Wuth AdoptOpenJDK 11.0.5 with OpenJ9:

[root@ip-172-31-32-163 mnt]# ./Java1105-OpenJ9/bin/java -version
openjdk version "11.0.5" 2019-10-15
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.5+10)
Eclipse OpenJ9 VM AdoptOpenJDK (build openj9-0.17.0, JRE 11 Linux amd64-64-Bit Compressed References 20191016_358 (JIT enabled, AOT enabled)
OpenJ9   - 77c1cf708
OMR      - 20db4fbc
JCL      - 2a7af5674b based on jdk-11.0.5+10)


[root@ip-172-31-32-163 mnt]# ./Java1105-OpenJ9/bin/java -cp . JavascriptTest test.js
Warning: Nashorn engine is planned to be removed from a future JDK release
80557
[root@ip-172-31-32-163 mnt]# ./Java1105-OpenJ9/bin/java -cp . JavascriptTest test.js
Warning: Nashorn engine is planned to be removed from a future JDK release
89117
[root@ip-172-31-32-163 mnt]# ./Java1105-OpenJ9/bin/java -cp . JavascriptTest test.js
Warning: Nashorn engine is planned to be removed from a future JDK release
86910
[root@ip-172-31-32-163 mnt]# ./Java1105-OpenJ9/bin/java -cp . JavascriptTest test.js
Warning: Nashorn engine is planned to be removed from a future JDK release
90677
[root@ip-172-31-32-163 mnt]# ./Java1105-OpenJ9/bin/java -cp . JavascriptTest test.js
Warning: Nashorn engine is planned to be removed from a future JDK release
89783

=> Average 87408 ms with openj9-0.17.0 java 8
