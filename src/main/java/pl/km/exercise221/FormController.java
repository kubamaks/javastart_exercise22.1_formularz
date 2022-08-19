package pl.km.exercise221;

import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class FormController {
    private final MailService mailService;

    public FormController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/kontakt")
    public String addForm(Model model) {
        model.addAttribute("mail", new Mail());
        return "form";
    }

    @PostMapping("/wyslij")
    public String sentEmail(Mail mail) {
        mailService.addMail(mail);
        try {
            mailService.sendMail(mail);
            return "sent";
        } catch (MailException e) {
            return "sentFailure";
        }
    }
}

