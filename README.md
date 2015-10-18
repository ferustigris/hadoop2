# hadoop2
hadoop training: task 2
Download the data set (http://goo.gl/lwgoxw); (Data description http://contest.ipinyou.com/data.shtml)

·         Unzip these files and put them in HDFS system:

o   bid.20130606.txt.bz2

o   bid.20130607.txt.bz2

o   bid.20130608.txt.bz2

o   bid.20130609.txt.bz2

o   bid.20130610.txt.bz2

o   bid.20130611.txt.bz2

o   bid.20130612.txt.bz2

·         Count amount of records for each iPinyou ID from all these files, sort in a DESC order, write result into bid_result.txt file on HDFS system (use for this only HDFS api and plain java (scala), no MR paradigm, no Hive, no Spark);

·         Measure the whole process time, memory consumptions, others resources utilization;

·         Try to optimize JVM, GC parameters, like: --Xms8g --Xmx8g --Xmn2g  -XX:PermSize=64M -XX:MaxPermSize=256M -XX:-OmitStackTraceInFastThrow -XX:SurvivorRatio=2 -XX:+UseG1GC -XX:NewSize=4g -XX:MaxNewSize=5g -XX:ConcGCThreads -XX:+UseStringDeduplication… (Repeat previous measurements and provide you results with your keys).
