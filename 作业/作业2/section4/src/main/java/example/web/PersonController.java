package example.web;

import example.Person;
import example.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/person")
public class PersonController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String persons(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max, Model model) {
        model.addAttribute(personRepository.findPersons(max));
        return "list";
    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public List<Person> persons(
//            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max) {
//        return personRepository.findPersons(max);
//    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String person(
            @PathVariable("name") String name,//同名时，value可以去除
            Model model) {
        model.addAttribute(personRepository.findByName(name));
        return "person";
    }

    @RequestMapping(value = "/add", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Person());
        return "personForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String savePerson(@Valid Person person, Errors errors) throws Exception {
        if (errors.hasErrors()) {
            return "personForm";
        }
        personRepository.save(person);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute Person person, Errors errors) throws Exception{
        if (errors.hasErrors()) {
            return "list";
        }
        personRepository.update(person);
        return "list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePerson(@ModelAttribute Person person, Errors errors) throws Exception{
        String name = person.getName();
        personRepository.delete(name);
        return "list";
    }
}
