package com.centit.app.util;

import java.util.List;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

public class FieldUtil {
	@SuppressWarnings("rawtypes")
	public Class addFields(Class c, List<String> addFields) {

		ClassPool pool = ClassPool.getDefault();// 获取Pool工具
		pool.insertClassPath(new ClassClassPath(this.getClass()));// 获取容器当前类根路径
		CtClass pt = null;// 通过Pool工具获取内存中类.class
		try {
			pt = pool.get(c.getName());
			CtMethod oldMethod = pt.getDeclaredMethod("copyNotNullProperty");// 获取copyNotNullProperty方法
			for (int i = 0; i < addFields.size(); i++) {
				String methodName = addFields.get(i).substring(0, 1).toUpperCase() + addFields.get(i).substring(1);
				String field = "private String " + addFields.get(i) + ";";// 定义字段--private String A;
				String methodGet = "public String get" + methodName + "(){return this." + addFields.get(i) + ";}";// 字段A封装get方法
				String methodSet = "public void set" + methodName + "(String " + addFields.get(i) + "){this."
						+ addFields.get(i) + "=" + addFields.get(i) + ";}";// 字段A封装set方法
				String methodCopy = "if(other.get" + methodName + "()!=null)this." + addFields.get(i) + "=other.get"
						+ methodName + "();";// copyNouNullProperty添加
				pt.addField(CtField.make(field, pt));// 添加字段
				pt.addMethod(CtMethod.make(methodSet, pt));// 字段set方法添加进去
				pt.addMethod(CtMethod.make(methodGet, pt));// 不解释
				oldMethod.insertBefore(methodCopy);// 在方法return之前添加代码块
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}// 通过Pool工具获取内存中类.class
		catch (CannotCompileException e) {
			e.printStackTrace();
		}
		return c;

	}
}
