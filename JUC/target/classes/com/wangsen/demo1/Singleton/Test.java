// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EnumSingleton.java

package com.wangsen.demo1.Singleton;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.wangsen.demo1.Singleton:
//			EnumSingleton

class Test
{

	Test()
	{
	}

	public static void main(String args[])
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
	{
		EnumSingleton instance1 = EnumSingleton.INSTANCE;
		Constructor enumSingletonConstructor = com/wangsen/demo1/Singleton/EnumSingleton.getDeclaredConstructor(new Class[] {
			java/lang/String, Integer.TYPE
		});
		enumSingletonConstructor.setAccessible(true);
		EnumSingleton instance2 = (EnumSingleton)enumSingletonConstructor.newInstance(new Object[0]);
		System.out.println((new StringBuilder()).append("instance1--->").append(instance1.hashCode()).toString());
		System.out.println((new StringBuilder()).append("instance2--->").append(instance2.hashCode()).toString());
	}
}
