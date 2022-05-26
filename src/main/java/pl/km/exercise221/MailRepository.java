package pl.km.exercise221;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
class MailRepository {
    private Collection<Mail> mailCollection;

    public MailRepository() {
        mailCollection = new ArrayList<>();
    }

    public void addMail(Mail mail) {
        mailCollection.add(mail);
    }
}
