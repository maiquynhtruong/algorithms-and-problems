/**Design a chat server **/
public class Solution {
    public class UserManager {
        public static UserManager instance;
        public static UserManager getInstance() {
            if (instance == null) instance = new UserManager();
            return instance;
        }
        HashMap<Integer, User> usersById = new HashMap<Integer, User>();
        HashMap<String, User> usersByName = new HashMap<String, User>();
        // sender sends an add request to receiver. 
        // add the request to receiver's queue
        public void addUser(User receiver, User sender) {
            sender.sendAddRequest(receiver);
            receiver.receivedAddRequest(sender);
        } 
        
        public void acceptRequest(AddRequest request) { 
            request.receiver.contacts.add(sender);
            request.receiver.deleteRAddRequest(this);
        }
        public void rejectRequest(AddRequest request) {}
    }
    
    public class AddRequest {
        public Date = 
        User sender, receiver;
        boolean accepted;
    }
    public enum UserStatusType {
        ONLINE, OFFLINE, IDLE, AWAY, BUSY
    }
    public class User {
        
        // maps user id with add requests received
        HashMap<Integer, AddRequest> receivedAddRequest = new HashMap<Integer, AddRequest>(); 
        // maps user id with add requests sent
        HashMap<Integer, AddRequest> sentAddRequest = new HashMap<Integer, AddRequest>(); 
        UserStatus status = null;
        private HashMap<Integer, PrivateChat> privateChats; // one to one chat
        private ArrayList<GroupChat> groupChats;
        HashMap<Integer, User> contacts;
        public int id;
        public username;
        public String fullName;
        public void requestAddUser(User receiver) { UserManager.getInstance().addUser(receiver, this); }
        public void receivedAddRequest(User sender) { addRequests.add(sender); }
        public void sendAddRequest(AddRequest request){}
        public void deleteAddRequest(AddRequest request) {}
        public void sendMessageToUser(User receiver) {}
        public void sendMessageToGroupChat(GroupChat group) {}
        public void setStatus(UserStatus status) { this.status = status; }
        public UserStatus getStatus() { return status; }
        public void addContact(User user) {}
        public void setFullName(String newName) {}
        public void setProfilePicture() {}
        public GroupChat createGroupChat(List<User> users) {}
        public int getId() { return id; }
        public String getUsername() { return username; }
        public String getFullName() { return fullName; }        
    }
    
    public abstract class Conversation {
        List<User> participants;
        HashMap<Integer, List<Message>> messages; // maps list of message a user sent
        public int id;
        public List<String> getMessageFromUser(int userId) { return messages.get(userId); }
        public List<String> getMessagesFromAll() { return; ...}
        public boolean addMessage(int userId, Message mes) {}
        public int getId() { return id; }
    }
    
    public PrivateChat extends Conersation {
        User user1, user2;
        public PrivateChat(User user1, User user2) {}
        public boolean addMessage(int userId, Message mes ) { messages.get(userId).add(mes) }; 
    }
    public GroupChat extends Conversation {
        public void addMoreUsers() {}
        public void removeUser (User user); 
    }
    
    public class Message () {
        public String message;
        User sender, receiver;
        private Date date;
        public String getContent();
        public Date getDate();
    }
    public claass addRequest {
        User fromUser, toUser;
        public RequestStatus(get s);
    }
    public enum requests {
        Unread, Read, In.ccepted
    }
}
