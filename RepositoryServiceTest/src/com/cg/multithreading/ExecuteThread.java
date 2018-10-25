package com.cg.multithreading;

public class ExecuteThread {

	public static void main(String[] args) {
		ThreadingProblem tp = new ThreadingProblem();
		Thread t = new Thread(tp);
		t.start();
		Thread t1 = new Thread(tp);
		t1.start();
		Thread t3 = new Thread(tp);
		t3.start();
		Thread t4 = new Thread(tp);
		t4.start();
		Thread t5 = new Thread(tp);
		t5.start();
		Thread t6 = new Thread(tp);
		t6.start();
		Thread t7 = new Thread(tp);
		t7.start();
		Thread t8 = new Thread(tp);
		t8.start();
		Thread t9 = new Thread(tp);
		t9.start();
		Thread t10 = new Thread(tp);
		t10.start();
	}
}
