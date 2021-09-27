package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import compute.ComputeFirst;
import compute.ComputeFollow;
import models.Grammar;
import models.NonTerminal;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> l = new ArrayList<>();
		l.add("E>T A | b");
		l.add("A>+ T A | !");
		l.add("T>F B");
		l.add("B>* F B| !");
		l.add("F>( E )| i");
		//l.add("B>E");
		Grammar g = InputParser.parseInput(l);
		//System.out.println(g);
		NonTerminal non=new NonTerminal(null);
		ComputeFirst first=new ComputeFirst(g);
		ComputeFollow second=new ComputeFollow(g);
	}
}
