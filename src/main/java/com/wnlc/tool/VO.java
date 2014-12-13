package com.wnlc.tool;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VO
{
	private String a;
	private int b;
	private Long c;
	private Inner inner;
	private String[] str;
	private List<String> lst;
	private Map<String, String> map;
	private Set<String> set;
	private Inner[] ins;
	private List<Inner> inslst;
	private Map<String, Inner> innmap;
	private Set<Inner> innset;

	public String getA()
	{
		return a;
	}

	public void setA(String a)
	{
		this.a = a;
	}

	public int getB()
	{
		return b;
	}

	public void setB(int b)
	{
		this.b = b;
	}

	public Long getC()
	{
		return c;
	}

	public void setC(Long c)
	{
		this.c = c;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("VO [a=");
		builder.append(a);
		builder.append(", b=");
		builder.append(b);
		builder.append(", c=");
		builder.append(c);
		builder.append(", inner=");
		builder.append(inner);
		builder.append(", str=");
		builder.append(Arrays.toString(str));
		builder.append(", lst=");
		builder.append(lst);
		builder.append(", map=");
		builder.append(map);
		builder.append(", set=");
		builder.append(set);
		builder.append(", ins=");
		builder.append(Arrays.toString(ins));
		builder.append(", inslst=");
		builder.append(inslst);
		builder.append(", innmap=");
		builder.append(innmap);
		builder.append(", innset=");
		builder.append(innset);
		builder.append("]");
		return builder.toString();
	}

	public Inner getInner()
	{
		return inner;
	}

	public void setInner(Inner inner)
	{
		this.inner = inner;
	}

	public String[] getStr()
	{
		return str;
	}

	public void setStr(String[] str)
	{
		this.str = str;
	}

	public List<String> getLst()
	{
		return lst;
	}

	public void setLst(List<String> lst)
	{
		this.lst = lst;
	}

	public Map<String, String> getMap()
	{
		return map;
	}

	public void setMap(Map<String, String> map)
	{
		this.map = map;
	}

	public Set<String> getSet()
	{
		return set;
	}

	public void setSet(Set<String> set)
	{
		this.set = set;
	}

	public Inner[] getIns()
	{
		return ins;
	}

	public void setIns(Inner[] ins)
	{
		this.ins = ins;
	}

	public List<Inner> getInslst()
	{
		return inslst;
	}

	public void setInslst(List<Inner> inslst)
	{
		this.inslst = inslst;
	}

	public Map<String, Inner> getInnmap()
	{
		return innmap;
	}

	public void setInnmap(Map<String, Inner> innmap)
	{
		this.innmap = innmap;
	}

	public Set<Inner> getInnset()
	{
		return innset;
	}

	public void setInnset(Set<Inner> innset)
	{
		this.innset = innset;
	}

}
