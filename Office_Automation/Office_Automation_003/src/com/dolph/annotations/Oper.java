package com.dolph.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Oper {

	/***
	 * 操作的名称,如果不定义,自动根据方法,赋予一个值;
	 * add开头:添加;
	 * update开头:更新;
	 * del开头:删除
	 * 其他:查询
	 */
	String name() default "";
	/**
	 * 操作的唯一标识,如果不定义,根据方法给予一个默认值;
	 * add开头:CREATE
	 * update开头:UPDATE
	 * del开头:DELETE
	 * 其他方法:READ
	 */
	String sn() default "";
	/**
	 *操作对应的索引,若果不定义,根据方法给予一个默认值;
	 *add开头:0;
	 *update开头:1;
	 *del开头:2;
	 *其他方法:3;
	 */
	int operIndex() default -1;
}
