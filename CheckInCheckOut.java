package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CheckInCheckOut {
	public static void main(String args[]) throws Exception{
		Scanner in = new Scanner(new File("input.txt"));
		int n = Integer.parseInt(in.nextLine());
		Date dateIn [] = new Date[n];
		Date dateOut[] = new Date[n];
		for(int i= 1 ; i <= n ; i ++){
			String [] tempArr = in.nextLine().split(" ");
			dateIn[i-1] = new SimpleDateFormat("yyyy-dd-mm").parse(tempArr[0]);
			dateOut[i-1] = new SimpleDateFormat("yyyy-dd-mm").parse(tempArr[1]);
		}
		//System.out.println(Arrays.toString(dateIn));
		Arrays.sort(dateIn);
		Arrays.sort(dateOut);
		//System.out.println(Arrays.toString(dateIn));
		int room = 0 ;
		int i = 0 ; 
		int j= 0 ; 
		int maxRoom = -1;
		while(i < dateIn.length && j < dateOut.length){
			if(dateIn[i].compareTo(dateOut[j]) < 0 ){
				i++;
				room++;
				if(room > maxRoom){
					maxRoom = room;
				}
			}
			else{
				room--;
				j++;
			}
		}
		System.out.println(room);
		in.close();
	}
}
