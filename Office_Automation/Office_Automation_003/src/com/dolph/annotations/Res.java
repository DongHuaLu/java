package com.dolph.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.dom4j.Element;

@Retention(RetentionPolicy.RUNTIME)//运行时反射来获得注解的资源中的信息
@Target(ElementType.TYPE)//只能定义在类前
public @interface Res {
	/**
	 * 资源名称,必须定义
	 */
	String name();
	/***
	 * 资源标识,必须定义
	 */
	String sn();
	/**
	 * 排序号
	 */
	int orderNumber() default 0;
	/**
	 * 父资源标识
	 */
	String parentSn() default "";
}
