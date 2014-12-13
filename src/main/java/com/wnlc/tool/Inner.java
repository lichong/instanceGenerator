package com.wnlc.tool;

import java.util.List;

public class Inner
{
	private String i;
	private List<InnerVO> lst;

	public String getI()
	{
		return i;
	}

	public void setI(String i)
	{
		this.i = i;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Inner [i=");
		builder.append(i);
		builder.append(", lst=");
		builder.append(lst);
		builder.append("]");
		return builder.toString();
	}

	public List<InnerVO> getLst()
	{
		return lst;
	}

	public void setLst(List<InnerVO> lst)
	{
		this.lst = lst;
	}
}
