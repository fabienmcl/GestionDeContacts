package domain;

import java.util.HashSet;
import java.util.Set;

public class ContactGroup {
	int groupId;
	String groupName;
	private Set<Contact> contacts = new HashSet<Contact>();
	private int version;
	
	public ContactGroup() {
		super();
	}
	public ContactGroup(int groupId) {
		super();
		this.groupId = groupId;
	}
	public ContactGroup(int groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}
	public ContactGroup(int groupId, String groupName, Set<Contact> contacts) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.contacts = contacts;
	}
	public ContactGroup(int groupId, String groupName, Set<Contact> contacts, int version) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.contacts = contacts;
		this.version = version;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
	

}
