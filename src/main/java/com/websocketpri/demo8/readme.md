http://192.168.32.181:8080/demoweb/chat

遇到的问题:class not found.
解决办法：
打开eclipse所关联的tomcat文件夹，将所需要的jar包复制到lib文件夹里面，重启项目，问题搞定。
也可以在eclipse下选中项目右键-properties-deployment assembly-add 添加你用的jar

catalina.jar
commons-beanutils-1.7.0.jar
commons-collections-3.1.jar
commons-io-1.3.2.jar
commons-lang-2.3.jar
commons-logging-1.0.4.jar
commons-logging-api-1.1.jar
ezmorph-1.0.4.jar
json-lib-2.2.2-jdk15.jar
tomcat-coyote.jar