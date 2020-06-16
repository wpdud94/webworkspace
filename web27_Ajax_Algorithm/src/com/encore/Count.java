
package com.encore;

import java.util.ArrayList;
import java.util.Arrays;

public class Count {

	public String execute(String book) {
		String word = "";
		//1. 문장 분해--> 배열화
		//이때 특수문자 빼기
		//알파베 순서를 위해 정렬
		String[] arr= book.split(" ");
		String[] special= {".",",","'","-","(",")","?","!"};
		
		for(int i=0;i<arr.length;i++) {
			//소문자화
			arr[i]=arr[i].toLowerCase();
			for(int j=0;j<special.length;j++) {
				//특수문자 빼기
				if(arr[i].contains(special[j])){
					arr[i]=arr[i].substring(0, arr[i].indexOf(special[j]));
					//System.out.println(arr[i]);
				}
			}
			
		}
		//정렬
		Arrays.sort(arr);
		//2. 배열의 원소를 각각 샌다
		//해당 단어가 다른 단어와 일치하면 카운트 증가
		int max=0;
		int modeidx=0;
		for(int i=0;i<arr.length;i++) {
			int cnt=0;
			for(int j=i;j<arr.length;j++) {
				if(arr[i].equals(arr[j])) {
					cnt++;
				}else {
					//정렬했기 때문에 다른 단어 나오면 더 이상 나올 일 없으므로 효율성을 위해 삭제
					break;
				}
			}
			if(cnt>max) {
				max=cnt;
				modeidx=i;
				//System.out.println(arr[modeidx]);
			}
		}
		
		//최빈 단어 word에 할당
		word=arr[modeidx];
		
		//System.out.println(Arrays.toString(arr));
		return word;
	}

	/*public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Count c = new Count();
		System.out.println("최빈 단어 : "+c.execute(book1));
		System.out.println("최빈 단어 : "+c.execute(book2));
		System.out.println("최빈 단어 : "+c.execute(book3));

	}*/

}
