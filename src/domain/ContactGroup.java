package domain;

import java.util.HashSet;
import java.util.Set;

public class ContactGroup {
	private long groupId=0;
	String groupName;
	private Set<Contact> contacts = new HashSet<Contact>();
	private int version;
	
	public ContactGroup() {
		super();
		this.groupName = "group" + groupId;
		version=0;
	}
	public ContactGroup(long groupId) {
		super();
		this.groupId = groupId;
		version=0;
	}
	public ContactGroup(long groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		version=0;
	}
	public ContactGroup(String groupName) {
		super();
		this.groupName = groupName;
		version=0;
	}
	public ContactGroup(long groupId, String groupName, Set<Contact> contacts) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.contacts = contacts;
		version=0;
	}
	public ContactGroup(long groupId, String groupName, Set<Contact> contacts, int version) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.contacts = contacts;
		this.version = version;
		version=0;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
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
