package com.wnlc.tool;

public class InnerVO
{
	private String name;

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("InnerVO [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
