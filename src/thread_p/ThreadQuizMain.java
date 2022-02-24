package thread_p;

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
				
				System.out.println(i+","+chk);
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
	
	int jum =0;
	
	
	public ThQuiz(ThQuizTimer timer, ThQuizData... arr) {
		super();
		this.timer = timer;
		this.arr = new ArrayList<ThQuizData>();
		
		for (ThQuizData qData : arr) {
			this.arr.add(qData);
			qData.timer = timer;
		}
	}




	@Override
	public void run() {
	
		jum = 0;
		for (ThQuizData qd : arr) {
			
			if(timer.chk) {
				break;
			}
			
			if(qd.go()) {
				jum+=20;
			}
			
		}
		
		timer.chk = true;
		ppp();
	}
	
	void ppp() {
		System.out.println("시험점수:"+jum);
		for (ThQuizData qd : arr) {
			System.out.println(qd.res);
		}
	}
}

class ThQuizData{
	String qq, answer, input, last, res;
	ThQuizTimer timer;

	public ThQuizData(String qq, String answer) {
		super();
		this.qq = qq;
		this.answer = answer;
		
		res= qq+":미응시->"+input+"("+answer+")";
	}
	
	boolean go() {
		
		while(true) {
			input  = JOptionPane.showInputDialog(qq);
			if(timer.chk) {
				input ="시간경과";
				return false;
			}
			
			
			if(answer.equals(input)) {
				res=qq+":정답->"+input+"("+answer+")";
				break;
			}
			if(input.equals("p")) {
				input = last;
				res=qq+":패스->"+input+"("+answer+")";
				break;
			}
			System.out.println(qq+":"+input+"("+answer+")");
			last = input;		
		}
		
		return answer.equals(input);

	}
	
}


public class ThreadQuizMain {

	public static void main(String[] args) {
		ThQuizTimer timer = new ThQuizTimer();
		ThQuiz quiz =new ThQuiz(timer,
				new ThQuizData("송지은은 이뻐요?", "y"),
				new ThQuizData("송지은은 송가은 동생?", "n"),
				new ThQuizData("송지은은 힘든가요?", "y"),
				new ThQuizData("송지은은 뭐시킬까요?", "y"),
				new ThQuizData("송지은 하일하이드라!", "n")
				);
		//quiz.timer = timer;
		
		timer.start();
		quiz.start();

	}

}
