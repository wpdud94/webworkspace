package com.encore;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.javafx.collections.MappingChange.Map;

public class Kickboard {

		public static int execute(File path) throws FileNotFoundException {
			/*
			결과값을 리스트가 아닌 int에는 못 하는지?
			 */
			int result = -1;
			Scanner sc = new Scanner(path);
			//1.다루기 쉬운 자료구조로 변환--행렬루~
			int[][] map = {};
			int i=0;
			while(sc.hasNextLine()) {
				String str = sc.nextLine();
				//System.out.println(str);
				//1-1.첫문장 받아서 2차원 배열 형성
				if(str.length()==3) {
					String[] rowcol = str.split(" ");
					//System.out.println("행의 수 :" + rowcol[0]);
					//System.out.println("열의 수 :" + rowcol[1]);
					 map = new int[Integer.parseInt(rowcol[0])][Integer.parseInt(rowcol[1])];
				}else {//1-2.나머지는 2차원 배열에 할당
					String[] element = str.split(" ");
					for(int j=0;j<map[0].length;j++) {
						map[i][j] = Integer.parseInt(element[j]);
						
					}
					i++;
				}
				
			}
			/*for(int[] arr : map) {
				System.out.println(Arrays.toString(arr));
			}*/
			//2. 재귀함수에 넣고 돌린다. 길을 찾을 때마다 
			int x= 0;
			int y =0;
			int sum=0;
			ArrayList<Integer> list = new ArrayList<>();
			list = findWay(x, y, list, map);
			for(int k : list) {
				sum+=k;
			}
			//System.out.println(map[x][y]);
			
			
			result=sum;

			return result;
		}

		public static void main(String[] args) throws FileNotFoundException {
			System.out.println("경우의 수는 : "+execute(new File("input.txt")));

		}
		
		public static ArrayList<Integer> findWay(int x,int y, ArrayList<Integer> list, int[][] map) {
			System.out.println("x: "+(x+1)+", "+"y: "+(y+1));
			//System.out.println("count : "+list);
			//지도를 벗어나면 에러내서 재귀함수에서 벗어나게 함
				//1. 좌
			try {
				if(map[y][x]>map[y][x-1]) {
					findWay(x-1, y, list, map);
				}
			}catch(ArrayIndexOutOfBoundsException e) {
			
			}
				//2. 우
			try {
				if(map[y][x]>map[y][x+1]) {
					findWay(x+1, y, list, map);
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
				//3. 상
			try {
				if(map[y][x]>map[y-1][x]) {
					findWay(x, y-1, list, map);
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
				//4. 하
			try {
				if(map[y][x]>map[y+1][x]) {
					findWay(x, y+1, list, map);
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			//5. 목적지 도달 시
			if(x==map[0].length-1&&y==map.length-1) {
				System.out.println("도착");
				list.add(1);
			}
			return list;
			}
		
		/*public static ArrayList<Integer> findWay(int x,int y, ArrayList<Integer> list, int[][] map) {
			System.out.println("x: "+(x+1)+", "+"y: "+(y+1));
			System.out.println("count : "+list);
			//1. 벽에 안 붙어있을 때
			if(x<map[0].length-1&&y<map.length-1) {
				//1. 좌
				if(map[y][x]>map[y][x-1]) {
					findWay(x-1, y, list, map);
				}
				//2. 우
				if(map[y][x]>map[y][x+1]) {
					findWay(x+1, y, list, map);
				}
				//3. 상
				if(map[y][x]>map[y-1][x]) {
					findWay(x, y-1, list, map);
				}
				//4. 하
				if(map[y][x]>map[y+1][x]) {
					findWay(x, y+1, list, map);
				}
			}else if(x==map[0].length-1&&y<map.length-1) {
				//2. 윗벽인데 모서리가 아닌 곳
				if(map[y][x]>map[y+1][x]) {
					//3. 단방향-하
					findWay(x, y+1, list, map);
				}else if(x==map[0].length-1&&y==map.length-1) {
					System.out.println("찾았다");
					list.add(1);
				}else {
					//4. 막힘
					System.out.println("막힘");
					//count=0;
				}
				
			}else if(x<map[0].length-1&&y==map.length-1) {
				if(map[y][x]>map[y][x+1]) {
					//2. 단방향-우
					findWay(x+1, y, list, map);
				}else if(x==map[0].length-1&&y==map.length-1) {
					System.out.println("찾았다");
					list.add(1);
				}else {
					//4. 막힘
					System.out.println("막힘");
					//count=0;
				}
				
			}else if(x==map[0].length-1&&y==map.length-1) {
				System.out.println("찾았다");
				list.add(1);
			}
			return list;
		}*/
			
}
