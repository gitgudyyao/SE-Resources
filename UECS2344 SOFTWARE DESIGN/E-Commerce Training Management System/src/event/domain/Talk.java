package event.domain;

public class Talk {
	private String title;
	private String speaker;
	private int duration;
	
	public Talk(String title,String speaker,int duration) {
		this.title = title;
		this.speaker = speaker;
		this.duration = duration;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSpeaker() {
		return speaker;
	}
	
	public int getDuration() {
		return duration;
	}
}
