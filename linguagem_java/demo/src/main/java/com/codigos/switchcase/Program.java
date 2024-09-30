package com.codigos.switchcase;

public class Program {
	public static void main(String[] args) {

		var mesDoAno = 3;
		switch (mesDoAno) {
			case 1 -> System.out.println("janeiro");
			case 2 -> System.out.println("fevereiro");
			case 3 -> System.out.println("março");
			default -> System.out.println("Mês invalido.");
		}
	}
}
