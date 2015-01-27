package dblayer;

public class Project {
	public String ProjectName;
	public String ProjectStartDate;
	public int ProjectLenght;
	public String pointScale;
	public String VelocityStrategy;
	public String NumberDoneIterationToShow;
	
	public String GetProjectName(){
		return ProjectName;
	}
	public String GetProjectStartDate(){
		return ProjectStartDate;
	}
	public int GetProjectLenght(){
		return ProjectLenght;
	}
}
