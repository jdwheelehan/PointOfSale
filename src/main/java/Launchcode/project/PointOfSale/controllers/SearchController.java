package Launchcode.project.PointOfSale.controllers;

import Launchcode.project.PointOfSale.models.Customer;
import Launchcode.project.PointOfSale.models.Item;
import Launchcode.project.PointOfSale.models.data.CustomerDao;
import Launchcode.project.PointOfSale.models.data.ItemDao;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.messages.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    ItemDao itemDao;

    @Autowired
    CustomerDao customerDao;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){


        model.addAttribute("title", "Search");

        return "search/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processIndex(@RequestParam String searchTerm, Model model){

         ArrayList<Item> searchResults;
        searchResults = new ArrayList<>();

        for (Item i : itemDao.findAll()){
            if ((i.getName().toLowerCase().contains(searchTerm.toLowerCase()) && i.getQuantity() > 0)){
                searchResults.add(i);
            }
        }
        if (searchResults.isEmpty()){
            return "search/noresult";
        }else{

            model.addAttribute("results", searchResults);
            model.addAttribute("title", "Search");
            return "search/index";
        }


    }

    @RequestMapping(value = "noresult", method = RequestMethod.GET)
    public String displayNoResultForm(Model model){
        model.addAttribute("title", "Notify Me");
        return "search/noresult";}

    @RequestMapping(value = "noresult", method = RequestMethod.POST)
    public String processNoResultForm(@RequestParam String name, @RequestParam String game, @RequestParam String phoneNumber){

        Customer newCustomer = new Customer(name, game, phoneNumber);
        customerDao.save(newCustomer);
        AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
        NexmoClient client = new NexmoClient(auth);

        TextMessage message = new TextMessage("12028525650", newCustomer.getCustomernumber(), "We will notify you upon arrival.");
        return "redirect:search";
    }

}
