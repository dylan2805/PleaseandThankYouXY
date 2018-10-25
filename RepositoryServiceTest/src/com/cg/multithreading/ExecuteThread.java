package com.cg.multithreading;

public class ExecuteThread {

	public static void main(String[] args) {
		ThreadingProblem tp = new ThreadingProblem();
		Thread t = new Thread(tp);
		t.start();
		Thread t1 = new Thread(tp);
		t1.start();
	}
}
