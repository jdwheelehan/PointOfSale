package Launchcode.project.PointOfSale.controllers;


import Launchcode.project.PointOfSale.models.Item;
import Launchcode.project.PointOfSale.models.data.ItemDao;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


@Controller
@RequestMapping("inventory")
public class ItemController {

    @Autowired
    ItemDao itemDao;


    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("items", itemDao.findAll());
        model.addAttribute("title", "Inventory");

        return "inventory/index";
    }

    @RequestMapping(value = "receiving", method = RequestMethod.GET)
    public String displayReceivingForm(Model model){
        model.addAttribute("title", "Receiving");
        model.addAttribute("items", itemDao.findAll());
        return "inventory/receiving";
    }

    @RequestMapping(value = "receiving", method = RequestMethod.POST)
    public String processReceivingForm(@RequestParam Integer sku, @RequestParam Integer qty,  Model model){

        if (itemDao.exists(sku)){
            Item newItem = itemDao.findOne(sku);
            newItem.setQuantity(newItem.getQuantity()+ qty);
            itemDao.save(newItem);
            return "redirect:receiving";
        }else{

            return "redirect:addstock";}




    }


    @RequestMapping(value = "addstock", method = RequestMethod.GET)
    public String displayNewStockForm(Model model){
        model.addAttribute("title", "Add Stock");
        return "inventory/addstock";
    }

    @RequestMapping(value = "addstock", method = RequestMethod.POST)
    public String processNewStockForm(@RequestParam Integer sku, @RequestParam String name, @RequestParam Integer qty ,
                                      @RequestParam Double price,  Model model) throws TwitterException {


        Item newItem = new Item(sku, name, qty, price);
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.updateStatus("Hey guys and gals! "+newItem.getName()+" is now in stock for $"+newItem.getPrice()+"! (Not a real thing)");
        itemDao.save(newItem);


        return "redirect:receiving";
    }


}
