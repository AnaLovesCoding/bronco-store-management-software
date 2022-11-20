package domain;

import java.util.List;

public interface IPersistenceHandler {

    List<Friend> getFriends();

    boolean createFriend(Friend friend);

    void deleteLastFriend();
}
