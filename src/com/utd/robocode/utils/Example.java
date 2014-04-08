package com.utd.robocode.utils;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bitmask = 0xFFFF;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);
        
		int low = 0;
		int high = 6;
		int mid = (low + high) >> 1;
		System.out.println(mid);
	}

}
