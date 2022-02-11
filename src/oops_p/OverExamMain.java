package oops_p;

class OverExam{
	String name, kind;
	int tot, res;
	
	OverExam(String name, int kor, int eng, int mat){
		kind = "일반";
		this.name=name;
		tot=kor+eng+mat;
		res=tot/3;
	}
	
	OverExam(String name, int kor, int eng, int mat, int art){
		kind = "예체능";
		this.name=name;
		tot=kor+eng+mat+art;
		res=(int)(kor*0.2 + eng*0.1 + mat*0.15 + art*0.55);
	}
	
	@Override
	public String toString() {
		return kind + "\t" + name + "\t" + tot + "\t" + res;
	}
	
}

public class OverExamMain {

	public static void main(String[] args) {
		OverExam [] student = {
				new OverExam("현빈", 37, 68, 92),
				new OverExam("원빈", 27, 48, 62, 84),
				new OverExam("투빈", 97, 68, 32),
				new OverExam("김우빈", 87, 68, 42, 24),
				new OverExam("장희빈", 77, 78, 72),
				new OverExam("젤리빈", 77, 78, 72, 74),
				new OverExam("커피빈", 57, 58, 52),
				new OverExam("미스터빈", 57, 58, 52, 54),
				new OverExam("골빈", 27, 38, 92),
				new OverExam("텅빈", 37, 28, 22, 94)
		};
		for(OverExam oe : student) {
			System.out.println(oe);
		}

	}

}
