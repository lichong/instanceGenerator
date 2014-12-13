package com.wnlc.tool;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Generator
{
	private static Generator INSTANCE = new Generator();

	private static Map<Class<?>, Object> primitiveMap = new HashMap<Class<?>, Object>();

	static
	{
		primitiveMap.put(Integer.class, Integer.valueOf(0));
		primitiveMap.put(Short.class, Short.valueOf((short) 0));
		primitiveMap.put(Long.class, Long.valueOf(0));
		primitiveMap.put(Double.class, Double.valueOf(0));
		primitiveMap.put(Float.class, Float.valueOf(0));
		primitiveMap.put(Character.class, Character.valueOf('0'));
		primitiveMap.put(Byte.class, Byte.valueOf((byte) 0));
		primitiveMap.put(Boolean.class, Boolean.valueOf("false"));

		primitiveMap.put(int.class, Integer.valueOf(0));
		primitiveMap.put(short.class, Short.valueOf((short) 0));
		primitiveMap.put(long.class, Long.valueOf(0));
		primitiveMap.put(double.class, Double.valueOf(0));
		primitiveMap.put(float.class, Float.valueOf(0));
		primitiveMap.put(char.class, Character.valueOf('0'));
		primitiveMap.put(byte.class, Byte.valueOf((byte) 0));
		primitiveMap.put(boolean.class, Boolean.valueOf("false"));

		primitiveMap.put(String.class, "0");

	}

	private Generator()
	{
	}

	public static Generator getInstance()
	{
		return INSTANCE;
	}

	@SuppressWarnings("rawtypes")
	public Object generator(Class<?> clazz) throws Throwable
	{
		if (primitiveMap.containsKey(clazz))
		{
			return primitiveMap.get(clazz);
		}
		Object result = clazz.newInstance();

		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields)
		{
			f.setAccessible(true);
			Class<?> fc = f.getType();
			Object o = null;
			if (fc.isAssignableFrom(List.class))
			{
				Type gt = f.getGenericType(); // 得到泛型类型
				ParameterizedType pt = (ParameterizedType) gt;
				Class at = (Class) pt.getActualTypeArguments()[0];
				o = Collections.singletonList(generator(at));
			}
			else if (fc.isAssignableFrom(Map.class))
			{
				Type gt = f.getGenericType(); // 得到泛型类型
				ParameterizedType pt = (ParameterizedType) gt;
				Class key = (Class) pt.getActualTypeArguments()[0];
				Class value = (Class) pt.getActualTypeArguments()[1];
				o = Collections.singletonMap(generator(key), generator(value));
			}
			else if (fc.isAssignableFrom(Set.class))
			{
				Type gt = f.getGenericType(); // 得到泛型类型
				ParameterizedType pt = (ParameterizedType) gt;
				Class at = (Class) pt.getActualTypeArguments()[0];
				o = Collections.singleton(generator(at));
			}
			else if (fc.isArray())
			{
				o = Array.newInstance(fc.getComponentType(), 1);
				Array.set(o, 0, generator(fc.getComponentType()));
			}
			else
			{
				o = generator(fc);
			}
			f.set(result, o);
		}
		return result;
	}

	public static void main(String[] args) throws Throwable
	{
		System.out.println(INSTANCE.generator(VO.class));
	}
}
