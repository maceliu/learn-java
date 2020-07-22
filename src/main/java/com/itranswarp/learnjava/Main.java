package com.itranswarp.learnjava;


import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {
	// 启动Tomcat:
	Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.getInteger("port", 8080));
        tomcat.getConnector();
	// 创建webapp:
	Context ctx = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
	WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(
				new DirResourceSet(resources, "/WEB-INF/classes", new File("target/classes").getAbsolutePath(), "/"));
        ctx.setResources(resources);
        tomcat.start();
        tomcat.getServer().await();
}
