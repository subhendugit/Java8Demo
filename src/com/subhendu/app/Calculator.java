package com.subhendu.app;

public class Calculator {
	int a, b;

	public Calculator(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void calculate(WorkerFunctionalInterface worker) {

		int result = worker.performTask(a, b);
		System.out.println("Result of calculation :: " + result);

	}

}
