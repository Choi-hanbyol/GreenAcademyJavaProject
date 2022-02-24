package homework;

import java.util.ArrayList;
import javax.swing.JOptionPane;

class ThQuizTimer extends Thread{
	
	boolean chk = false;
	
	@Override
	public void run() {
		
		for (int i = 30; i> 0; i--) {
			if(chk) {
				break;
			}
			
			try {
				
				System.out.println(i+"초..");
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		chk = true;
		System.out.println("타이머 종료");
	}
}

class ThQuiz extends Thread{
	
	ThQuizTimer timer;
	
	ArrayList<ThQuizData> arr;
	
	public ThQuiz(ThQuizTimer timer, ThQuizData... ar1) {
		super();
		this.timer = timer;
		this.arr = new ArrayList<ThQuizData>();
		
		for (ThQuizData qData : ar1) {
			this.arr.add(qData);
		}
	}

	@Override
	public void run() {
	
		int jum = 0;

		for (ThQuizData qd : arr) {
			
			while(!timer.chk) { //
				
				String input = JOptionPane.showInputDialog(qd.qq);
				String input1 = null;
				
				if(timer.chk) {
					input = "시간초과";
					break;
				}
				System.out.println(qd.qq+" / 입력:"+input+" / 정답("+qd.answer+")");


				if(qd.answer.equals(input)){
					jum+=20;
					System.out.println("====정답!!====");
					break;
				}
				if(input.equals("p")) {
					input=input1;
					System.out.println("====패스!!====");
					System.out.println("전에 입력한 정답 : "+input1);
					 //pass를 했을때 전에 입력한 정답을 어캐 저장하는지...
					break;
				}
				System.out.println("====땡!!====");
				input1=input;
			}				
		}
		
		timer.chk = true;
		System.out.println("시험점수 : "+jum);
	}
}

class ThQuizData{
	String qq, answer;

	public ThQuizData(String qq, String answer) {
		super();
		this.qq = qq;
		this.answer = answer;
	}
	
	
}

public class ThreadQuiz {

	public static void main(String[] args) {
		ThQuizTimer timer = new ThQuizTimer();
		ThQuiz quiz = new ThQuiz(timer,
				new ThQuizData("1+1(pass = p)", "2"),
				new ThQuizData("1+2(pass = p)", "3"),
				new ThQuizData("1+3(pass = p)", "4"),
				new ThQuizData("1+4(pass = p)", "5"),
				new ThQuizData("1+5(pass = p)", "6")
				);
		//quiz.timer = timer;
		
		timer.start();
		quiz.start();

	}

}