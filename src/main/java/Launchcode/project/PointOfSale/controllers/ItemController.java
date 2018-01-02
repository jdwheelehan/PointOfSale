package Launchcode.project.PointOfSale.controllers;


import Launchcode.project.PointOfSale.models.Item;
import Launchcode.project.PointOfSale.models.data.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("inventory")
public class ItemController {

    @Autowired
    ItemDao itemDao;

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("items", itemDao.findAll());
        model.addAttribute("title", "My Stock");

        return "inventory/index";
    }

    @RequestMapping(value = "addstock", method = RequestMethod.GET)
    public String displayRecievingForm(Model model){
        model.addAttribute("title", "Add Stock");
        return "inventory/addstock";
    }

    @RequestMapping(value = "addstock", method = RequestMethod.POST)
    public String processRecievinForm(@RequestParam Long sku, @RequestParam String name, @RequestParam Integer qty ,
                                      @RequestParam Double price,  Model model){

        Item newItem = new Item(sku, name, qty, price);
        itemDao.save(newItem);



        return "redirect:";
    }
}
