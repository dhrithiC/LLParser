package models;

public abstract class Symbol {
	final String val;
	public Symbol(String val) {
		this.val = val;
	}
	
	public String toString() {
		return val;
	}
	@Override
	public boolean equals(Object obj) {
		return ((Symbol)obj).val.equals(val);
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
}
