package com.zxp.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParsing {
	public static void main(String[] args){
		try{
			
			for(Method method:(AnnotationParsing.class
					.getClassLoader().
					loadClass("com.zxp.annotation.AnnotationExample").
					getMethods())){
				if(method.isAnnotationPresent(com.zxp.annotation.MethodInfo.class)){
					try{
						for(Annotation anno: method.getDeclaredAnnotations()){
							System.out.println("Annotation in Method"+method+":"+anno);
						}
					MethodInfo methodAnno=method.getAnnotation(MethodInfo.class);
					if(methodAnno.revision()==1){
						System.out.println("Method with revid=sion no 1+"+method);
					}
				}catch(Throwable ex){
					ex.printStackTrace();
				}			
				}
			}
		}catch(SecurityException|ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
