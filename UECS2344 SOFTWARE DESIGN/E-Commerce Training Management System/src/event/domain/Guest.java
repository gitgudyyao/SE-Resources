package event.domain;

public class Guest {
	private String name;
	private String contact;
	private String replyStatus; 
	
	public Guest (String name,String contact) {
		this.name = name;
		this.contact = contact;
		this.replyStatus = "Invited";
	}
	
	public String getName() {
		return name;
	}
	
	public String getContact() {
		return contact;
	}
	
	public String getReplyStatus() {
		return replyStatus;
	}
	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}
	
}
