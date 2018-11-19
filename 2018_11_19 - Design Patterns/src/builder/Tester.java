package builder;

public class Tester {

	public static void main(String[] args) {
		String swIngCourseModel = (String) ERHardCodedDirector.getModel(new OrientedERBuilder());
		System.out.println(swIngCourseModel);
		ERModel dbCourseModel = (ERModel) ERHardCodedDirector.getModel(new NotOrientedERBuilder());
		dbCourseModel.showStructure();

	}

}
