package compute;

import java.util.ArrayList;
import java.util.List;

import models.*;

public class ComputeFirst 
{
	private Grammar grammar;
		
	public ComputeFirst(Grammar grammar)
	{
		this.grammar=grammar;
		display();
	}
	public List<String> mFirst = new ArrayList<>();
	//public List<String> mFollow = new ArrayList<>();
	private void display()
	{
		
		NonTerminal non=new NonTerminal(null);
		for(int i=0;i<grammar.nonTerminals.size();i++)
		{
			non.mFirst.add(first(i));
		}
		System.out.println("First Set");
		for(int i=0; i<grammar.nonTerminals.size(); ++i)
				System.out.println(grammar.nonTerminals.get(i)+":"+non.mFirst.get(i));
		
	}
	public String first(int i)
	{
		int j,k,l=0,found=0;
		String temp="",str="";
		for(j=0;j<grammar.getNonTerminal(grammar.nonTerminals.get(i).toString()).getProductions().size();j++) 
		{
			for(k=0;k<grammar.getNonTerminal(grammar.nonTerminals.get(i).toString()).getProductions().get(j).size();k++,found=0) 
			{
				for(l=0;l<grammar.nonTerminals.size();l++)
				{
					if(grammar.getNonTerminal(grammar.nonTerminals.get(i).toString()).getProductions().get(j).get(k)==grammar.nonTerminals.get(l))
					{
						str=first(l);
						if(!(str.length()==1 && str.charAt(0)=='!'))
						{
							temp=temp+str;
						}
						found=1;
						break;
						
					}
					
				}
				if(found==1)
				{
					if(str.contains("!")) 
						continue;
				}
				else 
					temp=temp+(grammar.getNonTerminal(grammar.nonTerminals.get(i).toString()).getProductions().get(j).get(k));
				break;
			}
		}
		return temp;
	}
	
	
}