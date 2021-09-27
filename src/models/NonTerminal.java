package models;
import java.util.ArrayList;
import java.util.List;


public class NonTerminal extends Symbol {
	final private List<List<Symbol>> mProds = new ArrayList<>();
	 public List<String> mFirst = new ArrayList<>();
	public List<String> mFollow = new ArrayList<>();
	
	
	public NonTerminal(String v) {
		super(v);		
	}
	
	public List<List<Symbol>> getProductions() {
		return mProds;
	}
	
	public void addProduction(List<Symbol> l) {
		mProds.add(l);
	}	
}
