// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EnumSingleton.java

package com.wangsen.demo1.Singleton;


public final class EnumSingleton extends Enum
{

	public static final EnumSingleton INSTANCE;
	private static final EnumSingleton $VALUES[];

	public static EnumSingleton[] values()
	{
		return (EnumSingleton[])$VALUES.clone();
	}

	public static EnumSingleton valueOf(String name)
	{
		return (EnumSingleton)Enum.valueOf(com/wangsen/demo1/Singleton/EnumSingleton, name);
	}

	private EnumSingleton(String s, int i)
	{
		super(s, i);
	}

	public EnumSingleton getInstance()
	{
		return INSTANCE;
	}

	static 
	{
		INSTANCE = new EnumSingleton("INSTANCE", 0);
		$VALUES = (new EnumSingleton[] {
			INSTANCE
		});
	}
}
