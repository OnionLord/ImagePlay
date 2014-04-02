package yame.Face.ImageProcess;

import java.util.Random;
public class ImageProcess{
	public ImageProcess()
	{
		//메모용 클래스
		//Just For Memo!!!
	}
	
	/*
	현재까지 수집된 표본(여자 : 홀수, 남자 : 짝수)
	1 : 최준희
	2 : 홍진호
	3 : 방민아
	4 : 류승룡
	5 : 김슬기
	6 : 박명수
	7 : 이지은
	8 : 현빈
	9 : 김아영
	10 : 원빈
	11 : 배수지
	12 : 황광희
	13 : 최진리
	14 : 주원
	15 : 오혜린
	16 : 유재석
	17 : 김남주
	18 : 류뚱
	19 : 김현아
	20 : 송중기
	*/
	
	//public ImageProcess()
	//{
		//여기서는 그냥 결과값만 GUI로 쏴줄 수 있도록 한다.
		//배열에다가 해당 번호, 결과값 등을 저장함.
		//가능하면 순위 매겨서 상위 5개 부분에서 결정 할 수 있게..
		//제일 값 높은게 제일 크게 나머지 순위 표시하도록..
		//DB에 관련해서 이름도 따로 저장 하도록...
	//}
	//static public void main(String args[])
	//{
		/* 앞으로 해야할 일
		 * GUI환경으로 비교시킬 이미지 찾기 -> 이미지 제한 조건 설명. 120*120 및 적용
		 * GUI환경으로 비교하고 나서 결과 찾기
		 * GUI환경으로 순위 표시
		 * 비교대상 DB 많이 확보 -> 원본 이미지도 준비하기.
		 * 올릴 이미지 에디터 기능까지 첨부 하려면 힘들다 ㅠㅠ
		 * Luminance로 변환하여 처리하였으니...
		 * */
		
		
		/*
		 * 이상형 월드컵 구현도 같이 해보자.
		 * */
		//20130530 -> 닮은꼴 찾기 알고리즘 완성.
	//	MatCor match = new MatCor("image\\view.jpg", "image\\DB\\1.jpg");
	//	MatCor match = new MatCor("EE.jpg", "EE1.jpg");
	//	System.out.println(match.getResult());
		
	//	MatCor match1 = new MatCor("image\\view.jpg", "image\\DB\\2.jpg");
		//	MatCor match = new MatCor("EE.jpg", "EE1.jpg");
	//		System.out.println(match1.getResult());
			
	//	MatCor match2 = new MatCor("image\\view.jpg", "image\\DB\\3.jpg");
		//	MatCor match = new MatCor("EE.jpg", "EE1.jpg");
	//	System.out.println(match2.getResult());
		
	//	MatCor match3 = new MatCor("image\\view.jpg", "image\\DB\\7.jpg");
		//	MatCor match = new MatCor("EE.jpg", "EE1.jpg");
	//	System.out.println(match3.getResult());
		
	//}
}