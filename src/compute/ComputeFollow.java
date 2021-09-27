package compute;

import java.util.ArrayList;
import java.util.List;

import models.*;

public class ComputeFollow {
	private Grammar grammar;
	
	public ComputeFollow(Grammar grammar)
	{
		this.grammar=grammar;
		Display();
		
	}
	public List<String> mFollow = new ArrayList<>();
	private void Display()
	{
		NonTerminal non=new NonTerminal(null);
	
		for(int i=0;i<grammar.nonTerminals.size();i++)
		{
			non.mFollow.add(follow(i));
		}
		System.out.println("Follow Set");
		for(int i=0; i<grammar.nonTerminals.size(); ++i)
				System.out.println(grammar.nonTerminals.get(i)+":"+non.mFollow.get(i));
		
		
	}
	
	public String follow(int i)
	{
		ComputeFirst first = new ComputeFirst(grammar);
		NonTerminal non=new NonTerminal(null);
		List<Symbol> pro;
		char[] chr;
		String temp="";
		int j,k,l,m,n,found=0;
		if(i==0)
		temp="$";
	
		for(j=0;j<grammar.nonTerminals.size();j++)
		{
			
			for(k=0;k<grammar.getNonTerminal(grammar.nonTerminals.get(j).toString()).getProductions().size();k++) 
			{
				
				pro=new ArrayList<Symbol>();
				pro=(grammar.getNonTerminal(grammar.nonTerminals.get(j).toString()).getProductions().get(k));
				System.out.println("pro size : "+pro.size()+" k = "+k);
				for(l=0;l<pro.size();l++) //entering each production
			    {
					
					if(pro.get(l)==grammar.nonTerminals.get(i)) //nonterminal whose follow set is to be found
				    {
						System.out.println("true");
						System.out.println(l);
						System.out.println(pro.size()-1);
						if(l==((pro.size())-1)) //if it is the last terminal/non-terminal then follow of current non-terminal
				        {
						  System.out.println(j);
						  System.out.println(i);
						  System.out.println("mfollow : "+non.mFollow.get(j));
						  if(j<i)
				          {
							  System.out.println("mfollow : "+non.mFollow.get(j));
				        	  temp=temp+non.mFollow.get(j);  
				        	 
				          }
						}
				          
				          else
					      {
				        	  for(m=0;m<grammar.nonTerminals.size();m++)
						      {
				        		  
				        		  if(pro.get(l+1)==grammar.nonTerminals.get(m)) //first of next non-terminal
				        		  {
				        			  
				        			  chr = new char[non.mFirst.get(m).length()];
				        			  chr = non.mFirst.get(m).toCharArray();
				        			  for(n=0;n<chr.length;n++)
							          {
				        				  if(chr[n]=='!') 
				        				  {
				        					  if(l+1==(pro.size())-1)
				        					  {
				        						  temp=temp+follow(j);
				        						  
				        					  }
				        					 
				        					  else
				        					  {
				        						  temp=temp+follow(m);
				        						  
				        					  }
				        					 
				        				  }
				        				  else
				  			                temp=temp+chr[n];
				        				  
							          }
				        			  found=1;
						          }
				        		  
						      }
				        	  if(found!=1)
						          temp=temp+pro.get(l+1); 
						       
					      }
				        }
				    }
						
			    }
			}
		
		return temp;
	}

}
