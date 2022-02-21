package collection_p;

import java.util.HashMap;

public class MapWordCnt {

	public static void main(String[] args) {
		String ttt = "지난 20일 폐막한 2022 베이징 동계올림픽은 ‘형님’들의 활약이 돋보였다. "
				+ "쇼트트랙 ‘맏형’ 곽윤기 (33·고양시청)와 스피드스케이팅 이승훈(34·IHQ)은 이번 대회에서 메달을 획득했다. "
				+ "곽윤기는 지난 16일 중국 베이징 캐피털 실내경기장에서 열린 베이징 동계올림픽 쇼트트랙 남자 5000m 결승에서 은메달을 이끌었다. 한국은 2010 밴쿠버 대회 은메달 이후 12년 만에 쇼트트랙 남자 계주에서 메달을 획득했다. "
				+ "2022 베이징 동계올림픽 스피드스케이팅 남자 매스스타트에서 동메달을 획득한 한국의 이승훈이19일 오후 중국 베이징 메달 플라자에서 열린 메달 수여식에서 메달을 받은 뒤 미소짓고 있다."
				+ "12년 전 메달을 획득했던 선수도 곽윤기였다. 당시 곽윤기는 시상대에서 ‘시건방춤’을 춰서 화제를 모았다. 그리고 밴쿠버 대회 이후 메달과 인연이 없었다. 2014 소치 대회는 부상으로 참가하지 못했고 2018 평창 대회 때에는 "
				+ "동료가 넘어지면서 메달 획득에 실패했다. 이번 대회에서는 은메달을 목에 거는데 성공했지만 그토록 그리던 금메달은 획득하지 못했다."
				+ "곽윤기는 계주 경기를 앞두고 자신의 유튜브 채널 ‘꽉잡아윤기’를 통해서 “평창 때도 마지막 올림픽이라고 얘기를 했었는데, 이제 정말 마지막 올림픽이다. 이제 스케이트 인생에 마침표를 찍게 될 텐데 유종의 미를 잘 거두고 싶다”고 전했다.";
		
		String [] arr = ttt.split(" ");
		
		HashMap map = new HashMap();
		for (String string : arr) {
			System.out.println(string);
			
			int cnt = 1;
			
			if(map.containsKey(string)) {
				cnt+= (int)map.get(string);
				//System.out.println("있어:");
			}
			
			map.put(string, cnt);
			//System.out.println(map);
		}
		System.out.println("=========================================");
		for (Object oo :map.entrySet()) {
			System.out.println(oo);
			
		}
	}

}
